<?php
   require "dbconfig.php";
   $UserID=$_GET['UserID'];
   $NewPassword=$_GET['NewPassword'];
   $db_conn=connect_to_database_register();

   Update_Password($db_conn,$UserID,$NewPassword);



?>