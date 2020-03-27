Admin Console : http://164.68.113.222:8080/auth/
Username : admin
Password : admin



Realm : testrealm
Client : test-app
Users

     testuser:
        username : testuser
        password : testuser
        roles     : USER
    
    adminuser
        username : adminuser
        password : adminuser
        roles     : USER,ADMIN 
        
        
Token Url :   
   
    http://164.68.113.222:8080/auth/realms/testrealm/protocol/openid-connect/token 
Token Request for testuser : 

    curl --data "grant_type=password&client_id=test-app&username=testuser&password=testuser" http://164.68.113.222:8080/auth/realms/testrealm/protocol/openid-connect/token
Token Request for adminuser : 
      
    curl --data "grant_type=password&client_id=test-app&username=adminuser&password=adminuser" http://164.68.113.222:8080/auth/realms/testrealm/protocol/openid-connect/token



Application EndPoint : 
        
        http://164.68.113.222:8085/products

URI :  /products  visible only authz users 
        
        curl -H "Accept: application/json" -H "Authorization: Bearer my_token" http://164.68.113.222:8085/products
       
URI : POST  /products/add visible only admin   
        
        curl -H "Content-Type: application/json" -H "Authorization: Bearer token" -d '{"name":"new"}' -X POST http://164.68.113.222:8085/products/add
               


           