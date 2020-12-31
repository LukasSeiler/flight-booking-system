import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class GUI4 extends JFrame{
	
	/*Initialisierung der Frame vom GUI4*/
	static GUI4 frameGUI4;
	/*Initialisierung der Frame vom GUI5*/
	static GUI5 frameGUI5;
	/*Initialisierung der API2*/
	API2 a;
	/*ComboBox für die Anrede*/
	JComboBox JCBanrede;
	/*TextField für den Vornamen*/
	JTextField JTvorname;
	/*TextField für den Nachnamen*/
	JTextField JTnachname;
	/*TextField für die Strasse*/
	JTextField JTstrasse;
	/*TextField für die PLZ*/
	JTextField JTplz;
	/*TextField für den Ort*/
	JTextField JTort;
	/*Farbe für Orange*/
	Color myOrange = new Color(255, 127, 000);

	public GUI4(GUI3 frameGUI3) {
		
		/*Einstellungen der Frame*/
		setTitle("Persönliche Daten");
		setSize(450, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		/*globales Panel der Frame*/
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 461);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		/*Label für die Beschriftung der Anrede*/
		JLabel JLtitleanred = new JLabel("Anrede:");
		JLtitleanred.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLtitleanred.setBounds(10, 11, 61, 33);
		panel.add(JLtitleanred);
		
		/*ComboBox für die Anrede*/
		JCBanrede = new JComboBox();
		JCBanrede.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JCBanrede.setModel(new DefaultComboBoxModel(new String[] {"Herr", "Frau"}));
		JCBanrede.setBounds(10, 43, 179, 35);
		panel.add(JCBanrede);
		
		/*JLabel für die Beschriftung des Vornamens*/
		JLabel JLtitlevorname = new JLabel("Vorname:");
		JLtitlevorname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLtitlevorname.setBounds(10, 89, 78, 33);
		panel.add(JLtitlevorname);
		
		/*TextField für den Vornamen*/
		JTvorname = new JTextField();
		JTvorname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTvorname.setBounds(10, 120, 179, 33);
		panel.add(JTvorname);
		
		/*JLabel für die Beschriftung des Nachnamens*/
		JLabel JLtitlenachname = new JLabel("Nachname:");
		JLtitlenachname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLtitlenachname.setBounds(226, 89, 78, 33);
		panel.add(JLtitlenachname);
		
		/*TextField für den Nachnamen*/
		JTnachname = new JTextField();
		JTnachname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTnachname.setBounds(226, 120, 179, 33);
		panel.add(JTnachname);
		
		/*Trennbalken*/
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 206, 397, 10);
		panel.add(separator);
		
		/*Label für den Titel des Adressteils*/
		JLabel JLtitleadresse = new JLabel("Adresse:");
		JLtitleadresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLtitleadresse.setBounds(10, 179, 126, 23);
		panel.add(JLtitleadresse);
		
		/*Label für die Beschriftung der Strasse*/
		JLabel JLtitlestrasse = new JLabel("Strasse:");
		JLtitlestrasse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLtitlestrasse.setBounds(10, 227, 78, 33);
		panel.add(JLtitlestrasse);
		
		/*TextField für die Strasse*/
		JTstrasse = new JTextField();
		JTstrasse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTstrasse.setBounds(10, 258, 179, 33);
		panel.add(JTstrasse);
		
		/*Label für die Beschriftung der PLZ*/
		JLabel JLtitleplz = new JLabel("PLZ:");
		JLtitleplz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLtitleplz.setBounds(226, 227, 78, 33);
		panel.add(JLtitleplz);
		
		/*TextField für die PLZ*/
		JTplz = new JTextField();
		JTplz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTplz.setBounds(226, 258, 179, 33);
		panel.add(JTplz);
		
		/*Label für die Beschriftung des Orts*/
		JLabel JLtitleort = new JLabel("Ort:");
		JLtitleort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLtitleort.setBounds(10, 302, 78, 33);
		panel.add(JLtitleort);
		
		/*TextField für den Ort*/
		JTort = new JTextField();
		JTort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTort.setBounds(10, 333, 179, 33);
		panel.add(JTort);
		
		/*Label für die Beschriftung des Landes*/
		JLabel JLtitleland = new JLabel("Land:");
		JLtitleland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLtitleland.setBounds(226, 302, 78, 33);
		panel.add(JLtitleland);
		
		/*TextField für das Land*/
		JTextField JTland = new JTextField();
		JTland.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTland.setBounds(226, 333, 179, 33);
		panel.add(JTland);
		
		/*Button Weiter zum Verlasssen der Frame*/
		JLabel JLweiter = new JLabel("Flug buchen >");
		JLweiter.setBackground(myOrange);
		JLweiter.setOpaque(true);
		JLweiter.setForeground(Color.WHITE);
		JLweiter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLweiter.setHorizontalAlignment(SwingConstants.CENTER);
		JLweiter.setBounds(10, 390, 179, 49);
		panel.add(JLweiter);
		
		/*Button Zurück zum Wechseln in die letzte Frame*/
		JLabel JLzurück = new JLabel("Zurück <");
		JLzurück.setBackground(Color.LIGHT_GRAY);
		JLzurück.setOpaque(true);
		JLzurück.setHorizontalAlignment(SwingConstants.CENTER);
		JLzurück.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLzurück.setBounds(226, 390, 179, 49);
		panel.add(JLzurück);
		
		/*Label für das Obligatorisch-Zeichen*/
		JLabel o1 = new JLabel("*");
		o1.setForeground(Color.RED);
		o1.setBounds(62, 11, 33, 21);
		panel.add(o1);
		
		/*Label für das Obligatorisch-Zeichen*/
		JLabel o2 = new JLabel("*");
		o2.setForeground(Color.RED);
		o2.setBounds(73, 89, 33, 21);
		panel.add(o2);
		
		/*Label für das Obligatorisch-Zeichen*/
		JLabel o3 = new JLabel("*");
		o3.setForeground(Color.RED);
		o3.setBounds(295, 88, 33, 21);
		panel.add(o3);
		
		/*Label für das Obligatorisch-Zeichen*/
		JLabel o4 = new JLabel("*");
		o4.setForeground(Color.RED);
		o4.setBounds(62, 227, 33, 21);
		panel.add(o4);
		
		/*Label für das Obligatorisch-Zeichen*/
		JLabel o5 = new JLabel("*");
		o5.setForeground(Color.RED);
		o5.setBounds(253, 226, 33, 21);
		panel.add(o5);
		
		/*Label für das Obligatorisch-Zeichen*/
		JLabel o6 = new JLabel("*");
		o6.setForeground(Color.RED);
		o6.setBounds(38, 302, 33, 21);
		panel.add(o6);
		
		/*Label für das Obligatorisch-Zeichen*/
		JLabel o7 = new JLabel("*");
		o7.setForeground(Color.RED);
		o7.setBounds(265, 302, 22, 21);
		panel.add(o7);
		
		/**
		 * Onclick-Action in Ort-TextField:
		 * Es wird von der PLZ mithilfe der API der Name des Ortes bestimmt.
		 */
		JTort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Text im TextField wird gelöscht*/
				JTort.setText("");
				/*PLZ wird aus JTPLZ gezogen und zwischengespeichert*/
				String plz = JTplz.getText();
				/*Objekt für API2*/
				a = new API2(plz);
				/*Gefundener Ort wird in das TextField eingefügt*/
				JTort.setText(a.ortschaft);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				/*Text im TextField wird gelöscht*/
				JTort.setText("");
				/*PLZ wird aus JTPLZ gezogen und zwischengespeichert*/
				String plz = JTplz.getText();
				/*Objekt für API2*/
				a = new API2(plz);
				/*Gefundener Ort wird in das TextField eingefügt*/
				JTort.setText(a.ortschaft);
			}
		});
		
		/**
		 * Onclick-Action für Weiter:
		 * Es werden diverse Checks gemacht,welche unten aufgeführt sind
		 */
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean JTvornamestatus = false;
				boolean JTnachnamestatus = false;
				boolean JTstrassestatus = false;
				boolean JTplzstatus = false;
				boolean JTortstatus = false;
				boolean JTlandstatus = false;
				
				/*Es wird geprpft, ob der Vorname definiert wurde*/
				if(! JTvorname.getText().isEmpty() && JTvorname.getText() != null) {
					JTvorname.setBackground(Color.white);
					JTvornamestatus = true;
				}else {
					/*Hintergrund des TextFields wird gelb*/
					JTvorname.setBackground(Color.yellow);
					JTvorname.setOpaque(true);
				}
				
				/*Es wird geprpft, ob der Nachname definiert wurde*/
				if(! JTnachname.getText().isEmpty() && JTnachname.getText() != null) {
					JTnachname.setBackground(Color.white);
					JTnachnamestatus = true;
				}else {
					/*Hintergrund des TextFields wird gelb*/
					JTnachname.setBackground(Color.yellow);
					JTnachname.setOpaque(true);
				}
				
				/*Es wird geprpft, ob die Strasse definiert wurde*/
				if(! JTstrasse.getText().isEmpty() && JTstrasse.getText() != null) {
					JTstrasse.setBackground(Color.white);
					JTstrassestatus = true;
				}else {
					/*Hintergrund des TextFields wird gelb*/
					JTstrasse.setBackground(Color.yellow);
					JTstrasse.setOpaque(true);
				}
				
				/*Es wird geprpft, ob die PLZ definiert wurde*/
				if(! JTplz.getText().isEmpty() && JTplz.getText() != null) {
					JTplz.setBackground(Color.white);
					JTplzstatus = true;
				}else {
					/*Hintergrund des TextFields wird gelb*/
					JTplz.setBackground(Color.yellow);
					JTplz.setOpaque(true);
				}
				
				/*Es wird geprüft, ob der Ort definiert wurde*/
				if(! JTort.getText().isEmpty() && JTort.getText() != null) {
					JTort.setBackground(Color.white);
					
					String plz = JTplz.getText();
					/*Objekt für API2*/
					a = new API2(plz);
					
					/*Es wird geprüft, ob das Feld des Orts ausgefüllt wurde und ob die EIngabe mit der Rückmeldung der API übereinstimmt */
					if(! a.ortschaft.equalsIgnoreCase("") && JTort.getText().equalsIgnoreCase(a.ortschaft)){
						JTortstatus = true;
					}
					else {
						/*Hintergrund des TextFields wird gelb*/
						JTort.setBackground(Color.yellow);
						JTort.setOpaque(true);
					}
			
				}else {
					/*Hintergrund des TextFields wird gelb*/
					JTort.setBackground(Color.yellow);
					JTort.setOpaque(true);
				}
				
				/*Es wird geprpft, ob das Land definiert wurde*/
				if(! JTland.getText().isEmpty() && JTland.getText() != null) {
					JTland.setBackground(Color.white);
					JTlandstatus = true;
				}else {
					/*Hintergrund des TextFields wird gelb*/
					JTland.setBackground(Color.yellow);
					JTland.setOpaque(true);
				}
				
				/*Alle Status müssen True sein*/
				if(JTvornamestatus == true && JTnachnamestatus == true && JTstrassestatus == true && JTplzstatus == true && JTortstatus == true && JTlandstatus == true) {
					/*Frame wird unsichtbar*/
					setVisible(false);
					/*Frame für das GUI5 wird erstellt*/
					frameGUI5 = new GUI5(frameGUI4);
					/*Frame für das GUI5 wird sichtbar*/
					frameGUI5.setVisible(true);
					
				}
				
				
			}
		});
		
		/**
		 * Onclick-Action für Zurück:
		 * Wechsel von der aktuellen Frame auf die vorherige Frame von GUI3
		 */
		JLzurück.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Frame wird unsichtbar*/
				setVisible(false);
				/*Frame für das GUI3 wird sichtbar*/
				GUI2.frameGUI3.setVisible(true);
			}
		});
		
	}
}
