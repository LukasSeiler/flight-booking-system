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
	GridLayout Layoutflugauswahl1 = new GridLayout(2,3);
	private JTable JTflugauswahl;
	static GUI3 frameGUI3;
	static int persons = 0;
	
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
		
		JLabel JLrückflug = new JLabel("Rückflug:");
		JLrückflug.setForeground(myOrange);
		JLrückflug.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLrückflug.setBounds(315, 114, 70, 55);
		JPconentnorth.add(JLrückflug);
		
		JLabel JLabflugdatum = new JLabel(frame.JThinflugdatum.getText());
		JLabflugdatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabflugdatum.setBounds(77, 114, 204, 55);
		JPconentnorth.add(JLabflugdatum);
		
		JLabel JLrückflugdatum = new JLabel(frame.JTrückflugdatum.getText());
		JLrückflugdatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLrückflugdatum.setBounds(395, 114, 213, 55);
		JPconentnorth.add(JLrückflugdatum);
		
		JLabel JLflugwahl = new JLabel("Wählen Sie Ihren Flug:");
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
		
		JLabel JLtitlerückflugdatum = new JLabel("Rückflugdatum:");
		JLtitlerückflugdatum.setBounds(292, 253, 93, 14);
		getContentPane().add(JLtitlerückflugdatum);
		
		JLabel JLtitleabflugzeit2 = new JLabel("Abflugzeit:");
		JLtitleabflugzeit2.setBounds(391, 253, 68, 14);
		getContentPane().add(JLtitleabflugzeit2);
		
		JLabel JLtitlerückflugzeit2 = new JLabel("Ankunftszeit:");
		JLtitlerückflugzeit2.setBounds(486, 253, 81, 14);
		getContentPane().add(JLtitlerückflugzeit2);
		
		JLabel JLtitlepreis = new JLabel("Preis:");
		JLtitlepreis.setBounds(584, 253, 81, 14);
		getContentPane().add(JLtitlepreis);
		
		String[] columnNames = { "Datum", "Abflugzeit", "Ankunftszeit", "Datum", "Abflugzeit", "Ankunftszeit", "Preis" };
		Object [][] rowdata = { { frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" },
								{ frame.JThinflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", frame.JTrückflugdatum.getText(), "15:00 Uhr", "17:00 Uhr", "200 CHF" }};
		
		JTable JTflugauswahl = new JTable(rowdata, columnNames) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		JTflugauswahl.setTableHeader(null);
		JTflugauswahl.setFillsViewportHeight(true);
		JTflugauswahl.setBounds(10, 268, 684, 182);
		getContentPane().add(JTflugauswahl);
		
		JScrollPane scrollPane = new JScrollPane(JTflugauswahl);
		scrollPane.setBounds(10, 268, 684, 182);
		getContentPane().add(scrollPane);
		scrollPane.setVisible(true);
		
		/*--------------------------------------------------*/
		
		JLabel JLweiter = new JLabel("Weiter >");
		JLweiter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLweiter.setHorizontalAlignment(SwingConstants.CENTER);
		JLweiter.setBackground(myOrange);
		JLweiter.setForeground(Color.WHITE);
		JLweiter.setBounds(10, 467, 302, 60);
		JLweiter.setOpaque(true);
		getContentPane().add(JLweiter);
		
		JLabel JLzurück = new JLabel("Zurück <");
		JLzurück.setBackground(Color.LIGHT_GRAY);
		JLzurück.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLzurück.setHorizontalAlignment(SwingConstants.CENTER);
		JLzurück.setBounds(392, 467, 302, 60);
		JLzurück.setOpaque(true);
		getContentPane().add(JLzurück);
		
		
		/*Weiter-Button*/
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JTflugauswahl.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frameGUI2,"Sie müssen einen Flug auswählen.","Hinweis",JOptionPane.WARNING_MESSAGE);     
				}
				else {
					setVisible(false);
					frameGUI3 = new GUI3(frameGUI2);
					frameGUI3.setVisible(true);
				}
			}
		});
		
		/*Zurück-Button*/
		JLzurück.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				frame.setVisible(true);
			}
		});
	}
}
