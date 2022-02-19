package proiectbd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Menu extends JFrame{
     
	private JFrame frame;
	private PanelTotal panelTotal;
	private PanelLocalitati panelLocalitati;
	private PanelClienti panelClienti;
	private PanelSlideuri panelSlideuri;
	private PanelFacturi panelFacturi;
	private PanelAcasa panelAcasa;

	
	public static void MenuScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Menu() throws IOException {
		initialize(); 
	}
	
	
	private void initialize() throws IOException {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getContentPane().setLayout(null);
		
		// se creaza panel pentru fiecare varianta din meniu
		panelTotal=new PanelTotal();
		panelLocalitati= new PanelLocalitati();
		panelClienti=new PanelClienti();
		panelSlideuri=new PanelSlideuri();
		panelFacturi=new PanelFacturi();
		panelAcasa=new PanelAcasa();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 61, 77));
		panel.setBounds(0, 0, 286, 470);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//imagine
		JLabel labelImagine = new JLabel("");
		labelImagine.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_pngegg.png")));
		labelImagine.setHorizontalAlignment(SwingConstants.TRAILING);
		labelImagine.setBounds(71, 27, 125, 158);
		panel.add(labelImagine);
		
		//Acasa
		JPanel paneAcasa = new JPanel();
		paneAcasa.addMouseListener(new PanelButtonMouseAdapter(paneAcasa) 
		{		@Override
				public void mouseClicked(MouseEvent e) 
				{
					menuClicked(panelAcasa);
				}
		});
		
		paneAcasa.setLayout(null);
		paneAcasa.setBackground(new Color(0, 61, 77));
		paneAcasa.setBounds(0, 203, 286, 45);
		panel.add(paneAcasa);
		
		JLabel labelAcasa = new JLabel("Acas\u0103");
		labelAcasa.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_home.png")));
		
		labelAcasa.setForeground(Color.WHITE);
		labelAcasa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelAcasa.setBounds(44, 0, 123, 45);
		paneAcasa.add(labelAcasa);
		
		
		//  Total
		JPanel paneTotal = new JPanel();
		paneTotal.addMouseListener(new PanelButtonMouseAdapter(paneTotal) 
		{		@Override
				public void mouseClicked(MouseEvent e) 
				{
					menuClicked(panelTotal);
				}
		});
		
		
		paneTotal.setBackground(new Color(0, 61, 77));
		paneTotal.setBounds(0, 247, 286, 45);
		panel.add(paneTotal);
		paneTotal.setLayout(null);
		
	
		JLabel labelTotal = new JLabel("Total");
		labelTotal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_1cash.png")));
		
		labelTotal.setForeground(Color.WHITE);
		labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelTotal.setBounds(53, 0, 123, 45);
		paneTotal.add(labelTotal);
		
		// Localitati
		JPanel paneLocalitati = new JPanel();
		paneLocalitati.addMouseListener(new PanelButtonMouseAdapter(paneLocalitati){
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelLocalitati);
			}
	});
		paneLocalitati.setBackground(new Color(0, 61, 77));
		paneLocalitati.setBounds(0, 292, 286, 45);
		panel.add(paneLocalitati);
		paneLocalitati.setLayout(null);
		
		
		JLabel labelLocalitati = new JLabel("Localit\u0103\u021Bi");
		labelLocalitati.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_5993015401552302412-128.png")));
		labelLocalitati.setForeground(Color.WHITE);
		labelLocalitati.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelLocalitati.setBounds(53, 10, 168, 35);
		paneLocalitati.add(labelLocalitati);
		
		//Clienti
		JPanel paneClienti = new JPanel();
		paneClienti.addMouseListener(new PanelButtonMouseAdapter(paneClienti){
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelClienti);
			}
	});
		paneClienti.setBackground(new Color(0, 61, 77));
		paneClienti.setBounds(0, 336, 286, 45);
		panel.add(paneClienti);
		paneClienti.setLayout(null);
		
		JLabel labelClienti = new JLabel("Clien\u021Bi");
		labelClienti.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_male-icon-7928 (1).png")));
		labelClienti.setForeground(Color.WHITE);
		labelClienti.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelClienti.setBounds(52, 10, 136, 35);
		paneClienti.add(labelClienti);
		
		//Slide uri
		JPanel panelNrSlideuri = new JPanel();
		panelNrSlideuri.addMouseListener(new PanelButtonMouseAdapter(panelNrSlideuri){
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelSlideuri);
			}
	});
		panelNrSlideuri.setBackground(new Color(0, 61, 77));
		panelNrSlideuri.setBounds(0, 380, 286, 45);
		panel.add(panelNrSlideuri);
		panelNrSlideuri.setLayout(null);
		
		JLabel labelSlideuri = new JLabel("Slide-uri");
		labelSlideuri.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_slides-icon.png")));

		labelSlideuri.setForeground(Color.WHITE);
		labelSlideuri.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelSlideuri.setBounds(51, 10, 137, 35);
		panelNrSlideuri.add(labelSlideuri);
		
		//Facturi
		JPanel paneFacturi = new JPanel();
		paneFacturi.addMouseListener(new PanelButtonMouseAdapter(paneFacturi){
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelFacturi);
			}
	});
		paneFacturi.setLayout(null);
		paneFacturi.setBackground(new Color(0, 61, 77));
		paneFacturi.setBounds(0, 425, 286, 45);
		panel.add(paneFacturi);
		
		JLabel labelFacturi = new JLabel("Facturi");
		labelFacturi.setIcon(new ImageIcon(getClass().getClassLoader().getResource("rsz_bill-131979040781653683_48.png")));
		labelFacturi.setForeground(Color.WHITE);
		labelFacturi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelFacturi.setBounds(50, 10, 146, 35);
		paneFacturi.add(labelFacturi);
		
		JLabel fundalMenu = new JLabel("");
		fundalMenu.setIcon(new ImageIcon(getClass().getClassLoader().getResource("fundalMeniuFinal.jpg")));
		fundalMenu.setBounds(0, 0, 286, 470);
		panel.add(fundalMenu);
		
	
		
		//Main Content
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBackground(new Color(0, 128, 128));
		panelMainContent.setBounds(287, 0, 471, 470);
		frame.getContentPane().add(panelMainContent);
		panelMainContent.setLayout(null);
		frame.setBounds(100, 100, 772, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	panelMainContent.setLayout(null);
	panelMainContent.add(panelFacturi);
	panelMainContent.add(panelClienti);
	panelMainContent.add(panelTotal);
	panelMainContent.add(panelSlideuri);
	panelMainContent.add(panelLocalitati);
	panelMainContent.add(panelAcasa);
	menuClicked(panelAcasa);
	
	}
	
	// metoda pentru a face vizibil un anumit panel
	public void menuClicked(JPanel panel) {
		panelTotal.setVisible(false);
		panelFacturi.setVisible(false);
		panelClienti.setVisible(false);
		panelSlideuri.setVisible(false);
		panelLocalitati.setVisible(false);
		panelAcasa.setVisible(false);
		panel.setVisible(true);
		
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
	
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(0, 50, 77));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0, 61, 77));	
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(0, 11, 77));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(0, 45, 77));
		}
		
	}
}
