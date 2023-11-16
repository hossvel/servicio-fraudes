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

## swagger
http://localhost:8085/swagger-ui/index.html


## referencia
https://github.com/rajeshsgr/order-svc-k8/blob/main/postgresql-initial-data-configmap.yaml
https://belowthemalt.com/2022/09/18/setup-of-spring-boot-application-initialization-of-postgresql-database-on-kubernetes-part-1/
