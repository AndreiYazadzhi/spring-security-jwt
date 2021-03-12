# spring-security-jwt
## Todo Application with JWT Authentication
Stack of technologies: Spring Boot, Spring Data, Spring Security  
Tools and another: H2 Database, Lombok, jjwt
### AuthController
POST: /register  -  for register  
POST: /auth  -  for user authentication  
### RecordController
POST: /  -  for adding new record  
*{  
    "description":"text",  
    "completed":true  
}*  
PUT: /{id}  -  for update record  
*{  
    "description":"text",  
    "completed":true  
}*  
DELETE: /{id}  -  for deleting record  
GET: /{id}  -  get record by id  

For tests you need to install [postman](https://www.postman.com)
