package com.atguigu.b2c.sale.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order_Info {


	private Integer id;
	private Integer dd_id;
	private Integer sku_id;
	private Date chjshj;
	private String shp_tp;
	private String sku_mch;
	private BigDecimal sku_jg;
	private Integer sku_shl;
	private Integer gwch_id;
	private String sku_kcdz;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDd_id() {
		return dd_id;
	}
	public void setDd_id(Integer dd_id) {
		this.dd_id = dd_id;
	}
	public Integer getSku_id() {
		return sku_id;
	}
	public void setSku_id(Integer sku_id) {
		this.sku_id = sku_id;
	}
	public Date getChjshj() {
		return chjshj;
	}
	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}
	public String getShp_tp() {
		return shp_tp;
	}
	public void setShp_tp(String shp_tp) {
		this.shp_tp = shp_tp;
	}
	public String getSku_mch() {
		return sku_mch;
	}
	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}
	public BigDecimal getSku_jg() {
		return sku_jg;
	}
	public void setSku_jg(BigDecimal sku_jg) {
		this.sku_jg = sku_jg;
	}
	public Integer getSku_shl() {
		return sku_shl;
	}
	public void setSku_shl(Integer sku_shl) {
		this.sku_shl = sku_shl;
	}
	public Integer getGwch_id() {
		return gwch_id;
	}
	public void setGwch_id(Integer gwch_id) {
		this.gwch_id = gwch_id;
	}
	public String getSku_kcdz() {
		return sku_kcdz;
	}
	public void setSku_kcdz(String sku_kcdz) {
		this.sku_kcdz = sku_kcdz;
	}
	
	
	
	
	
	
}
