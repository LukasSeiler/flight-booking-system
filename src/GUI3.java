import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
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
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class GUI3 extends JFrame{
	
	/*Initialisierung der Frame vom GUI3*/
	static GUI3 frameGUI3;
	/*Initialisierung der Frame vom GUI4*/
	static GUI4 frameGUI4;
	/*Icon für einen freien (weissen) Stuhl*/
	ImageIcon icon1 = new ImageIcon(getClass().getResource("icons8-sleeper-chair-35.png"));
	/*Icon für einen selektierten (orangen) Stuhl*/
	ImageIcon icon2 = new ImageIcon(getClass().getResource("icons8-sleeper-chair-36.png"));
	/*Farbe für Orange*/
	Color myOrange = new Color(255, 127, 000);
	/*Sitze am Fenster, Variable für das Ein- und Ausblenden der Extras*/
	int i = 0;
	/*Sitze in den vorderen Reihen, Variable für das Ein- und Ausblenden der Extras*/
	int j = 0;
	/*Anzahl der ausgewählten Sitze*/
	int selected = 0;
	/*Betrag für die Reservierung der Sitze*/
	static int betrag = 0;

	public GUI3(GUI2 frameGUI2) {
		
		/*Einstellunge der Frame*/
		setSize(585, 569);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sitzplatzauswahl");
		getContentPane().setLayout(null);
		
		/*globales Panel der Frame*/
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 580, 540);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		/*Panel für die Sitze*/
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(20, 23, 320, 500);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		/*Label für die Beschriftung der Spalte A*/
		JLabel JLrowA = new JLabel("A");
		JLrowA.setHorizontalAlignment(SwingConstants.CENTER);
		JLrowA.setForeground(Color.WHITE);
		JLrowA.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrowA.setBounds(20, 20, 40, 40);
		panel_1.add(JLrowA);
		
		/*Label für die Beschriftung der Spalte B*/
		JLabel JLrowB = new JLabel("B");
		JLrowB.setHorizontalAlignment(SwingConstants.CENTER);
		JLrowB.setForeground(Color.WHITE);
		JLrowB.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrowB.setBounds(80, 20, 40, 40);
		panel_1.add(JLrowB);
		
		/*Label für die Beschriftung der Spalte C*/
		JLabel JLrowC = new JLabel("C");
		JLrowC.setHorizontalAlignment(SwingConstants.CENTER);
		JLrowC.setForeground(Color.WHITE);
		JLrowC.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrowC.setBounds(200, 20, 40, 40);
		panel_1.add(JLrowC);
		
		/*Label für die Beschriftung der Spalte D*/
		JLabel JLrowD = new JLabel("D");
		JLrowD.setHorizontalAlignment(SwingConstants.CENTER);
		JLrowD.setForeground(Color.WHITE);
		JLrowD.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrowD.setBounds(260, 20, 40, 40);
		panel_1.add(JLrowD);
		
		/*Icon für Sitz*/
		JLabel JLs1a = new JLabel("");
		JLs1a.setHorizontalAlignment(SwingConstants.CENTER);
		JLs1a.setIcon(icon1);
		JLs1a.setForeground(Color.WHITE);
		JLs1a.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs1a.setBounds(20, 80, 40, 40);
		panel_1.add(JLs1a);
		
		/*Icon für Sitz*/
		JLabel JLs1b = new JLabel("");
		JLs1b.setHorizontalAlignment(SwingConstants.CENTER);
		JLs1b.setIcon(icon1);
		JLs1b.setForeground(Color.WHITE);
		JLs1b.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs1b.setBounds(80, 80, 40, 40);
		panel_1.add(JLs1b);
		
		/*Label für die Reihe 1*/
		JLabel JLrow1 = new JLabel("1");
		JLrow1.setHorizontalAlignment(SwingConstants.CENTER);
		JLrow1.setForeground(Color.WHITE);
		JLrow1.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrow1.setBounds(140, 80, 40, 40);
		panel_1.add(JLrow1);
		
		/*Icon für Sitz*/
		JLabel JLs1c = new JLabel("");
		JLs1c.setHorizontalAlignment(SwingConstants.CENTER);
		JLs1c.setIcon(icon1);
		JLs1c.setForeground(Color.WHITE);
		JLs1c.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs1c.setBounds(200, 80, 40, 40);
		panel_1.add(JLs1c);
		
		/*Icon für Sitz*/
		JLabel JLs1d = new JLabel("");
		JLs1d.setHorizontalAlignment(SwingConstants.CENTER);
		JLs1d.setIcon(icon1);
		JLs1d.setForeground(Color.WHITE);
		JLs1d.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs1d.setBounds(260, 80, 40, 40);
		panel_1.add(JLs1d);
		
		/*Icon für Sitz*/
		JLabel JLs2a = new JLabel("");
		JLs2a.setHorizontalAlignment(SwingConstants.CENTER);
		JLs2a.setIcon(icon1);
		JLs2a.setForeground(Color.WHITE);
		JLs2a.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs2a.setBounds(20, 140, 40, 40);
		panel_1.add(JLs2a);
		
		/*Icon für Sitz*/
		JLabel JLs2b = new JLabel("");
		JLs2b.setHorizontalAlignment(SwingConstants.CENTER);
		JLs2b.setIcon(icon1);
		JLs2b.setForeground(Color.WHITE);
		JLs2b.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs2b.setBounds(80, 140, 40, 40);
		panel_1.add(JLs2b);
		
		/*Label für die Reihe 2*/
		JLabel JLrow2 = new JLabel("2");
		JLrow2.setHorizontalAlignment(SwingConstants.CENTER);
		JLrow2.setForeground(Color.WHITE);
		JLrow2.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrow2.setBounds(140, 140, 40, 40);
		panel_1.add(JLrow2);
		
		/*Icon für Sitz*/
		JLabel JLs2c = new JLabel("");
		JLs2c.setHorizontalAlignment(SwingConstants.CENTER);
		JLs2c.setIcon(icon1);
		JLs2c.setForeground(Color.WHITE);
		JLs2c.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs2c.setBounds(200, 140, 40, 40);
		panel_1.add(JLs2c);
		
		/*Icon für Sitz*/
		JLabel JLs2d = new JLabel("");
		JLs2d.setHorizontalAlignment(SwingConstants.CENTER);
		JLs2d.setIcon(icon1);
		JLs2d.setForeground(Color.WHITE);
		JLs2d.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs2d.setBounds(260, 140, 40, 40);
		panel_1.add(JLs2d);
		
		/*Icon für Sitz*/
		JLabel JLs3a = new JLabel("");
		JLs3a.setHorizontalAlignment(SwingConstants.CENTER);
		JLs3a.setIcon(icon1);
		JLs3a.setForeground(Color.WHITE);
		JLs3a.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs3a.setBounds(20, 200, 40, 40);
		panel_1.add(JLs3a);
		
		/*Icon für Sitz*/
		JLabel JLs3b = new JLabel("");
		JLs3b.setHorizontalAlignment(SwingConstants.CENTER);
		JLs3b.setIcon(icon1);
		JLs3b.setForeground(Color.WHITE);
		JLs3b.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs3b.setBounds(80, 200, 40, 40);
		panel_1.add(JLs3b);
		
		/*Label für die Reihe 3*/
		JLabel JLrow3 = new JLabel("3");
		JLrow3.setHorizontalAlignment(SwingConstants.CENTER);
		JLrow3.setForeground(Color.WHITE);
		JLrow3.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrow3.setBounds(140, 200, 40, 40);
		panel_1.add(JLrow3);
		
		/*Icon für Sitz*/
		JLabel JLs3c = new JLabel("");
		JLs3c.setHorizontalAlignment(SwingConstants.CENTER);
		JLs3c.setIcon(icon1);
		JLs3c.setForeground(Color.WHITE);
		JLs3c.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs3c.setBounds(200, 200, 40, 40);
		panel_1.add(JLs3c);
		
		/*Icon für Sitz*/
		JLabel JLs3d = new JLabel("");
		JLs3d.setHorizontalAlignment(SwingConstants.CENTER);
		JLs3d.setIcon(icon1);
		JLs3d.setForeground(Color.WHITE);
		JLs3d.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs3d.setBounds(260, 200, 40, 40);
		panel_1.add(JLs3d);
		
		/*Icon für Sitz*/
		JLabel JLs4a = new JLabel("");
		JLs4a.setHorizontalAlignment(SwingConstants.CENTER);
		JLs4a.setIcon(icon1);
		JLs4a.setForeground(Color.WHITE);
		JLs4a.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs4a.setBounds(20, 260, 40, 40);
		panel_1.add(JLs4a);
		
		/*Icon für Sitz*/
		JLabel JLs4b = new JLabel("");
		JLs4b.setHorizontalAlignment(SwingConstants.CENTER);
		JLs4b.setIcon(icon1);
		JLs4b.setForeground(Color.WHITE);
		JLs4b.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs4b.setBounds(80, 260, 40, 40);
		panel_1.add(JLs4b);
		
		/*Label für die Reihe 4*/
		JLabel JLrow4 = new JLabel("4");
		JLrow4.setHorizontalAlignment(SwingConstants.CENTER);
		JLrow4.setForeground(Color.WHITE);
		JLrow4.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrow4.setBounds(140, 260, 40, 40);
		panel_1.add(JLrow4);
		
		/*Icon für Sitz*/
		JLabel JLs4c = new JLabel("");
		JLs4c.setHorizontalAlignment(SwingConstants.CENTER);
		JLs4c.setIcon(icon1);
		JLs4c.setForeground(Color.WHITE);
		JLs4c.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs4c.setBounds(200, 260, 40, 40);
		panel_1.add(JLs4c);
		
		/*Icon für Sitz*/
		JLabel JLs4d = new JLabel("");
		JLs4d.setHorizontalAlignment(SwingConstants.CENTER);
		JLs4d.setIcon(icon1);
		JLs4d.setForeground(Color.WHITE);
		JLs4d.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs4d.setBounds(260, 260, 40, 40);
		panel_1.add(JLs4d);
		
		/*Icon für Sitz*/
		JLabel JLs5a = new JLabel("");
		JLs5a.setHorizontalAlignment(SwingConstants.CENTER);
		JLs5a.setIcon(icon1);
		JLs5a.setForeground(Color.WHITE);
		JLs5a.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs5a.setBounds(20, 320, 40, 40);
		panel_1.add(JLs5a);
		
		/*Icon für Sitz*/
		JLabel JLs5b = new JLabel("");
		JLs5b.setHorizontalAlignment(SwingConstants.CENTER);
		JLs5b.setIcon(icon1);
		JLs5b.setForeground(Color.WHITE);
		JLs5b.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs5b.setBounds(80, 320, 40, 40);
		panel_1.add(JLs5b);
		
		/*Label für die Reihe 5*/
		JLabel JLrow5 = new JLabel("5");
		JLrow5.setHorizontalAlignment(SwingConstants.CENTER);
		JLrow5.setForeground(Color.WHITE);
		JLrow5.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrow5.setBounds(140, 320, 40, 40);
		panel_1.add(JLrow5);
		
		/*Icon für Sitz*/
		JLabel JLs5c = new JLabel("");
		JLs5c.setHorizontalAlignment(SwingConstants.CENTER);
		JLs5c.setIcon(icon1);
		JLs5c.setForeground(Color.WHITE);
		JLs5c.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs5c.setBounds(200, 320, 40, 40);
		panel_1.add(JLs5c);
		
		/*Icon für Sitz*/
		JLabel JLs5d = new JLabel("");
		JLs5d.setHorizontalAlignment(SwingConstants.CENTER);
		JLs5d.setIcon(icon1);
		JLs5d.setForeground(Color.WHITE);
		JLs5d.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs5d.setBounds(260, 320, 40, 40);
		panel_1.add(JLs5d);
		
		/*Icon für Sitz*/
		JLabel JLs6a = new JLabel("");
		JLs6a.setHorizontalAlignment(SwingConstants.CENTER);
		JLs6a.setIcon(icon1);
		JLs6a.setForeground(Color.WHITE);
		JLs6a.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs6a.setBounds(20, 380, 40, 40);
		panel_1.add(JLs6a);
		
		/*Icon für Sitz*/
		JLabel JLs6b = new JLabel("");
		JLs6b.setHorizontalAlignment(SwingConstants.CENTER);
		JLs6b.setIcon(icon1);
		JLs6b.setForeground(Color.WHITE);
		JLs6b.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs6b.setBounds(80, 380, 40, 40);
		panel_1.add(JLs6b);
		
		/*Label für die Reihe 6*/
		JLabel JLrow6 = new JLabel("6");
		JLrow6.setHorizontalAlignment(SwingConstants.CENTER);
		JLrow6.setForeground(Color.WHITE);
		JLrow6.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrow6.setBounds(140, 380, 40, 40);
		panel_1.add(JLrow6);
		
		/*Icon für Sitz*/
		JLabel JLs6c = new JLabel("");
		JLs6c.setHorizontalAlignment(SwingConstants.CENTER);
		JLs6c.setIcon(icon1);
		JLs6c.setIcon(icon1);
		JLs6c.setForeground(Color.WHITE);
		JLs6c.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs6c.setBounds(200, 380, 40, 40);
		panel_1.add(JLs6c);
		
		/*Icon für Sitz*/
		JLabel JLs6d = new JLabel("");
		JLs6d.setHorizontalAlignment(SwingConstants.CENTER);
		JLs6d.setIcon(icon1);
		JLs6d.setForeground(Color.WHITE);
		JLs6d.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs6d.setBounds(260, 380, 40, 40);
		panel_1.add(JLs6d);
		
		/*Icon für Sitz*/
		JLabel JLs7a = new JLabel("");
		JLs7a.setHorizontalAlignment(SwingConstants.CENTER);
		JLs7a.setIcon(icon1);
		JLs7a.setForeground(Color.WHITE);
		JLs7a.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs7a.setBounds(20, 440, 40, 40);
		panel_1.add(JLs7a);
		
		/*Icon für Sitz*/
		JLabel JLs7b = new JLabel("");
		JLs7b.setHorizontalAlignment(SwingConstants.CENTER);
		JLs7b.setIcon(icon1);
		JLs7b.setForeground(Color.WHITE);
		JLs7b.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs7b.setBounds(80, 440, 40, 40);
		panel_1.add(JLs7b);
		
		/*Label für die Reihe 7*/
		JLabel JLrow7 = new JLabel("7");
		JLrow7.setHorizontalAlignment(SwingConstants.CENTER);
		JLrow7.setForeground(Color.WHITE);
		JLrow7.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLrow7.setBounds(140, 440, 40, 40);
		panel_1.add(JLrow7);
		
		/*Icon für Sitz*/
		JLabel JLs7c = new JLabel("");
		JLs7c.setHorizontalAlignment(SwingConstants.CENTER);
		JLs7c.setIcon(icon1);
		JLs7c.setForeground(Color.WHITE);
		JLs7c.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs7c.setBounds(200, 440, 40, 40);
		panel_1.add(JLs7c);
		
		/*Icon für Sitz*/
		JLabel JLs7d = new JLabel("");
		JLs7d.setHorizontalAlignment(SwingConstants.CENTER);
		JLs7d.setIcon(icon1);
		JLs7d.setForeground(Color.WHITE);
		JLs7d.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLs7d.setBounds(260, 440, 40, 40);
		panel_1.add(JLs7d);
		
		/*String für das speichern der Anzahl Personen aus dem GUI2*/
		String persons = String.valueOf(frameGUI2.persons);
		
		/*Label für die Anzahl Personen, für welche einen Sitz ausgewählt werden muss*/
		JLabel JLanzPersonen = new JLabel(persons);
		JLanzPersonen.setForeground(myOrange);
		JLanzPersonen.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLanzPersonen.setHorizontalAlignment(SwingConstants.RIGHT);
		JLanzPersonen.setBounds(350, 23, 35, 45);
		panel.add(JLanzPersonen);
		
		/*Label für die Beschriftung der Anzahl Personen*/
		JLabel JLtextpersonen = new JLabel(" Person/en");
		JLtextpersonen.setForeground(Color.BLACK);
		JLtextpersonen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLtextpersonen.setBounds(395, 23, 117, 45);
		panel.add(JLtextpersonen);
		
		/*Trennbalken*/
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
		separator1.setBounds(360, 68, 200, 2);
		panel.add(separator1);
		
		/*Label für die Beschriftung des Standard-Preises*/
		JLabel JLstandard = new JLabel("Standard:");
		JLstandard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLstandard.setBounds(370, 79, 79, 38);
		panel.add(JLstandard);
		
		/*Label für den Standardpreis*/
		JLabel JLstandardpreis = new JLabel("20 CHF");
		JLstandardpreis.setHorizontalAlignment(SwingConstants.RIGHT);
		JLstandardpreis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLstandardpreis.setBounds(459, 79, 76, 38);
		panel.add(JLstandardpreis);
		
		/*Label für den Zuschlag auf den Preis für die Spalten A und D*/
		JLabel JLad = new JLabel("A / D:");
		JLad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLad.setBounds(370, 115, 79, 38);
		panel.add(JLad);
		
		/*Label für den Zuschlag*/
		JLabel JLadpreis = new JLabel("+ 5 CHF");
		JLadpreis.setHorizontalAlignment(SwingConstants.RIGHT);
		JLadpreis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLadpreis.setBounds(459, 115, 76, 38);
		panel.add(JLadpreis);
		
		/*Label für den Zuschlag auf den Preis für die Reihen 1 und 2*/
		JLabel JL12 = new JLabel("1 / 2:");
		JL12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JL12.setBounds(370, 152, 79, 38);
		panel.add(JL12);
		
		/*Label für den Zuschlag*/
		JLabel JL12preis = new JLabel("+ 5 CHF");
		JL12preis.setHorizontalAlignment(SwingConstants.RIGHT);
		JL12preis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JL12preis.setBounds(459, 152, 76, 38);
		panel.add(JL12preis);
		
		/*Trennbalken*/
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(Color.BLACK);
		separator2.setBounds(360, 201, 200, 2);
		panel.add(separator2);
		
		/*Label für das Beschriften des Betrags*/
		JLabel JLtextbetrag = new JLabel("Betrag:");
		JLtextbetrag.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLtextbetrag.setBounds(369, 221, 80, 38);
		panel.add(JLtextbetrag);
		
		/*Label für den totalen Betrag der Sitzreservation*/
		JLabel JLbetrag = new JLabel(betrag+" CHF");
		JLbetrag.setForeground(myOrange);
		JLbetrag.setHorizontalAlignment(SwingConstants.RIGHT);
		JLbetrag.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLbetrag.setBounds(455, 221, 80, 38);
		panel.add(JLbetrag);
		
		/*Label für den Titel der Extras*/
		JLabel JLtextextras = new JLabel("Extras:");
		JLtextextras.setForeground(myOrange);
		JLtextextras.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLtextextras.setBounds(370, 259, 80, 38);
		panel.add(JLtextextras);
		
		/*Label für das Extra 1 - Vordere zwei Sitzreihen*/
		JLabel JLextras_1 = new JLabel("Up Front Sitz");
		JLextras_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLextras_1.setBounds(370, 289, 190, 28);
		JLextras_1.setVisible(false);
		panel.add(JLextras_1);
		
		/*Label für das Extra 2 - Fensterplätze*/
		JLabel JLextras_2 = new JLabel("Window Sitz");
		JLextras_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLextras_2.setBounds(370, 315, 190, 28);
		JLextras_2.setVisible(false);
		panel.add(JLextras_2);
		
		/*Trennbalken*/
		JSeparator separator3 = new JSeparator();
		separator3.setForeground(Color.BLACK);
		separator3.setBounds(360, 354, 200, 2);
		panel.add(separator3);
		
		/*Button für das Verlassen der Frame*/
		JLabel JLweiter = new JLabel("Weiter >");
		JLweiter.setHorizontalAlignment(SwingConstants.CENTER);
		JLweiter.setBackground(myOrange);
		JLweiter.setOpaque(true);
		JLweiter.setForeground(Color.WHITE);
		JLweiter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLweiter.setBounds(359, 367, 201, 71);
		panel.add(JLweiter);
		
		/*Button für das Wechseln auf die letzte Frame*/
		JLabel JLzurück = new JLabel("Zurück <");
		JLzurück.setBackground(Color.LIGHT_GRAY);
		JLzurück.setOpaque(true);
		JLzurück.setForeground(Color.BLACK);
		JLzurück.setHorizontalAlignment(SwingConstants.CENTER);
		JLzurück.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLzurück.setBounds(359, 452, 201, 71);
		panel.add(JLzurück);
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs1a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs1a.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs1a.setIcon(icon2);
					selected++;
					JLextras_1.setVisible(true);
					JLextras_2.setVisible(true);
					i++;
					j++;
					betrag = betrag + 30;
					JLbetrag.setText(betrag+" CHF");
					
				}
				else if(JLs1a.getIcon() == icon2){
					JLs1a.setIcon(icon1);
					selected--;
					i--;
					j--;
					betrag = betrag - 30;
					JLbetrag.setText(betrag+" CHF");
					if(i == 0) {
						JLextras_1.setVisible(false);
					}
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs1b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs1b.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs1b.setIcon(icon2);
					selected++;
					JLextras_1.setVisible(true);
					i++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs1b.getIcon() == icon2){
					JLs1b.setIcon(icon1);
					selected--;
					i--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(i == 0) {
						JLextras_1.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs1c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs1c.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs1c.setIcon(icon2);
					selected++;
					JLextras_1.setVisible(true);
					i++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs1c.getIcon() == icon2){
					JLs1c.setIcon(icon1);
					selected--;
					i--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(i == 0) {
						JLextras_1.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs1d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs1d.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs1d.setIcon(icon2);
					selected++;
					JLextras_1.setVisible(true);
					JLextras_2.setVisible(true);
					i++;
					j++;
					betrag = betrag + 30;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs1d.getIcon() == icon2){
					JLs1d.setIcon(icon1);
					selected--;
					i--;
					j--;
					betrag = betrag - 30;
					JLbetrag.setText(betrag+" CHF");
					if(i == 0) {
						JLextras_1.setVisible(false);
					}
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/*--------------------------*/
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs2a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs2a.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs2a.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs2a.getIcon() == icon2){
					JLs2a.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs2b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs2b.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs2b.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs2b.getIcon() == icon2){
					JLs2b.setIcon(icon1);
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
					selected--;
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs2c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs2c.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs2c.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs2c.getIcon() == icon2){
					JLs2c.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs2d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs2d.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs2d.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs2d.getIcon() == icon2){
					JLs2d.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/*--------------------------*/
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs3a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs3a.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs3a.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs3a.getIcon() == icon2){
					JLs3a.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs3b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs3b.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs3b.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs3b.getIcon() == icon2){
					JLs3b.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs3c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs3c.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs3c.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs3c.getIcon() == icon2){
					JLs3c.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs3d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs3d.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs3d.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs3d.getIcon() == icon2){
					JLs3d.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/*--------------------------*/
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs4a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs4a.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs4a.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs4a.getIcon() == icon2){
					JLs4a.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs4b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs4b.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs4b.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs4b.getIcon() == icon2){
					JLs4b.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs4c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs4c.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs4c.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs4c.getIcon() == icon2){
					JLs4c.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs4d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs4d.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs4d.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs4d.getIcon() == icon2){
					JLs4d.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/*--------------------------*/
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs5a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs5a.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs5a.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs5a.getIcon() == icon2){
					JLs5a.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs5b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs5b.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs5b.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs5b.getIcon() == icon2){
					JLs5b.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs5c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs5c.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs5c.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs5c.getIcon() == icon2){
					JLs5c.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs5d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs5d.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs5d.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(false);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs5d.getIcon() == icon2){
					JLs5d.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/*--------------------------*/
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs6a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs6a.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs6a.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs6a.getIcon() == icon2){
					JLs6a.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs6b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs6b.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs6b.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs6b.getIcon() == icon2){
					JLs6b.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs6c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs6c.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs6c.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs6c.getIcon() == icon2){
					JLs6c.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs6d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs6d.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs6d.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs6d.getIcon() == icon2){
					JLs6d.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/*--------------------------*/
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs7a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs7a.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs7a.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs7a.getIcon() == icon2){
					JLs7a.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag -25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs7b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs7b.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs7b.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs7b.getIcon() == icon2){
					JLs7b.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs7c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs7c.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs7c.setIcon(icon2);
					selected++;
					betrag = betrag + 20;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs7c.getIcon() == icon2){
					JLs7c.setIcon(icon1);
					selected--;
					betrag = betrag - 20;
					JLbetrag.setText(betrag+" CHF");
				}
			}
		});
		
		/**
		 * Onclick-Action beim Sitz:
		 * Falls er noch nicht angewählt wurde, erscheint er orange und wird zu selected hinzugefügt.
		 * Falls er schon angewählt wurde, erscheint er wieder weiss und wird von selected subtrahiert.
		 * Der Betrag wird auch angepasst, sowie die Variablen j + i für die Extras.
		 */
		JLs7d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JLs7d.getIcon() == icon1 && selected < frameGUI2.persons) {
					JLs7d.setIcon(icon2);
					selected++;
					JLextras_2.setVisible(true);
					j++;
					betrag = betrag + 25;
					JLbetrag.setText(betrag+" CHF");
				}
				else if(JLs7d.getIcon() == icon2){
					JLs7d.setIcon(icon1);
					selected--;
					j--;
					betrag = betrag - 25;
					JLbetrag.setText(betrag+" CHF");
					if(j == 0) {
						JLextras_2.setVisible(false);
					}
				}
			}
		});
		
		/**
		 * Onclick-Action für Weiter:
		 * Es wird geprüft, ob so viele Sitze selected worden sind wie auch Passagiere ausgewählt wurden.
		 * Falls diese zwei Werte nicht übereinstimmen, wird eine Hinweis-Meldung ausgegeben
		 * Falls diese zwei Werte übereinstimmen, wird die aktuelle Frame unsichtbar und die Frame von GUI3 sichbar gemacht.
		 */
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selected == frameGUI2.persons) {
					/*Frame wird unsichtbar gemacht*/
					setVisible(false);	
					/*Neue Frame für das GUI4 wird erstellt*/
					frameGUI4 = new GUI4(frameGUI3);
					/*Frame für das GUI4 wird sichtbar gemacht*/
					frameGUI4.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(frameGUI3,"Es wurden weniger als "+frameGUI2.persons+" Person/en ausgewählt","Hinweis",JOptionPane.WARNING_MESSAGE); 
				}
			}
		});
		
		/**
		 * Onclick-Action für Zurück:
		 * Die aktuelle Frame wird unsichtbar gemacht, der Betrag zurückgesetzt und zurück auf die Frame von GUI2 gewechselt
		 */
		JLzurück.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Frame wird unsichtbar gemacht*/
				setVisible(false);
				/*Betrag wird zurückgesetzt*/
				betrag = 0;
				/*Frame von GUI2 wird sichtbar gemacht*/
				GUI1.frameGUI2.setVisible(true);
			}
		});
	}
}
