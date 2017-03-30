package bankmanagement;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountServices {

	
	private AccountGateway ag;
	private int suma,sumaTotal,sumaPlata;
	
	public AccountServices() throws SQLException 
	{
			ag=new AccountGateway();
		
	}
	

	public ResultSet showAccountInfo(String name)
	{
		ResultSet r=ag.showAccountInfo(name);
		return r;
	}
	
	public void createAccount(String type,int amount,Date data,int idc,int ide)
	{
		ag.createNewAccount(type, amount, data, idc, ide);
	}
	
	public void updateAccount(int id,String type,int amount)
	{
		ag.updateAccount(id, type, amount);
	}
	
	public void deleteAccount(int id)
	{
		ag.deleteAccount(id);
	}
	
	
	
	
	public int getAmount(int id)  
	{
		ResultSet r=ag.getAmount(id);
		try {
			while(r.next())
			{
				suma=r.getInt("Amount");
				//System.out.println(suma);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma;
	}
		
	
	
	public void transferAmount(int src,int dst,int amountN)
	{
		int srca=getAmount(src);
		int dsta=getAmount(dst);
		
		dsta=dsta+amountN;
		
		if(srca>amountN)
		{
			srca=srca-amountN;
		}
		ag.updateAmount(src,srca);
		ag.updateAmount(dst,dsta);
	}
	
	public boolean findAccount(int id) throws SQLException
	{
		boolean ok=true;
		ResultSet r=ag.findAccount(id);
		if(r.next()) ok=true; else ok=false;
		return ok;
	}
	
	
	public void processBills(int id)
	{
		ResultSet r=ag.getBill(id);
		try{
			while(r.next())
			{
				sumaTotal=r.getInt("Amount");
				sumaPlata=r.getInt("AmountBill");
				if(sumaPlata<sumaTotal)
				{
					sumaTotal=sumaTotal-sumaPlata;
					ag.updateAmount(id,sumaTotal);
				}
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	
	
}
