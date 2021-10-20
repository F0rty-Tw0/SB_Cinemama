README.md

To ensure that the entities in the database created in the previous week could be seen, 

F0rty-Tw0 (Artion Tofan)
During the second sprint, I made the database bigger in size and updated the controllers so that overall, we had AuthController, DirectorController, HallController, MovieController, RoleController, RowController, ScheduleController, SeatController, TheaterController, UserController and the HomeController to handle all the necessary requests. 

I took on the role of overseeing code that other members of the group were submitting. That way, everybody understood what the code was doing and helped not only with the communication but with the learning process from members of the group who were not so confident in their code.  In a project of this magnitude, it was important to support one another. 
By utilizing modelMapper, this allowed me to list specific information related to the movie such as the director, actors and genre whenever information on a specific movie is requested. 

By the end of the second sprint, I uploaded the project onto Heroku. This will help in the handling of storage, networking and monitoring in the cloud thus allowing us to deploy the backend to our AWS service. 

Raszbanana (Nikolai Lenander)
I was tasked on working on the endpoint “GetMovie” which would retrieve detailed information about a specific movie. To accomplish this, I carried on coding with RowService, SeatService and TheatreService. During the coding process, the user was booking a seat as well as booking a movie so it was important to have this process integrated. Requirements were needed for one of our endpoints which needed to return specific info of a movie so as a result, I created the code to allow GetMovie id to show the user the actor rating and the description.   
To avoid limitations, we decided to abandon the idea of having 10 rows and settle for 5 rows of 5 seats


Pawe0733 (Pawel Stephien)
Whilst the endpoints for services were being completed by Nikolai, we needed DTOs to transfer all the relevant data. This would end up showing the movie to the user.  I also worked alongside Artiom to create additional DTOs for Actor, Director and Genre 
 
As the second sprint came to a close, I was successful in completing all the DTOs along with the help of Artiom so that the 

tombill143 (Tom Billington)
As coding was developing during the second sprint, my limited coding skills began to show. This was on my fault in part for not communicating better with my group regarding what needed to be coded. I was very apprehensive to begin attempting to try writing code that I was 40% unsure how to construct without the entire project becoming inoperable. 
My role was appointed to logging the coding for the purposes for this sprint. 


The link of the Movie Theater REST Api to Swagger
https://cine-mama.herokuapp.com/swagger-ui/index.html#/   
