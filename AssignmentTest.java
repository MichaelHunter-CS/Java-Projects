/*
 * Student Name: Michael Hunter
 * Student Number: C19365646
 * Compiler: Eclipse
 * Operating System: Windows 10
 * Date of Submission: 19-4-21
 * Module: OOP
 * Lecturer: Dr. Susan McKeever
 * Program Description: The aim of this program is to act as a search engine for files. The user enters in a term that they would like to be searched and the program will return whether or not the given file contains the searched term. The program is also displayed to the user through a Graphical User Interface where the user just enters the files directory to which an example will be given below. 
 * Example File Directory: C:\Users\Owner\Desktop\2nd Year Notes\Object Oriented Programming\testfile.txt
 */

package com.assignment3;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileNotFoundException;

public class AssignmentTest extends JFrame implements ActionListener
{	
	//Graphical User Interface
	//Global rather than local so that the ActionListener can recognise the icons
	JButton button;
	JTextField filePath;
	JTextField textField;
	JLabel FilePath;
	JLabel SearchTerm;
	JLabel message;
	
	AssignmentTest()
	{
		//Search Button 
		button = new JButton("Search");
		button.addActionListener(this);
		//Textfield where the user enters the file directory of the file that they want to search 
		FilePath = new JLabel("File Directory: ");
		filePath = new JTextField();
		filePath.setPreferredSize(new Dimension(250,40));
		filePath.setText("Enter the full path of the file that you would like to search.");
		//Textfield where the user enters the term that they want to search for through the file that they have given
		SearchTerm = new JLabel("Search Term: ");
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setText("Enter the term that you would like us to find for you.");
		message = new JLabel();
		
		//Layout of the labels and textfields in x and y dimensions followed by the length and width of the textfields
		FilePath.setBounds(50,100,75,25);
		SearchTerm.setBounds(50,150,75,25);
		message.setBounds(125,250,250,35);
		filePath.setBounds(125,100,200,25);
		textField.setBounds(125,150,200,25);
		button.setBounds(125,200,200,25);
		
		this.add(button);
		this.add(filePath);
		this.add(textField);
		this.add(FilePath);
		this.add(SearchTerm);
		this.add(message);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420,420);
		this.setLayout(null);
		this.setVisible(true);
		
		{	
		//The Hashtable where the searched term is the key and the file is the mapped value
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		try 
		{
			//The file the the user gives is then scanned and saved until the user enters a term that they would like to be serached
		  	Scanner input = new Scanner(System.in);
		    char option;
		    System.out.print("Enter the filename you want to search text: ");
		    String fileName = input.nextLine();
		    File inputFile = new File(fileName);
		    Scanner fileInput = new Scanner(inputFile);
		    while (fileInput.hasNext()) 
		    {
		    	String value = fileInput.next();
		        hashTable.put(value, new String(value));
		    }
		    do 
		    {
		      	System.out.print("Enter the text you want to search: ");
		        String searchText = input.next();
		        boolean flag = false;
		        Enumeration<String> names;
		        names = hashTable.keys();
		        while (names.hasMoreElements()) 
		        {
		          	String str = (String) names.nextElement();
		            //To allow the user to ignore case sensitivity
		            if ((hashTable.get(str).toLowerCase()).equals(searchText.toLowerCase())) 
		            {
		              	flag = true;
		            }
		        }
		        if (flag) 
		        {
		          	System.out.println("'" + searchText + "' Text find in the file.");
		        } 
		        else
		          	System.out.println("'" + searchText + "' Text not find in the file. Please try again");
		           	System.out.println("Do you want to continue:(y/n)");
		           	option = input.next().charAt(0);
		   } 
		      while (option == 'y' || option == 'Y');
			} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error: " + e.getMessage());
	    }
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==button)
		{
			
		}
	}
}
