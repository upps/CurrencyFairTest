# CurrencyFairTest
A Spring Boot Application which eposes a REST-API endpoint in order to post the market trade messages in the form of json requests. The application just consumes the incoming json request and process it with the in memory database and provides the response of the consumed message.
# The json messages must be POST in http://localhost:8080/api/cf/tradeMessage The below message was used as the incoming request.
{
   "userId" : "testUser3",
   "currencyFrom" : "EUR",
   "currencyTo" : "USD",
   "amountBuy" : 210.00,
   "amountSell" : 800.00,
   "rate" : 0.96,
   "timePlaced": "21-DEC-18 11:20:03",
   "originatingCountry" : "FR"
}
