package com.taoxiha.common.utils.datasource;

import org.springframework.util.Assert;

public class DataSourceContextHolder {  
    
	private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<DataSourceType>();
			 
	   public static void setCustomerType(DataSourceType dataSourceType) {
	      Assert.notNull(dataSourceType, "DataSourceType cannot be null");
	      contextHolder.set(dataSourceType);
	   }
	 
	   public static DataSourceType getDataSourceType() {
	      return (DataSourceType) contextHolder.get();
	   }
	 
	   public static void clearDataSourceType() {
	      contextHolder.remove();
	   } 
      
}