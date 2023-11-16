## Servicio de Fraudes
http://localhost:8085/api/v1/fraud-checks

## compilar y generar jar
mvn clean package

## generar imagen:
docker build -t hhvelascoa/appfraudes:v1 .

## docker push
docker push hhvelascoa/appfraudes:v1 

## docker compose
docker-compose up -d , 
docker-compose down