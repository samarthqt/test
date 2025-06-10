package com.framework.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MssqlDatabase {


	/**
	 * Function to get data from a MS SQL database
	 * 
	 * @param tableName The table name
	 * @param Iteration Iteration
	 */
	public void SQL(String tableName, String Iteration) {
		//C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=testdata;integratedSecurity=true;";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url);
			if(conn!=null) {
				Statement sta = conn.createStatement();
				String sql1 = "SELECT * from " +tableName+ " where TC_ID='TC001' AND Iteration = '" + Iteration +"'";
				sta.execute(sql1); sta.close();
			}else {
				System.out.println("Error while connecting SQL server");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

}
