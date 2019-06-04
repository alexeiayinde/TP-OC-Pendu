package com.sdz.model;

import java.io.Serializable;

public class Score implements Serializable {
	
	private String pseudo;
	private int score;
	private int nbreMots;
	
	public Score() 
	{
		pseudo = ".....";
		score = 0;
		nbreMots = 0;
	}
	
	public Score(String pseudo, int score, int nbreMots)
	{
		this.pseudo = pseudo;
		this.score = score;
		this.nbreMots = nbreMots;
	}


	public String getPseudo() 
	{
		return pseudo;
	}


	public void setPseudo(String pseudo)
	{
		this.pseudo = (pseudo != null)? pseudo : ".....";
	}


	public int getScore() 
	{
		return score;
	}


	public void setScore(int nbreErreurs) 
	{
		if (nbreErreurs == 0)
			this.score += 100;
		if (nbreErreurs == 1)
			this.score += 50;
		if (nbreErreurs == 2)
			this.score += 35;
		if (nbreErreurs == 3)
			this.score += 25;
		if (nbreErreurs == 4)
			this.score += 15;
		if (nbreErreurs == 5)
			this.score += 10;
		if (nbreErreurs == 6)
			this.score += 5;
	}


	public int getNbreMots()
	{
		return nbreMots;
	}


	public void setNbreMots(int nbreMots) 
	{
		this.nbreMots = nbreMots;
	}

	
	public String toString() 
	{
		return this.pseudo + " -> " + this.score + " Pts  (" + this.nbreMots + " mots)";
	}

}
