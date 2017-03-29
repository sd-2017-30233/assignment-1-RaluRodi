package bankmanagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EmployeeGateway {

	  private Connection connection;
	  private Statement statement;
	  private ResultSet resultSet;
	  private CallableStatement callableStatement;
	  private DatabaseConnection conn;

	  
	@SuppressWarnings("static-access")
	public EmployeeGateway() throws SQLException {
		  conn=new DatabaseConnection();
		  this.connection = conn.getConnection();
	  }
	  
	  
	  
	  public ResultSet showEmployeeInfo(String name) {
		    String query = "select e.nameE as Name, e.age as Age, e.empl_date as EmplDate\n"+
		                    "from Employee e\n"+
		    		        "where e.nameE='" +name+ "';";
		    try {
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(query);
		      }
		      catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed!", null, JOptionPane.ERROR_MESSAGE);
		      }
		      return resultSet;
		  }
	  
	  
	  public String insertNewEmployee(String name, int age,Date data) {
		    String result = new String();
		    try {
		      callableStatement = connection.prepareCall("{call ADD_EMPLOYEE(?,?,?)}");
		      callableStatement.setString(1,name);
		      callableStatement.setInt(2, age);
		      callableStatement.setDate(3,data);
		      callableStatement.execute();
		      resultSet = callableStatement.getResultSet();
		      if (callableStatement.getMoreResults()) {
		        resultSet = callableStatement.getResultSet();
		        resultSet.next();
		        result = resultSet.getString(1);
		      }
		    }
		    catch (SQLException e) {
		          e.printStackTrace();
		          
		    }
		    return result;
		  }
	  
	  
	  
	  
	  public String updateEmployee(String name, int age,Date data) {
		    String result = new String();
		    try {
		      callableStatement = connection.prepareCall("{call UPDATE_EMPLOYEE(?,?,?)}");
		      callableStatement.setString(1,name);
		      callableStatement.setInt(2, age);
		      callableStatement.setDate(3,data);
		      callableStatement.execute();
		      resultSet = callableStatement.getResultSet();
		      if (callableStatement.getMoreResults()) {
		        resultSet = callableStatement.getResultSet();
		        resultSet.next();
		        result = resultSet.getString(1);
		      }
		    }
		    catch (SQLException e) {
		          e.printStackTrace();
		          
		    }
		    return result;
		  }
	  
	  
	  
	  public String deleteEmployee(String name) {
		    String result = new String();
		    try {
		      callableStatement = connection.prepareCall("{call DELETE_EMPLOYEE(?)}");
		      callableStatement.setString(1,name);
		      callableStatement.execute();
		      resultSet = callableStatement.getResultSet();
		      if (callableStatement.getMoreResults()) {
		        resultSet = callableStatement.getResultSet();
		        resultSet.next();
		        result = resultSet.getString(1);
		      }
		    }
		    catch (SQLException e) {
		          e.printStackTrace();
		          
		    }
		    return result;
		  }
	  
	  public String getPassword(String user)
	  {
		  String pass=new String();
		  String query="select u.pass as Pass\n"+
                  "from BasicUser u\n"+
  		        "where u.username='" +user+ "';";
		  try {
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(query);
		        
		        while(resultSet.next())
		        {
		            pass=resultSet.getString("Pass");
		        }
		        
		      }
		      catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed!", null, JOptionPane.ERROR_MESSAGE);
		      }
		      return pass;
		  
	  }
	  
	  
	  
	  public String getPasswordAdmin(String user)
	  {
		  String pass=new String();
		  String query="select a.pass as Pass\n"+
                  "from Admin a\n"+
  		        "where a.username='" +user+ "';";
		  try {
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(query);
		        
		        while(resultSet.next())
		        {
		            pass=resultSet.getString("Pass");
		        }
		        
		      }
		      catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed!", null, JOptionPane.ERROR_MESSAGE);
		      }
		      return pass;
		  
	  }
	  
	  
	  public ResultSet findEmployee(String name)
	  {
		  
		  String query="select Employee.nameE as Nume from Employee where Employee.nameE='" +name+ "';";
		  try {
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(query);
		        
		      }
		      catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed!", null, JOptionPane.ERROR_MESSAGE);
		      }
		  return resultSet;
	  }
	  
	  
	  
	  
	  
	  public ResultSet employeeReports(Date d1,Date d2,String name) {
		    String query ="select e.nameE as Nume,c.NameC as NumeClient, a.account_type as Tip,a.amount as Suma\n"+
		    				"from Account a, ClientInfo c, Employee e\n"+
		    				"where a.creation_date>'"+d1+"'and a.creation_date<'"+d2+"' and a.id_client=c.id and a.id_employee=e.id and e.nameE='"+name+"'\n;";
		    try {
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(query);
		      }
		      catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed!", null, JOptionPane.ERROR_MESSAGE);
		      }
		      return resultSet;
		  }
}
