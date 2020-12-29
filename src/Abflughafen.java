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

public class Abflughafen extends JFrame{
	
	/*Initialisierung der API*/
	API1 a;
	/*Initialisierung der Frame*/
	Abflughafen frame1;
	/*Liste f�r die Abflugh�fen*/
	JList JLabflughafen;
	/*Model f�r die Liste*/
	DefaultListModel<String> model = new DefaultListModel<>();
	
	public Abflughafen(GUI1 frame){
		
		/*Objekt f�r API wird erstellt*/
		a =  new API1();
		/*Einstellungen f�r Frame*/
		setTitle("Abflughafen");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 450, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		
		/*Hauptpanel der Frame*/
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		/*Titel f�r die Frame*/
		JLabel JLtitle = new JLabel("Flug von:");
		JLtitle.setBounds(11, 1, 264, 51);
		JLtitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(JLtitle);
		
		/*Liste f�r das Anzeigen von Abflugh�fen*/
		JLabflughafen = new JList(model);
		JLabflughafen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabflughafen.setBounds(10, 43, 414, 194);
		JScrollPane scrollPane = new JScrollPane(JLabflughafen);
		scrollPane.setBounds(11, 51, 401, 164);
		panel.add(scrollPane);
		scrollPane.setVisible(true);
		JLabflughafen.setVisibleRowCount(9);
		
		/*Bef�llen der JList*/
		for(int i = 0; i < a.airports.size(); i++) {
			model.addElement(a.airports.get(i));
			
		}
		
		/*Button Weiter zum Schliessen des GUIs*/
		JLabel JLweiter = new JLabel("Weiter >");
		JLweiter.setBounds(10, 248, 190, 51);
		Color myOrange = new Color(255, 127, 000);
		JLweiter.setBackground(myOrange);
		JLweiter.setOpaque(true);
		JLweiter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLweiter.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(JLweiter);
		
		/*Button Zur�ck zum Schliessen des GUIs*/
		JLabel JLzur�ck = new JLabel("Zur�ck <");
		JLzur�ck.setBounds(222, 248, 190, 51);
		JLzur�ck.setHorizontalAlignment(SwingConstants.CENTER);
		JLzur�ck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLzur�ck.setBackground(Color.LIGHT_GRAY);
		JLzur�ck.setOpaque(true);
		panel.add(JLzur�ck);
		
		/**
		 * Onclick-Action f�r den Weiter-Button:
		 * Es muss ein Flug ausgew�hlt werden, um die Frame zu schliessen
		 */
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Varialbe f�r das Spiechern des ausgew�hlten Flughafens*/
				String selected = (String) JLabflughafen.getSelectedValue();
				
				/*Ist die Auswahl nicht gleich null?*/
				if(selected != null) {
					/*Frame wird unsichtbar*/
					setVisible(false);
					/*Duch Methode in GUI1 wird Abflughafen gespeichert*/
					frame.setAbflughafen();
					/*Frame von GUI1 wird wieder sichtbar*/
					frame.setVisible(true);
				}
				
				else {
					/*Warnungs-Hinweis, dass kein Flughafen ausgew�hlt wurde*/
					JOptionPane.showMessageDialog(null,"Sie m�ssen einen Abflughafen w�hlen", "Hinweis", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		/**
		 * Onclick-Action f�r den Zur�ck-Button:
		 */
		JLzur�ck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Frame wird unsichtbar*/
				setVisible(false);
				/*Frame von GUI1 wird wieder sichtbar*/
				frame.setVisible(true);
			}
		});
	}
	
	/**
	 * Speicherung des ausgew�hlten Abflughafens, welcher zur�ckgegeben wird
	 * @return ausgew�hlter Abflughafen
	 */
	public String guiAuswahl() {
		/*Zwischenspeicherung des ausgew�hlten Abflughafen*/
		String selected = (String) JLabflughafen.getSelectedValue();
		return selected;
	}
	
	/**
	 * Methode zur Visualisierung der Frame
	 */
	public void visibleGUI() {
		setVisible(true);
	}

}
