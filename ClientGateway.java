package bankmanagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ClientGateway {
	
	  private Connection connection;
	  private Statement statement;
	  private ResultSet resultSet;
	  private CallableStatement callableStatement;
	  private DatabaseConnection conn;

	  @SuppressWarnings("static-access")
	public ClientGateway() throws SQLException {
		  conn=new DatabaseConnection();
		  this.connection = conn.getConnection();
	  }
	 

	  public ResultSet showClientInfo(String name) {
	    String query = "select c.nameC as Nume, c.identity_card_nr as IDCnr, c.cnp as CNP,c.adress as Adress\n"+
	                    "from ClientInfo c\n"+
	    		        "where c.nameC='" +name+ "';";
	    try {
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);
	        
	       /* while(resultSet.next())
	        {
	        	String nume=resultSet.getString("Nume");
	        	System.out.printf("%s",nume);
	        }*/
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed!", null, JOptionPane.ERROR_MESSAGE);
	      }
	      return resultSet;

	  }
	  
	  
	  
	  public String insertNewClient(String name, int idc_nr,String cnp,String adress) {
		    String result = new String();
		    try {
		      callableStatement = connection.prepareCall("{call ADD_CLIENT(?,?,?,?)}");
		      callableStatement.setString(1,name);
		      callableStatement.setInt(2, idc_nr);
		      callableStatement.setString(3,cnp);
		      callableStatement.setString(4,adress);
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
	  
	
	  

	  public String updateClient(String name, int idc_nr,String cnp,String adress) {
		    String result = new String();
		    try {
		      callableStatement = connection.prepareCall("{call UPDATE_CLIENT(?,?,?,?)}");
		      callableStatement.setString(1,name);
		      callableStatement.setInt(2, idc_nr);
		      callableStatement.setString(3,cnp);
		      callableStatement.setString(4,adress);
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
	  
	  
	  public ResultSet findClient(String name)
	  {
		  
		  String query="select ClientInfo.nameC as Nume from ClientInfo where ClientInfo.nameC='" +name+ "';";
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
	  
	  public ResultSet findClientId(int id)
	  {
		  
		  String query="select ClientInfo.id as ID from ClientInfo where ClientInfo.id='" +id+ "';";
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
