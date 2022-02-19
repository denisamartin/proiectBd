package proiectbd;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelSlideuri extends JPanel {
	private JTextField textField;
	private JTextField textField2;
	private JTable table;
	Connection con;
	
	
	public PanelSlideuri() {
		  setBackground(new Color(0, 139, 139));
		  setVisible(true);
		  setBounds(0,0,470,471);
		  setLayout(null);
		  
		  //Titlu
		  JLabel lblSlideuri = new JLabel("Slide-uri");
		  lblSlideuri.setForeground(new Color(0, 61, 77));
		  lblSlideuri.setFont(new Font("Tahoma", Font.BOLD, 25));
		  lblSlideuri.setBounds(166, 41, 128, 31);
		  add(lblSlideuri);
		  
		  //Interogare
		  JLabel labelInterogare1 = new JLabel("Afi\u0219are num\u0103r de slide-uri pentru fiecare localitate");
		  labelInterogare1.setForeground(new Color(0, 61, 77));
		  labelInterogare1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  labelInterogare1.setBounds(38, 105, 406, 45);
		  add(labelInterogare1);
		  
		  JLabel labelInterogare12 = new JLabel("\u0219i fiecare zi din:");
		  labelInterogare12.setForeground(new Color(0, 61, 77));
		  labelInterogare12.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  labelInterogare12.setBounds(38, 135, 406, 31);
		  add(labelInterogare12);
		  
		  JLabel labelL = new JLabel("Luna");
		  labelL.setForeground(new Color(0, 61, 77));
		  labelL.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  labelL.setBounds(38, 176, 46, 19);
		  add(labelL);
		  
		  textField = new JTextField();
		  textField.setForeground(Color.WHITE);
		  textField.setColumns(10);
		  textField.setBackground(new Color(0, 61, 77));
		  textField.setBounds(94, 179, 103, 19);
		  add(textField);
		  
		  JLabel labelA = new JLabel("Anul");
		  labelA.setForeground(new Color(0, 61, 77));
		  labelA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  labelA.setBounds(220, 182, 74, 13);
		  add(labelA);
		  
		  textField2 = new JTextField();
		  textField2.setForeground(Color.WHITE);
		  textField2.setColumns(10);
		  textField2.setBackground(new Color(0, 61, 77));
		  textField2.setBounds(285, 179, 115, 19);
		  add(textField2);
		  
		  //Raspuns
		  table = new JTable();
		  table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  table.setBackground(new Color(0, 61, 77));
		  table.setForeground(Color.WHITE);
		  table.setBounds(41, 240, 372, 149);
		  add(table);
		  
		  //Button
		  JButton buttonSearch = new JButton("Caut\u0103");
		  buttonSearch.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		try 
				{	
					int x=0, y=0;
					String data, data2;
				    data= textField.getText();
				    data2= textField2.getText();
					try
					 {
			              x = Integer.parseInt(data);
			              y = Integer.parseInt(data2);
			        
					 }
                     catch (NumberFormatException nx) 
					{   
						 JOptionPane.showMessageDialog(null, "Incorrect number...");
				     }
					con=SqlConnection.dbConnector(0); 
				Statement stmt1=con.createStatement();
				String sql="SELECT d.id_l , EXTRACT(DAY FROM f.data) AS zi , SUM(f.nr_slideuri) AS Nr_slideuri FROM Difuzare d JOIN Factura f ON(d.id_f=f.id_f) WHERE EXTRACT(MONTH FROM f.data)="+ textField.getText()+" AND EXTRACT(YEAR FROM f.data)="+ textField2.getText()+" GROUP BY d.id_l, EXTRACT(DAY FROM f.data) WITH ROLLUP;";

				ResultSet rs=stmt1.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				 
		  		
		  		
		  		
		  	}
		  });
		  
			
		  
		  buttonSearch.setForeground(Color.WHITE);
		  buttonSearch.setBackground(new Color(0, 61, 77));
		  buttonSearch.setBounds(166, 410, 105, 27);
		  add(buttonSearch);
		  
		  JLabel lblNewLabel = new JLabel("           Id_l                     |                 Zi                  |             Nr slideuri");
		  lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		  lblNewLabel.setForeground(Color.WHITE);
		  lblNewLabel.setBounds(41, 222, 372, 19);
		  add(lblNewLabel);
		  
		  JPanel panel = new JPanel();
		  panel.setBackground(new Color(0, 51, 77));
		  panel.setBounds(41, 220, 372, 21);
		  add(panel);
		  
		  JLabel fundal = new JLabel("");
		  fundal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backkk.jpg")));
		  fundal.setBounds(0, 0, 470, 471);
		  add(fundal);
		  
	
	}
}
