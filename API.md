# API Documentation
## About our API
In our REST API you can find all the features of the PadelVerus website, by consulting:
1. Tournaments and tournament information
2. Matches, match information, match filtering according to criteria
3. Teams, being able to list all and get teams per player
4. Players, with their data
5. You will be able to access all the features of the registered user.
6. You can access all the features of the admin

## How to use our API
1. Download [Postman](https://www.getpostman.com/).
2. You only can send GET, POST, PUT requests.

## API requests

### Resources
The resource API has GET, POST, PUT methods.
http: // localhost: 8443 followed by the containt request URL.

**All API queries have been preceded by /api**

## Authentication (Ejemplo)

#### login
Allows a user to log in.

* ##### URL:

	< /login >

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  	```
	{
	    "id": 1,
	    "name": "User",
	    "email": "email@hotmail.es",
	    "level": 1,
	    "points": 0,
	    "streak": 0,
	    "fluency": 0,
	    "dailyGoal": 0,
	    "lastConnection": "2018-03-17/11:44:21",
	    "lastUnit": 0,
	    "lastLesson": 0,
	    "progress": null,
	    "remainingGoals": 0,
	    "exp": 0
	}
	```
  
* ##### Error response:

	**Code**: 401 UNAUTHORIZED
	
