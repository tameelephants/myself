package cn.cj.tools;

import java.util.Date;
/**
 * layui表格分页帮助类
 * @author chenjie
 *
 */
public class LayuiPage {
	private Integer page;//第几页
	private Integer limit;//每页显示条目书 sql第二个参数
	private Integer pageX;//sql第一个参数
	private String keyWords;//关键字
	private String startTime;//开始时间
	private String endTime;//结束时间
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
	/**
	 * sql第一个参数
	 * @return
	 */
	public Integer getPageX() {
		return (page-1)*limit > 0 ? (page-1)*limit : 0;
	}
	public void setPageX(Integer pageX) {
		this.pageX = pageX;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public LayuiPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LayuiPage(Integer page, Integer limit,  String keyWords, String startTime, String endTime) {
		super();
		this.page = page;
		this.limit = limit;
		this.keyWords = keyWords;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public LayuiPage(Integer page, Integer limit){
		super();
		this.page = page;
		this.limit = limit;
	}
}
