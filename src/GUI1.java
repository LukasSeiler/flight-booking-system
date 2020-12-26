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

	static GUI1 frame;
	/*Objekt f�r Abflughafen-GUI*/
	private static Abflughafen ab;
	/*Objekt f�r Zielflughafen-GUI*/
	private static Zielflughafen ziel;
	/*Objekt f�r das Menu-GUI*/
	static Menu menu;
	/*Objekt f�r API*/
	static API1 a;
	/*Objekt f�r Flugauswahl-GUI*/
	static GUI2 frameGUI2;
	private JPanel contentPane;
	/*Variable f�r Status des Buttons Nur Hinflug*/
	static boolean statushinflug = true;
	private JLabel JTab;
	private JLabel JTnach;
	public JTextField JThinflugdatum;
	public JTextField JTr�ckflugdatum;
	/*Count-Variable f�r Erwachsene*/
	public int count1 = 0;
	/*Count-Variable f�r Kinder*/
	public int count2 = 0;
	/*Count-Variable f�r Kleinkinder*/
	public int count3 = 0;
	/*Variable zum Speichern der Eingabe des Abflughafens*/
	public String abflughafen;
	/*Variable zum Speichern der Eingabe des Zielflughafens*/
	public String zielflughafen;
	JLabel JLcounter1;
	JLabel JLcounter2;
	JLabel JLcounter3;
	/*Pattern f�r das �berpr�fen des eingegebenen Datums*/
	private Pattern pattern = Pattern.compile("\\b(0[1-9]|[12][0-9]?|3[01]?|[4-9])\\b\\.\\b(0[1-9]|[1][0-2]?|[2-9])\\b\\.\\b([1-2][019][0-9][0-9])\\b");
	
	
	public static void main(String[] args) {
		
		frame = new GUI1();
		frame.setTitle("Fl�ge");
		frame.setVisible(false);
		menu = new Menu(frame, ab, a);
		menu.setVisible(true);
		ab = new Abflughafen(frame);
		ziel = new Zielflughafen(frame);
		a = new API1();
	}

	public GUI1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 607);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Button f�r "Nur Hinflug"-Auswahl*/
		JLabel JBnurhinflug = new JLabel("");
		ImageIcon icon1 = new ImageIcon(getClass().getResource("icons8-aircraft-35.png"));
		JBnurhinflug.setIcon(icon1);
		JBnurhinflug.setBounds(66, 24, 48, 41);
		contentPane.add(JBnurhinflug);
		
		/*Beschriftung f�r "Nur Hinflug*/
		JLabel JLnurhinflug = new JLabel("Nur Hinflug");
		JLnurhinflug.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLnurhinflug.setBounds(124, 30, 144, 35);
		contentPane.add(JLnurhinflug);
		
		/*JLabel f�r Abflughafen-Beschriftung*/
		JLabel JLab = new JLabel("Ab:");
		JLab.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLab.setBounds(21, 96, 48, 35);
		contentPane.add(JLab);
		
		/*JLabel f�r Zielflughafen-Beschriftung*/
		JLabel JLnach = new JLabel("Nach:");
		JLnach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLnach.setBounds(21, 158, 48, 41);
		contentPane.add(JLnach);
		
		/*JTextfield f�r Abflughafen-Auswahl*/
		JTab = new JLabel();
		JTab.setBackground(Color.white);
		JTab.setOpaque(true);
		JTab.setBounds(66, 94, 246, 41);
		contentPane.add(JTab);
		
		/*JTextfield f�r Zielflughafen-Auswahl*/
		JTnach = new JLabel();
		JTnach.setBackground(Color.white);
		JTnach.setOpaque(true);
		JTnach.setBounds(66, 158, 246, 41);
		contentPane.add(JTnach);
		
		/*Button f�r Abflughafen-Liste*/
		JLabel JBab = new JLabel("");
		ImageIcon icon2 = new ImageIcon(getClass().getResource("icons8-questionnaire-24.png"));
		JBab.setIcon(icon2);
		JBab.setBounds(322, 96, 48, 35);
		contentPane.add(JBab);
		
		/*Button f�r Zielflughafen-Liste*/
		JLabel JBnach = new JLabel("");
		ImageIcon icon3 = new ImageIcon(getClass().getResource("icons8-questionnaire-24.png"));
		JBnach.setIcon(icon3);
		JBnach.setBounds(322, 164, 48, 35);
		contentPane.add(JBnach);
		
		/*Icon f�r das Hinflugdatum*/
		JLabel datum_icon1 = new JLabel("");
		ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-leave-35.png"));
		datum_icon1.setIcon(icon4);
		datum_icon1.setBounds(21, 237, 48, 35);
		contentPane.add(datum_icon1);
		
		/*JLabel f�r Beschriftung des Hinflugdatums*/
		JLabel JLhinflugdatum = new JLabel("Hinflugdatum:");
		JLhinflugdatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLhinflugdatum.setBackground(Color.WHITE);
		JLhinflugdatum.setBounds(81, 228, 95, 53);
		contentPane.add(JLhinflugdatum);
		
		/*Icon f�r das R�ckflugdatum*/
		JLabel datum_icon2 = new JLabel("");
		ImageIcon icon5 = new ImageIcon(getClass().getResource("icons8-leave-35.png"));
		datum_icon2.setIcon(icon5);
		datum_icon2.setBounds(21, 300, 48, 35);
		contentPane.add(datum_icon2);
		
		/*jLabel f�r Beschriftung des Zielflughafens*/
		JLabel JLr�ckflugdatum = new JLabel("R�ckflugdatum:");
		JLr�ckflugdatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLr�ckflugdatum.setBackground(Color.WHITE);
		JLr�ckflugdatum.setBounds(81, 292, 95, 53);
		contentPane.add(JLr�ckflugdatum);
		
		/*TextField f�r das Definieren des Hinflugdatums*/
		JThinflugdatum = new JTextField();
		JThinflugdatum.setBounds(186, 237, 126, 36);
		contentPane.add(JThinflugdatum);
		JThinflugdatum.setColumns(10);
		
		/*TextField f�r das Definieren des R�ckflugdatums*/
		JTr�ckflugdatum = new JTextField();
		JTr�ckflugdatum.setColumns(10);
		JTr�ckflugdatum.setBounds(186, 299, 126, 36);
		contentPane.add(JTr�ckflugdatum);
		
		/*JLabel f�r das Beschriften des Erwachsenen*/
		JLabel JLerwachsener = new JLabel("Erwachsene (16+)");
		JLerwachsener.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLerwachsener.setBounds(42, 364, 144, 35);
		contentPane.add(JLerwachsener);
		
		/*JLabel f�r das Beschriften des Kindes*/
		JLabel JLkinder = new JLabel("Kinder (2 - 15)");
		JLkinder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLkinder.setBounds(42, 398, 144, 35);
		contentPane.add(JLkinder);
		
		/*JLabel f�r das Beschriften des Kleinkindes*/
		JLabel JLkleinkinder = new JLabel("Kleinkinder (<2)");
		JLkleinkinder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLkleinkinder.setBounds(42, 432, 144, 35);
		contentPane.add(JLkleinkinder);
		
		/*JPanel f�r die Elemente des Hochz�hlens von Passagieren*/
		JPanel JPplusminus1 = new JPanel();
		JPplusminus1.setBounds(202, 364, 126, 35);
		contentPane.add(JPplusminus1);
		JPplusminus1.setLayout(new GridLayout(0, 3, 0, 0));
		
		/*Minus-Button f�r das Herunterz�hlen von Erwachsenen*/
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
		
		/*Plus-Button f�r das Hochz�hlen von Erwachsenen*/
		JLabel JBplus1 = new JLabel("");
		JBplus1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon7 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
		JBplus1.setIcon(icon7);
		
		/*Elemente werden dem JPanel hinzugef�gt*/
		JPplusminus1.add(JBminus1);
		JPplusminus1.add(JLcounter1);
		JPplusminus1.add(JBplus1);
		
		/*JPanel f�r die Elemente des Hochz�hlens von Passagieren*/
		JPanel JPplusminus2 = new JPanel();
		JPplusminus2.setBounds(202, 398, 126, 35);
		contentPane.add(JPplusminus2);
		JPplusminus2.setLayout(new GridLayout(0, 3, 0, 0));
		
		/*Minus-Button f�r das Herunterz�hlen von Kinder*/
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
		
		/*Plus-Button f�r das Hochz�hlen von Kinder*/
		JLabel JBplus2 = new JLabel("");
		JBplus2.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon9 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
		JBplus2.setIcon(icon9);
		
		/*Elemente werden dem JPanel hinzugef�gt*/
		JPplusminus2.add(JBminus2);
		JPplusminus2.add(JLcounter2);
		JPplusminus2.add(JBplus2);
		
		/*JPanel f�r die Elemente des Hochz�hlens von Passagieren*/
		JPanel JPplusminus3 = new JPanel();
		JPplusminus3.setBounds(202, 432, 126, 35);
		contentPane.add(JPplusminus3);
		JPplusminus3.setLayout(new GridLayout(0, 3, 0, 0));
		
		/*Minus-Button f�r das Herunterz�hlen von Kleinkinder*/
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
		
		/*Plus-Button f�r das Hochz�hlen von Kleinkinder*/
		JLabel JBplus3 = new JLabel("");
		JBplus3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon11 = new ImageIcon(getClass().getResource("icons8-plus-math-26.png"));
		JBplus3.setIcon(icon11);
		
		/*Elemente werden dem JPanel hinzugef�gt*/
		JPplusminus3.add(JBminus3);
		JPplusminus3.add(JLcounter3);
		JPplusminus3.add(JBplus3);
		
		/*Button f�r das Wechseln in die n�chste View*/
		JLabel JBfl�geanzeigen = new JLabel("Fl\u00FCge anzeigen >");
		JBfl�geanzeigen.setForeground(Color.WHITE);
		Color myOrange = new Color(255, 127, 000);
		JBfl�geanzeigen.setBackground(myOrange);
		JBfl�geanzeigen.setOpaque(true);
		JBfl�geanzeigen.setHorizontalAlignment(SwingConstants.CENTER);
		JBfl�geanzeigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBfl�geanzeigen.setBounds(23, 497, 216, 47);
		contentPane.add(JBfl�geanzeigen);
		
		/*Zur�ck-Button f�r Wechsel in vorherige View*/
		JLabel JBzur�ck = new JLabel("Zur�ck <");
		JBzur�ck.setBackground(Color.LIGHT_GRAY);
		JBzur�ck.setOpaque(true);
		JBzur�ck.setHorizontalAlignment(SwingConstants.CENTER);
		JBzur�ck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBzur�ck.setBounds(249, 497, 118, 47);
		contentPane.add(JBzur�ck);
		
		/*Onclick-Action f�r Nur-Hinflug-Button*/
		JBnurhinflug.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(statushinflug == true) {
					ImageIcon icon = new ImageIcon(getClass().getResource("icons8-aircraft-36.png"));
					JBnurhinflug.setIcon(icon);
					statushinflug = false;
					JLnurhinflug.setText("Hin- und R�ckflug");
					JLr�ckflugdatum.setVisible(false);
					datum_icon2.setVisible(false);
					JTr�ckflugdatum.setVisible(false);
				}
				else {
					ImageIcon icon = new ImageIcon(getClass().getResource("icons8-aircraft-35.png"));
					JBnurhinflug.setIcon(icon);
					statushinflug = true;
					JLnurhinflug.setText("Nur Hinflug");
					JLr�ckflugdatum.setVisible(true);
					datum_icon2.setVisible(true);
					JTr�ckflugdatum.setVisible(true);
				}
			}
		});
		
		/*Button f�r Abflughafen-Liste*/
		JBab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ab.visibleGUI();
			}
		});
		
		/*Button f�r Zielflughafen-Liste*/
		JBnach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ziel.visibleGUI();
			}
		});
		
		/*Onclick-Action f�r Plus-Button*/
		JBplus1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				/*Ist Anzahl Erwachsener nicht gr�sser als 40*/
				if((count1+count2+count3) != 40) {
					
					count1++;
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
		
		/*Onclick-Action f�r Minus-Button*/
		JBminus1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Unterschreitet Anzahl Erwachsener nicht 0*/
				if(count1 >= 1 && count1 <= 40) {
					
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
					
					count1--;
					String c1 = Integer.toString(count1);
					JLcounter1.setText(c1);
				}
				if(count1 == 0) {
					/*Minus-Icon wird auf Schwarz gewechselt*/
					ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
					JBminus1.setIcon(icon4);
					JBminus1.repaint();
					JBminus1.validate();
				}

			}
		});
		
		/*Onclick-Action f�r Plus-Button*/
		JBplus2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				/*Ist Anzahl Kinder nicht gr�sser als 40*/
				if((count1+count2+count3) != 40) {
					
					count2++;
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
		
		/*Onclick-Action f�r Minus-Button*/
		JBminus2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Unterschreitet Anzahl Kinder nicht 0*/
				if(count2 >= 1 && count2 <= 40) {
					
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
					
					count2--;
					String c2 = Integer.toString(count2);
					JLcounter2.setText(c2);
				}
				if(count2 == 0) {
					/*Minus-Icon wird auf Schwarz gewechselt*/
					ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
					JBminus2.setIcon(icon4);
					JBminus2.repaint();
					JBminus2.validate();
				}

			}
		});
		
		/*Onclick-Action f�r Plus-Button*/
		JBplus3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				/*Ist Anzahl Kleinkinder nicht gr�sser als 40*/
				if((count1+count2+count3) != 40) {
					
					count3++;
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
		
		/*Onclick-Action f�r Minus-Button*/
		JBminus3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Unterschreitet Anzahl Kleinkinder nicht 0*/
				if(count3 >= 1 && count3 <= 40) {
					
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
					
					count3--;
					String c3 = Integer.toString(count3);
					JLcounter3.setText(c3);
				}
				if(count3 == 0) {
					/*Minus-Icon wird auf Schwarz gewechselt*/
					ImageIcon icon4 = new ImageIcon(getClass().getResource("icons8-subtract-26.png"));
					JBminus3.setIcon(icon4);
					JBminus3.repaint();
					JBminus3.validate();
				}


			}
		});
		
		/*Button f�r das Beenden dieser View*/
		JBfl�geanzeigen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				abflughafen = JTab.getText();
				zielflughafen = JTnach.getText();
				
				String abflugdatum_tmp = JThinflugdatum.getText();
				String r�ckflugdatum_tmp = JTr�ckflugdatum.getText();
				
				String abflugdatum=abflugdatum_tmp.replace(".","");
				String r�ckflugdatum=r�ckflugdatum_tmp.replace(".", "");
				
				boolean JTabstatus = false;
				boolean JTnachstatus = false;
				boolean JThinflugdatumstatus = false;
				boolean JTr�ckflugdatumstatus = false;
				boolean Countstatus = false;
				
				if(! JTab.getText().isEmpty() && JTab.getText() != null) { //ausbauen, dass es checkt, ob diese eingabe als flughafen existiert
					JTab.setBackground(Color.white);
					JTabstatus = true;
				}
				
				else {
					JTab.setBackground(Color.yellow);
					JTab.setOpaque(true);
				}
				
				if(! JTnach.getText().isEmpty() && JTnach.getText() != null && ! JTnach.getText().equalsIgnoreCase(JTab.getText())) {
					JTnach.setBackground(Color.white);
					JTnachstatus = true;
				}
				
				else {
					JTnach.setBackground(Color.yellow);
					JTnach.setOpaque(true);
				}
				
				if((count1+count2+count1) > 0 && (count1+count2+count1) <= 50) {
					JLcounter1.setBackground(null);
					JLcounter2.setBackground(null);
					JLcounter3.setBackground(null);
					Countstatus = true;
				}
				
				else {
					JLcounter1.setBackground(Color.yellow);
					JLcounter1.setOpaque(true);
					JLcounter2.setBackground(Color.yellow);
					JLcounter2.setOpaque(true);
					JLcounter3.setBackground(Color.yellow);
					JLcounter3.setOpaque(true);
				}
				
				Matcher h = pattern.matcher(JThinflugdatum.getText());
				Matcher r = pattern.matcher(JTr�ckflugdatum.getText());
				
				if(h.matches() == true) {
					JThinflugdatum.setBackground(Color.white);
					JThinflugdatumstatus = true;
				}
				else {
					JThinflugdatum.setBackground(Color.yellow);
					JThinflugdatum.setOpaque(true);
				}
				
				if(statushinflug == true) {
					
					/*R�ckflugdatum > Hinflugdatum*/
					
					if(r.matches() == true) {
					
						JTr�ckflugdatum.setBackground(Color.white);
						JTr�ckflugdatumstatus = true;
					}
					
					else {
						JTr�ckflugdatum.setBackground(Color.yellow);
						JTr�ckflugdatum.setOpaque(true);
					}
				}
				
				else {
					JTr�ckflugdatumstatus = true;
				}
				
				if(JTabstatus == true && JTnachstatus == true && JThinflugdatumstatus == true && JTr�ckflugdatumstatus == true && Countstatus == true) {
					frameGUI2 = new GUI2(frame);
					frameGUI2.setVisible(true);
					setVisible(false);
				}
				
				
			}
		});
		
		/*Zur�ck-Button*/
		JBzur�ck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(true);
				setVisible(false);
			}
		});
		
	}
	
	public int getErwachsene(){
		String persons = JLcounter1.getText();
		int count = Integer.parseInt(persons);
		return count;
	}
	
	public void setAbflughafen() {
		String selected = ab.guiAuswahl();
		JTab.setText(selected);
	}
	
	public void setZielflughafen() {
		String selected = ziel.guiAuswahl();
		JTnach.setText(selected);
	}
}
