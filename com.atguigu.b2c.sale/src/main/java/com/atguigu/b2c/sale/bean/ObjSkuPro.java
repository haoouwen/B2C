package com.atguigu.b2c.sale.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class ObjSkuPro {

	private  Integer id;
	private Integer shp_id;
	private Integer kc;
	private BigDecimal jg;
	private Date chjshj;
	private String sku_mch;
	private Integer sku_xl;
	private String kcdz;
	private Product product;
	private TradeMark tradeMark;
	
	
	public BigDecimal getJg() {
		return jg;
	}
	public void setJg(BigDecimal jg) {
		this.jg = jg;
	}
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
	public Integer getSku_xl() {
		return sku_xl;
	}
	public void setSku_xl(Integer sku_xl) {
		this.sku_xl = sku_xl;
	}
	public String getKcdz() {
		return kcdz;
	}
	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public TradeMark getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(TradeMark tradeMark) {
		this.tradeMark = tradeMark;
	}
	
	
	
}
