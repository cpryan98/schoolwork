import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Multi implements Runnable
{

	public Multi(String name)
	{
		filename = name;
	}
	public void run() 
	{
		try 
		{
			Scanner scan = new Scanner(new File(filename));
			while(scan.hasNext())
			{
				String currentWord = scan.nextLine();
				allText += "" + currentWord;
				String[] words = currentWord.split(" ");
				wordcount = wordcount + words.length;
				for(String word : words)
				{
					lettercount = lettercount + word.length();
				}
				String str = "The file " + filename + " has " + wordcount + " words and"
							+ lettercount + " letters.";
				FileOutputStream outputStream = new FileOutputStream("results.txt");
			    byte[] strToBytes = str.getBytes();
			    outputStream.write(strToBytes);
			 
			    outputStream.close();
				
				//Thread.sleep(DELAY);

			}
			drawGUI(lettercount, wordcount, filename);

		}
		catch (FileNotFoundException ex) 
		{
			ex.getSuppressed();
		}
		catch(IOException ex)
		{
			ex.getSuppressed();
		}

	}
	private void drawGUI(int lettercount2, int wordcount2, String filename2) 
	{
		JFrame frame = new JFrame(filename2);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		//Create and set up the window.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		JLabel filename = new JLabel("The name of the analyized file is " + filename2);
		JLabel words = new JLabel("The amount of words in the Text file is: " +wordcount2);
		JLabel letters = new JLabel("The amount of letters in the Text file is: " + lettercount2);
		JTextArea allWords = new JTextArea(allText);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(filename,c);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(words, c);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(letters, c);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(allWords, c);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
	private int wordcount;
	private int lettercount;
	private String filename;
	private static final int REPITIONS = 10;
	private static final int DELAY = 1000;
	private String allText = "";
}
