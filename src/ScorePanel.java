import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sdz.model.Score;
import com.sdz.model.ScoreSerializer;

public class ScorePanel extends JPanel {
	
	private JPanel scoreContainer = new JPanel();
	private JPanel imageContainer = new JPanel();
	private ScoreSerializer score = new ScoreSerializer();

	public ScorePanel()
	{
		this.setBackground(Color.WHITE);
		
		imageContainer.setPreferredSize(new Dimension(350, 550));
		imageContainer.setBackground(Color.white);
		imageContainer.add(new JLabel(new ImageIcon("images/pendu8.jpg")));
		
		initScoreList();
		this.add(imageContainer);
	}
	
	
	public void initScoreList()
	{
		scoreContainer.setPreferredSize(new Dimension(500, 550));
		scoreContainer.setBackground(Color.white);
		
		JLabel scoreList = new JLabel();
		
		int taillePolice = 25;
		
		for (Score scores : score.getScoreList())
		{
			scoreList = new JLabel(scores.toString());
			scoreList.setFont(new Font("Arial", Font.BOLD, taillePolice));
			scoreList.setPreferredSize(new Dimension(350, 40));
			scoreContainer.add(scoreList);
			
			taillePolice--;
		}
		
		this.add(scoreContainer);
	}
	
}
