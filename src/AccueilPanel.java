import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AccueilPanel extends JPanel {

	private JLabel titre = new JLabel("Bienvenue dans le jeu de PENDU");
	private String str = "Vous avez 7 coups pour trouver le mot caché et si vous réussissez...et bien on recommence!\n"
			+"Plus vous avez trouvé de mots, plus votre score grandira!!! Alors à vous de jouer!\n"
			+"PROVERBE: \"Pas vu, pas pris!\n"
			+"\tPris! PENDU!!!!\"";
	private JTextArea test = new JTextArea(str);
	
	public AccueilPanel()
	{
		this.setBackground(Color.white);
		
		titre.setFont(new Font("Arial", Font.BOLD, 30));
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setPreferredSize(new Dimension(900,30));
		
		test.setFont(new Font("Arial", Font.BOLD, 15));
		test.setForeground(Color.black);
		test.setEditable(false);
		test.setPreferredSize(new Dimension(700,80));
		
		this.add(titre);
		this.add(new JLabel(new ImageIcon("images/pendu_accueil.jpg")));
		this.add(test);
	}
	
	
	
}
