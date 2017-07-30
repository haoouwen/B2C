package com.atguigu.b2c.sale.handler;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestBigDecimal {

	
	
	/*public static void main(String[] args) {
		BigDecimal add = null;
		BigDecimal bigDecimal1 = new BigDecimal("0");
		BigDecimal bigDecimal2 = new BigDecimal("1500");
		for(int i = 0;i<5;i++){
			bigDecimal1 = bigDecimal1.add(bigDecimal2);
		}
		
		System.out.println(bigDecimal1);
		
	}*/
	
	public static void main(String[] args) {  
        ApplicationContext context = new FileSystemXmlApplicationContext(  
                "classpath:/spring-context.xml");  
         Object bean = context.getBean("dataSource");  
         System.out.println(context);
         System.out.println(bean);
         
         HashMap hashMap = new HashMap();
         
         
    }  
	
	
	
	
	
	
	
}
