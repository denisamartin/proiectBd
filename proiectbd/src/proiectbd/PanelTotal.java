package proiectbd;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import com.mysql.jdbc.CallableStatement;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class PanelTotal extends JPanel {
	private JTextField totalText;
	Connection con;
	
	
	
	public PanelTotal() {
	
	 setBackground(new Color(0, 128, 128));
	 setForeground(Color.WHITE);
	 setVisible(true);
     setBounds(0,0,470,471);
     setLayout(null);
     
     //Titlu
     JLabel labelTitlu = new JLabel("Total");
     labelTitlu.setForeground(new Color(0, 61, 77));
     labelTitlu.setFont(new Font("Tahoma", Font.BOLD, 25));
     labelTitlu.setBounds(197, 31, 78, 34);
     add(labelTitlu);
     
     //Interogare
     JLabel labelCerinta = new JLabel("Afi\u0219are valoare medie total\u0103 pentru facturile din anul:");
     labelCerinta.setForeground(new Color(0, 61, 77));
     labelCerinta.setFont(new Font("Tahoma", Font.PLAIN, 17));
     labelCerinta.setBounds(34, 118, 406, 45);
     add(labelCerinta);
     
     //text field Total
     totalText = new JTextField();
     totalText.setFont(new Font("Tahoma", Font.PLAIN, 15));
     totalText.setForeground(Color.WHITE);
     totalText.setBackground(new Color(0, 61, 77));
     totalText.setBounds(34, 189, 406, 34);
     add(totalText);
     totalText.setColumns(10);
     
     //Rezultat
     JLabel label = new JLabel("Rezultat:");
     label.setForeground(new Color(0, 61, 77));
     label.setFont(new Font("Tahoma", Font.PLAIN, 17));
     label.setBounds(34, 233, 406, 45);
     add(label);
     
     //button Search
     JButton buttonSearch = new JButton("Caut\u0103");
     JLabel labelRez = new JLabel("");
     buttonSearch.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		
     		try 
			{	
				int x=0;
				String data;
			    data= totalText.getText();
				try
				 {
		              x = Integer.parseInt(data);
		        
				 }
                 catch (NumberFormatException nx) 
				{   
					 JOptionPane.showMessageDialog(null, "Incorrect number...");
			     }
				 con=SqlConnection.dbConnector(0); 
				 CallableStatement stmt=(CallableStatement) con.prepareCall("{call ex_6_b(?,?)}");
				 stmt.setFloat(1, Float.parseFloat(totalText.getText()));
				 Double rezultat;
				 stmt.registerOutParameter(2, java.sql.Types.DOUBLE);
				 stmt.execute();
				 rezultat=stmt.getDouble(2);
				 labelRez.setText(Double.toString(rezultat));
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
     		
     		
     		
     		
     	}
     });
     buttonSearch.setBackground(new Color(0, 61, 77));
     buttonSearch.setForeground(Color.WHITE);
     buttonSearch.setBounds(180, 389, 105, 27);
     add(buttonSearch);
     
     JPanel panel = new JPanel();
     panel.setBackground(new Color(0, 61, 77));
     panel.setBounds(34, 298, 406, 34);
     add(panel);
     panel.setLayout(null);
     
   
     labelRez.setFont(new Font("Tahoma", Font.BOLD, 15));
     labelRez.setForeground(Color.WHITE);
     labelRez.setEnabled(false);
     labelRez.setBounds(0, 0, 406, 34);
     panel.add(labelRez);
     
     JLabel fundal = new JLabel("");
     fundal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backkk.jpg")));
     fundal.setBounds(0, 0, 470, 471);
     add(fundal);
	}
}
