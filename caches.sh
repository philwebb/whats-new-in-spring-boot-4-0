cd isdb
docker compose pull
./mvnw clean package
./mvnw dependency:sources
cd ..

cd isdb-count
./mvnw clean package
./mvnw dependency:sources
cd ..

cd isdb-web
docker compose pull
./mvnw clean package
./mvnw dependency:sources
cd ..


