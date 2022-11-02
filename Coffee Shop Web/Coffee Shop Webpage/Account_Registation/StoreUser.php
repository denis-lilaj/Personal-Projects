<?php
     require "dbconfig.php";
     $user_first_name=$_GET["FirstName"];
     $user_last_name=$_GET["LastName"];
     $user_email=$_GET["EMail"];
     $user_password=$_GET["Password"];
     $connect_to_sql=connect_sql_register();
     create_database_register($connect_to_sql);
     $connect=connect_to_database_register();

     createRegisterTable($connect);
     
        if(isset($user_first_name) && isset($user_last_name) && isset($user_email) && isset($user_password))
        {
        StoreUserData($connect,$user_first_name,$user_last_name,$user_email,$user_password);

        header("location:My_Account_Registration_Page.php");
       
        }
?>