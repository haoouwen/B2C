package com.atguigu.b2c.sale.bean;

import java.sql.Date;
import java.util.List;

public class Class2Attr {

	private Integer id;
	private String shxm_mch;
	private String shfqy;
	private Integer flbh2;
	private Date chjshj;
	private List<AttrValue> list;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShxm_mch() {
		return shxm_mch;
	}
	public void setShxm_mch(String shxm_mch) {
		this.shxm_mch = shxm_mch;
	}
	public String getShfqy() {
		return shfqy;
	}
	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}
	public Integer getFlbh2() {
		return flbh2;
	}
	public void setFlbh2(Integer flbh2) {
		this.flbh2 = flbh2;
	}
	public Date getChjshj() {
		return chjshj;
	}
	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}
	public List<AttrValue> getList() {
		return list;
	}
	public void setList(List<AttrValue> list) {
		this.list = list;
	}
	
	
	
}
