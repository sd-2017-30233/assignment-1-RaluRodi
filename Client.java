package bankmanagement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
	
	
	private ClientGateway cg;
	
	public Client() throws SQLException 
	{
			cg=new ClientGateway();
		
	}
	
	
	public ResultSet showClientInfo(String name)
	{
		ResultSet r=cg.showClientInfo(name);
		return r;
	}
	
	public void insertClient(String name, int idc_nr,String cnp,String adress)
	{
		cg.insertNewClient(name, idc_nr, cnp, adress);
	}
	
	public void updateClient(String name, int idc_nr,String cnp,String adress)
	{
		cg.updateClient(name, idc_nr, cnp, adress);
	}
	
	public boolean findClient(String name) throws SQLException
	{
		boolean ok=true;
		ResultSet r=cg.findClient(name);
		if(r.next()) ok=true; else ok=false;
		return ok;
	}
	
	public boolean findClient(int id) throws SQLException
	{
		boolean ok=true;
		ResultSet r=cg.findClientId(id);
		if(r.next()) ok=true; else ok=false;
		return ok;
	}
}
