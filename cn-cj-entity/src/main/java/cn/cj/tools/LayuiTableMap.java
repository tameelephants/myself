package cn.cj.tools;

import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.cj.entity.Article;

/**
 * layui表格数据返回基础类
 * @author 陈洁
 *
 * @param <T>
 */
public class LayuiTableMap<T,V> {
	private Integer code;
	
	private String message;
	
	private List<T> data;
	
	private Integer count;
	
	private List<V> otherData;
	

	public List<V> getOtherData() {
		return otherData;
	}

	public void setOtherData(List<V> otherData) {
		this.otherData = otherData;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public LayuiTableMap(Integer code, String message, List<T> data, Integer count, List<V> otherData) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.count = count;
		this.otherData = otherData;
	}
	
	public LayuiTableMap(Integer code, String message, List<T> data, Integer count) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.count = count;
	}


	public LayuiTableMap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
