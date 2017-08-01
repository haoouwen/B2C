package com.atguigu.b2c.sale.bean;

import java.math.BigDecimal;

import com.mysql.fabric.xmlrpc.base.Data;

public class Orders {

	
	private Integer id;
	private Integer yh_id;
	
	private BigDecimal zje;
	private Integer jdh;
	
	private Data chjshj;
	private String shhr;
	private Data yjsdshj;
	private Integer dzh_id;
	private String dzh_mch;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYh_id() {
		return yh_id;
	}
	public void setYh_id(Integer yh_id) {
		this.yh_id = yh_id;
	}
	public BigDecimal getZje() {
		return zje;
	}
	public void setZje(BigDecimal zje) {
		this.zje = zje;
	}
	public Integer getJdh() {
		return jdh;
	}
	public void setJdh(Integer jdh) {
		this.jdh = jdh;
	}
	public Data getChjshj() {
		return chjshj;
	}
	public void setChjshj(Data chjshj) {
		this.chjshj = chjshj;
	}
	public String getShhr() {
		return shhr;
	}
	public void setShhr(String shhr) {
		this.shhr = shhr;
	}
	public Data getYjsdshj() {
		return yjsdshj;
	}
	public void setYjsdshj(Data yjsdshj) {
		this.yjsdshj = yjsdshj;
	}
	public Integer getDzh_id() {
		return dzh_id;
	}
	public void setDzh_id(Integer dzh_id) {
		this.dzh_id = dzh_id;
	}
	public String getDzh_mch() {
		return dzh_mch;
	}
	public void setDzh_mch(String dzh_mch) {
		this.dzh_mch = dzh_mch;
	}
	
	
	
	
	
	
	
}
