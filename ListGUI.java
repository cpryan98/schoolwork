import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @Author - Colin Ryan
 * @Date - 12/6/2017
 * @Class - ITEC 324
 */
public class ListGUI 
{
	public ListGUI()
	{

	}
	public void drawGUI() 
	{
		JFrame frame = new JFrame();
		frame.setSize(600, 750);
		frame.setLayout(new GridLayout(16,2, 5 , 5));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton empty = new JButton("isEmpty");
		JTextField emptyText = new JTextField();
		JButton addFront = new JButton("addToFront");
		JTextField frontText = new JTextField();
		JButton addBack = new JButton("addToBack");
		JTextField backText = new JTextField();
		JButton toString = new JButton("toString");
		JTextField toStringText = new JTextField();
		JButton revtoString = new JButton("reverseToString");
		JTextField revTSText = new JTextField();
		JButton reverse = new JButton("reverse");
		JTextField revText = new JTextField();
		JButton size = new JButton("sizeOf");
		JTextField sizeText = new JTextField();
		JButton phonetoname = new JButton("Phone Number by name");
		JTextField p2nText = new JTextField();
		JButton emailByName = new JButton("Email by name");
		JTextField e2nText = new JTextField();
		JButton nameByPhone = new JButton("Name by phone number");
		JTextField n2pText = new JTextField();
		JButton dobbyname = new JButton("DOB by name");
		JTextField d2nText = new JTextField();

		JTextField name = new JTextField("NAME");
		JTextField tel = new JTextField("TELEPHONE");
		JTextField email = new JTextField("E-MAIL");
		JTextField addy = new JTextField("ADDRESS");
		JTextField dob = new JTextField("DATE OF BIRTH");
		JTextArea textular = new JTextArea();

		frame.add(empty);
		frame.add(emptyText);
		frame.add(addFront);
	
		frame.add(addBack);
		frame.add(toString);
		frame.add(toStringText);
		frame.add(revtoString);
		frame.add(revTSText);
		frame.add(reverse);
		frame.add(revText);
		frame.add(size);
		frame.add(sizeText);
		frame.add(phonetoname);
		frame.add(p2nText);
		frame.add(emailByName);
		frame.add(e2nText);
		frame.add(nameByPhone);
		frame.add(n2pText);
		frame.add(dobbyname);
		frame.add(d2nText);
		frame.add(name);
		frame.add(tel);
		frame.add(email);
		frame.add(addy);
		frame.add(dob);

		frame.setVisible(true);
		
		AddressList list = new AddressList();
		
		empty.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				if(list.isEmpty())
					emptyText.setText("true");
				else
					emptyText.setText("false");
			}
		});
		addFront.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				list.addToFront(name.getText(), tel.getText(), email.getText(), addy.getText(), dob.getText());
			}
		});
		addBack.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				list.addToBack(name.getText(), tel.getText(), email.getText(), addy.getText(), dob.getText());
			}
		});
		toString.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				JFrame frame = new JFrame();
				frame.setSize(500, 500);
				frame.setLayout(new GridLayout(1, 1));
				JTextArea labez = new JTextArea(list.toString());
				frame.add(labez);
				frame.setVisible(true);
			}
		});
		//MISSING REVERSE TO STRING AND REVERSE 
		reverse.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				revText.setText("Succesfully Reversed");
			}
		});
		size.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				sizeText.setText("" + list.getSize());
			}
		});
		phonetoname.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				p2nText.setText(list.phoneToName(p2nText.getText()));
			}
		});
		emailByName.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				e2nText.setText(list.emailToName(e2nText.getText()));
			}
		});
		nameByPhone.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				n2pText.setText(list.nameByPhone(n2pText.getText()));
			}
		});
		dobbyname.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) 
			{
				d2nText.setText(list.dobByName(d2nText.getText()));
			}
		});
		
		
		
		
		
		
	
	
	
	
	
	
	}
	
}

