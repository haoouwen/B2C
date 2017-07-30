package com.atguigu.b2c.sale.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class ShoppingCart {

	/*Idint(11) NOT NULL编号
	sku_mchvarchar(100) NULLsku名称
	sku_jgdouble NULLsku价格
	tjshlint(11) NULL添加数量
	hjdecimal(10,0) NULL合计
	yh_idint(11) NULL用户id
	shp_idint(11) NULL商品id
	chjshjtimestamp NOT NULL创建时间
	sku_idint(11) NULLskuid
	shp_tpvarchar(100) NULL商品图片
	shfxzvarchar(100) NULL是否选中
	kcdz*/
	private Integer id;
	private String sku_mch;
	private BigDecimal sku_jg;
	private Integer tjshl;
	private BigDecimal hj;
	private Integer yh_id;
	private Integer shp_id;
	private Date chjshj;
	private Integer sku_id;
	private String shp_tp;
	private String shfxz;
	private String kcdz;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getTjshl() {
		return tjshl;
	}
	public void setTjshl(Integer tjshl) {
		this.tjshl = tjshl;
	}
	public BigDecimal getHj() {
		return hj;
	}
	public void setHj(BigDecimal hj) {
		this.hj = hj;
	}
	public Integer getYh_id() {
		return yh_id;
	}
	public void setYh_id(Integer yh_id) {
		this.yh_id = yh_id;
	}
	public Integer getShp_id() {
		return shp_id;
	}
	public void setShp_id(Integer shp_id) {
		this.shp_id = shp_id;
	}
	public Date getChjshj() {
		return chjshj;
	}
	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}
	public Integer getSku_id() {
		return sku_id;
	}
	public void setSku_id(Integer sku_id) {
		this.sku_id = sku_id;
	}
	public String getShp_tp() {
		return shp_tp;
	}
	public void setShp_tp(String shp_tp) {
		this.shp_tp = shp_tp;
	}
	public String getShfxz() {
		return shfxz;
	}
	public void setShfxz(String shfxz) {
		this.shfxz = shfxz;
	}
	public String getKcdz() {
		return kcdz;
	}
	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}
	
	
	
	
	
	
	
	
}
