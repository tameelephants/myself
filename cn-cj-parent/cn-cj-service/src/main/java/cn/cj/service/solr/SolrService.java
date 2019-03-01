package cn.cj.service.solr;

import java.util.List;


import cn.cj.entity.User;

public interface SolrService {
	/**
	 * 添加用户索引
	 * @throws Exception
	 */
	void selectAllUser() throws Exception;

	/**
	 * 展示数据(通过邮箱，用户名，昵称匹配高亮)
	 * @return
	 * @throws Exception
	 */
	List<User> showSolr() throws Exception;

	/**
	 * 删除所有solr服务器索引
	 */
	void deleteAllIndex() throws Exception;
}
