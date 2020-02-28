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
1. [Match related API] (#Match Related)
### Resources
The resource API has GET, POST, PUT methods.
http: // localhost: 8443 followed by the containt request URL.

**All API queries have been preceded by /api**

## Match Related

#### Match info
Allows a anonymous user to see info of a match

* ##### URL:

	< /match/{id} >

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  	```
		{
		    "id": 1,
		    "date": "2019-10-20",
		    "played": true,
		    "stadistics_1": {
			"acurracy": 23,
			"effectiveness": 57,
			"games_wins": 16,
			"unforcedErrors": 50,
			"win": true
		    },
		    "stadistics_2": {
			"acurracy": 13,
			"effectiveness": 17,
			"games_wins": 13,
			"unforcedErrors": 0,
			"win": false
		    },
		    "teams": [
			{
			    "id": 1,
			    "name": "Madrid PT"
			},
			{
			    "id": 2,
			    "name": "Atletico PT"
			}
		    ]
		}
	```
  
* ##### Error response:

	**Code**: NOT.FOUND
	
#### Match by played
Allows a anonymous user to see played or not matches

* ##### URL:

	< /matches/?played={true/false} >

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  	```
		[
		    {
			"id": 13,
			"date": "2019-10-19",
			"played": true,
			"stadistics_1": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 9,
			    "unforcedErrors": 50,
			    "win": false
			},
			"stadistics_2": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 14,
			    "unforcedErrors": 50,
			    "win": true
			},
			"teams": [
			    {
				"id": 8,
				"name": "VersusTeam"
			    },
			    {
				"id": 6,
				"name": "Donuts"
			    }
			]
		    },
		    {
			"id": 1,
			"date": "2019-10-20",
			"played": true,
			"stadistics_1": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 16,
			    "unforcedErrors": 50,
			    "win": true
			},
			"stadistics_2": {
			    "acurracy": 13,
			    "effectiveness": 17,
			    "games_wins": 13,
			    "unforcedErrors": 0,
			    "win": false
			},
			"teams": [
			    {
				"id": 1,
				"name": "Madrid PT"
			    },
			    {
				"id": 2,
				"name": "Atletico PT"
			    }
			]
		    },
		    {
			"id": 2,
			"date": "2019-10-21",
			"played": true,
			"stadistics_1": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 15,
			    "unforcedErrors": 50,
			    "win": true
			},
			"stadistics_2": {
			    "acurracy": 13,
			    "effectiveness": 17,
			    "games_wins": 9,
			    "unforcedErrors": 0,
			    "win": false
			},
			"teams": [
			    {
				"id": 1,
				"name": "Madrid PT"
			    },
			    {
				"id": 3,
				"name": "Barcelona PT"
			    }
			]
		    },
		    {
			"id": 3,
			"date": "2019-10-22",
			"played": true,
			"stadistics_1": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 9,
			    "unforcedErrors": 50,
			    "win": false
			},
			"stadistics_2": {
			    "acurracy": 13,
			    "effectiveness": 17,
			    "games_wins": 16,
			    "unforcedErrors": 0,
			    "win": true
			},
			"teams": [
			    {
				"id": 4,
				"name": "Leones"
			    },
			    {
				"id": 1,
				"name": "Madrid PT"
			    }
			]
		    },
		    ...........
	```
  
* ##### Error response:

	**Code**: NOT.FOUND
	
#### Macthes by date
Allows a anonymous user to see info of a match from a concrete date

* ##### URL:

	< /matches/?date={date_with"-"} >

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  	```
		[
		    {
			"id": 19,
			"date": "2020-03-22",
			"played": false,
			"stadistics_1": null,
			"stadistics_2": null,
			"teams": [
			    {
				"id": 1,
				"name": "Madrid PT"
			    },
			    {
				"id": 3,
				"name": "Barcelona PT"
			    }
			]
		    }
		]
	```
  
* ##### Error response:

	**Code**: NOT.FOUND
	
#### Matches from a Team
Allows a anonymous user to see info of matches given a teamid

* ##### URL:

	< /matches/?teamid={id} >

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  	```
		[
		    {
			"id": 5,
			"date": "2019-10-24",
			"played": true,
			"stadistics_1": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 13,
			    "unforcedErrors": 50,
			    "win": true
			},
			"stadistics_2": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 10,
			    "unforcedErrors": 50,
			    "win": false
			},
			"teams": [
			    {
				"id": 2,
				"name": "Atletico PT"
			    },
			    {
				"id": 4,
				"name": "Leones"
			    }
			]
		    },
		    {
			"id": 4,
			"date": "2019-10-23",
			"played": true,
			"stadistics_1": {
			    "acurracy": 99,
			    "effectiveness": 99,
			    "games_wins": 8,
			    "unforcedErrors": 99,
			    "win": false
			},
			"stadistics_2": {
			    "acurracy": 78,
			    "effectiveness": 7,
			    "games_wins": 15,
			    "unforcedErrors": 3,
			    "win": true
			},
			"teams": [
			    {
				"id": 2,
				"name": "Atletico PT"
			    },
			    {
				"id": 3,
				"name": "Barcelona PT"
			    }
			]
		    },
		    {
			"id": 1,
			"date": "2019-10-20",
			"played": true,
			"stadistics_1": {
			    "acurracy": 23,
			    "effectiveness": 57,
			    "games_wins": 16,
			    "unforcedErrors": 50,
			    "win": true
			},
			"stadistics_2": {
			    "acurracy": 13,
			    "effectiveness": 17,
			    "games_wins": 13,
			    "unforcedErrors": 0,
			    "win": false
			},
			"teams": [
			    {
				"id": 1,
				"name": "Madrid PT"
			    },
			    {
				"id": 2,
				"name": "Atletico PT"
			    }
			]
		    }
		]
	```
  
* ##### Error response:

	**Code**: NOT.FOUND
