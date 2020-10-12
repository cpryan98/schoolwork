/*
 * Colin Ryan
 * ITEC 324
 */

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.*;

public class OutputView extends JFrame{

	FlowLayout experimentLayout = new FlowLayout();

	//JFrame frame = new JFrame("Shapes!");
	protected Graphics2D g2;
	final int FRAME_WIDTH = 700;
	final int FRAME_HEIGHT = 500;

	JTextField field1 = new JTextField(40);
	JTextField field2 = new JTextField(40);
	JTextField field3 = new JTextField(40);
	JTextField field4 = new JTextField(40);
	JTextField field5 = new JTextField(40);
	JTextField field6 = new JTextField(40);
	JTextField field7 = new JTextField(40);
	JTextField field8 = new JTextField(40);
	JTextField field9 = new JTextField(40);
	JTextField field0 = new JTextField(40);
	String[] files = new String[10];


	public void addComponentsToPane(final Container pane) 
	{

		experimentLayout.setAlignment(FlowLayout.TRAILING);

		//frame.setVisible(true);

	}	

	public void drawGUI() 
	{
		JFrame frame = new JFrame("MultiThreading");
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		//Create and set up the window.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		// frame.setBounds(400, 400, 400, 400);

		//Set up the content pane.
		//frame.addComponentsToPane(frame.getContentPane());
		//frame.add(field);
		JButton submit = new JButton("Submit");
		//frame.add(submit);
		c.insets = new Insets(10,10,10,10);
		JLabel t = new JLabel("Welcome to the Amazing File Reader 2000! Please enter a file name and be amazed!");
		c.gridx = 0;
		c.gridy = 0;
		panel.add(t, c);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(field1, c);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(field2, c);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(field3, c);
		c.gridx = 0;
		c.gridy = 4;
		panel.add(field4, c);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(field5, c);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(field6, c);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(field7, c);
		c.gridx = 2;
		c.gridy = 1;
		panel.add(field8, c);
		c.gridx = 2;
		c.gridy = 2;
		panel.add(field9, c);
		c.gridx = 2;
		c.gridy = 3;
		panel.add(field0, c);
		c.gridx = 3;
		c.gridy = 2;
		panel.add(submit, c);
		frame.add(panel);
		//String airlineCode = field.getText();
		submit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				String[] files = new String[10];
				files[1] = field1.getText();
				files[2] = field2.getText();
				files[3] = field3.getText();
				files[4] = field4.getText();
				files[5] = field5.getText();
				files[6] = field6.getText();
				files[7] = field7.getText();
				files[8] = field8.getText();
				files[9] = field9.getText();
				files[0] = field0.getText();
				for(int i = 1; i <10; i++)
				{
					if(files[i] != null)
						processData(files[i]);
				}
				for(int i = 1; i <10; i++)
				{
					System.out.println(files[i].toString());
				}
			}
		});
		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	/*
	 * this method will take the file input names from drawGUI and pass them to 
	 * thread tester and then will display the return data
	 * 10 text boxes
	 * takes input file names of input boxes that are !null
	 * thread all of them
	 * create output GUI for each thread
	 */
	public void processData(String files2)
	{
		Runnable r1 = new Multi(files2.toString());
		Thread t1 = new Thread(r1);
		t1.start();		
	}

	public static void main(String[] args)
	{

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OutputView().drawGUI();
			}
		});
	}
	//OutputView frame = new OutputView("Project 2");

}