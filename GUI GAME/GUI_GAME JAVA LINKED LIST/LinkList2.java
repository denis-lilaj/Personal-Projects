public class LinkList2
{
  
    Node first;
    int length;
    Node temp1;
  
   
   
    public LinkList2()
    {
        first = null;
    }

   
    
    
    public void insertFirst(int key)
    {

    	Node newNode = new Node(key);

        newNode.next = first;

        first = newNode;
    }
    
    
    
     
    public void fill(int fill)
    {
    	length=fill;
    	
    	for (int i=fill;i>0;i--)
    	{
    		insertFirst(i);
    	}
    }
    
    
     
    
    public Node temp1(int index)
    {	
       	 int count=1;
       	
       	 Node temp=first;
       
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
         
    	
      
    
      public Node Move(int index)
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
      
//////////////////////////////////////////////////////////////////////////////////////////      
     
      public Node deleteFirst()
      {
         if ( first==null )
         {
             System.out.println("List Empty! Deletion aborted...");
             return null;
         }
         
         else
         {
           
             Node todelete = first;
             
             temp1=first.next;
             
             first = first.next;
           
             return todelete;
         }
      }
      
      
     
      
      public void delete(int key)
      {
          if ( first.key == key )
          {
              deleteFirst();
              length--;
          }
         
          else
          {
              Node temp = first;
         
              while (temp.next != null)
              {
                  if ( temp.next.key == key ) 
                  {
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
    
//////////////////////////////////////////////////////////////////////////////////////////       
    
    
   
      
      
      
    public void display()
      {
        Node temp = first;
        
        
        System.out.println("=-=-=-=-= Linked List =-=-=-=-=-=");

        
        while ( temp != null )
        {

        	temp.display();
        

        	temp = temp.next;
        }
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
     }
    
    
}
