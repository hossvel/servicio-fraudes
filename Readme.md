## Servicio de Fraudes
http://localhost:8085/api/v1/fraud-checks

## compilar y generar jar
mvn clean package

## generar imagen:
docker build -t hhvelascoa/appfraudes:v1 .

## docker push
docker push hhvelascoa/appfraudes:v1 

## docker compose
- docker-compose up -d 
- docker-compose down

## swagger
http://localhost:8085/swagger-ui/index.html

## k8s

- kubectl apply -f .\postgresql-claim0-persistentvolume.yaml
- kubectl apply -f .\postgresql-claim0-persistentvolumeclaim.yaml
- kubectl apply -f .\postgresql-initial-data-configmap.yaml
- kubectl apply -f .\postgresql-deployment.yaml
- kubectl apply -f .\postgresql-service.yaml
- kubectl get pv
- kubectl get pvc
- kubectl get configmap
- kubectl get deployment
- kubectl get services

- kubectl get all

# verificando el pod de bd postgres
- kubectl logs pod/postgresql-6d7bccf544-hpqrq
# ingresando a la bd
- kubectl exec -it pod/postgresql-6d7bccf544-hpqrq bash
# Connect to postgres
- psql -U postgres
# Connect to db_fraudes database 
- \c db_fraudes
# Check the tables  
- \dt
# Check if database is initialized by executing
- select * from tbl_fraud_customer_check










## referencia
https://github.com/rajeshsgr/order-svc-k8/blob/main/postgresql-initial-data-configmap.yaml
https://belowthemalt.com/2022/09/18/setup-of-spring-boot-application-initialization-of-postgresql-database-on-kubernetes-part-1/
- /Users/rajeshp/docker/postgres/docker-pg-vol/data:/var/lib/postgresql/data
- /Users/rajeshp/docker/postgres/init/initData.sql:/docker-entrypoint-initdb.d/initData.sql
  path: "/Users/rajeshp/docker/postgres/docker-pg-vol/data"