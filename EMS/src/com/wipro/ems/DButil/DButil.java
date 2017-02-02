package com.wipro.ems.DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	static Connection con;
	public static Connection getDBConnection() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/world","root","2032");//oracle:thin:@10.0.0.1:1521/orcl
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
