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

public class GUI1 extends JFrame{

	/*Initialisierung der Frame vom GUI1*/
	static GUI1 frame;
	/*Initialisierung des Objekts für das Abflughafen-GUI*/
	private static Abflughafen ab;
	/*Initialisierung des Objekts für das Zielflughafen-GUI*/
	private static Zielflughafen ziel;
	/*Initialisierung des Objekts für das Menu-GUI*/
	static Menu menu;
	/*Initialisierung des Objekts für die API*/
	static API1 a;
	/*Initialiserung des Objekts für das Flugauswahl-GUI*/
	static GUI2 frameGUI2;
	/*Hauptpanel für Frame*/
	private JPanel contentPane;
	/*Variable für Status des Buttons Nur Hinflug*/
	static boolean statushinflug = true;
	/*Label für die Anzeige des Abflughafens*/
	private JLabel JTab;
	/*Label für die Anzeige des Zielflughafens*/
	private JLabel JTnach;
	/*Textfeld für das Hinflugdatum*/
	public static JTextField JThinflugdatum;
	/*Textfeld für das Rückflugdatum*/
	public static JTextField JTrückflugdatum;
	/*Count-Variable für Erwachsene*/
	public static int count1 = 0;
	/*Count-Variable für Kinder*/
	public static int count2 = 0;
	/*Count-Variable für Kleinkinder*/
	public static int count3 = 0;
	/*Variable zum Speichern der Eingabe des Abflughafens*/
	public static String abflughafen;
	/*Variable zum Speichern der Eingabe des Zielflughafens*/
	public static String zielflughafen;
	/*Label für die Anzahl Erwachsene*/
	JLabel JLcounter1;
	/*Label für die Anzahl Kinder*/
	JLabel JLcounter2;
	/*Label für die Anzahl Kleinkinder*/
	JLabel JLcounter3;
	/*Pattern für das Überprüfen des eingegebenen Datums*/
	private Pattern pattern = Pattern.compile("\\b(0[1-9]|[12][0-9]?|3[01]?|[4-9])\\b\\.\\b(0[1-9]|[1][0-2]?|[2-9])\\b\\.\\b([1-2][019][0-9][0-9])\\b");
	
	
	public static void main(String[] args) {
		
		/*Erstellung der Frame*/
		frame = new GUI1();
		frame.setTitle("Flüge");
		frame.setVisible(false);
		/*Erstellung des Menus*/
		menu = new Menu(frame, ab, a);
		menu.setVisible(true);
		/*Erstellung der Abflughafen-Frame*/
		ab = new Abflughafen(frame);
		/*Erstellung der Zielflughafen-Frame*/
		ziel = new Zielflughafen(frame);
		/*Erstellung der API*/
		a = new API1();
	}

	public GUI1() {
		
		/*Einstellungen der Frame*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 607);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Button für "Nur Hinflug"-Auswahl*/
		JLabel JBnurhinflug = new JLabel("");
		ImageIcon icon1 = new ImageIcon(getClass().getResource("icons8-aircraft-35.png"));
		JBnurhinflug.setIcon(icon1);
		JBnurhinflug.setBounds(66, 24, 48, 41);
		contentPane.add(JBnurhinflug);
		
		/*Beschriftung für "Nur Hinflug*/
		JLabel JLnurhinflug = new JLabel("Nur Hinflug");
		JLnurhinflug.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLnurhinflug.setBounds(124, 30, 144, 35);
		contentPane.add(JLnurhinflug);
		
		/*JLabel für Abflughafen-Beschriftung*/
		JLabel JLab = new JLabel("Ab:");
		JLab.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLab.setBounds(21, 96, 48, 35);
		contentPane.add(JLab);
		
		/*JLabel für Zielflughafen-Beschriftung*/
		JLabel JLnach = new JLabel("Nach:");
		JLnach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLnach.setBounds(21, 158, 48, 41);
		contentPane.add(JLnach);
		
		/*JLabel für Abflughafen-Auswahl*/
		JTab = new JLabel();
		JTab.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTab.setBackground(Color.white);
		JTab.setOpaque(true);
		JTab.setBounds(66, 94, 246, 41);
		contentPane.add(JTab);
		
		/*JLabel für Zielflughafen-Auswahl*/
		JTnach = new JLabel();
		JTnach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTnach.setBackground(Color.white);
		JTnach.setOpaque(true);
		JTnach.setBounds(66, 158, 246, 41);
		contentPane.add(JTnach);
		
		/*Button für Abflughafen-Liste*/
		JLabel JBab = new JLabel("");
		ImageIcon icon2 = new ImageIcon(getClass().getResource("icons8-questionnaire-24.png"));
		JBab.setIcon(icon2);
		JBab.setBounds(322, 96, 48, 35);
		contentPane.add(JBab);
		
		/*Button für Zielflughafen-Liste*/
		JLabel JBnach = new JLabel("");
		ImageIcon icon3 = new ImageIcon(getClass().getResource("icons8-questionnaire-24.png"));
		JBnach.setIcon(icon3);
		JBnach.setBounds(322, 164, 48, 35);
		contentPane.add(JBnach);
		
		/*Icon für das Hinflugdatum*/
		JLabel datum_icon1 = new JLabel("");
		ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-leave-35.png"));
		datum_icon1.setIcon(icon4);
		datum_icon1.setBounds(21, 237, 48, 35);
		contentPane.add(datum_icon1);
		
		/*JLabel für Beschriftung des Hinflugdatums*/
		JLabel JLhinflugdatum = new JLabel("Hinflugdatum:");
		JLhinflugdatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLhinflugdatum.setBackground(Color.WHITE);
		JLhinflugdatum.setBounds(81, 228, 95, 53);
		contentPane.add(JLhinflugdatum);
		
		/*TextField für das Definieren des Hinflugdatums*/
		JThinflugdatum = new JTextField();
		JThinflugdatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JThinflugdatum.setBounds(186, 237, 126, 36);
		contentPane.add(JThinflugdatum);
		JThinflugdatum.setColumns(10);
		
		/*Icon für das Rückflugdatum*/
		JLabel datum_icon2 = new JLabel("");
		ImageIcon icon5 = new ImageIcon(getClass().getResource("icons8-leave-35.png"));
		datum_icon2.setIcon(icon5);
		datum_icon2.setBounds(21, 300, 48, 35);
		contentPane.add(datum_icon2);
		
		/*JLabel für Beschriftung des Rückflugdatums*/
		JLabel JLrückflugdatum = new JLabel("Rückflugdatum:");
		JLrückflugdatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLrückflugdatum.setBackground(Color.WHITE);
		JLrückflugdatum.setBounds(81, 292, 95, 53);
		contentPane.add(JLrückflugdatum);
		
		/*TextField für das Definieren des Rückflugdatums*/
		JTrückflugdatum = new JTextField();
		JTrückflugdatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTrückflugdatum.setColumns(10);
		JTrückflugdatum.setBounds(186, 299, 126, 36);
		contentPane.add(JTrückflugdatum);
		
		/*JLabel für das Beschriften des Erwachsenen*/
		JLabel JLerwachsener = new JLabel("Erwachsene (16+)");
		JLerwachsener.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLerwachsener.setBounds(42, 364, 144, 35);
		contentPane.add(JLerwachsener);
		
		/*JLabel für das Beschriften des Kindes*/
		JLabel JLkinder = new JLabel("Kinder (2 - 15)");
		JLkinder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLkinder.setBounds(42, 398, 144, 35);
		contentPane.add(JLkinder);
		
		/*JLabel für das Beschriften des Kleinkindes*/
		JLabel JLkleinkinder = new JLabel("Kleinkinder (<2)");
		JLkleinkinder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLkleinkinder.setBounds(42, 432, 144, 35);
		contentPane.add(JLkleinkinder);
		
		/*JPanel für die Elemente des Hochzählens von Erwachsenen*/
		JPanel JPplusminus1 = new JPanel();
		JPplusminus1.setBounds(202, 364, 126, 35);
		contentPane.add(JPplusminus1);
		JPplusminus1.setLayout(new GridLayout(0, 3, 0, 0));
		
		/*Minus-Button für das Herunterzählen von Erwachsenen*/
		JLabel JBminus1 = new JLabel("");
		JBminus1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon6 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
		JBminus1.setIcon(icon6);
		
		/*Anzeige der Anzahl Erwachsener*/
		JLcounter1 = new JLabel("");
		JLcounter1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLcounter1.setHorizontalAlignment(SwingConstants.CENTER);
		String c1 = String.valueOf(this.count1);  
		JLcounter1.setText(c1);
		
		/*Plus-Button für das Hochzählen von Erwachsenen*/
		JLabel JBplus1 = new JLabel("");
		JBplus1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon7 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
		JBplus1.setIcon(icon7);
		
		/*Elemente werden dem JPanel hinzugefügt*/
		JPplusminus1.add(JBminus1);
		JPplusminus1.add(JLcounter1);
		JPplusminus1.add(JBplus1);
		
		/*JPanel für die Elemente des Hochzählens von Kindern*/
		JPanel JPplusminus2 = new JPanel();
		JPplusminus2.setBounds(202, 398, 126, 35);
		contentPane.add(JPplusminus2);
		JPplusminus2.setLayout(new GridLayout(0, 3, 0, 0));
		
		/*Minus-Button für das Herunterzählen von Kinder*/
		JLabel JBminus2 = new JLabel("");
		JBminus2.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon8 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
		JBminus2.setIcon(icon8);
		
		/*Anzeige der Anzahl Kinder*/
		JLcounter2 = new JLabel("");
		JLcounter2.setHorizontalAlignment(SwingConstants.CENTER);
		JLcounter2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		String c2 = String.valueOf(this.count2);  
		JLcounter2.setText(c2);
		
		/*Plus-Button für das Hochzählen von Kinder*/
		JLabel JBplus2 = new JLabel("");
		JBplus2.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon9 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
		JBplus2.setIcon(icon9);
		
		/*Elemente werden dem JPanel hinzugefügt*/
		JPplusminus2.add(JBminus2);
		JPplusminus2.add(JLcounter2);
		JPplusminus2.add(JBplus2);
		
		/*JPanel für die Elemente des Hochzählens von Kleinkindern*/
		JPanel JPplusminus3 = new JPanel();
		JPplusminus3.setBounds(202, 432, 126, 35);
		contentPane.add(JPplusminus3);
		JPplusminus3.setLayout(new GridLayout(0, 3, 0, 0));
		
		/*Minus-Button für das Herunterzählen von Kleinkinder*/
		JLabel JBminus3 = new JLabel("");
		JBminus3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon10 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
		JBminus3.setIcon(icon10);
		
		/*Anzeige der Anzahl Kleinkinder*/
		JLcounter3 = new JLabel("");
		JLcounter3.setHorizontalAlignment(SwingConstants.CENTER);
		JLcounter3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		String c3 = String.valueOf(this.count3);  
		JLcounter3.setText(c3);
		
		/*Plus-Button für das Hochzählen von Kleinkinder*/
		JLabel JBplus3 = new JLabel("");
		JBplus3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon11 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
		JBplus3.setIcon(icon11);
		
		/*Elemente werden dem JPanel hinzugefügt*/
		JPplusminus3.add(JBminus3);
		JPplusminus3.add(JLcounter3);
		JPplusminus3.add(JBplus3);
		
		/*Button für das Wechseln in die nächste View*/
		JLabel JBflügeanzeigen = new JLabel("Flüge anzeigen >");
		JBflügeanzeigen.setForeground(Color.WHITE);
		Color myOrange = new Color(255, 127, 000);
		JBflügeanzeigen.setBackground(myOrange);
		JBflügeanzeigen.setOpaque(true);
		JBflügeanzeigen.setHorizontalAlignment(SwingConstants.CENTER);
		JBflügeanzeigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBflügeanzeigen.setBounds(23, 497, 216, 47);
		contentPane.add(JBflügeanzeigen);
		
		/*Zurück-Button für Wechsel in vorherige View*/
		JLabel JBzurück = new JLabel("Zurück <");
		JBzurück.setBackground(Color.LIGHT_GRAY);
		JBzurück.setOpaque(true);
		JBzurück.setHorizontalAlignment(SwingConstants.CENTER);
		JBzurück.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBzurück.setBounds(249, 497, 118, 47);
		contentPane.add(JBzurück);
		
		/**
		 * Onclick-Action für Nur-Hinflug-Button
		 * Wenn auf "Nur Hinflug" gewechselt wird, ändert sich das Icon sowie der statushinflug = false
		 * Wenn auf "Hin- und Rückflug" gewechselt wird, ändert sich das Icon sowie der statushinflug = true
		 */
		JBnurhinflug.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(statushinflug == true) {
					ImageIcon icon = new ImageIcon(getClass().getResource("icons8-aircraft-36.png"));
					JBnurhinflug.setIcon(icon);
					statushinflug = false;
					JLnurhinflug.setText("Hin- und Rückflug");
					JLrückflugdatum.setVisible(false);
					datum_icon2.setVisible(false);
					JTrückflugdatum.setVisible(false);
				}
				else {
					ImageIcon icon = new ImageIcon(getClass().getResource("icons8-aircraft-35.png"));
					JBnurhinflug.setIcon(icon);
					statushinflug = true;
					JLnurhinflug.setText("Nur Hinflug");
					JLrückflugdatum.setVisible(true);
					datum_icon2.setVisible(true);
					JTrückflugdatum.setVisible(true);
				}
			}
		});
		
		/**
		 * Sobald der Button für die Abflughafen-Liste gedrückt wird,
		 * wird die Frame unsichtbar gemacht
		 * wird die Abflughafen-Frame sichbar gemacht.
		 */
		JBab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ab.visibleGUI();
			}
		});
		
		/**
		 * Sobald der Button für die Zielflughafen-Liste gedrückt wird,
		 * wird die Frame unsichtbar gemacht
		 * wird die Zielflughafen-Frame sichbar gemacht.
		 */
		JBnach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ziel.visibleGUI();
			}
		});
		
		/**
		 * Onclick-Action für Plus-Button:
		 * Es können bis maximum 40 Personen Passagiere hinzugefügt werden
		 */
		JBplus1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				/*Ist Anzahl Passagiere nicht grösser als 40*/
				if((count1+count2+count3) != 40) {
					/*Count-Variable wird um eins erhöht*/
					count1++;
					/*Umwandlung der Count-Variable zu einem String, um diesen auf dem JLabel anzuzeigen*/
					String c1 = Integer.toString(count1);
					JLcounter1.setText(c1);
					
					/*Minus-Icon wird auf Orange gewechselt*/
					ImageIcon icon2 = new ImageIcon(getClass().getResource("icons8-subtract-26-orange.png"));
					JBminus1.setIcon(icon2);
					JBminus1.repaint();
					JBminus1.validate();
				}
				/*Ist Anzahl Erwachsener gleich 40, sollen alle Plus-Zeichen schwarz werden*/
				if((count1+count2+count3) == 40) {
					ImageIcon icon3 = new ImageIcon(getClass().getResource("icons8-plus-math-26 (1).png"));
					JBplus1.setIcon(icon3);
					JBplus1.repaint();
					JBplus1.validate();
					JBplus2.setIcon(icon3);
					JBplus2.repaint();
					JBplus2.validate();
					JBplus3.setIcon(icon3);
					JBplus3.repaint();
					JBplus3.validate();
				}
				
			}
		});
		
		/**
		 * Onclick-Action für Minus-Button:
		 * Es können nicht weniger als 0 Personen sein
		 */
		JBminus1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Unterschreitet Anzahl Erwachsener nicht 0*/
				if(count1 >= 1 && count1 <= 40) {
					
					/*Plus-Icon wird auf Orange gewechselt*/
					ImageIcon icon1 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
					JBplus1.setIcon(icon1);
					JBplus1.repaint();
					JBplus1.validate();
					JBplus2.setIcon(icon1);
					JBplus2.repaint();
					JBplus2.validate();
					JBplus3.setIcon(icon1);
					JBplus3.repaint();
					JBplus3.validate();
					
					/*Count-Variable wird um eins vermindert*/
					count1--;
					/*Umwandlung der Count-Variable zu einem String, um diesen auf dem JLabel anzuzeigen*/
					String c1 = Integer.toString(count1);
					JLcounter1.setText(c1);
				}
				/*Anzahl Passagiere darf nicht 0 unterschreiten*/
				if(count1 == 0) {
					/*Minus-Icon wird auf Schwarz gewechselt*/
					ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
					JBminus1.setIcon(icon4);
					JBminus1.repaint();
					JBminus1.validate();
				}

			}
		});
		
		/**
		 * Onclick-Action für Plus-Button:
		 * Es können bis maximum 40 Personen Passagiere hinzugefügt werden
		 */
		JBplus2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				/*Ist Anzahl Passagiere nicht grösser als 40*/
				if((count1+count2+count3) != 40) {
					/*Count-Variable wird um eins erhöht*/
					count2++;
					/*Umwandlung der Count-Variable zu einem String, um diesen auf dem JLabel anzuzeigen*/
					String c2 = Integer.toString(count2);
					JLcounter2.setText(c2);
					
					/*Minus-Icon wird auf Orange gewechselt*/
					ImageIcon icon2 = new ImageIcon(getClass().getResource("icons8-subtract-26-orange.png"));
					JBminus2.setIcon(icon2);
					JBminus2.repaint();
					JBminus2.validate();
				}
				/*Ist Anzahl Erwachsener gleich 40, sollen alle Plus-Zeichen schwarz werden*/
				if((count1+count2+count3) == 40) {
					ImageIcon icon3 = new ImageIcon(getClass().getResource("icons8-plus-math-26 (1).png"));
					JBplus1.setIcon(icon3);
					JBplus1.repaint();
					JBplus1.validate();
					JBplus2.setIcon(icon3);
					JBplus2.repaint();
					JBplus2.validate();
					JBplus3.setIcon(icon3);
					JBplus3.repaint();
					JBplus3.validate();
				}
				
			}
		});
		
		/**
		 * Onclick-Action für Minus-Button:
		 * Es können nicht weniger als 0 Personen sein
		 */
		JBminus2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Unterschreitet Anzahl Kinder nicht 0*/
				if(count2 >= 1 && count2 <= 40) {
					
					/*Plus-Icon wird auf Orange gewechselt*/
					ImageIcon icon1 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
					JBplus1.setIcon(icon1);
					JBplus1.repaint();
					JBplus1.validate();
					JBplus2.setIcon(icon1);
					JBplus2.repaint();
					JBplus2.validate();
					JBplus3.setIcon(icon1);
					JBplus3.repaint();
					JBplus3.validate();
					
					/*Count-Variable wird um eins vermindert*/
					count2--;
					/*Umwandlung der Count-Variable zu einem String, um diesen auf dem JLabel anzuzeigen*/
					String c2 = Integer.toString(count2);
					JLcounter2.setText(c2);
				}
				/*Anzahl Passagiere darf nicht 0 unterschreiten*/
				if(count2 == 0) {
					/*Minus-Icon wird auf Schwarz gewechselt*/
					ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
					JBminus2.setIcon(icon4);
					JBminus2.repaint();
					JBminus2.validate();
				}

			}
		});

		/**
		 * Onclick-Action für Plus-Button:
		 * Es können bis maximum 40 Personen Passagiere hinzugefügt werden
		 */
		JBplus3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				/*Ist Anzahl Passagiere nicht grösser als 40*/
				if((count1+count2+count3) != 40) {
					
					/*Count-Variable wird um eins erhöht*/
					count3++;
					/*Umwandlung der Count-Variable zu einem String, um diesen auf dem JLabel anzuzeigen*/
					String c3 = Integer.toString(count3);
					JLcounter3.setText(c3);
					
					/*Minus-Icon wird auf Orange gewechselt*/
					ImageIcon icon2 = new ImageIcon(getClass().getResource("icons8-subtract-26-orange.png"));
					JBminus3.setIcon(icon2);
					JBminus3.repaint();
					JBminus3.validate();
				}
				/*Ist Anzahl Erwachsener gleich 40, sollen alle Plus-Zeichen schwarz werden*/
				if((count1+count2+count3) == 40) {
					ImageIcon icon3 = new ImageIcon(getClass().getResource("icons8-plus-math-26 (1).png"));
					JBplus1.setIcon(icon3);
					JBplus1.repaint();
					JBplus1.validate();
					JBplus2.setIcon(icon3);
					JBplus2.repaint();
					JBplus2.validate();
					JBplus3.setIcon(icon3);
					JBplus3.repaint();
					JBplus3.validate();
				}
				
			}
		});
		
		/**
		 * Onclick-Action für Minus-Button:
		 * Es können nicht weniger als 0 Personen sein
		 */
		JBminus3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Unterschreitet Anzahl Kleinkinder nicht 0*/
				if(count3 >= 1 && count3 <= 40) {
					
					/*Plus-Icon wird auf Orange gewechselt*/
					ImageIcon icon1 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
					JBplus1.setIcon(icon1);
					JBplus1.repaint();
					JBplus1.validate();
					JBplus2.setIcon(icon1);
					JBplus2.repaint();
					JBplus2.validate();
					JBplus3.setIcon(icon1);
					JBplus3.repaint();
					JBplus3.validate();
					
					/*Count-Variable wird um eins vermindert*/
					count3--;
					/*Umwandlung der Count-Variable zu einem String, um diesen auf dem JLabel anzuzeigen*/
					String c3 = Integer.toString(count3);
					JLcounter3.setText(c3);
				}
				/*Anzahl Passagiere darf nicht 0 unterschreiten*/
				if(count3 == 0) {
					/*Minus-Icon wird auf Schwarz gewechselt*/
					ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
					JBminus3.setIcon(icon4);
					JBminus3.repaint();
					JBminus3.validate();
				}


			}
		});
		
		/**
		 * Button für das Beenden dieser View:
		 * Es werden diverse Checks für die Eingaben gemacht.
		 * Wenn diese Checks erfolgreich (true) sind, wird auf das nächste GUI gewechselt.
		 */
		JBflügeanzeigen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*Name des Abflughafens wird in lokaler Variable gespeichert*/
				abflughafen = JTab.getText();
				/*Name des Zielflughafens wird in lokaler Variable gespeichert*/
				zielflughafen = JTnach.getText();
				
				/*String abflugdatum_tmp = JThinflugdatum.getText();
				String rückflugdatum_tmp = JTrückflugdatum.getText();
				String abflugdatum=abflugdatum_tmp.replace(".","");
				String rückflugdatum=rückflugdatum_tmp.replace(".", "");*/
				
				/*Status für den Abflughafen*/
				boolean JTabstatus = false;
				/*Status für den Zielflughafen*/
				boolean JTnachstatus = false;
				/*Status für das Hinflugdatum*/
				boolean JThinflugdatumstatus = false;
				/*Status für das Rückflugdatum*/
				boolean JTrückflugdatumstatus = false;
				/*Status für die Anzahl Passagiere*/
				boolean Countstatus = false;
				
				/*Wurde ein Abflughafen ausgewählt?*/
				if(! JTab.getText().isEmpty() && JTab.getText() != null) {
					/*JLabel wird weiss*/
					JTab.setBackground(Color.white);
					JTabstatus = true;
				}
				
				else {
					/*JLabel wird gelb*/
					JTab.setBackground(Color.yellow);
					JTab.setOpaque(true);
				}
				
				/*Wurde ein Zielflughafen ausgewählt?*/
				if(! JTnach.getText().isEmpty() && JTnach.getText() != null && ! JTnach.getText().equalsIgnoreCase(JTab.getText())) {
					/*JLabel wird weiss*/
					JTnach.setBackground(Color.white);
					JTnachstatus = true;
				}
				
				else {
					/*JLabel wird gelb*/
					JTnach.setBackground(Color.yellow);
					JTnach.setOpaque(true);
				}
				
				/*Ist die Anzahl Passagiere grösser als 0 und kleiner / gleich 40?*/
				if((count1+count2+count1) > 0 && (count1+count2+count1) <= 40) {
					/*JLabels werden weiss*/
					JLcounter1.setBackground(null);
					JLcounter2.setBackground(null);
					JLcounter3.setBackground(null);
					Countstatus = true;
				}
				
				else {
					/*JLabels werden gelb*/
					JLcounter1.setBackground(Color.yellow);
					JLcounter1.setOpaque(true);
					JLcounter2.setBackground(Color.yellow);
					JLcounter2.setOpaque(true);
					JLcounter3.setBackground(Color.yellow);
					JLcounter3.setOpaque(true);
				}
				
				/*Matcher für das Überprüfen des Hinflugdatums mit dem Pattern*/
				Matcher h = pattern.matcher(JThinflugdatum.getText());
				/*Matcher für das Überprüfen des Rückflugdatums mit dem Pattern*/
				Matcher r = pattern.matcher(JTrückflugdatum.getText());
				
				/*Ist das Hinflugdatum korrekt?*/
				if(h.matches() == true) {
					/*JLabel wird weiss*/
					JThinflugdatum.setBackground(Color.white);
					JThinflugdatumstatus = true;
				}
				else {
					/*JLabel wird gelb*/
					JThinflugdatum.setBackground(Color.yellow);
					JThinflugdatum.setOpaque(true);
				}
				
				/*Wurde Hin- und Rückflug gewählt?*/
				if(statushinflug == true) {
										
					/*Ist das Rückflugdatum korrekt?*/
					if(r.matches() == true) {
						/*JLabel wird weiss*/
						JTrückflugdatum.setBackground(Color.white);
						JTrückflugdatumstatus = true;
					}
					
					else {
						/*JLabel wird gelb*/
						JTrückflugdatum.setBackground(Color.yellow);
						JTrückflugdatum.setOpaque(true);
					}
				}
				
				else {
					JTrückflugdatumstatus = true;
				}
				
				/*Sind alle Status auf true?*/
				if(JTabstatus == true && JTnachstatus == true && JThinflugdatumstatus == true && JTrückflugdatumstatus == true && Countstatus == true) {
					/*Frame für GUI2 wird erstellt*/
					frameGUI2 = new GUI2(frame);
					frameGUI2.setVisible(true);
					/*Frame für GUI2 wird unsichtbar*/
					setVisible(false);
				}
				
				
			}
		});
		
		/**
		 * Onclick-Action für Zurück-Button:
		 * GUI1-Frame wird unsichtbar gemacht
		 * Wechsel zurück auf das Menu
		 */
		JBzurück.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(true);
				setVisible(false);
			}
		});
		
	}
	
	/**
	 * Methode für das Visualisieren des ausgewählten Abflughafens auf der Frame
	 */
	public void setAbflughafen() {
		/*Ausgewählter Abflughafen wird zwischengespeichert*/
		String selected = ab.guiAuswahl();
		/*Abflughafen wird in JLabel eingefügt*/
		JTab.setText(selected);
	}
	
	/**
	 * Methode für das Visualisieren des ausgewählten Zielflughafens auf der Frame
	 */
	public void setZielflughafen() {
		/*Ausgewählter Zielflughafen wird zwischengespeichert*/
		String selected = ziel.guiAuswahl();
		/*Zielflughafen wird in JLabel eingefügt*/
		JTnach.setText(selected);
	}
}
