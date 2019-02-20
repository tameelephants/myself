package cn.cj.entity;

import java.io.Serializable;
import java.util.Date;

public class Label implements Serializable{

	private static final long serialVersionUID = -3622533855681928408L;

	private Integer labelId;
	
	private String labelName;
	
	private Date labelCreateTime;

	
	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Date getLabelCreateTime() {
		return labelCreateTime;
	}

	public void setLabelCreateTime(Date labelCreateTime) {
		this.labelCreateTime = labelCreateTime;
	}


	public Label(Integer labelId, String labelName, Date labelCreateTime) {
		super();
		this.labelId = labelId;
		this.labelName = labelName;
		this.labelCreateTime = labelCreateTime;
	}

	public Label() {
		super();
		// TODO Auto-generated constructor stub
	}
}
