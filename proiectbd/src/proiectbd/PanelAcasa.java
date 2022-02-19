package proiectbd;
import java.sql.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


public class PanelAcasa extends JPanel {
 
    private JTable tableClienti;
    private JTable tableFacturi;
    private JTable tableLocalitate;
    private JTable tableDifuzari;
    Connection con;
    
    
	public PanelAcasa() throws IOException {
		setForeground(new Color(173, 216, 230));
		
		setBackground(new Color(173, 216, 230));
		setVisible(true);
		setBounds(0,0,470,471);
		setLayout(null);
		
		JLabel lblAcas = new JLabel("Acas\u0103");
		lblAcas.setForeground(new Color(0, 61, 77));
		lblAcas.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAcas.setBounds(182, 28, 86, 40);
		add(lblAcas);
		
		tableClienti = new JTable();
		tableClienti.setForeground(Color.WHITE);
		tableClienti.setBackground(new Color(0, 61, 77));
		tableClienti.setBounds(0, 29, 450, 68);
		add(tableClienti);
		JScrollPane jp1= new JScrollPane(tableClienti);
		jp1.setLocation(10, 90);
		jp1.setSize(450, 70);
		add(jp1);
		
		tableFacturi = new JTable();
		tableFacturi.setForeground(Color.WHITE);
		tableFacturi.setBackground(new Color(0, 61, 77));
		tableFacturi.setBounds(10, 182, 450, 68);
		add(tableFacturi);
		JScrollPane jp2= new JScrollPane(tableFacturi);
		jp2.setLocation(10, 193);
		jp2.setSize(450, 70);
		add(jp2);
		
		tableLocalitate = new JTable();
		tableLocalitate.setForeground(Color.WHITE);
		tableLocalitate.setBackground(new Color(0, 61, 77));
		tableLocalitate.setBounds(10, 284, 450, 68);
		add(tableLocalitate);
		JScrollPane jp3= new JScrollPane(tableLocalitate);
		jp3.setLocation(10, 296);
		jp3.setSize(450, 70);
		add(jp3);
		
		tableDifuzari = new JTable();
		tableDifuzari.setBackground(new Color(0, 61, 77));
		tableDifuzari.setForeground(Color.WHITE);
		tableDifuzari.setBounds(10, 381, 450, 68);
		add(tableDifuzari);
		JScrollPane jp4= new JScrollPane(tableDifuzari);
		jp4.setLocation(10, 391);
		jp4.setSize(450, 70);
		add(jp4);
		
		try {
			con=SqlConnection.dbConnector(0);
			Statement stmt1=con.createStatement();
			String sql="SELECT *  FROM Client ;";
			ResultSet rs=stmt1.executeQuery(sql);
			tableClienti.setModel(DbUtils.resultSetToTableModel(rs));
			
			Statement stmt2=con.createStatement();
			String sql2="SELECT *  FROM Factura ;";
			ResultSet rs2=stmt2.executeQuery(sql2);
			tableFacturi.setModel(DbUtils.resultSetToTableModel(rs2));
			
			Statement stmt3=con.createStatement();
			String sql3="SELECT *  FROM Localitate ;";
			ResultSet rs3=stmt3.executeQuery(sql3);
			tableLocalitate.setModel(DbUtils.resultSetToTableModel(rs3));
			
			Statement stmt4=con.createStatement();
			String sql4="SELECT *  FROM difuzare ;";
			ResultSet rs4=stmt4.executeQuery(sql4);
			tableDifuzari.setModel(DbUtils.resultSetToTableModel(rs4));
			
			JLabel lblNewLabel = new JLabel("Tabel Client");
			lblNewLabel.setForeground(new Color(0, 61, 77));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 78, 135, 13);
			add(lblNewLabel);
			
			JLabel lblTabelFactura = new JLabel("Tabel Factur\u0103");
			lblTabelFactura.setForeground(new Color(0, 61, 77));
			lblTabelFactura.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTabelFactura.setBounds(10, 180, 135, 13);
			add(lblTabelFactura);
			
			JLabel lblTabel = new JLabel("Tabel Localitate");
			lblTabel.setForeground(new Color(0, 61, 77));
			lblTabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTabel.setBounds(10, 284, 135, 13);
			add(lblTabel);
			
			JLabel lblTabelDifuzare = new JLabel("Tabel Difuzare");
			lblTabelDifuzare.setForeground(new Color(0, 61, 77));
			lblTabelDifuzare.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTabelDifuzare.setBounds(10, 376, 135, 13);
			add(lblTabelDifuzare);
			
			JLabel fundal = new JLabel("");
			fundal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backkk.jpg")));
			fundal.setBounds(0, 1, 470, 470);
			add(fundal);
			
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
