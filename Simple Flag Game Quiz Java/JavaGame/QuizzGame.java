import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.TitledBorder;




public class QuizzGame extends JFrame implements ActionListener {
	
	TitledBorder Flags;
	TitledBorder ScoreTableTitle;
	JButton Submit;
	JButton NextFlag;
	JComboBox Combobox;
	String[] CountryNames= {"United Arab Emirates","Algeria","Albania","Armenia","Argentina","Austria","Bosnia and Herzegovina","Canada","Cuba","Cyprus","Egypt","Finland","France","Germany","Greece","Croatia","Israel","Spain","Sweden","Switzerland","Thailand","Turkey","United Kingdom","Ukraine","Uruguay"};
        boolean[] CountryDisplay= {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	JTextField Text;
	JLabel Result;
	JLabel SelectCountry;
	JLabel FlagsLabel;
	JPanel left;
	JPanel middle;
	JPanel right;
	JPanel left_right_adjust;
    JPanel CorrectIncorrectTableHeader;
    JPanel Score;
    JLabel Correct;
    JLabel Incorrect;
    JTextField CorrectPoints;
    JTextField IncorrectPoints;
    JPanel Table;
    int Randnum;
    int i=0;
    int CorrectP=0;
    int IncorrectP=0;
    
    

	
	   QuizzGame()
    {
		Randnum = (int)((Math.random()*25));
			
	 
		Flags=new TitledBorder("Flags");
		
		Submit=new JButton("Submit");
        NextFlag=new JButton("Next Flag");
        
        Combobox=new JComboBox(CountryNames);
	  	SelectCountry=new JLabel("Select Country");
	  	
	    FlagsLabel=new JLabel();
	    FlagsLabel.setIcon(new ImageIcon(getClass().getResource("Flags_Images/flag"+Randnum+".gif")));
	    
        
	    Result=new JLabel("Result");
		Text=new JTextField(20);
		
		
		Correct=new JLabel("Correct ");
		Incorrect=new JLabel("Incorrect ");
		
		
		CorrectPoints=new JTextField(2);
		CorrectPoints.setEditable(false);
		IncorrectPoints=new JTextField(2);
		IncorrectPoints.setEditable(false);
	  	
		
		CorrectIncorrectTableHeader=new JPanel();
		CorrectIncorrectTableHeader.add(Correct);
		CorrectIncorrectTableHeader.add(Box.createRigidArea(new Dimension(10,0)));
		CorrectIncorrectTableHeader.add(Incorrect);
		
		
		Score=new JPanel();
		Score.add(CorrectPoints);
		Score.add(Box.createRigidArea(new Dimension(38,0)));
		Score.add(IncorrectPoints);
		
		
		ScoreTableTitle=new TitledBorder("Score Table");
		Table=new JPanel();
		Table.setLayout(new BoxLayout(Table,BoxLayout.Y_AXIS));
		Table.add(CorrectIncorrectTableHeader);
		Table.add(Score);
		Table.setBorder(ScoreTableTitle);
		
		
		left=new JPanel();
		middle=new JPanel();
		right=new JPanel();
		
		
		
		left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
		middle.setLayout(new BoxLayout(middle,BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right,BoxLayout.Y_AXIS));
		
		
		
		left.add(Box.createRigidArea(new Dimension(0,10)));
		left.add(Submit);
		left.add(Box.createRigidArea(new Dimension(0,5)));
		left.add(NextFlag);
		
		
		
		
		FlagsLabel.setBorder(Flags);
		middle.add(FlagsLabel);
		
		
		
		
		right.add(SelectCountry);
		right.add(Box.createRigidArea(new Dimension(0,5)));
		right.add(Combobox);
		right.add(Box.createRigidArea(new Dimension(0,5)));
		right.add(Text);
		right.add(Box.createRigidArea(new Dimension(0,40)));
		right.add(Table);
		
		
		
		
		left_right_adjust=new JPanel();
		left_right_adjust.add(left);
		left_right_adjust.add(Box.createRigidArea(new Dimension(30,0)));
		left_right_adjust.add(middle);
		left_right_adjust.add(Box.createRigidArea(new Dimension(30,0)));
		left_right_adjust.add(right);
	
		
		getContentPane().setLayout(new FlowLayout());
	 
		
		getContentPane().add(left_right_adjust);
	
	
		
       
		Submit.addActionListener(this);
		NextFlag.addActionListener(this);
		Combobox.addActionListener(this);
		
		
		Submit.setActionCommand("Submit");
		NextFlag.setActionCommand("NextFlag");
		
		NextFlag.setEnabled(false);
		
}
	   
	   
	  
	
	   public void actionPerformed(ActionEvent e)
	{
		
		  if(e.getActionCommand().equals("Submit") && CountryNames[Randnum].equals(Combobox.getSelectedItem()))
			{
				Text.setText("Correct");
				
				NextFlag.setEnabled(true);
	            
				CountryDisplay[Randnum]=true;
		     	
				i++;
				
				CorrectP++;
			   
			    CorrectPoints.setText(Integer.toString(CorrectP));
				
				Submit.setEnabled(false);
			}
			
		  
		  else if(e.getActionCommand().equals("Submit") &&  !CountryNames[Randnum].equals(Combobox.getSelectedItem()))
			{
				Text.setText("Incorrect");
				
				NextFlag.setEnabled(false);
				
			    IncorrectP++;
			    
			    IncorrectPoints.setText(Integer.toString(IncorrectP));
			}
		  

		 	if (e.getActionCommand().equals("NextFlag"))
	       {
		 	
		     Combobox.removeItem(Combobox.getSelectedItem());	
					
		
		    while(CountryDisplay[Randnum]==true)
		     {
			   Randnum = (int)((Math.random()*25));
			 } 
		    
		     FlagsLabel.setIcon(new ImageIcon(getClass().getResource("Flags_Images/flag"+Randnum+".gif")));
		     
			 NextFlag.setEnabled(false);
			 
			 Submit.setEnabled(true);
		}
		 
		
		 	if (i==25)
		 {
		     System.out.print("Game over! You made " +IncorrectP+ " mistakes during the game.");
		     System.exit(0);
		 }
		 	
				
		 	
		  
		
	}
	    
}
			
     
	
   
   
		
		

