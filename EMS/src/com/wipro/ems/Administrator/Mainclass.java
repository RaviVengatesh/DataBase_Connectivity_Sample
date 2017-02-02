package com.wipro.ems.Administrator;

import java.sql.SQLException;

import com.wipro.ems.Bean.Employebean;
import com.wipro.ems.Service.DMLQuries;

public class Mainclass 
{

	public static void main(String[] args) throws SQLException 
	{
		Employebean e=new Employebean();
		DMLQuries d=new DMLQuries();
		e.setEmpno(121);
		e.setEmpname("Venkat");
		e.setSalary(12000);
		d.insert(e);
		e.setEmpno(122);
		e.setEmpname("Ajay");
		e.setSalary(24000);
		d.insert(e);
		d.select();
		d.update("Nikhil");
	}

}
