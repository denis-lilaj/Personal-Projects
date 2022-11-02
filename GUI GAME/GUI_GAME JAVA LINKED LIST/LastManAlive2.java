import java.util.Scanner;

public class LastManAlive2 {
	
	public static void main (String[] args)
	{
	 int numOfpeople;
	 int numSuicides;
	
	
	 
	 LinkList2String circle=new LinkList2String();
	
	 Scanner scan=new Scanner(System.in);
	 
	 System.out.println("Please enter the number of people that will show up in the gatherig");
	 numOfpeople=scan.nextInt();
	 circle.fill(numOfpeople);
	 
	 System.out.println("Please enter the number to be used for suicides");
	 numSuicides=scan.nextInt();
	 System.out.println();
	 System.out.println();
	 
     
	System.out.println("All the people who will show up in the gathering");
	System.out.println();
    circle.display();
    System.out.println();
    
    
    circle.delete(circle.temp1(numSuicides).key); 
    System.out.println("The person who will get executed will be: " +circle.displaydeleted.key);
    circle.display();
    System.out.println();
    
   
    
    while (circle.length!=1)
    {
    circle.delete(circle.Move(numSuicides).key);
    System.out.println("The person who got executed will be: " +circle.displaydeleted.key);
    circle.display();
    System.out.println();
    }
   
    System.out.println("You should stay in " +circle.temp1.key+ "'s place to stay alive");
    
     
	}
  
}
