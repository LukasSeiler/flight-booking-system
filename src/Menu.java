import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Menu extends JFrame{
	
	JLabel JLstatus;
	private static boolean beginner = false;
	private static boolean expert = false;
	private Color myOrange = new Color(255, 127, 000);
	static Menu menu;
	
	public Menu(GUI1 frame, Abflughafen ab, API1 a) {
		getContentPane().setLayout(null);
		setTitle("Zielflughafen");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 465, 315);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel JLbeginner = new JLabel("Beginner");
		JLbeginner.setForeground(Color.WHITE);
		JLbeginner.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLbeginner.setBackground(Color.LIGHT_GRAY);
		JLbeginner.setOpaque(true);
		JLbeginner.setHorizontalAlignment(SwingConstants.CENTER);
		JLbeginner.setBounds(20, 82, 190, 63);
		getContentPane().add(JLbeginner);
		
		JLabel JLexpert = new JLabel("Expert");
		JLexpert.setForeground(Color.WHITE);
		JLexpert.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLexpert.setBackground(Color.LIGHT_GRAY);
		JLexpert.setOpaque(true);
		JLexpert.setHorizontalAlignment(SwingConstants.CENTER);
		JLexpert.setBounds(234, 82, 190, 63);
		getContentPane().add(JLexpert);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(20, 161, 404, 12);
		getContentPane().add(separator);
		
		JLabel JLstart = new JLabel("Start >");
		JLstart.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLstart.setForeground(Color.WHITE);
		JLstart.setBackground(myOrange);
		JLstart.setOpaque(true);
		JLstart.setHorizontalAlignment(SwingConstants.CENTER);
		JLstart.setBounds(20, 184, 190, 63);
		getContentPane().add(JLstart);
		
		
		JLstatus = new JLabel("0 von 6500 Flughäfen gefunden");
		JLstatus.setHorizontalAlignment(SwingConstants.CENTER);
		JLstatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLstatus.setBounds(226, 184, 213, 63);
		getContentPane().add(JLstatus);
		
		JTextArea JTXTwillkommen = new JTextArea();
		JTXTwillkommen.setEditable(false);
		JTXTwillkommen.setBackground(UIManager.getColor("Button.background"));
		JTXTwillkommen.setLineWrap(true);
		JTXTwillkommen.setFont(new Font("Tahoma", Font.BOLD, 13));
		JTXTwillkommen.setText("Willkommen bei meinem Flugbuchungssystem, bitte w\u00E4hlenSie Ihren Modus:");
		JTXTwillkommen.setBounds(20, 11, 384, 53);
		getContentPane().add(JTXTwillkommen);
		
		/*Onclick auf den Beginner-Button*/
		JLbeginner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLbeginner.setBackground(myOrange);
				JLexpert.setBackground(Color.lightGray);
				beginner = true;
				expert = false;
			}
		});
		
		/*Onclick auf den Expert-Button*/
		JLexpert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLexpert.setBackground(myOrange);
				JLbeginner.setBackground(Color.lightGray);
				beginner = false;
				expert = true;
			}
		});
		
		/*Onclick auf den Start-Button*/
		JLstart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(beginner == true || expert == true) {
					a.setrun(false);
					frame.setVisible(true);
					setVisible(false);
				}else {
					 JOptionPane.showMessageDialog(menu,"Sie müssen zuerst einen Modus auswählen.","Hinweis",JOptionPane.WARNING_MESSAGE);  
				}
				
			}
		});
	}
	
	public void Status(int i, int length) {
		JLstatus.setText(i+" von "+(length-3)+" Flughäfen gefunden");
	}
}
