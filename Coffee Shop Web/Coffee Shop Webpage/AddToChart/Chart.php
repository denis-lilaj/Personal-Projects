<?php
    require "dbconfig.php";

     $UserID=$_GET["UserID"];
     $ProductID=$_GET["ProductID"];
     

     $conn=connect_sql();
     create_database($conn);
     $dbconn=connect_to_database();

     createProduct_Buyers($dbconn);
     insert_Product_Buyers($dbconn,$ProductID,$UserID);
     
     $AllPrices=Calculate_All_Products($dbconn,$UserID);
     $CountProd=Count_All_Products($dbconn,$UserID);
     
     
   

?>


