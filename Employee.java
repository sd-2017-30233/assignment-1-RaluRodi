package bankmanagement;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {


	private EmployeeGateway eg;
	
	
	public Employee() throws SQLException
	{
		eg=new EmployeeGateway();
	}
	
	
	
	public ResultSet showEmployeeInfo(String name)
	{
		ResultSet r=eg.showEmployeeInfo(name);
		return r;
	}
	
	public void insertNewEmployee(String name, int age, Date empl_date)
	{
		eg.insertNewEmployee(name, age, empl_date);
	}
	
	public void updateEmployee(String name,int age,Date empl_date)
	{
		eg.updateEmployee(name, age, empl_date);
	}
	
	public void deleteEmployee(String name)
	{
		eg.deleteEmployee(name);
	}
	
	public boolean getPassword(String user,String passowrd)
	{
		String pass=eg.getPassword(user);
		
		if(!(pass.equals(passowrd))) 
			return false;
		
		else return true;
	}
	
	public boolean getPasswordAdmin(String user,String passowrd)
	{
		String pass=eg.getPasswordAdmin(user);
		
		if(!(pass.equals(passowrd))) 
			return false;
		
		else return true;
	}
	
	public boolean findEmployee(String name) throws SQLException
	{
		boolean ok=true;
		ResultSet r=eg.findEmployee(name);
		if(r.next()) ok=true; else ok=false;
		return ok;
	}
	
	public ResultSet employeeReport(Date d1,Date d2,String name)
	{
		ResultSet r=eg.employeeReports(d1, d2,name);
		return r;
	}
}
