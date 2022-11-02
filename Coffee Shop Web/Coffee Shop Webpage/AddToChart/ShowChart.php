<?php
    require "dbconfig.php";
    require "../Account_Registation/dbconfig.php";
    
     $UserID=$_GET["UserID"]; 
     $Password=$_GET["Password"];
     $conn=connect_sql();
     create_database($conn);
     $dbconn=connect_to_database(); 
     $AllPrices=Calculate_All_Products($dbconn,$UserID);
     $CountProd=Count_All_Products($dbconn,$UserID);

     $conn1=connect_sql_register();
     $dbconn1=connect_to_database_register();
    
    

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../AddToChart/Chart.css">
    <link rel="stylesheet" href="../CSS_For_All_Pages.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <style>
        .StylingCharts{
            height: 170px;
            width: 120px;
            margin-left: 35px;
            margin-top:40px;
        }



        #ShoppingChart{
           width: 300px;
           height: 250px;
           position: relative;
           left: 400px;
           bottom: 40px;
           margin-right: 50px;
        }
    </style>
     
    <script>
        $(document).ready(function(){
            var cardID;
            var NewPassword;
            var PHPPassword="<?php echo $Password ?>";
            
            
            $(".StylingCharts").on("click",".DeleteB",function(){
              cardID=$(this).next().val();
              $("#deleteID").val(cardID);    
            })

            
            $("#SubmitDelete").submit(function(e){
                     $.ajax({
                           url:"../AddToChart/Delete.php",
                           data:{deleteID:$("#deleteID").val()},
                           success: function(response){
                              alert("Product was deleted successfully. Please refresh the page to see the results");
                             }
                      })
                  e.preventDefault();
               })  
              
            $("#LogOut").click(function(){
                  window.location.replace("../My_Account_Page/My_Account_Page.php");       
            })


            $("#ChangePassword").click(function(){
               $("#ResetPassword").show();
               })


            $("#SubmitPass").click(function(e){
               NewPassword=$("#NewPassword").val();

               if($("#OldPassword").val()!=PHPPassword)
               {
                 $("#span").show();
                 e.preventDefault();
               } 

               else if($("#OldPassword").val()==PHPPassword)
               {
                  $("#span").hide();
                  $("#PasswordForm").submit(function(e){
                           $.ajax({
                                 url:"../Account_Registation/UpdateUserPassword.php",
                                 data:{UserID: $("#UserID").val(),NewPassword:$("#NewPassword").val()},
                                 success: function(response){
                                    alert("Password Changed Successfully");
                                    $("#NewPassword").prop("readonly",true);
                                    $("#NewPassword").val("Refresh To Reset Pass");
                                 }
                           })
                        e.preventDefault();
                     })  
               }
          }) 
        })       
    </script>
</head>

<header>
    <img src="../Logo.png" width=300px height="250px" alt="">
</header>


<nav>
    <ul>
       <div id="LeftSideNav">
         <li><a href="../Main_Page/Coffee_Shop_Main_Page.html">Home</a></li>
         <li><a href="../Coffee_Page/Coffee_Page.php">Coffee</a></li>
         <li><a href="../Merchandise_Page/Merchandise_Page.html">Merchandise</a></li>
         <li><a href="../Equipment_Page/Equipment_Page.html">Equipment</a></li>
         <li><a href="../Gift_Page/Gift_page.html">Gifts</a></li>
         <li><a href="../My_Account_Page/My_Account_Page.php">My Account</a></li>
       </div>

       <div id="RightSideNav">
         <li><a href="../Contact_Page/Contact_Page.html">Contact</a></li>
         <li><a href="../Locations_Page/Locations_Page.html">Locations</a></li>
         <li><a href="../About_Us_Page/About_Us_Page.html">About Us</a></li>
       </div>
   </ul>
</nav>

<body>
      <div id="BigContainer" style="height: 1100px;">
        <div id="LogOutContainer">
           <input type="button" value="LogOut" id="LogOut">
        </div>
        
        <img src="Shopping_Chart.png" alt="ShoppingChart" id="ShoppingChart">

        <?php 
           if(isset($UserID))
           {
               $UserID=$_GET["UserID"];
               $sql="select * from user_register where id='$UserID' ";
               $result=mysqli_query($dbconn1,$sql);
               while($row=mysqli_fetch_assoc($result))
               {       
            ?>
            <div style="margin-left: 30px;">
              <h2>FullName: <?php echo $row["firstname"] ." ".$row["lastname"]; ?></p>
              <h2>E-Mail:<?php echo $row["email"]; ?></p>
              <input type="button" id="ChangePassword" value="ChangePassword" style="margin-left: 120px;">         
            </div>
       <?php	
       }        
      }
      ?>

           <div style="margin-left: 30px;" hidden id="ResetPassword">
             <form action="../Account_Registation/UpdateUserPassword.php" id="PasswordForm">
                <p>Confirm Old Password: <input type="text" id="OldPassword" name="OldPassword"> <span id="span" hidden>Please insert the correct Password!</span></p>
                <p>Enter New Password: <input type="text" id="NewPassword" name="NewPassword"></p>
                <p><input type="submit" id="SubmitPass" value="Submit"></p>
                <input type="text" name="UserID" id="UserID" value="<?php echo $UserID ?>" hidden>
              </form>
           </div>
   

        <?php 
           if(isset($UserID))
           {
               $UserID=$_GET["UserID"];
               $sql="select * from product_buyers  where userID='$UserID' ";
               $result=mysqli_query($dbconn,$sql);
               while($row=mysqli_fetch_assoc($result))
               {       
            ?>
         <div style="border:2px solid black;width:250px;" class="StylingCharts">
              <p>Product Name: <?php echo $row["ProductName"]; ?></p>
              <p>Price:<?php echo $row["Price"]; ?></p>
              <input type="submit" class="DeleteB" value="Delete" form="SubmitDelete">       
              <input type="text" name="CardId" id="CardId" value="<?php echo $row["id"]; ?>" hidden>        
         </div>     
       <?php	
       }        
      }

      if(isset($UserID))
           {  
            ?>
         <div style="border:2px solid black;width:250px;" class="StylingCharts">
              <h2>Total Products</h2>
              <p>NumberOfBags: <?php echo $CountProd; ?></p>
              <p>TotalPrice:<?php echo $AllPrices; ?></p>
         </div>
       
       <?php	
       }
    ?>   
      </div>

      <form action="../AddToChart/Delete.php" id="SubmitDelete" method="GET">
         <input type="text" name="deleteID" id="deleteID" value="" hidden>
      </form>
</body>

   <footer style="background-color: gray; height:30px">
      <p style="margin-top: 0px; margin-left:500px; padding-top:4px">Shopping Chart</p>
   </footer>
</html>