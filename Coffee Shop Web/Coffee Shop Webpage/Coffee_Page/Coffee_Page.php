<?php
   require "../AddToChart/dbconfig.php";
   $sql_connect=connect_sql();
   create_database($sql_connect);
   $db_conn=connect_to_database();
   create_Coffee_Products($db_conn);
   $StoreUserID=$_GET["UserID"];
   $Password=$_GET["Password"];   
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../Coffee_Page/Coffee_Page.css">
    <link rel="stylesheet" href="../CSS_For_All_Pages.css">
    <style>
       .submit{
          background-color: burlywood;
          margin-left: 110px;
       }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script>
      $(document).ready(function(){

        $(".CoffeeBag").on("click","input[type=submit]",function(){
           ProductId=$(this).next().text();
           $("#ProductID").val(ProductId);    
         })      
         
         $("#ChartForm").submit(function(e){
                     $.ajax({
                           url:"../AddToChart/Chart.php",
                           data:{UserID:$("#UserID").val(),ProductID:$("#ProductID").val()},
                           success: function(response){
                              alert("Product was addedd successfully");
                             }
                      })
                  e.preventDefault();
               })  
          
         $("#checkout").click(function(){
              $("ShowChart").submit(); 
         })    
            
         })
        
    </script>
</head>

<header>
    <img src="../Logo.png" width="300px" height="250px" alt="">
</header>


<nav>
    <ul>
       <div id="LeftSideNav">
         <li><a href="../Main_Page/Coffee_Shop_Main_Page.html">Home</a></li>
         <li hidden><a href="../Coffee_Page/Coffee_Page.php">Coffee</a></li>
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
   
   <div id="BigContainer">

    <h1>Introducing you with the best coffee beans in our country...</h1>
     
         <div class="CoffeeBag">
          <img src="Almond-Love.png" alt="">
          <p>14.5 <span style="color: #744c25;">$</span></p>
          <input type="submit" value="AddToChart" form="ChartForm" class="submit">
          <span class="id">1</span>
        </div>

        <div class="CoffeeBag">
           <img src="Billy-Goat_8351ef9e-ad79-4868-a7ec-9e364271da6b.png" alt="">
           <p>16.2 <span style="color: #744c25;">$</span></p>
           <input type="submit" value="AddToChart" form="ChartForm" class="submit">
           <span class="id">2</span>    
         </div>

        <div class="CoffeeBag">
           <img src="Black-Forest.png" alt="">
           <p>14.5 <span style="color: #744c25;">$</span></p>
           <input type="submit" value="AddToChart" form="ChartForm" class="submit">
           <span class="id">3</span>  
         </div>

        <div class="CoffeeBag">
           <img src="Black-Gold_a675f097-908e-468f-bc86-025699828db3.png" alt="">
           <p>20 <span style="color: #744c25;">$</span></p>
           <input type="submit" value="AddToChart" form="ChartForm" class="submit">
           <span class="id">4</span>  
        </div>

        <div class="CoffeeBag">
           <img src="Candy-Bar.png" alt="">
           <p>15.3 <span style="color: #744c25;">$</span></p>
           <input type="submit" value="AddToChart" form="ChartForm" class="submit">
           <span class="id">5</span>  
        </div>

       <div class="CoffeeBag">
          <img src="ChristmasBlend-01.png" alt="">
          <p>12 <span style="color: #744c25;">$</span></p>
          <input type="submit" value="AddToChart" form="ChartForm" class="submit">
          <span class="id">6</span>  
       </div>

       <div class="CoffeeBag">
          <img src="Lucky-7.png" alt="">
          <p>12 <span style="color: #744c25;">$</span></p>
          <input type="submit" value="AddToChart" form="ChartForm" class="submit">
          <span class="id">7</span>  
       </div>

       <div class="CoffeeBag">
          <img src="EthiopiaARDI.png" alt="">
          <p>14 <span style="color: #744c25;">$</span></p>
          <input type="submit" value="AddToChart" form="ChartForm" class="submit">
          <span class="id">8</span>  
      </div>

      <input type="submit" value="checkout" id="checkout" style="margin-left: 400px; width:300px ;background-color:burlywood" form="ShowChart" >
  </div>

  

  <form id="ChartForm" action="../AddToChart/Chart.php"  method="GET" >
     <input type="text" id="UserID" name="UserID" value="<?php echo $StoreUserID?>" hidden>
     <input type="text" id="ProductID" name="ProductID" hidden> 
  </form>

  <form id="ShowChart" action="../AddToChart/ShowChart.php"  method="GET" >
     <input type="text" id="UserID" name="UserID" value="<?php echo $StoreUserID?>" hidden>
     <input type="text" id="Password" name="Password" value="<?php echo $Password?>" hidden>   
  </form>


</body>


    <footer>
        
        <h1>Follow us on our social medias:</h1>
            <ul>
                <li><a href="">Facebook</a></li>
                <li><a href="">Instagram</a></li>
                <li><a href="">Twitter</a></li>
            </ul>
        
    </footer>

</html>