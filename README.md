# Starbound weapon generator

As the title said this tool generate a command that can spawn a custom weapon for the game Starbound\
and it can change the projectile fired of a ranged weapon\
Currently there are some few weapons supported:
- Melee weapon except shields
- Ranged weapons
- Staffs and wands

**Obs: some combinations cannot work properly**\
\
In order to install and run this project you will need the following programs:
- MySQL
- Java 11

First clone the project with this command
```
git clone https://github.com/srpapinha/Starbound-weapon-generator.git
cd Starbound-weapon-generator
```
Probably your database username and password are different so you need to change the properties of this file: 
```
src\main\resources\application.properties
```
and change these fields:
```
spring.datasource.username=root
spring.datasource.password=secret
```
In second step you need to load the starbound.sql in database with the following command:
```
mysql -u {username} -p starbound < starbound.sql
```
If you use docker:
```
docker exec -it {container-name} mysql -u {username} -p starbound < starbound.sql
```
Now to run the project
```
./mvnw spring-boot:run
```
To acess the website you need to open [http://localhost:8080](http://localhost:8080)

