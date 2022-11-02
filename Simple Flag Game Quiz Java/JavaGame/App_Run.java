import java.awt.*;

import java.io.*;
import javax.swing.*;


class App_Run extends QuizzGame {

	public static void main(String[] args) throws IOException
	{
	 InputStreamReader isr=new InputStreamReader(System.in);
	 BufferedReader br=new BufferedReader (isr);
	 String inData;
	 int number=0;
	 
	 QuizzGame frame=new QuizzGame();
	 WindowQuitter windowquitter=new WindowQuitter();
	
	 frame.addWindowListener( windowquitter );
         frame.setTitle("Flag Quizz Game");
         frame.setSize(700,300);
         frame.setResizable(false);
         frame.setVisible(true);
         
         System.out.println("Press 2 if you want to play the second game");
         
         inData=br.readLine();
         number=Integer.parseInt(inData);
         
        
	
	 if (number==2)
	 {
          Game2 frame2=new Game2();
	  WindowQuitter windowquitter2=new WindowQuitter();
	  frame2.addWindowListener( windowquitter2 );
          frame2.setSize(1270,400);
          frame2.setVisible(true);
          frame2.setResizable(false);
         }	
	}
	
}
	
	

