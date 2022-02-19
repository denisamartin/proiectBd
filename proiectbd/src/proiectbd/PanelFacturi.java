package proiectbd;
import java.sql.*;
import java.util.concurrent.Callable;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;


public class PanelFacturi extends JPanel {
	private JTextField facturaText;
	private JTable tableFacturi;
	Connection con;
	
	
	public PanelFacturi() {
		
		
		setVisible(true);
		setBackground(new Color(0, 128, 128));
		setBounds(0,0,470,471);
		setLayout(null);
		
		//Titlu
		JLabel titlu = new JLabel("Facturi");
		titlu.setIcon(null);
		titlu.setForeground(new Color(0, 61, 77));
		titlu.setFont(new Font("Tahoma", Font.BOLD, 25));
		titlu.setBounds(183, 39, 86, 40);
		add(titlu);
		
		//Interogare
		JLabel labelInterogare = new JLabel("Afi\u0219are facturi cu totalul mai mare dec\u00E2t:");
		labelInterogare.setForeground(new Color(0, 61, 77));
		labelInterogare.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelInterogare.setBounds(37, 85, 406, 81);
		add(labelInterogare);
		
		facturaText = new JTextField();
		facturaText.setForeground(Color.WHITE);
		facturaText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		facturaText.setBackground(new Color(0, 61, 77));
		facturaText.setBounds(108, 163, 239, 30);
		add(facturaText);
		facturaText.setColumns(10);
		
		
		//Button
		JButton butonFactura = new JButton("Caut\u0103");
		
		butonFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{	
					int x=0;
					String data;
				    data= facturaText.getText();
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
				String sql="SELECT *  FROM Factura WHERE total > "+ facturaText.getText()+" ORDER BY factura.data DESC, total ASC;";
				ResultSet rs=stmt1.executeQuery(sql);
				tableFacturi.setModel(DbUtils.resultSetToTableModel(rs));
				
		
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				 
				
			}
		});
		butonFactura.setForeground(Color.WHITE);
		butonFactura.setBackground(new Color(0, 61, 77));
		butonFactura.setBounds(183, 414, 100, 21);
		add(butonFactura);
		
		//Raspuns
		tableFacturi = new JTable();
		tableFacturi.setForeground(Color.WHITE);
		tableFacturi.setBackground(new Color(0, 61, 77));
		tableFacturi.setFillsViewportHeight(true);
		tableFacturi.setBounds(10, 253, 450, 151);
		add(tableFacturi);
		
		JLabel labelTable = new JLabel("    Id_f     |    Data   | Slideuri |Cost slide|     Zile    |   Total    |   Id_c    |   Tva       |");
		labelTable.setForeground(Color.WHITE);
		labelTable.setBackground(new Color(0, 41, 77));
		labelTable.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTable.setBounds(10, 232, 450, 21);
		add(labelTable);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 77));
		panel.setBounds(10, 232, 450, 21);
		add(panel);
		
		JLabel fundal = new JLabel("");
		fundal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backkk.jpg")));
		fundal.setBounds(0, 0, 470, 471);
		add(fundal);
		
	}
}
