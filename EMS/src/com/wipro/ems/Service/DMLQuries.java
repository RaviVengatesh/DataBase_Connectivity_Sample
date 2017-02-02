package com.wipro.ems.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.ems.Bean.Employebean;
import com.wipro.ems.DButil.DButil;

public class DMLQuries 
{

	public void insert(Employebean e) throws SQLException
	{
		Connection con=DButil.getDBConnection();
		if(con!=null)
		{
			PreparedStatement pst=con.prepareStatement("insert into EMPLOYEES values(?,?,?)");
			pst.setInt(1,e.getEmpno());
			pst.setString(2,e.getEmpname());
			pst.setInt(3,e.getSalary());
			int rs;
			rs=pst.executeUpdate();
			if(rs>0)
			{
				System.out.println("Inserted Successfully..");
			}
			else
			{
				System.out.println("Error in Insertion..");
			}
		}
	}
	public void select() throws SQLException
	{
		Connection con=DButil.getDBConnection();
		if(con!=null)
		{
			PreparedStatement pst=con.prepareStatement("select *  from EMPLOYEES");
			ResultSet rs;
			rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));//Depend upon the table attributes...
			}
		}
		
	}
	public void update(String name) throws SQLException
	{
		Connection con=DButil.getDBConnection();
		if(con!=null)
		{
			PreparedStatement pst=con.prepareStatement("update EMPLOYEES set FNAME=? where FNAME=?");
			pst.setString(1,name.toUpperCase());
			pst.setString(2,name);
			int rs;
			rs=pst.executeUpdate();
			if(rs>0)
			{
				System.out.println("Table Updated..");
			}
			else
			{
				System.out.println("Record not Found..");
			}
		}
	}
}
