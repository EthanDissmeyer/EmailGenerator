# EmailGenerator

# Backend: SpringBoot / Maven
- in the server dir
To clean
./mvnw clean   
To run the backend environment (on port 8080 - localhost:8080)
./mvnw spring-boot:run

# Frontend: Angular/Html/css (on port 4200)
- in the client dir
To start the client run:
ng serve

# Database / Docker 
- we are using a container with postgresql to hold our db in the root dir run
docker-compose down
docker-compose up -d

- to see the database visually go to localhost:5050 (which takes you to pgadmin)
- login details are in the .env file