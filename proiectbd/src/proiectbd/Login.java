package proiectbd;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Window;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {
	Connection conn=null;
	private JPanel contentPane;
	public static JTextField user;
	public static JPasswordField pass;

	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public Login() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 343);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//username label
		JLabel labelUsername = new JLabel("Username");
		labelUsername.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_male-icon-7928.png")));
		labelUsername.setBackground(new Color(0, 61, 77));
		labelUsername.setForeground(new Color(0, 61, 77));
		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelUsername.setBounds(26, 68, 115, 36);
		contentPane.add(labelUsername);
		
		//username text field
		user = new JTextField();
		user.setForeground(Color.WHITE);
		user.setBackground(new Color(0, 61, 77));
		user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user.setBounds(26, 102, 327, 36);
		contentPane.add(user);
		user.setColumns(10);
		
		//password label
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_1024px-passwordsvg.png")));
		
		labelPassword.setForeground(new Color(0, 61, 77));
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPassword.setBounds(26, 148, 145, 33);
		contentPane.add(labelPassword);
		
		//password field
		pass = new JPasswordField();
		pass.setForeground(Color.WHITE);
		pass.setBackground(new Color(0, 61, 77));
		pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass.setBounds(26, 183, 327, 38);
		contentPane.add(pass);
		
		//button de Login
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) 
			{
				 try 
				 {
				    conn=SqlConnection.dbConnector(1);
				    if(SqlConnection.k!=0) {
				    Menu menu1= new Menu();
				    menu1.MenuScreen();
				    }
				 }
				 catch (Exception ex)
				 {
					 System.out.println(ex);
					 
				 }
			}
		});
		
		buttonLogin.setForeground(SystemColor.controlLtHighlight);
		buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonLogin.setBackground(new Color(0, 61, 77));
		buttonLogin.setBounds(132, 247, 109, 29);
		contentPane.add(buttonLogin);
		
		//Login Page label si panel
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 61, 77));
		panel.setBounds(0, 0, 377, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setBounds(116, 0, 150, 62);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(null);
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backkk.jpg")));
		lblNewLabel_1.setBounds(0, 63, 377, 243);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
