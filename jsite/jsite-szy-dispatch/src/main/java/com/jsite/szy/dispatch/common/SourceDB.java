package com.jsite.szy.dispatch.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsite.core.config.Global;

public class SourceDB {
	
		
	    private String url = Global.getConfig("source.url");
	    private String user = Global.getConfig("source.username");
        private String password = Global.getConfig("source.password");
	    
        private static SourceDB instance = null;
        
        private SourceDB(){
        	
        }
        
        public static SourceDB getInstance(){
        	if(instance==null){
        		synchronized (SourceDB.class) {
					if(instance==null){
						instance = new SourceDB();
					}
				}
        	}
        	return instance;
        }
        
        static {  
            try {  
                Class.forName("oracle.jdbc.driver.OracleDriver");  
            } catch (ClassNotFoundException e) {  
                throw new ExceptionInInitializerError(e);  
            }  
        }  
      
        public Connection getConnection() throws SQLException {  
            return DriverManager.getConnection(url, user, password);  
        }  
        
        public void close(ResultSet rs, Statement st, Connection conn) {  
            try {  
                if (rs != null)  
                    rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                try {  
                    if (st != null)  
                        st.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                } finally {  
                    if (conn != null)  
                        try {  
                            conn.close();  
                        } catch (SQLException e) {  
                            e.printStackTrace();  
                        }  
                }  
            }  
        } 
        
		public static void main(String[] args) throws SQLException{
			SourceDB sourceDB = new SourceDB();
		    System.out.println(sourceDB.getConnection());
		}
	  	
}
