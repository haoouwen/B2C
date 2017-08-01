package com.atguigu.b2c.sale.bean;

import java.math.BigDecimal;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;

public class Object_Orders {

	private Integer id;
	private Integer yh_id;
	
	private BigDecimal zje;
	private Integer jdh;
	
	private Data chjshj;
	private String shhr;
	private Data yjsdshj;
	private Integer dzh_id;
	private String dzh_mch;
	private List<Order_Info> list_info;
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
	public List<Order_Info> getList_info() {
		return list_info;
	}
	public void setList_info(List<Order_Info> list_info) {
		this.list_info = list_info;
	}
	
	
	
	
}
