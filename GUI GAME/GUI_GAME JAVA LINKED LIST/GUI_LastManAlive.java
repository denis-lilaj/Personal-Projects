import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI_LastManAlive extends JFrame implements ActionListener {
	
	JLabel label;
	JTextField numOfpeople;
	JButton remove;
	JButton show;
	
	PaintStrings paint=new PaintStrings();

	
	GUI_LastManAlive()
	{
	   show=new JButton("Show");
	   label=new JLabel("Enter the number of people");
	   numOfpeople=new JTextField(14);
	   remove=new JButton("Remove");
	   
	  
	   show.addActionListener(this);
	   remove.addActionListener(this);
	   
	   show.setActionCommand("show");
	   remove.setActionCommand("remove");
	   
	   getContentPane().setLayout(null);
	   
	   getContentPane().add(label);
	   getContentPane().add(numOfpeople);
	   getContentPane().add(show);
	   getContentPane().add(remove);
	   
	   label.setBounds(300, 10, 200, 100);
	   numOfpeople.setBounds(375, 70, 80, 20);
	   show.setBounds(375,95,80,20);
	   remove.setBounds(365,140,90,20);
	  
	   
	   
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("show"))
		{
			int numdisplay=Integer.parseInt(numOfpeople.getText().toString());
			
			for (int i=0;i<numdisplay;++i)
			{
				paint.paint(getGraphics());
			}
			
		}
	 
		
	}	
	

	
	public static void main (String[] args)
	{
		GUI_LastManAlive frame=new GUI_LastManAlive();
		frame.setTitle("Last Man Alive");
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
	
	
	

