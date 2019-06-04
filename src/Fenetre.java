import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class Fenetre extends JFrame{
	
	private AccueilPanel accueil = new AccueilPanel();
	private JPanel container = new JPanel();
	private PanelListener pListener = new PanelListener();
	
	public Fenetre()
	{
		this.setSize(900,650);
		this.setTitle("Le Pendu");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		container.setLayout(new BorderLayout());
		container.add(accueil, BorderLayout.CENTER);
		
		initMenu();
		
		this.setContentPane(container);		
		this.setVisible(true);
	}
	
	
	public void initMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fichier = new JMenu("Fichier"),
				aPropos = new JMenu("A propos");
		
		JMenuItem nouveau = new JMenuItem("Nouveau"),
				scores = new JMenuItem("Scores"),
				regles = new JMenuItem("Règles"),
				quitter = new JMenuItem("Quitter"),
				info = new JMenuItem("?");
		
		// Onglet "Fichier"
		menuBar.add(fichier);
		fichier.setMnemonic('F');
		
		fichier.add(nouveau);
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		nouveau.addActionListener(pListener);
		
		fichier.add(scores);
		scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		scores.addActionListener(pListener);
		
		
		fichier.addSeparator();
		fichier.add(quitter);
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		// Onglet "A propos"
		menuBar.add(aPropos);
		aPropos.setMnemonic('O');

		aPropos.add(regles);
		regles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		regles.addActionListener(pListener);
		
		aPropos.add(info);
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null, "Créateur: Alexei Ayinde. \nLicense: Freeware. \nCopyright: alexei@alexei.com", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		this.setJMenuBar(menuBar);
	}
	
	
	class PanelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			container.removeAll();
			
			if (((JMenuItem)e.getSource()).getText() == "Règles")
				container.add(new RulesPanel(), BorderLayout.CENTER);			
			else if (((JMenuItem)e.getSource()).getText() == "Nouveau")
				container.add(new GamePanel(), BorderLayout.CENTER);
			else if (((JMenuItem)e.getSource()).getText() == "Scores")
				container.add(new ScorePanel(), BorderLayout.CENTER);
			else 
				container.add(new AccueilPanel(), BorderLayout.CENTER);
			
			container.revalidate();
		}		
	}
	
	
	
	
}
