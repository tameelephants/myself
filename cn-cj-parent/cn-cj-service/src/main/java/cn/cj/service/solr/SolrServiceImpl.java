package cn.cj.service.solr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.UserMapper;
import cn.cj.entity.User;

@Service
public class SolrServiceImpl implements SolrService {
	
	@Autowired
	private HttpSolrServer solrServer;
	@Autowired
	private UserMapper userMapper;

	public void selectAllUser() throws Exception{
			List<User> userList = userMapper.selectAllUser();
			List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
			for (User user : userList) {
				SolrInputDocument document = new SolrInputDocument();
				document.addField("user_id", user.getUserId());
				document.addField("user_name", user.getUserName());
				document.addField("user_email", user.getUserEmail());
				document.addField("user_account", user.getUserAccount());
				document.addField("user_img", user.getUserImg());
				document.addField("user_password", user.getUserPassword());
				document.addField("is_disable", user.getIsDisable());
				document.addField("last_login_time", user.getLastLoginTime());
				document.addField("role_id", user.getRoleId());
				document.addField("open_id", user.getOpenId());
				docs.add(document);
			}
			solrServer.add(docs);
			solrServer.commit();
		
	}
	
	public List<User> showSolr() throws Exception {
		SolrQuery query = new SolrQuery("user_account_name_emaill:*波");
		List<User> userList = new ArrayList<User>();
		//设置页面需要高亮的标签
		query.setHighlight(true);
        query.setHighlightFragsize(100);          //返回的字符个数  
		query.setHighlightSimplePre("<span style='color:red'>");
		query.setHighlightSimplePost("</span>");
//		query.set("hl.highlightMultiTerm","true");//启用多字段高亮

		//需要显示的高亮的域
		query.setParam("hl.fl", "user_email","user_account","user_name");
		//设置需要过滤的
		query.set("df", "user_account_name_emaill");
		QueryResponse queryResponse = solrServer.query(query);
		SolrDocumentList sdl = queryResponse.getResults();
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        System.err.println(highlighting);
		for (SolrDocument solrDocument : sdl) {
			String userAccount = (String) solrDocument.get("user_account");
			String userEmail = (String) solrDocument.get("user_email");
			String userName = (String) solrDocument.get("user_name");
			Date lastLoginTime = (Date) solrDocument.get("last_login_time");
			List<String> userAccountList = highlighting.get(solrDocument.get("user_id")).get("user_account");
			List<String> userEmailList = highlighting.get(solrDocument.get("user_id")).get("user_email");
			List<String> userNameList = highlighting.get(solrDocument.get("user_id")).get("user_name");
			if(userAccountList != null && userAccountList.size() > 0){
				userAccount = userAccountList.get(0);
			}
			if(userEmailList != null && userEmailList.size() > 0){
				userEmail = userEmailList.get(0);
			}
			if(userNameList != null && userNameList.size() > 0){
				userName = userNameList.get(0);
			}
			
			User user = new User();
			user.setUserAccount(userAccount);
			user.setUserEmail(userEmail);
			user.setUserName(userName);
			user.setLastLoginTime(lastLoginTime);
			userList.add(user);
		}
		return userList;
	}

	public void deleteAllIndex() throws Exception{
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}

}
