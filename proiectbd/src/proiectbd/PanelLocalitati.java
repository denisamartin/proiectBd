package proiectbd;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class PanelLocalitati extends JPanel {
	private JTextField textField;
	private JTextField textLuna;
	private JTextField textAn;
	Connection con;
	
	
	public PanelLocalitati() {
		setBackground(new Color(0, 128, 128));
		setVisible(true);
		  setBounds(0,0,470,471);
		  setLayout(null);
		  
		  //titlu
		  JLabel titlu = new JLabel("Localit\u0103\u021Bi");
		  titlu.setForeground(new Color(0, 61, 77));
		  titlu.setFont(new Font("Tahoma", Font.BOLD, 25));
		  titlu.setBounds(166, 22, 128, 31);
		  add(titlu);
		  
		  //Interogare1
		  JLabel labelInterogare1 = new JLabel("Afi\u0219area localit\u0103\u021Bilor care se termin\u0103 cu litera:");
		  labelInterogare1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  labelInterogare1.setForeground(new Color(0, 61, 77));
		  labelInterogare1.setBounds(47, 63, 380, 13);
		  add(labelInterogare1);
		  
		  textField = new JTextField();
		  textField.setForeground(Color.WHITE);
		  textField.setBackground(new Color(0, 61, 77));
		  textField.setBounds(47, 86, 351, 19);
		  add(textField);
		  textField.setColumns(10);
		  
		 //Raspunsuri1
		  
		  JList list1 = new JList();
		  list1.setForeground(Color.WHITE);
		  list1.setBackground(new Color(0, 61, 77));
		  list1.setBounds(47, 120, 351, 31);
		  
        //Button1
		  JButton buttonSearch1 = new JButton("Caut\u0103");
		  buttonSearch1.setForeground(Color.WHITE);
		  buttonSearch1.setBackground(new Color(0, 61, 77));
		
		  buttonSearch1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		try 
				{	 con=SqlConnection.dbConnector(0); 
				Statement stmt1=con.createStatement();
				String sql="SELECT denumire FROM Localitate WHERE denumire LIKE '%" + textField.getText()+ "';";
				ResultSet rs=stmt1.executeQuery(sql);   
				DefaultListModel DLM= new DefaultListModel();
				DLM.addAll((Collection) DbUtils.resultSetToNestedList(rs));
				list1.setModel( DLM);
     			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     		
		  	}
		  });
		  
		  buttonSearch1.setBounds(179, 166, 85, 21);
		  add(buttonSearch1);
		  
		  //Interogare2
		  JLabel labelInterogare21 = new JLabel("Afi\u0219are perechi de localit\u0103\u021Bi pentru care difuzarea s-a  ");
		  labelInterogare21.setForeground(new Color(0, 61, 77));
		  labelInterogare21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  labelInterogare21.setBounds(47, 197, 394, 31);
		  add(labelInterogare21);
		  
		  JLabel labelInterogare22 = new JLabel("facturat  pe aceea\u0219i factur\u0103:");
		  labelInterogare22.setForeground(new Color(0, 61, 77));
		  labelInterogare22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  labelInterogare22.setBounds(47, 218, 397, 31);
		  add(labelInterogare22);
		  
		  //Raspunsuri2
		  JList list2 = new JList();
		  list2.setForeground(Color.WHITE);
		  list2.setBackground(new Color(0, 61, 77));
		  list2.setBounds(47, 268, 351, 31);
		  add(list2);
		  
		  //Button2
		  JButton buttonSearch2 = new JButton("Caut\u0103");
		  buttonSearch2.setForeground(Color.WHITE);
		  buttonSearch2.setBackground(new Color(0, 61, 77));
		  buttonSearch2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		try 
				{	
		  		con=SqlConnection.dbConnector(0); 
				Statement stmt1=con.createStatement();
				String sql="SELECT CONCAT( '( ', CONCAT( d1.id_l, CONCAT(',',CONCAT(d2.id_l, ' )')))) FROM Difuzare d1 JOIN Difuzare d2 ON( d1.id_l!= d2.id_l) WHERE d1.id_f = d2.id_f AND  d1.id_l < d2.id_l;";
				ResultSet rs=stmt1.executeQuery(sql);   
				DefaultListModel DLM= new DefaultListModel();
				DLM.addAll((Collection) DbUtils.resultSetToNestedList(rs));
				list2.setModel( DLM);
     			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		  		
		  	}
		  });
		  JScrollPane jp2= new JScrollPane(list2);
		  jp2.setLocation(47, 246);
		  jp2.setSize(351, 37);
			  add(jp2);
			 
		  buttonSearch2.setBounds(179, 293, 85, 21);
		  add(buttonSearch2);
		  
		  
		  //Interogare3
		  JLabel labelInterogare3 = new JLabel("Afisarea localit\u0103\u021Bilor unde au existat difuz\u0103ri \u00EEn data de:");
		  labelInterogare3.setForeground(new Color(0, 61, 77));
		  labelInterogare3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  labelInterogare3.setBounds(47, 331, 380, 13);
		  add(labelInterogare3);
		  
		  textLuna = new JTextField();
		  textLuna.setForeground(Color.WHITE);
		  textLuna.setBackground(new Color(0, 61, 77));
		  textLuna.setBounds(91, 354, 103, 19);
		  add(textLuna);
		  textLuna.setColumns(10);
		  
		  textAn = new JTextField();
		  textAn.setForeground(Color.WHITE);
		  textAn.setBackground(new Color(0, 61, 77));
		  textAn.setBounds(277, 354, 115, 19);
		  add(textAn);
		  textAn.setColumns(10);
		  
		  JLabel labelL = new JLabel("Luna");
		  labelL.setForeground(new Color(0, 61, 77));
		  labelL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  labelL.setBounds(47, 354, 31, 13);
		  add(labelL);
		  
		  JLabel labelA = new JLabel("Anul");
		  labelA.setForeground(new Color(0, 61, 77));
		  labelA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  labelA.setBounds(226, 356, 31, 13);
		  add(labelA);
		  
		  //Raspuns3
		  JList list3 = new JList();
		  list3.setForeground(Color.WHITE);
		  list3.setBackground(new Color(0, 61, 77));
		  list3.setBounds(47, 383, 351, 31);
		  add(list3);
		  
		  //Button3
		  JButton butonSearch3 = new JButton("Caut\u0103");
		  butonSearch3.setForeground(Color.WHITE);
		  butonSearch3.setBackground(new Color(0, 61, 77));
		  butonSearch3.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		try 
				{	
					int x=0, y=0;
					String data, data2;
				    data= textLuna.getText();
					data2= textAn.getText();
				    try
					 {
			            x = Integer.parseInt(data);
			            y=Integer.parseInt(data2);
					 }
                     catch (NumberFormatException nx)
					{   
						 JOptionPane.showMessageDialog(null, "Incorrect number...");
				     }
				con=SqlConnection.dbConnector(0); 
				Statement stmt1=con.createStatement();
				String sql= "SELECT denumire FROM Localitate WHERE id_l IN (SELECT id_l FROM Difuzare WHERE EXTRACT(YEAR FROM datai)="+ textAn.getText()+" AND (EXTRACT(MONTH FROM datai)="+ textLuna.getText() +" OR EXTRACT(MONTH FROM datas)=" + textLuna.getText()+") );";
				ResultSet rs=stmt1.executeQuery(sql);   
				DefaultListModel DLM= new DefaultListModel();
				DLM.addAll((Collection) DbUtils.resultSetToNestedList(rs));
				list3.setModel( DLM);
				
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		  		
		  	}
		  });
		  
		  JScrollPane jp3= new JScrollPane(list3);
		  jp3.setLocation(47, 383);
		  jp3.setSize(345, 29);
		  add(jp3);
		  butonSearch3.setBounds(179, 424, 85, 21);
		  add(butonSearch3);
		 
		 JScrollPane jp= new JScrollPane(list1);
		 jp.setLocation(47, 115);
		 jp.setSize(351, 41);
		  add(jp);
		  
		  JLabel fundal = new JLabel("");
		  fundal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backkk.jpg")));
		 
		  fundal.setBounds(0, 1, 470, 470);
		  add(fundal);
		  
		
		 
	
		  
		  
	}
}
