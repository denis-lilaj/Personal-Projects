<?php
   require "dbconfig.php";
   $Email=$_GET["EMail"];
   $Password=$_GET["Password"];
   $connect=connect_to_database();
   $Authenticate=Validate($connect,$Email,$Password);

   if ($Authenticate==true)
   {
      echo '<script>alert("Successfull attempt. Redirecting to Products page!")</script>';
   }

   if ($Authenticate==false)
   {
      echo '<script>alert("Invalid username or password")</script>';
   } 

   if ($Authenticate==false)
   {
      header("location:My_Account_Page.php");
   } 


   $StoreUserID=getUserID($connect,$Email,$Password);

  
?>



<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Document</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <script>
      $(document).ready(function(){
         $("#Authenticates").submit();
      })
   </script>
</head>
<body>
    <form action="../Coffee_Page/Coffee_Page.php" method="GET" id="Authenticates">
       <input type="text" name="UserID" id="UserID" value=<?php echo $StoreUserID?>>
       <input type="text" name="Password" id="Password" value=<?php echo $Password?>>
    </form>
</body>
</html>








   

