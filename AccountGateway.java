package bankmanagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AccountGateway {
	
	  private Connection connection;
	  private Statement statement;
	  private ResultSet resultSet;
	  private CallableStatement callableStatement;
	  private DatabaseConnection conn;
	  
	  @SuppressWarnings("static-access")
	public AccountGateway() throws SQLException {
		  conn=new DatabaseConnection();
	    this.connection = conn.getConnection();
	  }
	  
	
	public String createNewAccount(String type,int amount,Date data,int idc,int ide) {
	    String result = new String();
	    try {
	      callableStatement = connection.prepareCall("{call CREATE_ACCOUNT(?,?,?,?,?)}");
	      callableStatement.setString(1,type);
	      callableStatement.setInt(2, amount);
	      callableStatement.setDate(3,data);
	      callableStatement.setInt(4,idc);
	      callableStatement.setInt(5,ide);
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


  
  public String updateAccount(int id,String type,int amount) {
	    String result = new String();
	    try {
	      callableStatement = connection.prepareCall("{call UPDATE_ACCOUNT(?,?,?)}");
	      callableStatement.setInt(1,id);
	      callableStatement.setString(2, type);
	      callableStatement.setInt(3,amount);
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
  
  
  
  public ResultSet showAccountInfo(String name) {
	    String query = "select c.nameC as Nume, a.account_type as Type, a.amount as Amount,a.creation_date as Date\n"+
	                    "from ClientInfo c,Account a\n"+
	    		        "where c.nameC='" +name+ "' and c.id=a.id_client;";
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
  
  
  
  public String deleteAccount(int id) {
	    String result = new String();
	    try {
	      callableStatement = connection.prepareCall("{call DELETE_ACCOUNT(?)}");
	      callableStatement.setInt(1,id);
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
  
  
  public ResultSet getAmount(int id) 
  {
	  String query = "select a.amount as Amount\n"+
              "from Account a\n"+
		       "where a.id='" +id+ "';";
	  try {
		  statement = connection.createStatement();
		  resultSet = statement.executeQuery(query);
		 // amount=resultSet.getInt("Amount");
  
		  /*while(resultSet.next())
		  {
			  String nume=resultSet.getString("Nume");
			  String type=resultSet.getString("Type");
			  int amount=resultSet.getInt("Amount");
			  Date data=resultSet.getDate("Date");
			  System.out.printf("%s %s %d %s",nume,type,amount,data);
		  }*/
	  }
	  catch (SQLException e) {
		  e.printStackTrace();
		  JOptionPane.showMessageDialog(null, "Failed!", null, JOptionPane.ERROR_MESSAGE);
	  }
	
	  return resultSet;

  }
  
  
  
  public String updateAmount(int id,int amount) {
	    String result = new String();
	    try {
	      callableStatement = connection.prepareCall("{call UPDATE_AMOUNT(?,?)}");
	      callableStatement.setInt(1,id);
	      callableStatement.setInt(2,amount);
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
  
  
  public ResultSet getBill(int id)
  
  {
	  String query = "select a.amount as Amount, b.amount as AmountBill\n"+
			  		  "from Account a, Bill b\n"+
			  		  "where a.id_client='"+id+"' and b.id_client=a.id_client;";
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
  
  
  
  public ResultSet findAccount(int id)
  {
	  
	  String query="select Account.id as ID from Account where Account.id='" +id+ "';";
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
