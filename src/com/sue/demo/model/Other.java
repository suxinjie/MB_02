package com.sue.demo.model;

import java.util.Arrays;

public class Other {

	private int id;
	private byte[] pic;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Other [id=" + id + ", remark=" + remark + "]";
	}

}
