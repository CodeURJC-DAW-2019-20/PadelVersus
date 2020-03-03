# Line to run from standard cmd like intellij idea one (only windows)
# Execution without log
# C:/Windows/System32/WindowsPowerShell/v1.0/powershell.exe -File C:/Users/jllav/IdeaProjects/PadelVersus/Script.ps1
# Execution with log
# C:/Windows/System32/WindowsPowerShell/v1.0/powershell.exe -File C:/Users/jllav/IdeaProjects/PadelVersus/Script.ps1 $true

# Clean and packge using local .m2 repository to do not download already gotten libraries
docker run -it --rm -v "$(pwd):/usr/src/project" `
                    -v"$HOME/.m2:/root/.m2" `
                    -w /usr/src/project maven:alpine mvn clean package

# If there is any problem in compilation we move and rename the .jar
if(Test-Path ./target/padelversus-0.0.1-SNAPSHOT.jar -PathType Leaf){
    Copy-Item -Path ./target/padelversus-0.0.1-SNAPSHOT.jar -Destination ./Docker/PadelVersus.jar -force
}else{
    echo "Maven compilation fail"
    exit
}

# If there is not already moved we copy recursive the folder with images needed for the demo
if (!(Test-Path ./Docker/DemoImages -PathType Any)){
    Copy-Item -Path ./DemoImages -Destination ./Docker/DemoImages -Recurse
}else{
    Remove-Item -Recurse -Force ./Docker/DemoImages
    Copy-Item -Path ./DemoImages -Destination ./Docker/DemoImages -Recurse
}

# We move into the folder were the .Dockerfile and docker-compose.yml is
cd Docker

# We remove the image in case we have done changes in .Dockerfile
docker rmi teampina/padelversus

# We build the app image
docker image build -t teampina/padelversus -f .Dockerfile .

# We push the image to docker hub
docker push teampina/padelversus

# We reutrned to the started directory
cd ..
