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
	
	API1 a;
	JList JLabflughafen;
	DefaultListModel<String> model = new DefaultListModel<>();
	Abflughafen frame1;
	
	public Abflughafen(GUI1 frame){
	
		a =  new API1();
		setTitle("Abflughafen");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 450, 350);
		setLocationRelativeTo(null);
		setVisible(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel JLtitle = new JLabel("Flug von:");
		JLtitle.setBounds(11, 1, 264, 51);
		JLtitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(JLtitle);
		
		
		JLabflughafen = new JList(model);
		JLabflughafen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabflughafen.setBounds(10, 43, 414, 194);
		JScrollPane scrollPane = new JScrollPane(JLabflughafen);
		scrollPane.setBounds(11, 51, 401, 164);
		panel.add(scrollPane);
		scrollPane.setVisible(true);
		JLabflughafen.setVisibleRowCount(9);
		
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
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = (String) JLabflughafen.getSelectedValue();
				
				if(selected != null) {
					setVisible(false);
					frame.setAbflughafen();
					frame.setVisible(true);
				}
				
				else {
					JOptionPane.showMessageDialog(null,"Sie müssen einen Abflughafen wählen", "Hinweis", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		});
		
		/*Button Zurück zum Schliessen des GUIs*/
		JLabel JLzurück = new JLabel("Zurück <");
		JLzurück.setBounds(222, 248, 190, 51);
		JLzurück.setHorizontalAlignment(SwingConstants.CENTER);
		JLzurück.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLzurück.setBackground(Color.LIGHT_GRAY);
		JLzurück.setOpaque(true);
		panel.add(JLzurück);
		JLzurück.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Frame();
				frame.setVisible(true);
			}
		});
	}
	
	public String guiAuswahl() {
		String selected = (String) JLabflughafen.getSelectedValue();
		return selected;
	}
	
	public void visibleGUI() {
		setVisible(true);
	}

}
