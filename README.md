# Online_Payment_Service
Online Payment Service using Spring Boot and JPA
Here we have two microservices, Bank-Wallet which deals with transactions,bills while Customer-service takes care of Bank accounts,Customer and wallet
<h1> How to Use</h1>
<ol>

  <h5>Running the Application</h5>
<ul>  
  <li>Download the files and run maven to download the neccessary dependencies</li>
  <li>Bank-Wallet runs on port 8082</li>
  <li>Customer-service runs on port 8081</li>
  <li>eureka server runs on port 8091</li>
  <li>open the swagger-ui.html on the required port</li>
  <li> for example localhost:8082/swagger-ui.html to see all controllers of Bank-Wallet</li>
</ul>
 <h5>Making Payments</h5>
 <ul>
  
   <li>Create customers </li>
   <li>Login using the username and password</li>
    <li>Create a Bank Account and create a wallet linked to it</li>
   <li>Make transactions and bill payments</li>
  </ul>
   <h3> if the api gives any error code or null values, please do check the terminal for the Custom Exception Raised</h3>
  
  
