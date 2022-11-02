<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../CSS_For_All_Pages.css">
    <link rel="stylesheet" href="My_Account_Registration_Page.css">
    <style>
      span{
        color: red;
      }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
      $(document).ready(function(){
       $("#Register_Form").submit(function(e){
        if ($("#FirstText").val()=="")
        {
           $("#SpanFirstName").text("Please enter your first name");
           e.preventDefault();
        }
        
        else if (!$("#FirstText").val()=="")
        {
          $("#SpanFirstName").text("");
        }

        if ($("#SecondText").val()=="")
        {
           $("#SpanLastName").text("Please enter your last name");
           e.preventDefault();
        }

        else if (!$("#SecondText").val()=="")
        {
          $("#SpanLastName").text("");
        }

        if ($("#ThirdText").val()=="")
        {
           $("#SpanEmail").text("Please enter your email");
           e.preventDefault();
        }

        else if (!$("#ThirdText").val()=="")
        {
          $("#SpanEmail").text("");
        }


        if ($("#FourthText").val()=="")
        {
           $("#SpanPassword").text("Please enter your password");
           e.preventDefault();
        }

        else if (!$("#FourthText").val()=="")
        {
          $("#SpanPassword").text("");
        }


        if (!$("#FirstText").val()=="" && !$("#SecondText").val()=="" && !$("#ThirdText").val()=="" && !$("#FourthText").val()=="")
        {
           alert("User added successfully");
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

    <main>
      
        <h1>Account Registration</h1>    
    
       <div id="RegisterContainer">
          <form id="Register_Form" name="Register_Form" action="StoreUser.php" method="GET">
               
               <fieldset>
                    
                    <legend>Register</legend>
                    
                    <table id="Register">
                        <tr>
                          <td>
                             <p> First Name*</p>
                          </td>

                          <td>
                              <p> Last Name*</p>
                          </td>
                        </tr>
                        
                    
                        <tr>
                          <td>
                             <p> <input type="text" id="FirstText" class="FullName" name="FirstName"> </p>
                             <p><span id="SpanFirstName"></span></p>
                          </td>

                          <td>
                            <p> <input type="text" id="SecondText" class="FullName" name="LastName">  </p>
                            <p><span id="SpanLastName"></span></p>
                         </td>
                        </tr>
                       
                       
                        <tr>
                           <td colspan="2">
                             <p> Email address* </p>
                           </td>  
                        </tr>
                        
                        <tr>
                           <td colspan="2">
                             <p><input type="email" id="ThirdText" class="FillCol" name="EMail" ></p>
                             <span id="SpanEmail"></span>
                           </td>
                       </tr>
                       
                        <tr>
                            <td colspan="2">
                               <p>Password*</p>
                            </td>
                        </tr>

                        <tr>
                           <td colspan="2">
                             <p><input type="text" id="FourthText" class="FillCol" name="Password"> </p>
                             <p><span id="SpanPassword"></span></p>
                          </td>
                        </tr> 


                        <tr>
                            <td colspan="2">
                              <p><input type="submit" id="Button" value="Register"></p>
                            </td>
                        </tr>
                   
                    </table>
                
                </fieldset>
          
            </form>
          <img src="SignUp.png" alt="">
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