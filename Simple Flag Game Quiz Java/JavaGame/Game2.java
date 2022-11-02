import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Game2 extends JFrame implements ActionListener{
	
        Icon flag0;
	Icon flag1;
	Icon flag2;
	Icon flag3;
	Icon flag4;
	Icon flag5;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	ArrayList<JButton> buttons=new ArrayList<JButton>();
	JLabel SelectFlag;;
	JPanel PutTheFlagsInFrame;
	JPanel MoveTheFlagsDown;
	ArrayList<String> flagnames=new ArrayList<String>();
	boolean[] ShowRandNumOnce= {false,false,false,false,false,false};
	JTextField Names;
	JTextField CorrectOrIncorrect;
	int Randnum;
	int i=0;
	int j=0;
	
	
	
	Game2()
	{
		Randnum=(int)(Math.random()*6);
	
		flagnames.add("UnitedArabEmirates");
		flagnames.add("Algeria");
		flagnames.add("Albania");
		flagnames.add("Armenia");
		flagnames.add("Argentina");
		flagnames.add("Austria");
		
		PutTheFlagsInFrame=new JPanel();
		MoveTheFlagsDown=new JPanel();
		SelectFlag=new JLabel("Select Flag");
		Names=new JTextField(flagnames.get(Randnum),18);
		Names.setEditable(false);
		
		
		
		flag0=new ImageIcon(getClass().getResource("Images_Inverse/flag0.gif"));
		flag1=new ImageIcon(getClass().getResource("Images_Inverse/flag1.gif"));
		flag2=new ImageIcon(getClass().getResource("Images_Inverse/flag2.gif"));
		flag3=new ImageIcon(getClass().getResource("Images_Inverse/flag3.gif"));
		flag4=new ImageIcon(getClass().getResource("Images_Inverse/flag4.gif"));
		flag5=new ImageIcon(getClass().getResource("Images_Inverse/flag5.gif"));
		
		button0=new JButton(flag0);
		button1=new JButton(flag1);
		button2=new JButton(flag2);
		button3=new JButton(flag3);
		button4=new JButton(flag4);
		button5=new JButton(flag5);
		
		
		
		CorrectOrIncorrect=new JTextField(15);
		CorrectOrIncorrect.setEditable(false);
		

		PutTheFlagsInFrame.add(button0);
		PutTheFlagsInFrame.add(Box.createRigidArea(new Dimension(15,0)));
		PutTheFlagsInFrame.add(button1);
		PutTheFlagsInFrame.add(Box.createRigidArea(new Dimension(15,0)));
		PutTheFlagsInFrame.add(button2);
		PutTheFlagsInFrame.add(Box.createRigidArea(new Dimension(15,0)));
		PutTheFlagsInFrame.add(button3);
		PutTheFlagsInFrame.add(Box.createRigidArea(new Dimension(15,0)));
		PutTheFlagsInFrame.add(button4);
		PutTheFlagsInFrame.add(Box.createRigidArea(new Dimension(15,0)));
		PutTheFlagsInFrame.add(button5);
		
		MoveTheFlagsDown.setLayout(new BoxLayout(MoveTheFlagsDown, BoxLayout.Y_AXIS));
		MoveTheFlagsDown.add(Box.createRigidArea(new Dimension(0,150)));
		MoveTheFlagsDown.add(SelectFlag);
		MoveTheFlagsDown.add(PutTheFlagsInFrame);
		
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		
		button0.setActionCommand("UnitedArabEmirates");
		button1.setActionCommand("Algeria");
		button2.setActionCommand("Albania");
		button3.setActionCommand("Armenia");
		button4.setActionCommand("Argentina");
		button5.setActionCommand("Austria");
		
		buttons.add(button0);
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);
		buttons.add(button5);
		
		
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(CorrectOrIncorrect);
		getContentPane().add(Names);
		getContentPane().add(MoveTheFlagsDown);
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getActionCommand().equals(flagnames.get(Randnum))) 
		{
		   CorrectOrIncorrect.setText("Correct");
		   buttons.get(Randnum).setEnabled(false);
		   ShowRandNumOnce[Randnum]=true;
		  
		   while( ShowRandNumOnce[Randnum]==true)
		   {
		   Randnum=(int)(Math.random()*6);
		   }
		   
		   Names.setText(flagnames.get(Randnum));
		   i++;
		}
		
		else if (!e.getActionCommand().equals(flagnames.get(Randnum)))
		{
		   CorrectOrIncorrect.setText("Incorrect");
		   j++;
	    }
		
		
		if (i==5)
		{
			
			System.out.println("Game over! You made " +j+ " mistakes during the game");
		}
		
		
	}
	
	
}