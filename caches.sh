cd isdb
docker compose pull
./mvnw clean package
./mvnw dependency:sources
./mvnw dependency:resolve -Dclassifier=javadoc
./mvnw dependency:resolve -Dclassifier=sources
cd ..

cd isdb-count
./mvnw clean package
./mvnw dependency:sources
./mvnw dependency:resolve -Dclassifier=javadoc
./mvnw dependency:resolve -Dclassifier=sources
cd ..

cd isdb-web
docker compose pull
./mvnw clean package
./mvnw dependency:sources
./mvnw dependency:resolve -Dclassifier=javadoc
./mvnw dependency:resolve -Dclassifier=sources
cd ..


