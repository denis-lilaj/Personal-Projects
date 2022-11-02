public class LinkList2String
{
  
    Node2 first;
    int length;
    Node2 temp1;
    String [] names= {"Jessica", "Jim", "Marius", "George", "Marlon", "Emily" ,"Tim","Britney","Sam","Ben","Elena","Tony","Frensis","Henry","Paoloa","Madison","Doris"};
    Node2 displaydeleted;
  
   
   
    public LinkList2String()
    {
        first = null;
    }

   
    
    
    public void insertFirst(String key)
    {

    	Node2 newNode = new Node2(key);

        newNode.next = first;

        first = newNode;
    }
    
    
    
     
    public void fill(int fill)
    {
    	length=fill;
    	
    	for (int i=fill-1;i>=0;i--)
    	{
    		insertFirst(names[i]);
    	}
    }
    
    
     
    
    public Node2 temp1(int index)
    {	
       	 int count=1;
       	
       	 Node2 temp=first;
       
       	 while(count!=index)
         {
       	  if (temp.next!=null)
       	  {
       	   count++;
       	   temp=temp.next;
       	  }
       	  
       	 
       	   else if (temp.next==null)
       	   {
       		count++;
       	    temp=first;
       	   }
         }
       	   
       	   temp1=temp;
       	   return temp;
        } 
         
    	
      
    
      public Node2 Move(int index)
      {
    	
    	 int count=1;
    	
    	
    	 while(count!=index)
    	{
    	  if (temp1.next!=null)
    	  {
    	   count++;
    	   temp1=temp1.next;
    	  }
    	  
    	 
    	  else if (temp1.next==null)
    	  {
    		count++;
    	    temp1=first;
    	  }
        }
    	
    	 return temp1;
      } 
      

      
      
      public Node2 deleteFirst()
      {
         if ( first==null )
         {
             System.out.println("List Empty! Deletion aborted...");
             return null;
         }
         
         else
         {
           
             Node2 todelete = first;
             
             displaydeleted=first;
             
             temp1=first.next;
             
             first = first.next;
           
             return todelete;
         }
      }
      
      
     
      
      public void delete(String key)
      {
          if ( first.key.equals(key) )
          {
              deleteFirst();
              length--;
          }
         
          else
          {
              Node2 temp = first;
         
              while (temp.next != null)
              {
                  if ( temp.next.key == key ) 
                  {
                	  displaydeleted=temp.next;
                	  
                	  temp1=temp.next.next;
                	  
          
                	  temp.next = temp.next.next; 
                	  
                	  
                	  if (temp.next==null)
                      {
                   	  temp1=first;
                      }
                	  
      
                	  length--;
                 
                  }
                  
                  else
                  {
                      temp = temp.next;
                  }
              } 
          }
      }
        
    
   
      
      
      
    public void display()
      {
        Node2 temp = first;
        
        
        System.out.println("=-=-=-=-= People at the gathering =-=-=-=-=-=");

        
        while ( temp != null )
        {

        	temp.display();
        

        	temp = temp.next;
        }
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
     }
    
    
}
