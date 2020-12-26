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
	
	GUI2 frameGUI2;
	JPanel flugauswahl1;
	private JTable JTflugauswahl;
	static GUI3 frameGUI3;
	static int persons = 0;
	static int price = 0;
	String [] abflug = { "08:00 Uhr", "08:30 Uhr", "09:00 Uhr", "09:30 Uhr", "10:00 Uhr", "10:30 Uhr", "11:00 Uhr", "11:30 Uhr", "12:00 Uhr", "12:30 Uhr", "13:00 Uhr", "13:30 Uhr", "14:00 Uhr", "14:30 Uhr", "15:00 Uhr", "15:30 Uhr", "16:00 Uhr"};
	String [] ankunft = {"09:00 Uhr", "09:30 Uhr", "10:00 Uhr", "10:30 Uhr", "11:00 Uhr", "11:30 Uhr", "12:00 Uhr", "12:30 Uhr", "13:00 Uhr", "13:30 Uhr", "14:00 Uhr", "14:30 Uhr", "15:00 Uhr", "15:30 Uhr", "16:00 Uhr", "16:30 Uhr", "17:00 Uhr"};
	int [] preis = {200, 190, 180, 170, 160, 150, 140, 130, 120, 110, 100};
	public GUI2(GUI1 frame) {
		
		persons = frame.count1 + frame.count2 + frame.count3;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 580);
		setLocationRelativeTo(null);
		setTitle("Flugauswahl");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel JPconentnorth = new JPanel();
		JPconentnorth.setBackground(Color.GRAY);
		JPconentnorth.setBounds(10, 11, 684, 179);
		getContentPane().add(JPconentnorth);
		JPconentnorth.setLayout(null);
		
		JLabel JLtitel = new JLabel(frame.abflughafen+" nach "+frame.zielflughafen);
		JLtitel.setForeground(Color.WHITE);
		JLtitel.setFont(new Font("Tahoma", Font.BOLD, 18));
		JLtitel.setBounds(10, 11, 664, 55);
		JPconentnorth.add(JLtitel);
		
		JSeparator separator = new JSeparator();
		Color myOrange = new Color(255, 127, 000);
		separator.setForeground(myOrange);
		separator.setBounds(10, 55, 580, 2);
		JPconentnorth.add(separator);
		
		JLabel JLpassagiere = new JLabel(frame.count1+" Erwachsene/r | "+frame.count2+" Kind/er | "+frame.count3+" Kleinkind/er");
		JLpassagiere.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLpassagiere.setForeground(Color.WHITE);
		JLpassagiere.setBounds(10, 73, 419, 30);
		JPconentnorth.add(JLpassagiere);
		
		JLabel JLabflug = new JLabel("Abflug:");
		JLabflug.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabflug.setForeground(myOrange);
		JLabflug.setBounds(10, 114, 70, 55);
		JPconentnorth.add(JLabflug);
		
		JLabel JLr�ckflug = new JLabel("R�ckflug:");
		JLr�ckflug.setForeground(myOrange);
		JLr�ckflug.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLr�ckflug.setBounds(315, 114, 70, 55);
		JPconentnorth.add(JLr�ckflug);
		
		JLabel JLabflugdatum = new JLabel(frame.JThinflugdatum.getText());
		JLabflugdatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabflugdatum.setBounds(77, 114, 204, 55);
		JPconentnorth.add(JLabflugdatum);
		
		JLabel JLr�ckflugdatum = new JLabel(frame.JTr�ckflugdatum.getText());
		JLr�ckflugdatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLr�ckflugdatum.setBounds(395, 114, 213, 55);
		JPconentnorth.add(JLr�ckflugdatum);
		
		JLabel JLflugwahl = new JLabel("W�hlen Sie Ihren Flug:");
		JLflugwahl.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLflugwahl.setBounds(10, 207, 205, 50);
		getContentPane().add(JLflugwahl);
		
		JLabel JLtitleabflugdatum = new JLabel("Abflugdatum:");
		JLtitleabflugdatum.setBounds(10, 253, 120, 14);
		getContentPane().add(JLtitleabflugdatum);
		
		JLabel JLtitleabflugzeit = new JLabel("Abflugzeit:");
		JLtitleabflugzeit.setBounds(108, 253, 93, 14);
		getContentPane().add(JLtitleabflugzeit);
		
		JLabel JLtitleankunftszeit = new JLabel("Ankuntszeit:");
		JLtitleankunftszeit.setBounds(200, 253, 88, 14);
		getContentPane().add(JLtitleankunftszeit);
		
		JLabel JLtitler�ckflugdatum = new JLabel("R�ckflugdatum:");
		JLtitler�ckflugdatum.setBounds(292, 253, 93, 14);
		getContentPane().add(JLtitler�ckflugdatum);
		
		JLabel JLtitleabflugzeit2 = new JLabel("Abflugzeit:");
		JLtitleabflugzeit2.setBounds(391, 253, 68, 14);
		getContentPane().add(JLtitleabflugzeit2);
		
		JLabel JLtitler�ckflugzeit2 = new JLabel("Ankunftszeit:");
		JLtitler�ckflugzeit2.setBounds(486, 253, 81, 14);
		getContentPane().add(JLtitler�ckflugzeit2);
		
		JLabel JLtitlepreis = new JLabel("Preis:");
		JLtitlepreis.setBounds(584, 253, 81, 14);
		getContentPane().add(JLtitlepreis);

			
			String[] columnNames1 = { "Datum", "Abflugzeit", "Ankunftszeit", "Datum", "Abflugzeit", "Ankunftszeit", "Preis" };
			Object [][] rowdata1 = { { frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTr�ckflugdatum.getText(), abflug[3], ankunft[3], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTr�ckflugdatum.getText(), abflug[4], ankunft[4], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTr�ckflugdatum.getText(), abflug[5], ankunft[5], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTr�ckflugdatum.getText(), abflug[6], ankunft[6], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTr�ckflugdatum.getText(), abflug[7], ankunft[7], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTr�ckflugdatum.getText(), abflug[8], ankunft[8], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTr�ckflugdatum.getText(), abflug[9], ankunft[9], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTr�ckflugdatum.getText(), abflug[10], ankunft[10], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTr�ckflugdatum.getText(), abflug[11], ankunft[11], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTr�ckflugdatum.getText(), abflug[12], ankunft[12], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[10], ankunft[10], frame.JTr�ckflugdatum.getText(), abflug[13], ankunft[13], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[11], ankunft[11], frame.JTr�ckflugdatum.getText(), abflug[14], ankunft[14], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[12], ankunft[12], frame.JTr�ckflugdatum.getText(), abflug[15], ankunft[15], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[13], ankunft[13], frame.JTr�ckflugdatum.getText(), abflug[16], ankunft[16], preis[0]+" CHF" }};
			
			String[] columnNames2 = { "Datum", "Abflugzeit", "Ankunftszeit", "Datum", "Abflugzeit", "Ankunftszeit", "Preis" };
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
			
			String[] columnNames3 = { "Datum", "Abflugzeit", "Ankunftszeit", "Datum", "Abflugzeit", "Ankunftszeit", "Preis" };
			Object [][] rowdata3 = { { frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTr�ckflugdatum.getText(), abflug[0], ankunft[0], preis[5]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTr�ckflugdatum.getText(), abflug[1], ankunft[1], preis[5]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[0], ankunft[0], frame.JTr�ckflugdatum.getText(), abflug[2], ankunft[2], preis[5]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTr�ckflugdatum.getText(), abflug[1], ankunft[1], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTr�ckflugdatum.getText(), abflug[2], ankunft[2], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[1], ankunft[1], frame.JTr�ckflugdatum.getText(), abflug[3], ankunft[3], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTr�ckflugdatum.getText(), abflug[2], ankunft[2], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTr�ckflugdatum.getText(), abflug[3], ankunft[3], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[2], ankunft[2], frame.JTr�ckflugdatum.getText(), abflug[4], ankunft[4], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTr�ckflugdatum.getText(), abflug[3], ankunft[3], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTr�ckflugdatum.getText(), abflug[4], ankunft[4], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[3], ankunft[3], frame.JTr�ckflugdatum.getText(), abflug[5], ankunft[5], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTr�ckflugdatum.getText(), abflug[4], ankunft[4], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTr�ckflugdatum.getText(), abflug[5], ankunft[5], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[4], ankunft[4], frame.JTr�ckflugdatum.getText(), abflug[6], ankunft[6], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTr�ckflugdatum.getText(), abflug[5], ankunft[5], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTr�ckflugdatum.getText(), abflug[6], ankunft[6], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[5], ankunft[5], frame.JTr�ckflugdatum.getText(), abflug[7], ankunft[7], preis[0]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTr�ckflugdatum.getText(), abflug[6], ankunft[6], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTr�ckflugdatum.getText(), abflug[7], ankunft[7], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[6], ankunft[6], frame.JTr�ckflugdatum.getText(), abflug[8], ankunft[8], preis[1]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTr�ckflugdatum.getText(), abflug[7], ankunft[7], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTr�ckflugdatum.getText(), abflug[8], ankunft[8], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[7], ankunft[7], frame.JTr�ckflugdatum.getText(), abflug[9], ankunft[9], preis[2]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTr�ckflugdatum.getText(), abflug[8], ankunft[8], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTr�ckflugdatum.getText(), abflug[9], ankunft[9], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[8], ankunft[8], frame.JTr�ckflugdatum.getText(), abflug[10], ankunft[10], preis[3]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTr�ckflugdatum.getText(), abflug[9], ankunft[9], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTr�ckflugdatum.getText(), abflug[10], ankunft[10], preis[4]+" CHF" },
									{ frame.JThinflugdatum.getText(), abflug[9], ankunft[9], frame.JTr�ckflugdatum.getText(), abflug[11], ankunft[11], preis[4]+" CHF" }};
			
		if(frame.JThinflugdatum.getText().equalsIgnoreCase(frame.JTr�ckflugdatum.getText())) {
			JTflugauswahl = new JTable(rowdata1, columnNames1) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
		}
		else if(frame.statushinflug == false) {
			JTflugauswahl = new JTable(rowdata2, columnNames2) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
		}
		else {
			JTflugauswahl = new JTable(rowdata3, columnNames3) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		         }
			};
		}
		
		JTflugauswahl.setTableHeader(null);
		JTflugauswahl.setFillsViewportHeight(true);
		JTflugauswahl.setBounds(10, 268, 684, 182);
		getContentPane().add(JTflugauswahl);
		
		JScrollPane scrollPane1 = new JScrollPane(JTflugauswahl);
		scrollPane1.setBounds(10, 268, 684, 182);
		getContentPane().add(scrollPane1);
		
		
		/*--------------------------------------------------*/
		
		JLabel JLweiter = new JLabel("Weiter >");
		JLweiter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLweiter.setHorizontalAlignment(SwingConstants.CENTER);
		JLweiter.setBackground(myOrange);
		JLweiter.setForeground(Color.WHITE);
		JLweiter.setBounds(10, 467, 302, 60);
		JLweiter.setOpaque(true);
		getContentPane().add(JLweiter);
		
		JLabel JLzur�ck = new JLabel("Zur�ck <");
		JLzur�ck.setBackground(Color.LIGHT_GRAY);
		JLzur�ck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLzur�ck.setHorizontalAlignment(SwingConstants.CENTER);
		JLzur�ck.setBounds(392, 467, 302, 60);
		JLzur�ck.setOpaque(true);
		getContentPane().add(JLzur�ck);
		
		
		/*Weiter-Button*/
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JTflugauswahl.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frameGUI2,"Sie m�ssen einen Flug ausw�hlen.","Hinweis",JOptionPane.WARNING_MESSAGE);     
				}
				else {
					String flyprice;
					int row = JTflugauswahl.getSelectedRow();
					int column = 6;
					flyprice = (String) JTflugauswahl.getValueAt(row, column);
					String price_tmp = flyprice.replace(" CHF", "");
					price = Integer.parseInt(price_tmp);
					setVisible(false);
					frameGUI3 = new GUI3(frameGUI2);
					frameGUI3.setVisible(true);
				}
			}
		});
		
		/*Zur�ck-Button*/
		JLzur�ck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				frame.setVisible(true);
			}
		});
	}
}
