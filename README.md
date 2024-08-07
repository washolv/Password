# Password

## Features

- Validate the password based on a set of predefined rules
- Return ok with a boolean value indicating if the password is valid

## Validation Rules
The password must meet the following criteria:
- at least 9 characters
- Contains at least one digit
- Contains at least one lowercase letter
- Contains at least one uppercase letter
- Contains at east one special character
- No repeated characters 

## Prerequisites
- Java 17
- Maven

## Instalation
1. Clone the repository:https://github.com/washolv/Password
2. mvn clean install
3. mvn spring-boot:run

## API endpoints
- URL: /password/validate
- method: POST
- Request Body: The password to be validated as JSON.
- Example of request:
  - curl --location 'http://localhost:8080/password/validate' \
    --header 'Content-Type: application/json' \
    --data '{
    "password": "teste"
    }'
  - response:
  - Status 200: true
  
## Running tests
- to run the tests, use the following command: 
  - mvn test

Technologies used:
- Java
- Spring boot
- Maven