# CurrencyFairTest
A Spring Boot Application which eposes a REST-API endpoint in order to post the market trade messages in the form of json requests. The application just consumes the incoming json request and process it with the in memory database and provides the response of the consumed message.

The Git-hub url to access the code is https://github.com/upps/CurrencyFairTest.git

The json messages must be POST in http://localhost:8080/api/cf/tradeMessage 
The below message was used as the incoming request.

{
   "userId" : "testUser",
   "currencyFrom" : "EUR",
   "currencyTo" : "USD",
   "amountBuy" : 210.00,
   "amountSell" : 800.00,
   "rate" : 0.96,
   "timePlaced": "12-NOV-20 17:29:03",
   "originatingCountry" : "FR"
}

In order to view to the cosumed messages http://localhost:8080/results

Also I have attached the screenshots of testing the request using Postman to check the functionality.
