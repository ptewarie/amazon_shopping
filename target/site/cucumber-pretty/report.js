$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Shopping.feature");
formatter.feature({
  "name": "Shopping for a new tv",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "order tv",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have launched the shopping App",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.Shopping.iHaveLaunchedTheShoppingApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the customer is logged out",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Shopping.theCustomerIsLoggedOut()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I log in the amazon app",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.Shopping.ILogInTheAmazonApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for a 65 inch television",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Shopping.ISearchForA65InchTelevision()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add that item to the cart",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Shopping.IAddThatItemToTheCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to shopping cart screen",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Shopping.IGoToShoppingCartScreen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the product details should be correct",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.Shopping.theProductDetailsShouldBeCorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});