# Lab6
Download these files and run HomeController.java for the main this or run mvn clean test where pom.xml is to first test the code.

to manually test these codes you can run the following
Valid Email
curl -X POST "http://localhost:8080/email-address-valid?email=user@example.com" \
     -H "Content-Type: application/json"
Invalid email
curl -X POST "http://localhost:8080/email-address-valid?email=userexample" \
     -H "Content-Type: application/json"

Strong pw
curl -X POST 'http://localhost:8080/password-quality?password=Abc123!@#' \
     -H "Content-Type: application/json"

Med pw
curl -X POST 'http://localhost:8080/password-quality?password=Abc12345' \
     -H "Content-Type: application/json"

bad password:
curl -X POST 'http://localhost:8080/password-quality?password=abc' \
     -H "Content-Type: application/json"
