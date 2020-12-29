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

public class Zielflughafen extends JFrame{
	
	/*Initialisierung der API*/
	API1 a;
	/*Initialisierung der Frame*/
	Zielflughafen frame1;
	/*Liste für die Zielflughäfen*/
	JList JLzielflughafen;
	/*Model für die Liste*/
	DefaultListModel<String> model = new DefaultListModel<>();
	
	public Zielflughafen(GUI1 frame){
	
		/*Objekt für API wird erstellt*/
		a =  new API1();
		/*Einstellungen für Frame*/
		setTitle("Zielflughafen");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 450, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		
		/*Hauptpanel der Frame*/
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		/*Titel für die Frame*/
		JLabel JLtitle = new JLabel("Flug nach:");
		JLtitle.setBounds(11, 1, 264, 51);
		JLtitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(JLtitle);
		
		/*Liste für das Anzeigen von Zielflughäfen*/
		JLzielflughafen = new JList(model);
		JLzielflughafen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLzielflughafen.setBounds(10, 43, 414, 194);
		JScrollPane scrollPane = new JScrollPane(JLzielflughafen);
		scrollPane.setBounds(11, 51, 401, 164);
		panel.add(scrollPane);
		scrollPane.setVisible(true);
		JLzielflughafen.setVisibleRowCount(9);
		
		/*Befüllen der JList*/
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
		
		/*Button Zurück zum Schliessen des GUIs*/
		JLabel JLzurück = new JLabel("Zurück <");
		JLzurück.setBounds(222, 248, 190, 51);
		JLzurück.setHorizontalAlignment(SwingConstants.CENTER);
		JLzurück.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLzurück.setBackground(Color.LIGHT_GRAY);
		JLzurück.setOpaque(true);
		panel.add(JLzurück);
		
		/**
		 * Onclick-Action für den Weiter-Button:
		 * Es muss ein Flug ausgewählt werden, um die Frame zu schliessen
		 */
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Varialbe für das Spiechern des ausgewählten Flughafens*/
				String selected = (String) JLzielflughafen.getSelectedValue();
				
				/*Ist die Auswahl nicht gleich null?*/
				if(selected != null) {
					/*Frame wird unsichtbar*/
					setVisible(false);
					/*Duch Methode in GUI1 wird Abflughafen gespeichert*/
					frame.setZielflughafen();
					/*Frame von GUI1 wird wieder sichtbar*/
					frame.setVisible(true);
				}
				
				else {
					/*Warnungs-Hinweis, dass kein Flughafen ausgewählt wurde*/
					JOptionPane.showMessageDialog(null,"Sie müssen einen Zielflughafen wählen", "Hinweis", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		/**
		 * Onclick-Action für den Zurück-Button:
		 */
		JLzurück.addMouseListener(new MouseAdapter() {
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
	 * Speicherung des ausgewählten Zielflughafens, welcher zurückgegeben wird
	 * @return ausgewählter Zielflughafen
	 */
	public String guiAuswahl() {
		/*Zwischenspeicherung des ausgewählten Zielflughafen*/
		String selected = (String) JLzielflughafen.getSelectedValue();
		return selected;
	}
	
	/**
	 * Methode zur Visualisierung der Frame
	 */
	public void visibleGUI() {
		setVisible(true);
	}
}

