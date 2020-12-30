import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

public class GUI2 extends JFrame{
	
	/*Initialisierung der Frame vom GUI2*/
	static GUI2 frameGUI2;
	/*Initialisierung der Frame vom GUI3*/
	static GUI3 frameGUI3;
	/*Tabel für das Anzeigen der verfügbaren Flügen*/
	private JTable JTflugauswahl;
	/*Varialbe für die Anzahl Personen*/
	static int persons = 0;
	/*Variable für den Preis des ausgewählten Fluges*/
	static int price = 0;
	/*Variable für das Speichern des Abflughafens (Hinflug)*/
	static String abflug1;
	/*Variable für das Speichern des Abflughafens (Rückflug)*/
	static String abflug2;
    /*Variable für das Speichern des Zielflughafens (Hinflug)*/
	static String ankunft1;
	/*Variable für das Speichern des Zielflughafens (Rückflug)*/
	static String ankunft2;
	/*Array für die Zeiten des Abfluges*/
	String [] abflug = { "08:00 Uhr", "08:30 Uhr", "09:00 Uhr", "09:30 Uhr", "10:00 Uhr", "10:30 Uhr", "11:00 Uhr", "11:30 Uhr", "12:00 Uhr", "12:30 Uhr", "13:00 Uhr", "13:30 Uhr", "14:00 Uhr", "14:30 Uhr", "15:00 Uhr", "15:30 Uhr", "16:00 Uhr"};
	/*Array für die Zeiten der Ankunft*/
	String [] ankunft = {"09:00 Uhr", "09:30 Uhr", "10:00 Uhr", "10:30 Uhr", "11:00 Uhr", "11:30 Uhr", "12:00 Uhr", "12:30 Uhr", "13:00 Uhr", "13:30 Uhr", "14:00 Uhr", "14:30 Uhr", "15:00 Uhr", "15:30 Uhr", "16:00 Uhr", "16:30 Uhr", "17:00 Uhr"};
	/*Array für die Preise der Flüge*/
	int [] preis = {200, 190, 180, 170, 160, 150, 140, 130, 120, 110, 100};
	
	public GUI2(GUI1 frame) {
		
		/*Personen von GUI1 werden zusammengezählt*/
		persons = frame.count1 + frame.count2 + frame.count3;
		
		/*Einstellungen für die Frame*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 580);
		setLocationRelativeTo(null);
		setTitle("Flugauswahl");
		setResizable(false);
		getContentPane().setLayout(null);
		
		/*Panel oberhalb der Frame mit untenstehenden Inhalten*/
		JPanel JPconentnorth = new JPanel();
		JPconentnorth.setBackground(Color.GRAY);
		JPconentnorth.setBounds(10, 11, 684, 179);
		getContentPane().add(JPconentnorth);
		JPconentnorth.setLayout(null);
		
		/*JLabel für Titel Abflughafen nach Zielflughafen*/
		JLabel JLtitel = new JLabel(frame.abflughafen+" nach "+frame.zielflughafen);
		JLtitel.setForeground(Color.WHITE);
		JLtitel.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLtitel.setBounds(10, 11, 664, 55);
		JPconentnorth.add(JLtitel);
		
		/*Trennbalken*/
		JSeparator separator = new JSeparator();
		Color myOrange = new Color(255, 127, 000);
		separator.setForeground(myOrange);
		separator.setBounds(10, 55, 580, 2);
		JPconentnorth.add(separator);
		
		/*JLabel zum Aufzeigen der Anzahl Passagiere aus dem GUI1*/
		JLabel JLpassagiere = new JLabel(frame.count1+" Erwachsene/r | "+frame.count2+" Kind/er | "+frame.count3+" Kleinkind/er");
		JLpassagiere.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLpassagiere.setForeground(Color.WHITE);
		JLpassagiere.setBounds(10, 73, 419, 30);
		JPconentnorth.add(JLpassagiere);
		
		/*JLabel für die Beschriftung des Abflugdatums*/
		JLabel JLabflug = new JLabel("Abflug:");
		JLabflug.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabflug.setForeground(myOrange);
		JLabflug.setBounds(10, 114, 70, 55);
		JPconentnorth.add(JLabflug);
		
		/*JLabel für die Beschriftung des Rückflugdatums*/
		JLabel JLrückflug = new JLabel("Rückflug:");
		JLrückflug.setForeground(myOrange);
		JLrückflug.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLrückflug.setBounds(315, 114, 70, 55);
		JPconentnorth.add(JLrückflug);
		
		/*JLabel für das Abflugdatum*/
		JLabel JLabflugdatum = new JLabel(frame.JThinflugdatum.getText());
		JLabflugdatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabflugdatum.setBounds(77, 114, 204, 55);
		JPconentnorth.add(JLabflugdatum);
		
		/*JLabel für das Rückflugdatum*/
		JLabel JLrückflugdatum = new JLabel(frame.JTrückflugdatum.getText());
		JLrückflugdatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLrückflugdatum.setBounds(395, 114, 213, 55);
		JPconentnorth.add(JLrückflugdatum);
		
		/*JLabel für den Titel der JTable*/
		JLabel JLflugwahl = new JLabel("Wählen Sie Ihren Flug:");
		JLflugwahl.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLflugwahl.setBounds(10, 207, 205, 50);
		getContentPane().add(JLflugwahl);
		
		/*JLabel als Überschrift für JTable*/
		JLabel JLtitleabflugdatum = new JLabel("Abflugdatum:");
		JLtitleabflugdatum.setBounds(10, 253, 120, 14);
		getContentPane().add(JLtitleabflugdatum);
		
		/*JLabel als Überschrift für JTable*/
		JLabel JLtitleabflugzeit = new JLabel("Abflugzeit:");
		JLtitleabflugzeit.setBounds(108, 253, 93, 14);
		getContentPane().add(JLtitleabflugzeit);
		
		/*JLabel als Überschrift für JTable*/
		JLabel JLtitleankunftszeit = new JLabel("Ankuntszeit:");
		JLtitleankunftszeit.setBounds(200, 253, 88, 14);
		getContentPane().add(JLtitleankunftszeit);
		
		/*JLabel als Überschrift für JTable*/
		JLabel JLtitlerückflugdatum = new JLabel("Rückflugdatum:");
		JLtitlerückflugdatum.setBounds(292, 253, 93, 14);
		getContentPane().add(JLtitlerückflugdatum);
		
		/*JLabel als Überschrift für JTable*/
		JLabel JLtitleabflugzeit2 = new JLabel("Abflugzeit:");
		JLtitleabflugzeit2.setBounds(391, 253, 68, 14);
		getContentPane().add(JLtitleabflugzeit2);
		
		/*JLabel als Überschrift für JTable*/
		JLabel JLtitlerückflugzeit2 = new JLabel("Ankunftszeit:");
		JLtitlerückflugzeit2.setBounds(486, 253, 81, 14);
		getContentPane().add(JLtitlerückflugzeit2);
		
		/*JLabel als Überschrift für JTable*/
		JLabel JLtitlepreis = new JLabel("Preis:");
		JLtitlepreis.setBounds(584, 253, 81, 14);
		getContentPane().add(JLtitlepreis);

			/*Spaltentitel*/
			String[] columnNames1 = { "Datum", "Abflugzeit", "Ankunftszeit", "Datum", "Abflugzeit", "Ankunftszeit", "Preis" };
			/*Inhalt der JTable bei einem Hin- und Rückflug am selben Datum*/
			Object [][] rowdata1 = { { frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTrückflugdatum.getText(), abflug[3], ankunft[3], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTrückflugdatum.getText(), abflug[4], ankunft[4], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTrückflugdatum.getText(), abflug[5], ankunft[5], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTrückflugdatum.getText(), abflug[6], ankunft[6], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTrückflugdatum.getText(), abflug[7], ankunft[7], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTrückflugdatum.getText(), abflug[8], ankunft[8], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTrückflugdatum.getText(), abflug[9], ankunft[9], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTrückflugdatum.getText(), abflug[10], ankunft[10], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTrückflugdatum.getText(), abflug[11], ankunft[11], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTrückflugdatum.getText(), abflug[12], ankunft[12], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[10], ankunft[10], frame.JTrückflugdatum.getText(), abflug[13], ankunft[13], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[11], ankunft[11], frame.JTrückflugdatum.getText(), abflug[14], ankunft[14], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[12], ankunft[12], frame.JTrückflugdatum.getText(), abflug[15], ankunft[15], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[13], ankunft[13], frame.JTrückflugdatum.getText(), abflug[16], ankunft[16], preis[0]+" CHF" }};
			
			/*Spaltentitel*/
			String[] columnNames2 = { "Datum", "Abflugzeit", "Ankunftszeit", "Datum", "Abflugzeit", "Ankunftszeit", "Preis" };
			/*Inhalt der JTable bei einem Hinflug*/
			Object [][] rowdata2 = { { frame.JThinflugdatum.getText(), abflug[0], ankunft[0], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[10], ankunft[10], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[11], ankunft[11], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[12], ankunft[12], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[13], ankunft[13], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[14], ankunft[14], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[15], ankunft[15], " - ", " - ", " - ", preis[10]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[16], ankunft[16], " - ", " - ", " - ", preis[10]+" CHF" }};
			
			/*Spaltentitel*/
			String[] columnNames3 = { "Datum", "Abflugzeit", "Ankunftszeit", "Datum", "Abflugzeit", "Ankunftszeit", "Preis" };
			/*Inhalt der JTabel bei einem Hin- und Rückflug zu einem unterschiedlichen Datum*/
			Object [][] rowdata3 = { { frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTrückflugdatum.getText(), abflug[0], ankunft[0], preis[5]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTrückflugdatum.getText(), abflug[1], ankunft[1], preis[5]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTrückflugdatum.getText(), abflug[2], ankunft[2], preis[5]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTrückflugdatum.getText(), abflug[1], ankunft[1], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTrückflugdatum.getText(), abflug[2], ankunft[2], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTrückflugdatum.getText(), abflug[3], ankunft[3], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTrückflugdatum.getText(), abflug[2], ankunft[2], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTrückflugdatum.getText(), abflug[3], ankunft[3], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTrückflugdatum.getText(), abflug[4], ankunft[4], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTrückflugdatum.getText(), abflug[3], ankunft[3], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTrückflugdatum.getText(), abflug[4], ankunft[4], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTrückflugdatum.getText(), abflug[5], ankunft[5], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTrückflugdatum.getText(), abflug[4], ankunft[4], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTrückflugdatum.getText(), abflug[5], ankunft[5], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTrückflugdatum.getText(), abflug[6], ankunft[6], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTrückflugdatum.getText(), abflug[5], ankunft[5], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTrückflugdatum.getText(), abflug[6], ankunft[6], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTrückflugdatum.getText(), abflug[7], ankunft[7], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTrückflugdatum.getText(), abflug[6], ankunft[6], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTrückflugdatum.getText(), abflug[7], ankunft[7], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTrückflugdatum.getText(), abflug[8], ankunft[8], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTrückflugdatum.getText(), abflug[7], ankunft[7], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTrückflugdatum.getText(), abflug[8], ankunft[8], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTrückflugdatum.getText(), abflug[9], ankunft[9], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTrückflugdatum.getText(), abflug[8], ankunft[8], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTrückflugdatum.getText(), abflug[9], ankunft[9], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTrückflugdatum.getText(), abflug[10], ankunft[10], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTrückflugdatum.getText(), abflug[9], ankunft[9], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTrückflugdatum.getText(), abflug[10], ankunft[10], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTrückflugdatum.getText(), abflug[11], ankunft[11], preis[4]+" CHF" }};
			
		/*Handelt es sich bei der Auswahl um einen Hin- und Rückflug am selben Datum?*/
		if(frame.JThinflugdatum.getText().equalsIgnoreCase(frame.JTrückflugdatum.getText())) {
			JTflugauswahl = new JTable(rowdata1, columnNames1) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
		}
		/*Handelt es sich bei der Auswahl um einen Hinflug (nur Hinflug aktiviert)?*/
		else if(frame.statushinflug == false) {
			JTflugauswahl = new JTable(rowdata2, columnNames2) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
		}
		/*Handelt es sich bei der Auswahl um einen Hin- und Rückflug zu einem unterschiedlichen Datum?*/
		else {
			JTflugauswahl = new JTable(rowdata3, columnNames3) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
		}
		
		/*Einstellungen der JTable*/
		JTflugauswahl.setTableHeader(null);
		JTflugauswahl.setFillsViewportHeight(true);
		JTflugauswahl.setBounds(10, 268, 684, 182);
		getContentPane().add(JTflugauswahl);
		
		/*Scrollbalken*/
		JScrollPane scrollPane1 = new JScrollPane(JTflugauswahl);
		scrollPane1.setBounds(10, 268, 684, 182);
		getContentPane().add(scrollPane1);
		
		/*Button Weiter für die nächste Frame*/
		JLabel JLweiter = new JLabel("Weiter >");
		JLweiter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLweiter.setHorizontalAlignment(SwingConstants.CENTER);
		JLweiter.setBackground(myOrange);
		JLweiter.setForeground(Color.WHITE);
		JLweiter.setBounds(10, 467, 302, 60);
		JLweiter.setOpaque(true);
		getContentPane().add(JLweiter);
		
		/*Button Zurück für das Wechseln auf die letzte Frame*/
		JLabel JLzurück = new JLabel("Zurück <");
		JLzurück.setBackground(Color.LIGHT_GRAY);
		JLzurück.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLzurück.setHorizontalAlignment(SwingConstants.CENTER);
		JLzurück.setBounds(392, 467, 302, 60);
		JLzurück.setOpaque(true);
		getContentPane().add(JLzurück);
		
		
		/**
		 * Button für das Beenden dieser View:
		 * Es werden geprüft, ob ein Flug augewählt wurde.
		 * Wenn ja, werden alle Daten aus dieser Row in Variabeln gespeichert
		 */
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JTflugauswahl.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frameGUI2,"Sie müssen einen Flug auswählen.","Hinweis",JOptionPane.WARNING_MESSAGE);     
				}
				else {
					/*Ausgewählte Zeile*/
					int row = JTflugauswahl.getSelectedRow();
					/*Spalte 6 beinhaltet die Preise*/
					int column = 6;
					/*Speicherung des Preises als String (temporär)*/
					String flyprice = (String) JTflugauswahl.getValueAt(row, column);
					/*Entfernung von den nicht konvertierbaren Bestandteile des Strings*/
					String price_tmp = flyprice.replace(" CHF", "");
					/*Konvertierung von string to int*/
					price = Integer.parseInt(price_tmp);
					/*Abflughafen des Hinfluges aus Spalte 1*/
					abflug1 = (String) JTflugauswahl.getValueAt(row, 1);
					/*Zielflughafen des Hinfluges aus Spalte 2*/
					ankunft1 = (String) JTflugauswahl.getValueAt(row, 2);
					/*Handelt es sich um einen Hin- und Rückflug?*/
					if(GUI1.statushinflug == true) {
						/*Abflughafen des Rückfluges aus Spalte 4*/
						abflug2 = (String) JTflugauswahl.getValueAt(row, 4);
						/*Zielflughafen des Rückfluges aus Spalte 5*/
						ankunft2 = (String) JTflugauswahl.getValueAt(row, 5);
					}
					/*Erzeugung der Frame des GUI3*/
					frameGUI3 = new GUI3(GUI2.frameGUI2);
					/*GUI3-Frame wird sichbar gemacht*/
					frameGUI3.setVisible(true);
					/*Frame von GUI2 wird unsichtbar gemacht*/
					setVisible(false);
				}
			}
		});
		
		/**
		 * Onclick-Action für Zurück-Button:
		 * GUI2-Frame wird unsichtbar gemacht
		 * Wechsel zurück auf die Frame des GUI1
		 */
		JLzurück.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				frame.setVisible(true);
			}
		});
	}
}
