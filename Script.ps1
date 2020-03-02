docker run -it --rm -v "$(pwd):/usr/src/project" -w /usr/src/project maven:alpine mvn clean install
Copy-Item -Path ./target/padelversus-0.0.1-SNAPSHOT.jar -Destination ./Docker/PadelVersus.jar -force
Copy-Item -Path ./DemoImages -Destination ./Docker/DemoImages -Recurse
cd Docker
docker rmi padelversus
docker image build -t padelversus -f .Dockerfile .
docker-compose up -d
cd ..

