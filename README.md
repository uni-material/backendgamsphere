DATABASE: dbgamesphere

sudo apt update
sudo apt-get install docker.io -y
docker --version
sudo systemctl enable docker
sudo systemctl start docker
sudo docker run --name dbcontainer -d -p 27017:27017 mongo --bind_ip_all
sudo docker ps

sudo docker exec -it dbcontainer mongo
sudo ufw allow 27017


SERVER APPLICATION:
f1 -> remote ssh connect to host
abrir config

spring initializer
- añadir spring web
- 

sudo apt update
sudo apt install openjdk-11-jdk
