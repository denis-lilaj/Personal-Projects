<?php


   function connect_sql()
   {
       $server="localhost";
       $username="root";
       $passowrd="";

       $mysqlconn=mysqli_connect($server,$username,$passowrd);
       return $mysqlconn;
    }



    function connect_to_database()
    {
        $server="localhost";
        $username="root";
        $password="";
        $db_name="User_LogIn";

        $db_conn=mysqli_connect($server,$username,$password,$db_name);
        return $db_conn;
    }



    function Validate($db_conn,$Email,$Password)
    {
        $sql="select * from user_register";
        $Validate=false;
        $result=mysqli_query($db_conn,$sql);
       
       
            while($row=mysqli_fetch_assoc($result))
            {

            if ($row['email']==$Email && $row['pass_word']==$Password)
            {
                $Validate=true;
                return $Validate;
            }

          }
        

       return $Validate;
    }


    function getUserID($db_conn,$Email,$Password)
    {
        $sql="select * from user_register";
        $UserID="";

       if($result=mysqli_query($db_conn,$sql))
       {
        foreach ($result as $row)
        {
            if($row['email']==$Email && $row['pass_word']==$Password)
            {
                $UserID=$row['id'];
                
            }
        }
       }

        return $UserID;
    }

 

?>