package com.atguigu.b2c.sale.bean;


public class UserAccount {
	/*Idint(11) NOT NULL编号
	yh_mchvarchar(100) NULL用户名称
	yh_nchvarchar(100) NULL用户昵称
	yh_mmvarchar(100) NULL用户密码
	yh_xmvarchar(100) NULL用户姓名
	yh_shjhvarchar(100) NULL手机号
	yh_yxvarchar(100) NULL邮箱
	yh_txvarchar(100) NULL头像
	yh_jb*/
	private Integer id;
	private String yh_mch;
	private String yh_lx;
	private String yh_nch;
	private String yh_xm;
	private String yh_mm;
	private String yh_shjh;
	private String yh_yx;
	private String yh_tx;
	private String yh_jb;
	
	public String getYh_lx() {
		return yh_lx;
	}
	public void setYh_lx(String yh_lx) {
		this.yh_lx = yh_lx;
	}
	public String getYh_mm() {
		return yh_mm;
	}
	public void setYh_mm(String yh_mm) {
		this.yh_mm = yh_mm;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYh_mch() {
		return yh_mch;
	}
	public void setYh_mch(String yh_mch) {
		this.yh_mch = yh_mch;
	}
	public String getYh_nch() {
		return yh_nch;
	}
	public void setYh_nch(String yh_nch) {
		this.yh_nch = yh_nch;
	}
	public String getYh_xm() {
		return yh_xm;
	}
	public void setYh_xm(String yh_xm) {
		this.yh_xm = yh_xm;
	}
	public String getYh_shjh() {
		return yh_shjh;
	}
	public void setYh_shjh(String yh_shjh) {
		this.yh_shjh = yh_shjh;
	}
	public String getYh_yx() {
		return yh_yx;
	}
	public void setYh_yx(String yh_yx) {
		this.yh_yx = yh_yx;
	}
	public String getYh_tx() {
		return yh_tx;
	}
	public void setYh_tx(String yh_tx) {
		this.yh_tx = yh_tx;
	}
	public String getYh_jb() {
		return yh_jb;
	}
	public void setYh_jb(String yh_jb) {
		this.yh_jb = yh_jb;
	}
	
	
}
