package com.atguigu.b2c.sale.util;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.FactoryBean;

public class MyUserWs<T> implements FactoryBean<T>{

	
	private Class<T> webServiceInterface;
	private String url;
	public  <T> T get_user(Class<T> t,String url){
		 JaxWsProxyFactoryBean jax = new JaxWsProxyFactoryBean();
		 jax.setAddress(url);
		 jax.setServiceClass(t);
		
		 T create = (T)jax.create();
		 
		 return create;
	 }

	public T getObject() throws Exception {
		
		return get_user(webServiceInterface,url);
	}

	public Class<T> getObjectType() {
		
		return webServiceInterface;
	}

	
	
	
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	public Class<T> getWebServiceInterface() {
		return webServiceInterface;
	}

	public void setWebServiceInterface(Class<T> webServiceInterface) {
		this.webServiceInterface = webServiceInterface;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
