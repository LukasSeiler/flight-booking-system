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
	
	API1 a;
	JList JLzielflughafen;
	DefaultListModel<String> model = new DefaultListModel<>();
	
	public Zielflughafen(GUI1 frame){
	
		a =  new API1();
		Zielflughafen frame1;
		setTitle("Zielflughafen");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 450, 350);
		setLocationRelativeTo(null);
		setVisible(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel JLtitle = new JLabel("Flug nach:");
		JLtitle.setBounds(11, 1, 264, 51);
		JLtitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(JLtitle);
		
		
		JLzielflughafen = new JList(model);
		JLzielflughafen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLzielflughafen.setBounds(10, 43, 414, 194);
		JScrollPane scrollPane = new JScrollPane(JLzielflughafen);
		scrollPane.setBounds(11, 51, 401, 164);
		panel.add(scrollPane);
		scrollPane.setVisible(true);
		JLzielflughafen.setVisibleRowCount(9);
		
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
		
		JLweiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = (String) JLzielflughafen.getSelectedValue();
				
				if(selected != null) {
					setVisible(false);
					frame.setZielflughafen();
					frame.setVisible(true);
				}
				
				else {
					JOptionPane.showMessageDialog(null,"Sie m�ssen einen Zielflughafen w�hlen", "Hinweis", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		/*Button Zur�ck zum Schliessen des GUIs*/
		JLzur�ck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Frame();
				frame.setVisible(true);
			}
		});
	}
	
	public String guiAuswahl() {
		String selected = (String) JLzielflughafen.getSelectedValue();
		return selected;
	}
	
	public void visibleGUI() {
		setVisible(true);
	}
}

