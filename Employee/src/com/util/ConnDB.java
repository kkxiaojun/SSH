package com.util;
import java.sql.*;

public class ConnDB {
	
		private static ConnPool cp = new ConnPool(); 
		public static Connection getConn(){
			return cp.get();
		}
		public static void close(Connection conn){
			cp.put(conn);
		}

}
