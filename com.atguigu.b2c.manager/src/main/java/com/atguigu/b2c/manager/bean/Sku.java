package com.atguigu.b2c.manager.bean;

import java.sql.Date;

public class Sku {
	
	private  Integer id;
	private Integer shp_id;
	private Integer kc;
	private double jg;
	private Date chjshj;
	private String sku_mch;
	private Integer shu_xl;
	private String kcdz;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShp_id() {
		return shp_id;
	}
	public void setShp_id(Integer shp_id) {
		this.shp_id = shp_id;
	}
	public Integer getKc() {
		return kc;
	}
	public void setKc(Integer kc) {
		this.kc = kc;
	}
	public double getJg() {
		return jg;
	}
	public void setJg(double jg) {
		this.jg = jg;
	}
	public Date getChjshj() {
		return chjshj;
	}
	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}
	public String getSku_mch() {
		return sku_mch;
	}
	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}
	public Integer getShu_xl() {
		return shu_xl;
	}
	public void setShu_xl(Integer shu_xl) {
		this.shu_xl = shu_xl;
	}
	public String getKcdz() {
		return kcdz;
	}
	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}
	
	
	
}
