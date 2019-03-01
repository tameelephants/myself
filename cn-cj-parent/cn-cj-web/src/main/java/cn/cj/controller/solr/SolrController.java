package cn.cj.controller.solr;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cj.entity.User;
import cn.cj.service.solr.SolrService;;


@Controller
@RequestMapping("solr")
public class SolrController {
	@Autowired
	private SolrService solrService;
	
	@RequestMapping("addUser")
	public String addUser() {
		try {
			solrService.selectAllUser();
		}  catch (Exception e) {
			e.printStackTrace();
			return "../login";
		}
		return "/index";
	}
	@RequestMapping("deleteAllIndex")
	public String deleteAllIndex(){
		try {
			solrService.deleteAllIndex();
		} catch (Exception e) {
			return "../login";
		}
		return "/index";
	}
	
	@RequestMapping("showSolr")
	public String showSolr(HttpServletRequest request){
		try {
			List<User> userList = solrService.showSolr();
			if(null != userList){
				request.setAttribute("userList", userList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/solrShowUser";
	}
}
