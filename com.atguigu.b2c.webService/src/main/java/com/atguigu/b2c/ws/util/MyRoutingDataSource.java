package com.atguigu.b2c.ws.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class MyRoutingDataSource  extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		
		return MyKeyShitch.getKey();
	}
    
	
	
	
}
