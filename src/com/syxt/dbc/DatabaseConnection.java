package com.syxt.dbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DatabaseConnection {
  private static final String DBDRIVER="com.mysql.jdbc.Driver";
  private static final String DBURL="jdbc:mysql://localhost:3306/yaan?useSSL=false";
  private static final String DBUSER="root";
  private static final String PASSWORD="root";
  private Connection conn=null;
  private static final Logger logger=LoggerFactory.getLogger(DatabaseConnection.class);

  public DatabaseConnection() {
    	try {
			PoolProperties p = new PoolProperties();
			p.setUrl(DBURL);
			p.setDriverClassName(DBDRIVER);
			p.setUsername(DBUSER);
			p.setPassword(PASSWORD);
			p.setJmxEnabled(true);
			p.setTestWhileIdle(false);
			p.setTestOnBorrow(true);
			p.setValidationQuery("SELECT 1");
			p.setTestOnReturn(false);
			p.setValidationInterval(30000);
			p.setTimeBetweenEvictionRunsMillis(30000);
			p.setMaxActive(200);
			p.setInitialSize(10);
			p.setMaxWait(10000);
			p.setRemoveAbandonedTimeout(60);
			p.setMinEvictableIdleTimeMillis(30000);
			p.setMinIdle(10);
			p.setLogAbandoned(true);
			p.setRemoveAbandoned(true);
			p.setJdbcInterceptors(
			  "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
			  "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
			DataSource datasource = new DataSource();
			datasource.setPoolProperties(p);
			this.conn=datasource.getConnection();
		} catch (SQLException e) {
			logger.error("获取数据库链接异常", e);
		}
		
	
   }
 
  public Connection getConnection(){
	  return this.conn;
  }
  public void close(){
	  if(null!=this.conn){
		  try {
			this.conn.close();
		} catch (SQLException e) {
			logger.error("关闭数据库链接异常", e);
		}
	  }
  }
}
