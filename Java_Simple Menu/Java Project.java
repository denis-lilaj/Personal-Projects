/*
 * Java project consisting of 6 different menus 
   related to mathematics quests
 
 * @author Denis Lilaj 
 * @email denislilaj10@gmail.com
 * @version 1.0 
 * @date 12/06/2019
 * Licensed under the GPL Open Source agreement.
 
*/

import java.io.*;
import java.util.Arrays;
import java.util.Random;
class FirstProject_Java1_0
{
  public static void main  (String[] args) throws IOException
   {
       InputStreamReader isr=new InputStreamReader (System.in); // Variable (object) reading the keystrokes
       BufferedReader br=new BufferedReader (isr);  // Variable (object) transalting the input stream
       int menu=0; // integer container labeled menu 
          
       String inData=null;   // Text variable to receive the user's input
       System.out.println("Hello user,choose a menu from the list below"); //Java statement that prints the argument passed
      do{ //start of the loop that will continue till the user presses menu 7 to exit the program  
          
          //Java statement that prints the argument passed//
          System.out.println("Press 1 for Menu 1"); 
          System.out.println("Press 2 for Menu 2");
          System.out.println("Press 3 for Menu 3");
          System.out.println("Press 4 for Menu 4");
          System.out.println("Press 5 for Menu 5");
          System.out.println("Press 6 for Menu 6");
          System.out.println("Press 7 for Menu 7 (exit the program)");
          //                                               //
          
       
             
          inData=br.readLine(); // Reads the user's input and stores it in variable 'inData'
          menu=Integer.parseInt(inData); /*transform user's input that is stored in inData into Integers and than these Integres
                                           are thrown inside container menu*/
          
         if (menu==1) // using if statements to devide each menu from each other
          {
            //declaring,initializing variables and arrays
            String inData1=null;
            float[] numbers=new float[6];
            float sum=0;
            float product=1;
            float[] subtraction=new float[6];
            float[] square=new float[6];
            float sumtheSquares=0;
            float statisticalVariance=0;
            double standardDeviation=0;
               
            System.out.println("Thank you,you have chosen Menu 1"); //Java statement that prints the argument passed
            System.out.println("In menu 1 you can check the sum,product,statistical variance and standard deviation of 6 real numbers");
            int j=0; //declaring variable
             
             for (int i=0;i<6;++i) //loop for gathering six real numbers
             
            {
                   j=j+1;
                 System.out.println("Enter number " +j);
                 inData1=br.readLine(); //reads user input
                 numbers[i]=Float.parseFloat(inData1);/*transform Strings that are stored in inData1
                                                       into Integers and than these Integers are thrown inside array labeled numbers with index i */
                 
                 sum=sum+numbers[i];  /*the 6 real numbers that are stored in the array labeled numbers are added one by one 
                                      and their sum is stored into the float container labeled sum*/
                 product=product*numbers[i]; /*the 6 real numbers that are stored in the array labeled numbers
                                             are multiplied one by one and their product is stored into the container labeled product*/
               }
               for (int i=0;i<6;++i) //loop for using the six real numbers stored in the array numbers
               {
                    
                 subtraction[i]=(numbers[i]-(sum/6));
                 square[i]=subtraction[i]*subtraction[i]; 
                 sumtheSquares=sumtheSquares+square[i]; //using the subtraction array, square array and float container labeled 
                                                        //sumtheSquares to find the sum of the squares that is needed to find Statistical Variance
               }
                  
               statisticalVariance=sumtheSquares/6; //finding statistical variance by dividing the value inside sumtheSquares by 6 and throwing
                                                       //the new value inside container labeled statisticalVariance
                  
               standardDeviation=Math.sqrt(statisticalVariance); //finding standardDeviation by square rooting what is inside statisticalVariance 
                                                                    //and throwing it inside the container labeled standardDeviation
                  
                  //Displaying sum,product,statistical Variance and standard Deviation//
                  System.out.println("The sum of the numbers will be :" +sum);
                  System.out.println("The product of the numbers will be:" +product);
                  System.out.println("Statistical variance of the numbers will be:" +statisticalVariance);
                  System.out.println("Standard deviation of the numbers will be:" +standardDeviation);
                  //                                                                   //
                  
               System.out.println(" ");   //creating spaces between Menu1 and the Menu table that is going to display again 
               System.out.println(" ");    
                
            }
                     
            
          if (menu==2) // using if statements to devide each menu from each other
            {
             //declaring,initializing variables and arrays
             double average1=0;
             double sum1=0;
             double[] subtraction1=new double[23];
             double[] square1=new double[23];
             double sumtheSquares1=0;
             double statisticalVariance1=0;
             double standardDeviation1=0;
             double [] values=new double [23];
             double [] values_square=new double [23];
             //
             
             //Java statements that print the argument passed//
             System.out.println("Thank you,you have chosen Menu 2"); 
             System.out.println("In menu 2 integer numbers between 0 and 500 are calculated.These numbers are the exact square of another integer.");
             System.out.println("Also this program calculates the sum,average,standard variance and standard deviation of all squares that are found.");
             System.out.println("Here is the list of numbers from the lowest to the highest:");
             System.out.println(" ");
            //                                               //
            
            for (int i=2;i<=22;i++) //loop for storing 22 values inside array values[i]
               {
                if (Math.sqrt(i*i)%1==0) //actions indide the if statement will be done only if the square roots of the i*i are even numbers
                {
                    values[i]=i*i; //finding 22 values by multiplying i with i and storing them inside array values
                    System.out.println(+values[i]); //displaying the values
                    sum1=sum1+values[i]; //finding the sum of the 22 values by adding each element of the array one by one and storing the sum inside
                                         //container double labeled sum1
                }
            }
                
            for (int i=2;i<=22;i++)
                {
                   subtraction1[i]=(values[i]-(sum1/21));
                   square1[i]=subtraction1[i]*subtraction1[i];
                   sumtheSquares1=sumtheSquares1+square1[i]; //using the arrays labeled substraction1[i] square[i] 
                                                             //and container sumtheSquares1 to find the sum of the squares
                 }
                statisticalVariance1=sumtheSquares1/21; //finding statistical variance by dividing the value inside sumtheSquares1 by 21 and throwing
                                                        //the new value inside container labeled statisticalVariance1
                  
                standardDeviation1=Math.sqrt(statisticalVariance1); //finding standardDeviation by square rooting what is inside statisticalVariance1 
                                                                    //and throwing it inside the container labeled standardDeviation1 container
               
               //Displaying sum,product,statistical Variance and standard Deviation
               System.out.println("The sum of the numbers will be :"+sum1);
               System.out.println("The average of the numbers will be :"+sum1/21);
               System.out.println("Statistical variance of the numbers will be :"+statisticalVariance1);
               System.out.println("Standard deviation of the numbers will be :"+standardDeviation1);
               // 
               
              System.out.println(" ");    //creating spaces between Menu2 and the Menu table that is going to display again 
              System.out.println(" ");   
          }
          
          
      
          if (menu==3) // using if statements to devide each menu from each other
          {
             //decalring,initializing variables and arrays
             double [] integers=new double[20];
             String inData2=null;
             double sum2=0;
             double averageOfTheFiveNumbers=0;
             double factorial=1;
             double round_value=1;
             
             //Java statements that print the argument passed
             System.out.println("Thank you,you have chosen Menu 3");
             System.out.println("In menu 3 you have to enter five positive integres between 0 and 15. The average of the 5 integers will be displayed as well as the factorial of the integer which is closest to the group's average.");
             System.out.println("Please enter 5 integers between 0 and 15");
             //
             
             int r=0; //declaring and initializing variable
             for (int i=0;i<20;++i) //loop that will be used to find the sum of 5 integers
              {
                System.out.println("Enter integer "); //Asking user to enter integer
                inData2=br.readLine();//throwing user input inside inData2
                integers[i]=Integer.parseInt(inData2);  //transform Strings that are stored in inData2 into Integers and than these Integres 
                                                        //are thrown inside array integers
                
               if (integers[i]>=0 && integers[i]<=15) //if numbers inside array integers are bigger or equal to 0 and smaller or equal to 15
                                                      //add the numbers inside the array one by one and throw the sum inside container sum2 till r=5
                 {
                    sum2=sum2+integers[i];
                   r=r+1;
                }
                
               else if (integers[i]<=0 || integers[i]>=15) //else if numbers inside array integers are smaller or equal to 0 and bigger or equal to 15
               {                                           //Display the message below
                 System.out.println("You are not allowed to enter integers less than 0 and bigger than 15.Please try again:"); 
                 continue; 
                }
                
                if (r==5) //when r=5  jump out of the loop
                {
                    break; 
                }
             }
             averageOfTheFiveNumbers=sum2/5; //finding the average of the five numbers by substracting the value inside sum2 by 5 
                                             //and throwing it inside the container named averageOfTheFiveNumbers
             System.out.println("The average of the 5 integers you entered is " +averageOfTheFiveNumbers); //Displaying the average
             
              for (int i=0;i<Math.round(averageOfTheFiveNumbers);++i) //loop used to find the factorial of the number that is closest to the average
             {
              round_value=Math.round(averageOfTheFiveNumbers); //since the number that we want to find is closest to the average,
                                                               //we can round up the average of the five numbers to find the number that is closest to the average
              factorial=factorial*(round_value-i); //finding the factorial by multipling what is inside round_value with the same number inside round value 
                                                   //but decreased by i and storing it inside factorial container
                                                   //this porcess will be done as many times as the rounded average of the five numbers
             }
             System.out.println("The factorial of the integer which is closest to the group's average is: "+factorial); //Displaying the factorial
              
             System.out.println(" ");   //creating spaces between Menu3 and the Menu table that is going to display again 
             System.out.println(" ");   
           }
          
         
        
          if (menu==4) // using if statements to devide each menu from each other
           {
               //declaring,initializing variables and arrays
               String inData3=null;
               int [] random_num=new int [100];
               int k=0; 
               int j=0;
               
              System.out.println("Thank you,you have chosen Menu 3");  //Java statement that prints the argument passed
              System.out.println("This program picks a random integer between 0 and 65 and then asks you to guess what it is. Every time you miss a guess the program tells you if your guess was higher or lower than the target number.");
              
              Random rand=new Random();  
              
              int n=rand.nextInt(65);//Obtain a number between 0 and 64//
              n+=1;//add one result to get a number from the required range
              
               System.out.println("Please add an integer"); //Java statement that prints the argument passed
             
              
              for (int i=0;i<200;++i) // loop that will be used to find the random number
               {
                 inData3=br.readLine(); //throws user input inside inData3
                 random_num[i]=Integer.parseInt(inData3); // Transforming Strings of the user input inside inData3 to Integers and throwing them inside 
                                                          //array labeled random_num[i]
                 if (random_num[i]<0) //if number that we have entered inside array is smaller than zero display message below(error output) and increase
                 {                    //k by one
                     System.out.println("Sorry,negative integers  are not allowed! Please enter a positive integer and try again!");
                     k=k+1;
                     continue;
                    }
                 
                 if (random_num[i]>n) //if number that we have entered inside array is bigger than the generated random number
                 {                    //Display the message below
                    System.out.println("Your integer is bigger than the random number that you need to find.Try again!");
                    }                       
                                               //if number that we have entered inside array is smaller than the generated random number
                 else if (random_num[i]<n)     //Display the message below
                 {
                     System.out.println("Your integer is smaller than the random number that you need to find.Try again!");
                    }
                 
                  j=i+1-k; // doing calculations and adding them inside variable j to find the number of times that I took to find the random number
                 
                 if (random_num[i]==n)  //if number that we have entered inside array is equal to the generated random number
                 {                      //Display the message below and jump  out of the loop
                     System.out.println("Congratulations!You found the random number");
                     System.out.println("It took you " +j+ " times to find the random number");
                     break;
                    } 
              
                }
                
                  System.out.println(" ");    //creating spaces between Menu4 and the Menu table that is going to display again 
                  System.out.println(" ");  
            }
            
          if (menu==5)  // using if statements to devide each menu from each other
           {
              System.out.println("Thank you,you have chosen Menu 5");  //Java statement that prints the argument passed
              System.out.println("In this menu all automorphic numbers between 0 and 10000 are displayed");
              System.out.println("Here are the automorphic numbers:");
              
              //Declaring and initializing variables
              int length=0; 
              int mathpower=0;
              
               for (int i=0;i<10000;++i) //using loop to find the automorphic numbers between 0 to 1000
                {
                   length=Integer.toString(i).length(); //Transforming Integer i to String and than finding its length.Than this length number will
                                                        //be thrown inside container labeled length
                   mathpower=(int)Math.pow(i,2); // Squaring integer i and throwing it inside container labeled mathpower
                   int remeinder=mathpower % (int)Math.pow(10,length); //finding remainder by deviding the value inside container labeled mathpower with the 10 in power the value
                                                                //inside length container
                   
                     if (i==remeinder) //if integer i is equal to the value inside container labeled remeinder
                                   //Display i or the automorphic number
                     {
                             System.out.println(+i); 
                    }
                
                }
                
              System.out.println(" ");   //creating spaces between Menu5 and the Menu table that is going to display again 
              System.out.println(" ");   
            }
            
          if (menu==6)  // using if statements to devide each menu from each other
          {
             System.out.println("Thank you,you have chosen Menu 6"); //Java statement that prints the argument passed
             System.out.println("This menu displays Pythagorean triples involving integers with a hypotenuse value smaller or equal to 100");
             
             //Declaring,initializing variables and arrays  
             int []hypotenuse=new int[100];
             int []leg1=new int[100];
             int []leg2=new int[100];
             int []leg1New=new int[100];
             int []leg2New=new int[100];
             int []hypotenuseNew=new int[100];
             int []valuesexceptions={3,5,11,13,57,51,21,35};//values that are needed to make calculations to find the primitive triplets are put inside an array
             int []valuesexceptions1={57,51,35}; //values that are needed to make calculations to find the primitive triplets are put inside an array
           
           int l=0;
           if (l<3) //if l<3 increase the l by one. l will be used later to go through all the values inside array valuesexceptions1
           {
               ++l;
            }
           int j=0;
           if (j<8) //if j<8 increase the j by one. j will be used later to go through all the values inside array valuesexceptions
           {
               j=j++;
            }
           
           for (int a=1;a<100;++a) //using neseted loops to find all the possible pythagorean triples
           {
            for (int b=1;b<100;++b)
             {
              for (int c=1;c<100;++c)
               {
                 
                if (a==Math.sqrt((c*c)-(b*b)) && c%2!=0 && a<b && (a+b)%3!=0 && (a+b)%5!=0 && (a+b)%11!=0 && (a+b)%13!=0 && a!=21 && a!=57 && a!=51 && a!=35)  
                                                                                                   //using if statement to find only the primitive triplets
                                                                                                   //if this condition happens,throw inside the array labeled hypotenuse
                                                                                                   //value c, inside array labeled leg2 the b value and inside the array 
                                                                                                   //labeled leg1 value a
                     {                                                                          
                     hypotenuse[a]=c;
                     leg2[a]=b;
                     leg1[a]=a;
                     
                     {
                      System.out.println(leg1[a]+" "+leg2[a]+ " "+hypotenuse[a]); //Display values inside array leg1 leg2 and hypthenuse
                     }                                                            
                     
                     
                    }
                  
                 if (a==Math.sqrt((c*c)-(b*b)) && c%2!=0 && b>a && (a+b)%3!=0 && (a+b)%5!=0 && (a+b)%11!=0 && (a+b)%13!=0 && a!=21 && a!=57 && a!=51 && a!=35 ) 
                                                                                         //using if statement to find duplicates
                  {                                                                      //if this condition happens,throw inside the array labeled hypotenuse
                                                                                         //value c, inside array labeled leg2New the a value and inside the array 
                                                                                         //labeled leg1New value b
                     hypotenuseNew[a]=c;
                     leg2New[a]=a;
                     leg1New[a]=b;
                     System.out.println("["+leg1New[a]+ " "+leg2New[a]+ " "+hypotenuseNew[a]+"]"); //Display duplicates
                   }     
                   
                 if (a==Math.sqrt((c*c)-(b*b)) && c%2!=0 && a<b && (a+b)%3!=0 && (a+b)%5!=0 && (a+b)%11!=0 && (a+b)%13!=0 && a!=21 && a!=57 && a!=51 && a!=35) //using if statement to find the multiples )
                  {
                     hypotenuse[a]=c;
                     leg2[a]=b;
                     leg1[a]=a;
                     for (int i=2;i<5;++i) //using loop to multiply each array that contains the primitive values 
                     {                     //with 2 than 3 than 4 than 5, in order to find the multiples 
                      {
                        System.out.println("["+i*leg1[a]+" "+i*leg2[a]+ " "+i*hypotenuse[a]+"]"); //Display multiples
                      }
                     }
                    
                    }
                   
                 }
                  
               }   
            } 
            
             System.out.println(" ");  //creating spaces between Menu6 and the Menu table that is going to display again    
             System.out.println(" ");   
          }        
           
	  //Declaring and initializing variables                          
          int exit=1;
          int type_exit=0;
          String inData4=null; 
         
          if (menu==7) // using if statements to devide each menu from each other
          {
             System.out.println("This is the menu to exit the program"); //Java statement that prints the argument passed
             System.out.println("Tap 1 to exit");
             do{ //repeat the loop till the user taps 1
               inData4=br.readLine();//reads user input and throws it inside inData4
               type_exit=Integer.parseInt(inData4); //the Strings enetered by user and stored inData4 will be transformed into integers and will be thrown
                                                    //inside container labeled type_exit
               if (exit==type_exit) //if user taps 1 jump out of the loop
               {
                   break;
                }
               else if (exit!=type_exit) //if user taps a number different from 1 repeat the loop and display the message below
               {
                   System.out.println("You did not tap 1.Please try again");
                }
           
              }while (exit!=type_exit);//end of the loop
              
              System.out.println(" "); //creating spaces between Menu6 and the Menu table 
              System.out.println(" ");   
           }
          } while (menu<7); //end of the main loop
    
     }
 }

