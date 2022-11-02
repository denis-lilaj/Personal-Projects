<?php

use LDAP\Result;

   function connect_sql_register()
   {
       $server="localhost";
       $username="root";
       $passowrd="";

       $mysqlconn=mysqli_connect($server,$username,$passowrd);
       return $mysqlconn;
    }


    function create_database_register($mysqlconn)
    {
        $db_name="User_LogIn";
        $sql="create database if not exists $db_name";
        mysqli_query($mysqlconn,$sql);
    }


    function connect_to_database_register()
    {
        $server="localhost";
        $username="root";
        $password="";
        $db_name="User_LogIn";

        $db_conn=mysqli_connect($server,$username,$password,$db_name);
        return $db_conn;
    }


    function createRegisterTable($db_conn)
    {
        $sql="create table if not exists user_register( id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        firstname VARCHAR(30) NOT NULL, lastname VARCHAR(30) NOT NULL, email VARCHAR(30) NOT NULL , pass_word VARCHAR(30) NOT NULL);
        ";
        mysqli_query($db_conn,$sql);
    }


    function StoreUserData($db_conn,$user_first_name,$user_last_name,$user_email,$user_password)
    {  
	    $sql="insert into user_register (firstname,lastname,email,pass_word) values('$user_first_name','$user_last_name','$user_email','$user_password')";
        mysqli_query($db_conn,$sql);
    }


    function Validate($db_conn,$Email,$Password)
    {
        $sql="select * from user_register";
        $Validate=false;
       
        if($result=mysqli_query($db_conn,$sql))
        {  
            $row=mysqli_fetch_assoc($result);

            if ($row['email']==$Email && $row['pass_word']==$Password)
            {
                $Validate=true;
            }

            else if($row['email']!=$Email && $row['pass_word']!=$Password)
            {
                $Validate=false;
            }
        }
    }


    function Update_Password($db_conn,$UserID,$NewPassword)
    {
        $sql="update user_register set pass_word='$NewPassword' where id='$UserID'";
        mysqli_query($db_conn,$sql);
    }


 

?>