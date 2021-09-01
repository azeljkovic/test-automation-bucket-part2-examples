# RestAssured-JUnit-RestfullBooker

Application under test: [Restful Booker](https://github.com/azeljkovic/restful-booker) (my fork which was modified to use static instead of the random data)  
API framework: [REST Assured](https://rest-assured.io/)  
Testing framework: [JUnit5](https://junit.org/junit5/)  

## How to run tests
Install artifacts: `mvn install`  
Run all tests: `mvn test`  
Run a specific test class:`mvn -Dtest=UpdateBookingTest test`
