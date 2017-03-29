package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GraphicController extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("BankManagement");
	private DefaultTableModel model ;
	private JTable table;
	
	//PANELS
	private JPanel mainPanel=new JPanel();
	private JPanel userPanel=new JPanel();
	private JPanel adminPanel=new JPanel();
	
	//LABELS
	private JLabel welcomeLabel=new JLabel("WELCOME!");
	private JLabel clientLabel=new JLabel("Client Operations");
	private JLabel accountLabel=new JLabel("Account Operations");
	private JLabel employeeLabel=new JLabel("Employee Operations");
	
	//BUTTONS
	private JButton userButton=new JButton("USER");
	private JButton adminButton=new JButton("ADMIN");
	private JButton viewClientInfo=new JButton("View Client Info");
	private JButton addClient=new JButton("Add Client");
	private JButton updateClient=new JButton("Update Client");
	private JButton viewAccount=new JButton("View Client Account");
	private JButton addAccount=new JButton("Create Account");
	private JButton updateAccount=new JButton("Update Account");
	private JButton deleteAccount=new JButton("Delete Account");
	private JButton transferAccount=new JButton("Transfer");
	private JButton processBills=new JButton("Process Bills");
	private JButton emplInfo=new JButton("View Employee Info");
	private JButton addEmpl=new JButton("Add Employee");
	private JButton updateEmpl=new JButton("Update Employee");
	private JButton deleteEmpl=new JButton("Delete Employee");
	private JButton reportEmpl=new JButton("Employee Report");
	private JButton backUser=new JButton("BACK");
	private JButton backAdmin=new JButton("BACK");
	
	GraphicController()
	{
		  frame.setVisible(true);
		  frame.setSize(800,600);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  frame.add(mainPanel);
		  
		  //MAIN PANEL
		  mainPanel.setBackground(new Color(255, 230, 204));
		  mainPanel.setLayout(null);
		  
		  userButton.setBounds(180,250,130,50);
		  userButton.setBackground(new Color(102, 53, 0));
		  userButton.setForeground(Color.white);
		  userButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  userButton.addActionListener(new userPanel());
		  mainPanel.add(userButton);
	
		  adminButton.setBounds(500,250,130,50);
		  adminButton.setBackground(new Color(102, 53, 0));
		  adminButton.setForeground(Color.white);
		  adminButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  adminButton.addActionListener(new adminPanel());
		  mainPanel.add(adminButton);
		  
		  welcomeLabel.setBounds(300,100,300,100);
		  welcomeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		  welcomeLabel.setForeground(new Color(102, 53, 0));
		  mainPanel.add(welcomeLabel);
		  
		 //USER PANEL
		  userPanel.setBackground(new Color(255, 230, 204));
		  userPanel.setLayout(null);
		  clientLabel.setBounds(100, 80, 200, 30);
		  clientLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		  clientLabel.setForeground(new Color(102, 53, 0));
		  userPanel.add(clientLabel);
		  
		  viewClientInfo.setBounds(100,160,170,30);
		  viewClientInfo.setBackground(new Color(102, 53, 0));
		  viewClientInfo.setForeground(Color.white);
		  viewClientInfo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  viewClientInfo.addActionListener(new clientInfo());
		  userPanel.add(viewClientInfo);
		  
		  addClient.setBounds(100,210,170,30);
		  addClient.setBackground(new Color(102, 53, 0));
		  addClient.setForeground(Color.white);
		  addClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  addClient.addActionListener(new addClient());
		  userPanel.add(addClient);
		  
		  updateClient.setBounds(100,260,170,30);
		  updateClient.setBackground(new Color(102, 53, 0));
		  updateClient.setForeground(Color.white);
		  updateClient.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  updateClient.addActionListener(new updateClient());
		  userPanel.add(updateClient);
		  
		  accountLabel.setBounds(450, 80, 250, 30);
		  accountLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		  accountLabel.setForeground(new Color(102, 53, 0));
		  userPanel.add(accountLabel);
		  
		  viewAccount.setBounds(450,160,170,30);
		  viewAccount.setBackground(new Color(102, 53, 0));
		  viewAccount.setForeground(Color.white);
		  viewAccount.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  viewAccount.addActionListener(new accountInfo());
		  userPanel.add(viewAccount);
		  
		  addAccount.setBounds(450,210,170,30);
		  addAccount.setBackground(new Color(102, 53, 0));
		  addAccount.setForeground(Color.white);
		  addAccount.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  addAccount.addActionListener(new createAccount());
		  userPanel.add(addAccount);
		  
		  updateAccount.setBounds(450,260,170,30);
		  updateAccount.setBackground(new Color(102, 53, 0));
		  updateAccount.setForeground(Color.white);
		  updateAccount.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  updateAccount.addActionListener(new updateAccount());
		  userPanel.add(updateAccount);
		  
		  deleteAccount.setBounds(450,310,170,30);
		  deleteAccount.setBackground(new Color(102, 53, 0));
		  deleteAccount.setForeground(Color.white);
		  deleteAccount.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  deleteAccount.addActionListener(new deleteAccount());
		  userPanel.add(deleteAccount);
		  
		  transferAccount.setBounds(450,360,170,30);
		  transferAccount.setBackground(new Color(102, 53, 0));
		  transferAccount.setForeground(Color.white);
		  transferAccount.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  transferAccount.addActionListener(new transfer());
		  userPanel.add(transferAccount);
		  
		  processBills.setBounds(450,410,170,30);
		  processBills.setBackground(new Color(102, 53, 0));
		  processBills.setForeground(Color.white);
		  processBills.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  processBills.addActionListener(new processBills());
		  userPanel.add(processBills);
		  
		  backUser.setBounds(290,480,130,50);
		  backUser.setBackground(new Color(102, 53, 0));
		  backUser.setForeground(Color.white);
		  backUser.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  backUser.addActionListener(new backUser());
		  userPanel.add(backUser);
		  
		  //ADMIN PANEL
		  adminPanel.setBackground(new Color(255, 230, 204));
		  adminPanel.setLayout(null);
		  employeeLabel.setBounds(300, 80, 300, 30);
		  employeeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		  employeeLabel.setForeground(new Color(102, 53, 0));
		  adminPanel.add(employeeLabel);
		  
		  emplInfo.setBounds(330,160,170,30);
		  emplInfo.setBackground(new Color(102, 53, 0));
		  emplInfo.setForeground(Color.white);
		  emplInfo.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  emplInfo.addActionListener(new employeeInfo());
		  adminPanel.add(emplInfo);
		  
		  addEmpl.setBounds(330,210,170,30);
		  addEmpl.setBackground(new Color(102, 53, 0));
		  addEmpl.setForeground(Color.white);
		  addEmpl.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  addEmpl.addActionListener(new addEmployee());
		  adminPanel.add(addEmpl);
		  
		  updateEmpl.setBounds(330,260,170,30);
		  updateEmpl.setBackground(new Color(102, 53, 0));
		  updateEmpl.setForeground(Color.white);
		  updateEmpl.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  updateEmpl.addActionListener(new updateEmployee());
		  adminPanel.add(updateEmpl);
		  
		  deleteEmpl.setBounds(330,310,170,30);
		  deleteEmpl.setBackground(new Color(102, 53, 0));
		  deleteEmpl.setForeground(Color.white);
		  deleteEmpl.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  deleteEmpl.addActionListener(new deleteEmployee());
		  adminPanel.add(deleteEmpl);
		  
		  reportEmpl.setBounds(330,360,170,30);
		  reportEmpl.setBackground(new Color(102, 53, 0));
		  reportEmpl.setForeground(Color.white);
		  reportEmpl.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		  reportEmpl.addActionListener(new employeeReport());
		  adminPanel.add(reportEmpl);
		  
		  backAdmin.setBounds(290,480,130,50);
		  backAdmin.setBackground(new Color(102, 53, 0));
		  backAdmin.setForeground(Color.white);
		  backAdmin.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		  backAdmin.addActionListener(new adminUser());
		  adminPanel.add(backAdmin);
		  
		  
		  
		  
	}
	
	public void setPanel(JPanel panel)
	{
	frame.setContentPane(panel);
	frame.validate();
	}
	
	
	//LISTENERI
	
	
	//BUTTONS FOR USER TO ACCESS
	class userPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JTextField userText = new JTextField();
			JTextField passText = new JTextField();
			
			Object[] msg = {"Username:",userText,"Password:",passText};
			JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
			       JDialog dialog = op.createDialog("Authentication:");
			       dialog.setVisible(true);
			       int result = JOptionPane.OK_OPTION;
			       try
			       {
			           result = ((Integer)op.getValue()).intValue();
			       }
			       catch(Exception uninitializedValue)
			       {}
			     if (result == JOptionPane.OK_OPTION)
			     {
			    	 
			    	String user=userText.getText();
			    	String pass=passText.getText();
			    	 if (user.equals("") || pass.equals(""))
			    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
			    	 else  
			    	 {
			    		 try {
							Employee emp=new Employee();
							if(!(emp.getPassword(user, pass)))
							{
								JOptionPane.showMessageDialog(null, "Username and Password don't match", "Alert", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								setPanel(userPanel);
								userPanel.setVisible(true);
								mainPanel.setVisible(false); 
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    	 }
			     }
	}
}
		
	
	
	//SHOW CLIENT INFO
	class clientInfo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JTextField NameText = new JTextField();
			Object[] msg = {"Enter client's name:",NameText};
			JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
			JDialog dialog = op.createDialog("Enter data:");
			dialog.setVisible(true);
			int result = JOptionPane.OK_OPTION;
			     try
			     {
			           result = ((Integer)op.getValue()).intValue();
			     }
			       catch(Exception uninitializedValue)
			       {}
			     if (result == JOptionPane.OK_OPTION)
			     {
			    	 
			    	String fname=NameText.getText();
			    	 if (fname.equals(""))
			    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
			    	 else
			    	 {
			    	 Client c;
					try {
						 c = new Client();
						 String[] columnNames = { "Name","Card nr.","CNP","Andress"};
						 if(c.findClient(fname)==false)
						 {
							 JOptionPane.showMessageDialog(null, "Client doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
						 }
						 else
						 {
				    	 String[][] data = parseClientInfo(c.showClientInfo(fname), 0, 4);
				    	    
				    	    model=new DefaultTableModel(data,columnNames);
				    	    table=new JTable(model);
				    	    table.setEnabled(false);
				    	    table.setBackground(new Color(255, 230, 204));
				    	 
				    	    JDialog dialog1=new JDialog();
				    	    dialog1.setVisible(false);
				    	    dialog1.setBounds(0,0,400,400);
				    	    dialog1.setLocationRelativeTo(null);
				    		dialog1.setTitle("Client Info");
				    		JScrollPane scrollPane = new JScrollPane(table);
				    		scrollPane.setBounds(10, 50, 150, 120);
				    		scrollPane.setEnabled(false);
				    		dialog1.add(scrollPane);
				    		dialog1.pack();
				    		dialog1.setVisible(true);
						 }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			  }
	}
	}
	}
	
	

		//ADD NEW CLIENT
		class addClient implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				JTextField NameText = new JTextField();
				JTextField idcText = new JTextField();
				JTextField cnpText = new JTextField();
				JTextField adressText = new JTextField();
				
				Object[] msg = {"Name:",NameText,"IDC number:",idcText,"CNP:",cnpText,"Adress:",adressText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				  	try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
				     
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 
				    	String name=NameText.getText();
				    	int idc=Integer.parseInt(idcText.getText());
				    	String cnp=cnpText.getText();
				    	String adress=adressText.getText();
				    	
				   if (name.equals("")||cnp.equals("")||adress.equals(""))
				    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				    	 else
				    	
				    	try {
							Client c=new Client();
							if(c.findClient(name)) 
							{
					JOptionPane.showMessageDialog(null, "Client exists!", null, JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								c.insertClient(name, idc, cnp, adress);
								JOptionPane.showMessageDialog(null, "Client added!", null, JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    	
				     }
			}
		}
		
		
		
		
		
	//UPDATE CLIENT
	class updateClient implements ActionListener {
		public void actionPerformed(ActionEvent e) {
						
			JTextField NameText = new JTextField();
			JTextField idcText = new JTextField();
			JTextField cnpText = new JTextField();
			JTextField adressText = new JTextField();
			
			Object[] msg = {"Name:",NameText,"IDC number:",idcText,"CNP:",cnpText,"Adress:",adressText};
			JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
			JDialog dialog = op.createDialog("Enter data:");
			dialog.setVisible(true);
			int result = JOptionPane.OK_OPTION;
			  	try
			       {
			           result = ((Integer)op.getValue()).intValue();
			       }
			       catch(Exception uninitializedValue)
			       {}
			     
			     if (result == JOptionPane.OK_OPTION)
			     {
			    	 
			    	String name=NameText.getText();
			    	int idc=Integer.parseInt(idcText.getText());
			    	String cnp=cnpText.getText();
			    	String adress=adressText.getText();
			   if (name.equals("")||cnp.equals("")||adress.equals(""))
			      JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
			   else
			    	try {
						Client c=new Client();
						if(c.findClient(name)==false)
						{
				JOptionPane.showMessageDialog(null, "Client doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							c.updateClient(name, idc, cnp, adress);
				JOptionPane.showMessageDialog(null, "Client updated!", null, JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			     }
		}
	}
	
	
	
	
	//VIEW CLIENT'S ACCOUNT
	class accountInfo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JTextField NameText = new JTextField();
			Object[] msg = {"Enter client's name:",NameText};
			JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
			JDialog dialog = op.createDialog("Enter data:");
			dialog.setVisible(true);
			int result = JOptionPane.OK_OPTION;
			     try
			     {
			           result = ((Integer)op.getValue()).intValue();
			     }
			       catch(Exception uninitializedValue)
			       {}
			     if (result == JOptionPane.OK_OPTION)
			     {
			    	 
			    	String fname=NameText.getText();
			    	 if (fname.equals(""))
			    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
			    	 else
			    	 {
			    	 Account a;
			    	 Client c;
					try {
						 a = new Account();
						 c=new Client();
						 String[] columnNames = { "Name","Account Type","Amount","Date"};
						 if(c.findClient(fname)==false)
						 {
							 JOptionPane.showMessageDialog(null, "Client doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
						 }
						 else
						 {
				    	 String[][] data = parseAccountInfo(a.showAccountInfo(fname), 0, 4);
				    	    
				    	    model=new DefaultTableModel(data,columnNames);
				    	    table=new JTable(model);
				    	    table.setEnabled(false);
				    	    table.setBackground(new Color(255, 230, 204));
				    	 
				    	    JDialog dialog1=new JDialog();
				    	    dialog1.setVisible(false);
				    	    dialog1.setBounds(0,0,400,400);
				    	    dialog1.setLocationRelativeTo(null);
				    		dialog1.setTitle("Account Info");
				    		JScrollPane scrollPane = new JScrollPane(table);
				    		scrollPane.setBounds(10, 50, 150, 120);
				    		scrollPane.setEnabled(false);
				    		dialog1.add(scrollPane);
				    		dialog1.pack();
				    		dialog1.setVisible(true);
						 }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			  }
	}
	}
	}
	
	
	
	
	
	
	
	//CREATE ACCOUNT
	class createAccount implements ActionListener {
		public void actionPerformed(ActionEvent e) {
						
			JTextField accType = new JTextField();
			JTextField amount = new JTextField();
			JTextField date = new JTextField();
			JTextField idc = new JTextField();
			JTextField ide = new JTextField();
			
			Object[] msg = {"Type:",accType,"Amount:",amount,"Date:",date,"IDclient:",idc,"IDemployee",ide};
			JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
			JDialog dialog = op.createDialog("Enter data:");
			dialog.setVisible(true);
			int result = JOptionPane.OK_OPTION;
			  	try
			       {
			           result = ((Integer)op.getValue()).intValue();
			       }
			       catch(Exception uninitializedValue)
			       {}
			     
			     if (result == JOptionPane.OK_OPTION)
			     {
			    	 
			    	String typee=accType.getText();
			    	int amountt=Integer.parseInt(amount.getText());
			    	
			    	String dates=date.getText();
			    	java.util.Date utilDate = new Date();
					try {
						utilDate = new SimpleDateFormat("yyy-MM-dd").parse(dates);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    	int idcc=Integer.parseInt(idc.getText());
			    	int idee=Integer.parseInt(ide.getText());
			    	
			   if (typee.equals("")||dates.equals("")||idc.getText().equals("")||ide.getText().equals("")||amount.getText().equals(""))
			      JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
			   else
			    	try {
			    Account a=new Account();
				a.createAccount(typee, amountt,sqlDate, idcc,idee);
				JOptionPane.showMessageDialog(null, "Account added!", null, JOptionPane.INFORMATION_MESSAGE);
						}
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     }
		}
	}
	
	
	
	
	//UPDATE ACCOUNT
		class updateAccount implements ActionListener {
			public void actionPerformed(ActionEvent e) {
							
				JTextField idText = new JTextField();
				JTextField typeText = new JTextField();
				JTextField amountText = new JTextField();
				
				Object[] msg = {"ID:",idText,"Type:",typeText,"Amount:",amountText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				  	try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
				     
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	int id=Integer.parseInt(idText.getText());
				    	String accType=typeText.getText();
				    	int amount=Integer.parseInt(amountText.getText());
				   if (idText.getText().equals("")||accType.equals("")||amountText.getText().equals(""))
				      JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				   else
				    	try {
							Account a=new Account();
							if(a.findAccount(id)==false)
							{
					JOptionPane.showMessageDialog(null, "Account doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								a.updateAccount(id, accType, amount);
					JOptionPane.showMessageDialog(null, "Account updated!", null, JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				   }
			}
		}
		
		
		
		
		
		//DELETE ACCOUNT
		class deleteAccount implements ActionListener {
			public void actionPerformed(ActionEvent e) {
									
				JTextField idText = new JTextField();
					
				Object[] msg = {"ID:",idText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				  	try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
						     
				     if (result == JOptionPane.OK_OPTION)
				     {
				     int id=Integer.parseInt(idText.getText());
						
			if (idText.getText().equals(""))
			   JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
			 else
					try {
						Account a=new Account();
						if(a.findAccount(id)==false)
							{
					JOptionPane.showMessageDialog(null, "Account doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
							}
						else
							{
						a.deleteAccount(id);
					JOptionPane.showMessageDialog(null, "Account deleted!", null, JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				  }
			}
		}
		
		
		
//TRANSFER
		class transfer implements ActionListener {
			public void actionPerformed(ActionEvent e) {
							
				JTextField acc1Text = new JTextField();
				JTextField acc2Text = new JTextField();
				JTextField amountText = new JTextField();

				Object[] msg = {"Source Account:",acc1Text,"Dest Account:",acc2Text,"Amount:",amountText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				  	try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
				     
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	int acc1=Integer.parseInt(acc1Text.getText());
				    	int acc2=Integer.parseInt(acc2Text.getText());
				    	int amount=Integer.parseInt(amountText.getText());
				    	try {
							Account a=new Account();
							a.transferAmount(acc1, acc2, amount);
					JOptionPane.showMessageDialog(null, "Success!", null, JOptionPane.INFORMATION_MESSAGE);
							}
						 catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    	
				     }
			}
		}
		

		
//BACK
class backUser implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
		setPanel(mainPanel);
		adminPanel.setVisible(false);
		userPanel.setVisible(false);
		mainPanel.setVisible(true); 
	}
}
		
//PROCESS BILLS
class processBills implements ActionListener {
	public void actionPerformed(ActionEvent e) {
									
				JTextField idText = new JTextField();
					
				Object[] msg = {"Client's id:",idText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				  	try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
						     
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 int id=Integer.parseInt(idText.getText());
						
			if (idText.getText().equals(""))
			   JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
			 else
					try {
						Account a=new Account();
						Client c=new Client();
						if(c.findClient(id)==false)
							{
					JOptionPane.showMessageDialog(null, "Invalid ID!", "Alert", JOptionPane.ERROR_MESSAGE);
							}
						else
							{
						a.processBills(id);
					JOptionPane.showMessageDialog(null, "Done!", null, JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				  }
			}
		}
		
//ADMIN
		class adminPanel implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				JTextField userText = new JTextField();
				JTextField passText = new JTextField();
				
				Object[] msg = {"Username:",userText,"Password:",passText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				       JDialog dialog = op.createDialog("Authentication:");
				       dialog.setVisible(true);
				       int result = JOptionPane.OK_OPTION;
				       try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 
				    	String user=userText.getText();
				    	String pass=passText.getText();
				    	 if (user.equals("") || pass.equals(""))
				    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				    	 else  
				    	 {
				    		 try {
								Employee emp=new Employee();
								if(!(emp.getPasswordAdmin(user, pass)))
								{
									JOptionPane.showMessageDialog(null, "Username and Password don't match", "Alert", JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									setPanel(adminPanel);
									adminPanel.setVisible(true);
									userPanel.setVisible(false);
									mainPanel.setVisible(false); 
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				    	 }
				     }
		}
	}
		
		
//SHOW EMPLOYEE INFO
		class employeeInfo implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				JTextField NameText = new JTextField();
				Object[] msg = {"Enter employee's name:",NameText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				     try
				     {
				           result = ((Integer)op.getValue()).intValue();
				     }
				       catch(Exception uninitializedValue)
				       {}
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 
				    	String fname=NameText.getText();
				    	 if (fname.equals(""))
				    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				    	 else
				    	 {
				    	 Employee c;
						try {
							 c = new Employee();
							 String[] columnNames = { "Name","Age","Employment Date"};
							 if(c.findEmployee(fname)==false)
							 {
								 JOptionPane.showMessageDialog(null, "Client doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
							 }
							 else
							 {
					    	 String[][] data = parseEmployeeInfo(c.showEmployeeInfo(fname), 0, 3);
					    	    
					    	    model=new DefaultTableModel(data,columnNames);
					    	    table=new JTable(model);
					    	    table.setEnabled(false);
					    	    table.setBackground(new Color(255, 230, 204));
					    	 
					    	    JDialog dialog1=new JDialog();
					    	    dialog1.setVisible(false);
					    	    dialog1.setBounds(0,0,400,400);
					    	    dialog1.setLocationRelativeTo(null);
					    		dialog1.setTitle("Employee Info");
					    		JScrollPane scrollPane = new JScrollPane(table);
					    		scrollPane.setBounds(10, 50, 150, 120);
					    		scrollPane.setEnabled(false);
					    		dialog1.add(scrollPane);
					    		dialog1.pack();
					    		dialog1.setVisible(true);
							 }
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				  }
		}
		}
		}

		

//ADD NEW CLIENT
		class addEmployee implements ActionListener {
			public void actionPerformed(ActionEvent e) {
						
			    JTextField NameText = new JTextField();
				JTextField ageText = new JTextField();
				JTextField dateText = new JTextField();
						
						Object[] msg = {"Name:",NameText,"Age:",ageText,"Employment Date:",dateText};
						JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
						JDialog dialog = op.createDialog("Enter data:");
						dialog.setVisible(true);
						int result = JOptionPane.OK_OPTION;
						  	try
						       {
						           result = ((Integer)op.getValue()).intValue();
						       }
						       catch(Exception uninitializedValue)
						       {}
						     
						     if (result == JOptionPane.OK_OPTION)
						     {
						    	 
						    	String name=NameText.getText();
						    	int age=Integer.parseInt(ageText.getText());
						    	String dates=dateText.getText();
						    	java.util.Date utilDate = new Date();
								try {
									utilDate = new SimpleDateFormat("yyy-MM-dd").parse(dates);
								} catch (ParseException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
						    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
						    	
						   if (name.equals("")||ageText.getText().equals("")||dates.equals(""))
						    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
						    	 else
						    	
						    	try {
									Employee c=new Employee();
									if(c.findEmployee(name)) 
									{
							JOptionPane.showMessageDialog(null, "Employee exists!", null, JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										c.insertNewEmployee(name, age, sqlDate);
										JOptionPane.showMessageDialog(null, "Employee added!", null, JOptionPane.INFORMATION_MESSAGE);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						    	
						     }
					}
				}
				
				
//UPDATE EMPLOYEE
		class updateEmployee implements ActionListener {
			public void actionPerformed(ActionEvent e) {
							
				JTextField NameText = new JTextField();
				JTextField ageText = new JTextField();
				JTextField dateText = new JTextField();
				
				Object[] msg = {"Name:",NameText,"Age:",ageText,"Employment Date:",dateText};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				  	try
				       {
				           result = ((Integer)op.getValue()).intValue();
				       }
				       catch(Exception uninitializedValue)
				       {}
				     
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 
				    	String name=NameText.getText();
				    	int age=Integer.parseInt(ageText.getText());
				    	String dates=dateText.getText();
				    	java.util.Date utilDate = new Date();
						try {
							utilDate = new SimpleDateFormat("yyy-MM-dd").parse(dates);
						} catch (ParseException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
				    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				    	
				   if (name.equals("")||dates.equals("")||ageText.getText().equals(""))
				      JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				   else
				    	try {
							Employee c=new Employee();
							if(c.findEmployee(name)==false)
							{
					JOptionPane.showMessageDialog(null, "Employee doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								c.updateEmployee(name, age, sqlDate);
					JOptionPane.showMessageDialog(null, "Employee updated!", null, JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    	
				     }
			}
		}
		
		
		

		
		
//DELETE EMPLOYEE
		class deleteEmployee implements ActionListener {
			public void actionPerformed(ActionEvent e) {
											
						JTextField nameText = new JTextField();
							
						Object[] msg = {"Name:",nameText};
						JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
						JDialog dialog = op.createDialog("Enter data:");
						dialog.setVisible(true);
						int result = JOptionPane.OK_OPTION;
						  	try
						       {
						           result = ((Integer)op.getValue()).intValue();
						       }
						       catch(Exception uninitializedValue)
						       {}
								     
						     if (result == JOptionPane.OK_OPTION)
						     {
						    	 String name=nameText.getText();
								
					if (name.equals(""))
					   JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
					 else
							try {
								Employee a=new Employee();
								if(a.findEmployee(name)==false)
									{
							JOptionPane.showMessageDialog(null, "Employee doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
									}
								else
									{
								a.deleteEmployee(name);
							JOptionPane.showMessageDialog(null, "Employee deleted!", null, JOptionPane.INFORMATION_MESSAGE);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						  }
					}
				}
		
		
		
		
//EMPLOYEE REPORT
	class employeeReport implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				
				JTextField d1Text = new JTextField();
				JTextField d2Text = new JTextField();
				JTextField nameText = new JTextField();
				Object[] msg = {"Employee's name:",nameText,"Begining of period:",d1Text,"End of period:",d2Text};
				JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
				JDialog dialog = op.createDialog("Enter data:");
				dialog.setVisible(true);
				int result = JOptionPane.OK_OPTION;
				     try
				     {
				           result = ((Integer)op.getValue()).intValue();
				     }
				       catch(Exception uninitializedValue)
				       {}
				     if (result == JOptionPane.OK_OPTION)
				     {
				    	 String name=nameText.getText();
				    	 String d1=d1Text.getText();
				    	 String d2=d2Text.getText();
					    	java.util.Date utilDate = new Date();
					    	java.util.Date utilDate1=new Date();
							try {
								utilDate = new SimpleDateFormat("yyy-MM-dd").parse(d1);
								utilDate1 = new SimpleDateFormat("yyy-MM-dd").parse(d2);
							} catch (ParseException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
					    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					    	java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
				    	
				    	 if (sqlDate.equals("")||sqlDate1.equals(""))
				    		 JOptionPane.showMessageDialog(null, "Uncompleted field", "Alert", JOptionPane.ERROR_MESSAGE);
				    	 else
				    	 {
				    	 Employee c;
						try {
							 c = new Employee();
							 String[] columnNames = { "EmployeeName","ClientName","AccountType","Amount"};
							 {
					    	 String[][] data = parseEmployeeReport(c.employeeReport(sqlDate, sqlDate1,name), 0, 4);
					    	    
					    	    model=new DefaultTableModel(data,columnNames);
					    	    table=new JTable(model);
					    	    table.setEnabled(false);
					    	    table.setBackground(new Color(255, 230, 204));
					    	 
					    	    JDialog dialog1=new JDialog();
					    	    dialog1.setVisible(false);
					    	    dialog1.setBounds(0,0,400,400);
					    	    dialog1.setLocationRelativeTo(null);
					    		dialog1.setTitle("Employee Report");
					    		JScrollPane scrollPane = new JScrollPane(table);
					    		scrollPane.setBounds(10, 50, 150, 120);
					    		scrollPane.setEnabled(false);
					    		dialog1.add(scrollPane);
					    		dialog1.pack();
					    		dialog1.setVisible(true);
							 }
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				  }
		}
		}
		}
		
	

	//BACK
	class adminUser implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			setPanel(mainPanel);
			adminPanel.setVisible(false);
			userPanel.setVisible(false);
			mainPanel.setVisible(true); 
		}
	}
	
		
		private String[][] parseClientInfo(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;
		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }
		        result[i][j] = resultSet.getString(1);
		        j++;
		        Integer t=resultSet.getInt(2);
		        result[i][j] = t.toString();
		        j++;
		        result[i][j] = resultSet.getString(3);
		        j++;
		        result[i][j] = resultSet.getString(4);
		        j++;
		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
		
		
		
		private String[][] parseAccountInfo(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;
		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }
		        result[i][j] = resultSet.getString(1);
		        j++;
		        result[i][j] = resultSet.getString(2);
		        j++;
		        Integer t=resultSet.getInt(3);
		        result[i][j] = t.toString();
		        j++;
		        Date d=resultSet.getDate(4);
		        result[i][j] = d.toString();
		        j++;
		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
		
		
		
		
		private String[][] parseEmployeeInfo(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;
		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }
		        result[i][j] = resultSet.getString(1);
		        j++;
		        Integer t=resultSet.getInt(2);
		        result[i][j] = t.toString();
		        j++;
		        Date d=resultSet.getDate(3);
		        result[i][j] = d.toString();
		        j++;
		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
		
		
		
		private String[][] parseEmployeeReport(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;
		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }
		        result[i][j] = resultSet.getString(1);
		        j++;
		        result[i][j] = resultSet.getString(2);
		        j++;
		        result[i][j] = resultSet.getString(3);
		        j++;
		        Integer t=resultSet.getInt(4);
		        result[i][j] = t.toString();
		        j++;
		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
		
		
		private String[][] copyMatrix(String[][] data, Integer rowCount, Integer columnCount) {
		    String[][] result = new String[rowCount + 1][columnCount];
		    for (int i = 0; i < rowCount; i++) {
		      for (int j = 0; j < columnCount; j++) {
		        result[i][j] = data[i][j];
		      }
		    }
		    return result;
		  }


	
}
