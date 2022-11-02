<?php

   function connect_sql()
   {
       $server="localhost";
       $username="root";
       $passowrd="";

       $mysqlconn=mysqli_connect($server,$username,$passowrd);
       return $mysqlconn;
    }


    function create_database($mysqlconn)
    {
        $db_name="Coffee_Chart";
        $sql="create database if not exists $db_name";
        mysqli_query($mysqlconn,$sql);
    }


    function connect_to_database()
    {
        $server="localhost";
        $username="root";
        $password="";
        $db_name="Coffee_Chart";

        $db_conn=mysqli_connect($server,$username,$password,$db_name);
        return $db_conn;
    }



    function create_Coffee_Products($db_conn){
      $sql="create table if not exists CoffeeProducts( ProductID INT(12) PRIMARY KEY, ProductName VARCHAR(12) , Price INT(12) )";
      mysqli_query($db_conn,$sql);
    }


     function createProduct_Buyers($db_conn)
    {
       $sql="create table if not exists Product_Buyers( id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
            ProductName VARCHAR(11) , Price DECIMAL(4) , userID INT(11))";
            mysqli_query($db_conn,$sql);
    }



    function insert_Product_Buyers($db_conn, $ProductID, $UserID)
    {      
     $sql="select * from coffeeproducts";
     
     $result=mysqli_query($db_conn,$sql);

     if($result=mysqli_query($db_conn,$sql))
     {
         foreach($result as $row)
         {

         if ($row['ProductID']==$ProductID)
         {
             $ProductName=$row['ProductName'];
             $ProductPrice=$row['Price'];
         }
        
      }
       $sql="insert into Product_Buyers (ProductName, Price, userID) VALUES ('$ProductName','$ProductPrice','$UserID')";
       mysqli_query($db_conn,$sql);  
       }
    }


       function Buyers_Product_Delete($db_conn,$CardRow)
       {
        $sql="select * from Product_Buyers";
     
        $result=mysqli_query($db_conn,$sql);
   
        if($result=mysqli_query($db_conn,$sql))
        {
            foreach($result as $row)
            {
               if ($row['id']==$CardRow) 
               {
                   $sql="delete from Product_Buyers where id=$CardRow";
                   mysqli_query($db_conn,$sql);
               }
            }


       }
    
    }




    function Calculate_All_Products($db_conn,$UserID)
       {
        $sql="select * from Product_Buyers";
        $resultPrice=null;
        $result=mysqli_query($db_conn,$sql);
   
        if($result=mysqli_query($db_conn,$sql))
        {
            foreach($result as $row)
            {
               if($row['userID']==$UserID)
               {
                  $sql="select userID, sum(Price) from Product_Buyers where userID='$UserID' ";
                  $resultPrice=mysqli_query($db_conn,$sql);

                  if($resultPrice=mysqli_query($db_conn,$sql))
                  { 
                     foreach($resultPrice as $row)
                      {        
                        return $row['sum(Price)']; 
                     }      
                  }
                  
               }
            }
       }

       return 0;
    
    }




    function Count_All_Products($db_conn, $UserID)
       {
           $sql="select * from Product_Buyers where userID=$UserID ";
           $count=null;
           $result=mysqli_query($db_conn,$sql);
           if($result=mysqli_query($db_conn,$sql))
             {
                 $count=mysqli_num_rows($result);
                 return $count;
              }  
            return $count;
      }

?>

     


      

