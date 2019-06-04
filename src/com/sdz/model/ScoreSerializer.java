package com.sdz.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ScoreSerializer {
	
	private ArrayList<Score> scoreList = new ArrayList<>();
	private int positionScore = 1;
	
	
	public ScoreSerializer() 
	{
		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("scorelist.txt"))));
			
			scoreList = (ArrayList)ois.readObject();
			
			ois.close();			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Boolean compareScore(Score score)
	{
		if (scoreList.isEmpty())
		{
			return true;
		}
		else
		{
			for (Score temp : scoreList)
			{
				if (temp.getScore() < score.getScore())
					return true;
				else
					positionScore++;
			}
			if (scoreList.size() < 10)
				return true;
		}
		return false;
	}
	
	
	public void saveScore(Score score)
	{
		ArrayList<Score> temp = new ArrayList<>();
		int i = 1;
		if (scoreList.isEmpty())
			temp.add(score);
		else
		{
			for (Score temp1 : scoreList)
			{
				if (i == positionScore)
					temp.add(score);
				temp.add(temp1);
				i++;
			}
			if (i == positionScore)
				temp.add(score);
		}
		
		if (temp.size() > 10)
			temp.remove(10);
		
		scoreList = temp;
		temp = null;
		
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("scorelist.txt"))));
			
			oos.writeObject(this.scoreList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Score> getScoreList() {
		return scoreList;
	}
	
}
