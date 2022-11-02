<?php
    require "../AddToChart/dbconfig.php";
   
    $CardRow=$_GET["deleteID"];
    $dbconn=connect_to_database();
    Buyers_Product_Delete($dbconn,$CardRow);
 

?>