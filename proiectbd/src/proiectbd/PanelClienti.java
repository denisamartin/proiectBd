package proiectbd;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.jdbc.CallableStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelClienti extends JPanel {
	private JTextField textField;
	private JTextField textField2;
	Connection con;
	
	
	
	public PanelClienti() {
		  setBackground(new Color(0, 128, 128));
		  setVisible(true);
		  setBounds(0,0,470,471);
		  setLayout(null);
		  
		  //Titlu
		  JLabel lblClienti = new JLabel("Clien\u021Bi");
		  lblClienti.setForeground(new Color(0, 61, 77));
		  lblClienti.setFont(new Font("Tahoma", Font.BOLD, 25));
		  lblClienti.setBounds(193, 33, 86, 31);
		  add(lblClienti);
		  
		  //Interogare1
		  JLabel labelInterogare1 = new JLabel("Afi\u0219area clien\u021Bilor care au facturi emise \u00EEn anul:");
		  labelInterogare1.setForeground(new Color(0, 61, 77));
		  labelInterogare1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  labelInterogare1.setBounds(38, 74, 406, 45);
		  add(labelInterogare1);
		  
		  textField = new JTextField();
		  textField.setForeground(Color.WHITE);
		  textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  textField.setColumns(10);
		  textField.setBackground(new Color(0, 61, 77));
		  textField.setBounds(38, 118, 396, 34);
		  add(textField);
		  
		  //Raspunsuri1
		  JList list = new JList();
		  list.setForeground(Color.WHITE);
		  list.setBackground(new Color(0, 61, 77));
		  list.setBounds(38, 262, 396, 59);
		  add(list);
		  
		  
		  //Button1
		  JButton buttonSearch1 = new JButton("Caut\u0103");
		  buttonSearch1.addActionListener(new ActionListener() {
		  	
			  public void actionPerformed(ActionEvent e) {
					try 
					{	
						int x=0;
						String data;
					    data= textField.getText();
					    try
						 {
				            x = Integer.parseInt(data);
				        
						 }
	                     catch (NumberFormatException nx)
						{   
							 JOptionPane.showMessageDialog(null, "Incorrect number...");
					     }
					con=SqlConnection.dbConnector(0); 
					Statement stmt1=con.createStatement();
					String sql= "SELECT DISTINCT c.nume FROM Client c Join Factura f ON( c.id_c=f.id_c) WHERE EXTRACT(YEAR FROM f.data) =" +textField.getText()+";"; 	
				    ResultSet rs=stmt1.executeQuery(sql);   
					DefaultListModel DLM= new DefaultListModel();
					DLM.addAll((Collection) DbUtils.resultSetToNestedList(rs));
					list.setModel( DLM);
					
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
			  		 
			  }
		  });
		  
		  JScrollPane jp3= new JScrollPane(list);
		  jp3.setLocation(38, 162);
		  jp3.setSize(396, 50);
		  add(jp3);
		  
		  buttonSearch1.setForeground(Color.WHITE);
		  buttonSearch1.setBackground(new Color(0, 61, 77));
		  buttonSearch1.setBounds(174, 222, 105, 27);
		  add(buttonSearch1);
		  
		  //Interogare2
		  JLabel labelInterogare2 = new JLabel("Afi\u0219area clientului care are factura cu totalul maxim ");
		  labelInterogare2.setForeground(new Color(0, 61, 77));
		  labelInterogare2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  labelInterogare2.setBounds(38, 247, 406, 45);
		  add(labelInterogare2);
		  
		  JLabel lblNewLabel_1_1_1 = new JLabel("din anul:");
		  lblNewLabel_1_1_1.setForeground(new Color(0, 61, 77));
		  lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  lblNewLabel_1_1_1.setBounds(38, 276, 406, 31);
		  add(lblNewLabel_1_1_1);
		  
		  textField2 = new JTextField();
		  textField2.setForeground(Color.WHITE);
		  textField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  textField2.setColumns(10);
		  textField2.setBackground(new Color(0, 61, 77));
		  textField2.setBounds(38, 317, 396, 34);
		  add(textField2);
		
		  
		  //Raspunsuri2
		  JLabel labelRez = new JLabel("");
		  labelRez.setFont(new Font("Tahoma", Font.BOLD, 15));

          //Button2
		  JButton buttonSearch2 = new JButton("Caut\u0103");
		  buttonSearch2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		try 
				{	
					int x=0;
					String data;
				    data= textField2.getText();
				    try
					 {
			            x = Integer.parseInt(data);
			        
					 }
                     catch (NumberFormatException nx)
					{   
						 JOptionPane.showMessageDialog(null, "Incorrect number...");
				     }
					con=SqlConnection.dbConnector(0); 	
				CallableStatement stmt=(CallableStatement) con.prepareCall("{call ex_5_b(?,?)}");
				stmt.setFloat(1, Float.parseFloat(textField2.getText()));
				String rezultat;
				stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				stmt.execute();
				rezultat=stmt.getString(2);
				labelRez.setText(rezultat);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		  		 
		  	}
		  });
		  
		  buttonSearch2.setForeground(Color.WHITE);
		  buttonSearch2.setBackground(new Color(0, 61, 77));
		  buttonSearch2.setBounds(174, 412, 105, 27);
		  add(buttonSearch2);
		  
		  JPanel panel = new JPanel();
		  panel.setBackground(new Color(0, 61, 77));
		  panel.setForeground(new Color(47, 79, 79));
		  panel.setBounds(38, 361, 396, 34);
		  add(panel);
		  panel.setLayout(null);
		 
		  labelRez.setEnabled(false);
		  labelRez.setForeground(Color.WHITE);
		  labelRez.setBackground(new Color(0, 61, 77));
		  labelRez.setBounds(0, 0, 386, 34);
		  panel.add(labelRez);
		  
		  JLabel fundal = new JLabel("");
		  fundal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backkk.jpg")));
		  fundal.setBounds(0, 1, 470, 470);
		  add(fundal);
	}
}
