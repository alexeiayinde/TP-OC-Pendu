import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sdz.model.Score;
import com.sdz.model.ScoreSerializer;
import com.sdz.model.Word;

public class GamePanel extends JPanel {
	
	private Score score = new Score();
	private JLabel labelMots;
	private JLabel labelScore;
	private Word word;
	
	private Font fontLabels = new Font("Arial", Font.BOLD, 14);
	private Dimension dimLabels = new Dimension(250, 20);
	private Dessin dessin = new Dessin();

	private int nbreErreurs;
	private JPanel panelGauche;
	private ScoreSerializer scoreList = new ScoreSerializer();
	
	public GamePanel()
	{

		initPartie();	
		
	}
	
	
	public void initPartie()
	{
		this.removeAll();
		this.setBackground(Color.white);
		
		

		labelMots = new JLabel();
		labelMots.setText("Nombre de mots trouvés : " + score.getNbreMots());
		labelMots.setFont(fontLabels);
		labelMots.setHorizontalAlignment(JLabel.CENTER);
		labelMots.setPreferredSize(dimLabels);
		
		labelScore = new JLabel();
		labelScore.setText("Votre score actuel est de : " + score.getScore());
		labelScore.setFont(fontLabels);
		labelScore.setHorizontalAlignment(JLabel.CENTER);
		labelScore.setPreferredSize(dimLabels);
		
		word = new Word();
		
		panelGauche = new JPanel();
		panelGauche.setBackground(Color.white);
		panelGauche.setPreferredSize(new Dimension(400, 600));
		panelGauche.add(labelMots);
		panelGauche.add(labelScore);
		panelGauche.add(word);
		initControler();
		
		dessin.setPreferredSize(new Dimension(450, 600));
		
		this.add(panelGauche);
		this.add(dessin);
		this.revalidate();
			
	}

	
	class Dessin extends JPanel
	{
		private int ImageWidth = 400, ImageHeight = 350;
		Image img;
		
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			try {
				if (nbreErreurs == 0)
					img = ImageIO.read(new File("images/pendu1.jpg"));
				if (nbreErreurs == 1)
					img = ImageIO.read(new File("images/pendu2.jpg"));
				if (nbreErreurs == 2)
					img = ImageIO.read(new File("images/pendu3.jpg"));
				if (nbreErreurs == 3)
					img = ImageIO.read(new File("images/pendu4.jpg"));
				if (nbreErreurs == 4)
					img = ImageIO.read(new File("images/pendu5.jpg"));
				if (nbreErreurs == 5)
					img = ImageIO.read(new File("images/pendu6.jpg"));
				if (nbreErreurs == 6)
					img = ImageIO.read(new File("images/pendu7.jpg"));
				if (nbreErreurs == 7)
					img = ImageIO.read(new File("images/pendu8.jpg"));
				
				g.drawImage(img, 50, 10, ImageWidth, ImageHeight, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void initControler()
	{
		JLabel controler = new JLabel();
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		JButton[] tab_boutons = new JButton[alphabet.length];
		JPanel panControler = new JPanel();
		
		panControler.setBackground(Color.white);
		panControler.setPreferredSize(new Dimension(400,200));
		
		for (int i = 0; i < alphabet.length; i++)
		{
			tab_boutons[i] = new JButton(alphabet[i]);
			tab_boutons[i].setPreferredSize(new Dimension(50, 25));
			tab_boutons[i].addActionListener(new ButtonListener());
			panControler.add(tab_boutons[i]);			
		}
		
		panelGauche.add(panControler);		
	}
	
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			((JButton)e.getSource()).setEnabled(false);
			word.updateLabel(((JButton)e.getSource()).getText().toLowerCase());
			
			if (word.getRepJuste() == false)
				nbreErreurs++;
			dessin.repaint();
			
			if (nbreErreurs == 7)
			{
				JOptionPane jop1 = new JOptionPane();
				ImageIcon img = new ImageIcon("images/gameover.png");
				jop1.showMessageDialog(null, "Le mot était : " + word.getMot().toUpperCase()+".\nVous avez trouvé : "+score.getNbreMots() + " mots. \n Votre score est de : "+score.getScore()+"Pts.", "GAME OVER", JOptionPane.INFORMATION_MESSAGE, img);
				exitGame();
			}
				
			
			if (word.getMot().toUpperCase().equals(word.getStr()))
			{
				score.setScore(nbreErreurs);
				score.setNbreMots(score.getNbreMots()+1);
				nbreErreurs = 0;

				JOptionPane jop1 = new JOptionPane();
				ImageIcon img = new ImageIcon("images/check.png");
				jop1.showMessageDialog(null, "Vous avez trouvé le mot!", "Bravo!", JOptionPane.INFORMATION_MESSAGE, img);
				
				initPartie();
			}
			
		}		
	}
	
	
	public void exitGame()
	{
		if (scoreList.compareScore(this.score))
		{
			JOptionPane jop = new JOptionPane();
			score.setPseudo(jop.showInputDialog(null, "Votre score est dans le top 10 ! \n Veuillez saisir votre prénom :", "Top 10", JOptionPane.QUESTION_MESSAGE));
			scoreList.saveScore(this.score);
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new ScorePanel(), BorderLayout.CENTER);
			this.revalidate();
		}
		else
		{
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new AccueilPanel(), BorderLayout.CENTER);
			this.revalidate();
		}
		
	}
}
