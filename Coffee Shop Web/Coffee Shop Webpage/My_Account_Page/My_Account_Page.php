<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../CSS_For_All_Pages.css">
    <link rel="stylesheet" href="My_Account_Page.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
      $(document).ready(function(){
          $("#AuthenticatesForm").submit(function(e){
          {
               if ($("#FirstText").val()=="")
                {
                  $("#EmailSpan").text("Please enter your first email");
                  e.preventDefault();
                }
                
                else if (!$("#EmailSpan").val()=="")
                {
                  $("#SpanFirstName").text("");
                }

                if ($("#SecondText").val()=="")
                {
                  $("#PasswordSpan").text("Please enter your password");
                  e.preventDefault();
                }

                else if (!$("#SecondText").val()=="")
                {
                  $("#PasswordSpan").text("");
                }

          }
      })
    })
    </script>
</head>
<body>
    <header>
        <img src="../Logo.png" width=300px height="250px" alt="">
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

    <main>
      
        <h1>Account</h1>

        <p id="AccountP">Don't have an account? Click here to <a href="../Account_Registation/My_Account_Registration_Page.php">register</a> .</p>
    
    
       <div id="LogInContainer">
          <form action="Authenticates.php" id="AuthenticatesForm">
               
               <fieldset>
                    
                    <legend>LogIn</legend>
                    
                    <table id="LogIn">
                        <tr>
                          <td>
                             <p> Email address * </p>
                          </td>
                        </tr>
                        
                    
                        <tr>
                          <td>
                             <p> <input type="text" id="FirstText" name="EMail"> </p>
                             <p><span id="EmailSpan"></span></p>
                          </td>
                        </tr>
                       
                       
                        <tr>
                          <td>
                             <p> Password </p>
                           </td>  
                        </tr>
                        
                        <tr>
                           <td>
                             <p> <input type="text" id="SecondText" name="Password"></p>
                             <p><span id="PasswordSpan"></p>
                           </td>
                        </tr>
                       
                        <tr>
                            <td>
                               <p><input type="checkbox" id="checkbox" value="Remember me">Remember me</p>
                            </td>
                        </tr>

                        <tr>
                           <td>
                            <input type="submit" id="Button" value="Log In">
                          </td>
                        </tr> 
                   
                    </table>
                
                </fieldset>
          
            </form>

           <img src="Log-In.png" alt="">
       </div>
    </main>
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