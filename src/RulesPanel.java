import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RulesPanel extends JPanel {
	
	private JLabel titre = new JLabel("le jeu de PENDU :");
	private JTextArea rules = new JTextArea();
	
	public RulesPanel()
	{
		this.setBackground(Color.white);
		
		titre.setFont(new Font("Arial", Font.BOLD, 30));
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setVerticalAlignment(JLabel.TOP);
		titre.setPreferredSize(new Dimension(900, 100));
		
		rules.setFont(new Font("Arial", Font.BOLD, 15));
		rules.setForeground(Color.black);
		rules.setEditable(false);
		rules.setText("Vous avez 7 coups pour trouver le mot cach� ! Et si vous r�ussissez : on recommence !\n"
				+"Plus vous avez trouv� de mots, plus votre score grandira!! Alors � vous de jouer!\n\n\n"
				+"COMPTE DES POINTS:\n\n"
				+"\tMot trouv� sans erreur:........100Pts\n"
				+"\tMot trouv� avec 1 erreur:.....50Pts\n"
				+"\tMot trouv� avec 2 erreurs:...35Pts\n"
				+"\tMot trouv� avec 3 erreurs:...25Pts\n"
				+"\tMot trouv� avec 4 erreurs:...15Pts\n"
				+"\tMot trouv� avec 5 erreurs:...10Pts\n"
				+"\tMot trouv� avec 6 erreurs:...5Pts\n\n\n"
				+"Je vous souhaite bien du plaisir...\n"
				+"Et si vous pensez trouver un mot en un seul coup, c'est que vous pensez que le dictionnaire est petit!\n"
				+"Or, pour votre information, il comprend plus de 336 000 mots... Donc bonne chance!! ;)");
		
		this.add(titre);
		this.add(rules);		
	}

}
