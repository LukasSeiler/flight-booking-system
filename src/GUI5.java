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
import javax.swing.JOptionPane;
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

public class GUI5 extends JFrame{
	
	static GUI5 frameGUI5;
	Color myOrange = new Color(255, 127, 000);

	public GUI5(GUI4 frameGUI4) {
		
		setTitle("Rechnung");
		setSize(450, 630);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 591);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel JLanrede = new JLabel(GUI3.frameGUI4.JCBanrede.getSelectedItem().toString());
		JLanrede.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLanrede.setBounds(20, 11, 404, 24);
		panel.add(JLanrede);
		
		JLabel JLname = new JLabel(GUI3.frameGUI4.JTvorname.getText()+" "+GUI3.frameGUI4.JTnachname.getText());
		JLname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLname.setBounds(20, 36, 404, 24);
		panel.add(JLname);
		
		JLabel JLstrasse = new JLabel(GUI3.frameGUI4.JTstrasse.getText());
		JLstrasse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLstrasse.setBounds(20, 61, 404, 24);
		panel.add(JLstrasse);
		
		JLabel JLort = new JLabel(GUI3.frameGUI4.JTplz.getText()+" "+GUI3.frameGUI4.JTort.getText());
		JLort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLort.setBounds(20, 86, 404, 24);
		panel.add(JLort);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
		separator1.setBounds(20, 121, 404, 10);
		panel.add(separator1);
		
		JLabel JLtitlehinflug = new JLabel("Von "+GUI1.abflughafen+" nach "+GUI1.zielflughafen);
		JLtitlehinflug.setForeground(myOrange);
		JLtitlehinflug.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLtitlehinflug.setBounds(20, 142, 404, 24);
		panel.add(JLtitlehinflug);
		
		JLabel JLabflug1 = new JLabel("Abflug: "+GUI1.JThinflugdatum.getText()+" / "+GUI2.abflug1);
		JLabflug1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabflug1.setBounds(20, 177, 404, 24);
		panel.add(JLabflug1);
		
		JLabel JLankunft1 = new JLabel("Ankunft: "+GUI1.JThinflugdatum.getText()+" / "+GUI2.ankunft1);
		JLankunft1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLankunft1.setBounds(20, 202, 404, 24);
		panel.add(JLankunft1);
		
		JLabel JLtitler�ckflug = new JLabel("Von "+GUI1.zielflughafen+" nach "+GUI1.abflughafen);
		JLtitler�ckflug.setForeground(myOrange);
		JLtitler�ckflug.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLtitler�ckflug.setBounds(20, 237, 404, 24);
		panel.add(JLtitler�ckflug);
		
		JLabel JLabflug2 = new JLabel("Abflug: "+GUI1.JTr�ckflugdatum.getText()+" / "+GUI2.abflug2);
		JLabflug2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabflug2.setBounds(20, 272, 404, 24);
		panel.add(JLabflug2);
		
		JLabel JLankunft2 = new JLabel("Ankunft: "+GUI1.JTr�ckflugdatum.getText()+" / "+GUI2.ankunft2);
		JLankunft2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLankunft2.setBounds(20, 297, 404, 24);
		panel.add(JLankunft2);
		
		if(GUI1.statushinflug == false) {
			JLtitler�ckflug.setVisible(false);
			JLabflug2.setVisible(false);
			JLankunft2.setVisible(false);
		}
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(Color.BLACK);
		separator2.setBounds(20, 342, 404, 10);
		panel.add(separator2);
		
		JLabel JLtitlekosten = new JLabel("Kosten f�r "+(GUI1.count1+GUI1.count2+GUI1.count3)+" Person/en:");
		JLtitlekosten.setForeground(Color.BLACK);
		JLtitlekosten.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLtitlekosten.setBounds(20, 363, 404, 24);
		panel.add(JLtitlekosten);
		
		JLabel JLkosten1 = new JLabel("Kosten f�r Flugstrecke");
		JLkosten1.setForeground(myOrange);
		JLkosten1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLkosten1.setBounds(20, 398, 181, 24);
		panel.add(JLkosten1);
		
		JLabel JLkosten2 = new JLabel("Sitzplatz");
		JLkosten2.setForeground(myOrange);
		JLkosten2.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLkosten2.setBounds(20, 425, 181, 24);
		panel.add(JLkosten2);
		
		JLabel JLarrow2 = new JLabel(">>>");
		JLarrow2.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLarrow2.setBounds(229, 425, 39, 24);
		panel.add(JLarrow2);
		
		JLabel JLarrow1 = new JLabel(">>>");
		JLarrow1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLarrow1.setBounds(229, 398, 39, 24);
		panel.add(JLarrow1);
		
		JLabel JLbetrag1 = new JLabel(GUI2.price+" CHF");
		JLbetrag1.setHorizontalAlignment(SwingConstants.RIGHT);
		JLbetrag1.setForeground(Color.BLACK);
		JLbetrag1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLbetrag1.setBounds(294, 398, 103, 24);
		panel.add(JLbetrag1);
		
		JLabel JLbetrag2 = new JLabel(GUI3.betrag+" CHF");
		JLbetrag2.setHorizontalAlignment(SwingConstants.RIGHT);
		JLbetrag2.setForeground(Color.BLACK);
		JLbetrag2.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLbetrag2.setBounds(294, 425, 103, 24);
		panel.add(JLbetrag2);
		
		JSeparator separator3 = new JSeparator();
		separator3.setForeground(Color.BLACK);
		separator3.setBounds(292, 460, 118, 10);
		panel.add(separator3);
		
		JLabel JLtotal = new JLabel((GUI2.price+GUI3.betrag)+" CHF");
		JLtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		JLtotal.setForeground(Color.BLACK);
		JLtotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLtotal.setBounds(294, 475, 103, 24);
		panel.add(JLtotal);
		
		JLabel JLdrucken = new JLabel("Drucken >");
		JLdrucken.setForeground(Color.WHITE);
		JLdrucken.setBackground(myOrange);
		JLdrucken.setOpaque(true);
		JLdrucken.setHorizontalAlignment(SwingConstants.CENTER);
		JLdrucken.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLdrucken.setBounds(20, 527, 181, 53);
		panel.add(JLdrucken);
		
		JLabel JLabbrechen = new JLabel("Abbrechen <");
		JLabbrechen.setHorizontalAlignment(SwingConstants.CENTER);
		JLabbrechen.setForeground(Color.BLACK);
		JLabbrechen.setOpaque(true);
		JLabbrechen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabbrechen.setBackground(Color.LIGHT_GRAY);
		JLabbrechen.setBounds(229, 527, 181, 53);
		panel.add(JLabbrechen);
		
		JLabel JLzur�ck1 = new JLabel("Zur�ck <");
		JLzur�ck1.setOpaque(true);
		JLzur�ck1.setHorizontalAlignment(SwingConstants.CENTER);
		JLzur�ck1.setForeground(Color.BLACK);
		JLzur�ck1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLzur�ck1.setBackground(Color.LIGHT_GRAY);
		JLzur�ck1.setBounds(321, 46, 89, 36);
		panel.add(JLzur�ck1);
		
		JLabel JLzur�ck2 = new JLabel("Zur�ck <");
		JLzur�ck2.setOpaque(true);
		JLzur�ck2.setHorizontalAlignment(SwingConstants.CENTER);
		JLzur�ck2.setForeground(Color.BLACK);
		JLzur�ck2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLzur�ck2.setBackground(Color.LIGHT_GRAY);
		JLzur�ck2.setBounds(321, 183, 89, 36);
		panel.add(JLzur�ck2);
		
		JLzur�ck1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				GUI3.frameGUI4.setVisible(true);
			}
		});
		
		JLzur�ck2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				GUI1.frame.setVisible(true);
			}
		});
		
		JLdrucken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 JOptionPane.showMessageDialog(frameGUI5,"Dokument wurde erfolgreich gedruckt (x)");
				 dispose();
			}
		});
		
		JLabbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
	}
}
