# spring-services
java code challenge
Below are the instructions to run the services. All services are running on port 8081

Validate VAT Input : We can access the service using below service endpoint
http://localhost:8081/vatapi/validateVAT/ FR94328781786

This URL is http Get request , we access this by passing VAT number. Highlighted above "FR94328781786" is VAT number, we have to pass VAT number as path variable. I am using Embedded DB i.e., H2 database to store country details. We can access DB using http://localhost:8081/h2-console/

Credentials to access DB : Username : sa and Password : password

Get Current Time : http://localhost:8081/timeapi/gettime URL is http Get request method. No parameter for this service.

Convert Currency from Source to target http://localhost:8081/api/currency/convert/20?from=USD&to=EUR

Parameters are : Amount From is the : source currency and To is : Target Currency

Note: I am using public convertor i.e., currencylayer.com. We have limited access for this service (USD to EUR, USD to CHF, USD to INR.. etc) i.e., no of requests and source and destination currencies (we may not convert all the currencies for this limited access) as I have subscribed as free. Services included swagger documentation, we access services using swagger ui. Swagger UI URL : http://localhost:8081/swagger-ui.html#/.


Technologies/Tools Used: Java, Springboot Framework, Spring Tool Suite (IDE), JPA, Hibernate (ORM ), H2 (Database), Swagger (Document and consume web services ), Maven (Build )
