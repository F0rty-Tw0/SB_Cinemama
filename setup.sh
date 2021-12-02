#!/bin/bash
#run
green=`tput setaf 2`
reset=`tput sgr0`
echo "${green}Lets create your environment variables first!${reset}"  
echo "${green}Enter your MySql ROOT user password:${reset}"  
read MYSQL_ROOT_PASSWORD  
echo "${green}Now enter your DATABASE URL:${reset}"  
read DATABASE_URL
echo "${green}Now enter your JWT SECRET:${reset}"  
read JWT_SECRET
echo "${green}Collecting sensitive information is finished!${reset}"  
echo "${green}Starting Docker installation and SpringBoot with MySql application Installation...${reset}"
echo "${green}Re-Synchronizing the packages...${reset}"
sudo apt -y update
echo "${green}Re-Synchronizing finished!${reset}"
echo "${green}Upgrading the packages...${reset}" 
sudo apt -y upgrade 
echo "${green}Upgrading finished!${reset}"
echo "${green}Downloading Docker from external source...${reset}"
wget -O - https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
echo "${green}Downloading finished!${reset}"
echo "${green}Adding Docker to the packages...${reset}"
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
echo "${green}Adding to the packages finished!${reset}"
echo "${green}Re-Synchronizing the packages...${reset}"
sudo apt -y update
echo "${green}Re-Synchroniz/ing finished!${reset}"
echo "${green}Installing the Docker...${reset}"
sudo apt -y install docker-ce
echo "${green}Installing Docker finished!${reset}"
echo "${green}Runing a docker test...${reset}"
sudo docker run hello-world
echo "${green}Installing Java...${reset}"
sudo apt -y install default-jre
echo "${green}Installing Java finished!${reset}"
echo "${green}Installing Jenkins!${reset}"
sudo wget -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
sudo chmod 777 /etc/apt/sources.list.d
echo "deb http://pkg.jenkins.io/debian-stable binary/" >> /etc/apt/sources.list.d/jenkins.list
sudo apt -y update
sudo apt -y upgrade
sudo apt -y install jenkins
echo "${green}Installing Jenkins finished!${reset}"
echo "${green}Installing Maven!${reset}"
sudo apt -y install maven
echo "${green}Installing Maven finished!${reset}"
echo "${green}Creating a MySql Image and Container...${reset}"
sudo docker run -d -p 3306:3306 --env="MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD" --name=cinemama_database mysql
sleep 30s
echo "${green}MySql is finished!${reset}"
sudo usermod -a -G docker jenkins
echo "${green}Printing your Jenkins Initial Password${reset}"
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
echo "${green}Prepare your Jenkins, and the Github connection, after done press y? [y,n]${reset}"
read input
if [[ $input == "Y" || $input == "y" ]]; then
      echo "${green}Adding the Jenkins user to the Docker group${reset}"
      sudo service jenkins restart
      sudo chmod 777 /var/lib/jenkins/workspace/cinemama
      cd /var/lib/jenkins/workspace/cinemama
      echo "${green}Creating a .env file...${reset}"
      echo "
      DATABASE_URL=$DATABASE_URL
      JWT_SECRET=$JWT_SECRET">>./env
      echo "${green}.env file is finished!${reset}"
      echo "${green}Creating a Dockerfile...${reset}"
      echo "FROM openjdk:latest
            COPY target/cinemama-0.0.1-SNAPSHOT.jar /usr/src/cinemama.jar
            CMD java -jar /usr/src/cinemama.jar">>./Dockerfile
      echo "${green}Dockerfile is finished!${reset}"
      echo "${green}Making a Docker Image...${reset}"
      sudo docker image build . --tag cinemama
      echo "${green}Image is finished!${reset}"
      echo "${green}Creating a Docker Application Container...${reset}"
      sudo docker run -d -p 80:8080 -p 443:443 --name cinemama_container --env-file=env  cinemama  
      echo "${green}Application Container is finished!${reset}"
else
      echo "${green}I hope you will configure the Jenkins by yourself.${reset}"
fi
echo "${green}No Fear Art is here!!! Congratulations Docker and your Application install is finilized!${reset}"