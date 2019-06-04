package com.sdz.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Word extends JPanel {
	
	private String mot, str="", str2 ="";
	private int nbre = (int)(Math.random()*336529);
	private JLabel affichage = new JLabel();
	private LineNumberReader lnr;
	private Boolean repJuste = false;

	
	public Word()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(400,60));
				
		try {
			lnr = new LineNumberReader(new FileReader(new File("dictionnaire.txt")));
			
			while((nbre+1) != lnr.getLineNumber())
			{
				mot = lnr.readLine();				
			}		
			
			lnr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < mot.length(); i++)
		{
			if (mot.substring(i, i+1).equals("-"))
				str += "-";
			else
				str  += "*";
		}
		
		affichage.setText(str);
		affichage.setFont(new Font("Arial", Font.BOLD, 30));
		affichage.setPreferredSize(new Dimension(400,60));
		affichage.setForeground(Color.blue);
		affichage.setHorizontalAlignment(JLabel.CENTER);
		affichage.setVerticalAlignment(JLabel.CENTER);
		
		this.add(affichage);
		
	}

	
	public String getMot()
	{
		return mot;
	}
	
	
	public String getStr()
	{
		return str;
	}
	
	
	public Boolean getRepJuste()
	{
		return repJuste;
	}
	
	
	public void updateLabel(String lettre)
	{		
		for (int i = 0; i < this.mot.length(); i++)
		{
			switch(lettre)
			{
			case "a":
				if (mot.substring(i, i+1).equals("à") || mot.substring(i, i+1).equals("â") || mot.substring(i, i+1).equals("a"))
					this.str2 += mot.substring(i, i+1).toUpperCase();
				else
					this.str2 += str.substring(i, i+1);
				break;
			case "e":
				if (mot.substring(i, i+1).equals("é") || mot.substring(i, i+1).equals("è") || mot.substring(i, i+1).equals("ê") || mot.substring(i, i+1).equals("e"))
					this.str2 += mot.substring(i, i+1).toUpperCase();
				else
					this.str2 += str.substring(i, i+1);
				break;
			case "u":
				if (mot.substring(i, i+1).equals("û") || mot.substring(i, i+1).equals("u"))
					this.str2 += mot.substring(i, i+1).toUpperCase();
				else
					this.str2 += str.substring(i, i+1);
				break;
			case "i":
				if (mot.substring(i, i+1).equals("î") || mot.substring(i, i+1).equals("ï") || mot.substring(i, i+1).equals("i"))
					this.str2 += mot.substring(i, i+1).toUpperCase();
				else
					this.str2 += str.substring(i, i+1);
				break;
			case "o":
				if (mot.substring(i, i+1).equals("ô") || mot.substring(i, i+1).equals("o"))
					this.str2 += mot.substring(i, i+1).toUpperCase();
				else
					this.str2 += str.substring(i, i+1);
				break;
			case "c":
				if (mot.substring(i, i+1).equals("ç") || mot.substring(i, i+1).equals("c"))
					this.str2 += mot.substring(i, i+1).toUpperCase();
				else
					this.str2 += str.substring(i, i+1);
				break;
				
			default :
					if (mot.substring(i, i+1).equals(lettre))
					{
						this.str2 += mot.substring(i, i+1).toUpperCase();
					}			
					else
					{
						this.str2 += str.substring(i, i+1);
					}
			}			
		}
		
		if (str.equals(str2))
			repJuste = false;
		else
			repJuste = true;
		
		str = str2;
		str2="";
		affichage.setText(str);
	}
	
}
