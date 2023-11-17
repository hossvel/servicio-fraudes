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

## k8s - base de datos 

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
- kubectl get pods

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

## k8s - aplicacion fraudes
- kubectl apply -f .\fraudes-svc-deployment.yaml
- kubectl apply -f .\fraudes-svc-service.yaml
- kubectl get deployment
- kubectl get services
- kubectl get pods

kubectl logs fraudes-svc-deployment-fff74f85f-w7bh9

# probando con el puerto generado
http://localhost:31093/api/v1/fraud-checks

## forward
kubectl port-forward service/fraudes-svc-service 8085:8085

## probando curl
curl http://localhost:8085/api/v1/fraud-checks


## referencia
https://github.com/rajeshsgr/order-svc-k8/blob/main/postgresql-initial-data-configmap.yaml
https://belowthemalt.com/2022/09/18/setup-of-spring-boot-application-initialization-of-postgresql-database-on-kubernetes-part-1/
