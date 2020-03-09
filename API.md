# [API Documentation](#api-documentation)
  * [Table of content](#table-of-content)
  * [About our API](#about-our-api)
  * [How to use our API](#how-to-use-our-api)
  * [API requests](#api-requests)
    + [Resources](#resources)
  * [Match Related](#match-related)
      - [Match info](#match-info)
        * [URL:](#url-)
        * [Method:](#method-)
        * [Success Response:](#success-response-)
        * [Error response:](#error-response-)
      - [Match by played](#match-by-played)
        * [URL:](#url--1)
        * [Method:](#method--1)
        * [Success Response:](#success-response--1)
        * [Error response:](#error-response--1)
      - [Macthes by date](#macthes-by-date)
        * [URL:](#url--2)
        * [Method:](#method--2)
        * [Success Response:](#success-response--2)
        * [Error response:](#error-response--2)
      - [Matches from a Team](#matches-from-a-team)
        * [URL:](#url--3)
        * [Method:](#method--3)
        * [Success Response:](#success-response--3)
        * [Error response:](#error-response--3)
  * [Admin Related](#admin-related)
      - [Save New Match](#save-new-match)
        * [URL:](#url--4)
        * [Method:](#method--4)
        * [Success Response:](#success-response--4)
        * [Error response:](#error-response--4)
      - [Save Stadistics Match](#save-stadistics-match)
        * [URL:](#url--5)
        * [Method:](#method--5)
        * [Success Response:](#success-response--5)
        * [Error response:](#error-response--5)
      - [Save New Tournament](#save-new-tournament)
        * [URL:](#url--6)
        * [Method:](#method--6)
        * [Success Response:](#success-response--6)
        * [Error response:](#error-response--6)
  * [Tournament related](#tournament-related)
      - [Tournaments info By TeamId](#tournaments-info-by-teamid)
        * [URL: </api/tournaments/?teamId=Long>](#url----api-tournaments--teamid-long-)
        * [Method:](#method--7)
        * [Success Response:](#success-response--7)
        * [Error response:](#error-response--7)
      - [Tournaments Info By PlayerId](#tournaments-info-by-playerid)
        * [URL: </api/tournaments/?playerId=Long>](#url----api-tournaments--playerid-long-)
        * [Method:](#method--8)
        * [Success Response:](#success-response--8)
        * [Error response:](#error-response--8)
      - [Tournament Info By PlayerId](#tournament-info-by-playerid)
        * [URL: </api/tournaments/?playerId=Long&name=String>](#url----api-tournaments--playerid-long-name-string-)
        * [Method:](#method--9)
        * [Success Response:](#success-response--9)
        * [Error response:](#error-response--9)
      - [Tournament Info By TeamId](#tournament-info-by-teamid)
        * [URL: </api/tournaments/?teamId=Long&name=String>](#url----api-tournaments--teamid-long-name-string-)
        * [Method:](#method--10)
        * [Success Response:](#success-response--10)
        * [Error response:](#error-response--10)
        * [URL: </api/tournament/{id}/ranking>](#url----api-tournament--id--ranking-)
        * [Method:](#method--11)
        * [Success Response:](#success-response--11)
        * [Error response:](#error-response--11)
        * [URL: </api/tournament/{id}>](#url----api-tournament--id--)
        * [Method:](#method--12)
        * [Success Response:](#success-response--12)
        * [Error response:](#error-response--12)
        * [URL: </api/tournament/{id}>](#url----api-tournament--id---1)
        * [Method:](#method--13)
        * [Example Body](#example-body)
        * [Success Response:](#success-response--13)
        * [Error response:](#error-response--13)
  * [Team Related](#team-related)
  * [User related](#user-related)
      - [Save New User](#save-new-user)
        * [URL:](#url--7)
        * [Method:](#method--14)
        * [Success Response:](#success-response--14)
        * [Error response:](#error-response--14)
  * [Player Related](#player-related)
      - [Save New Player](#save-new-player)
        * [URL:](#url--8)
        * [Method:](#method--15)
        * [Success Response:](#success-response--15)
        * [Error response:](#error-response--15)
      - [Player Info By PlayerId](#player-info-by-playerid)
        * [URL: </api/player/Long>](#url----api-player-long-)
        * [Method:](#method--16)
        * [Success Response:](#success-response--16)
        * [Error response:](#error-response--16)


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
**All API queries have been preceded by /api**
### Resources
The resource API has GET, POST, PUT methods.
http: // localhost: 8443 followed by the containt request URL.



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

	< /matches/?teamid={Long} >

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

## Admin Related

#### Save New Match
Allows an admin save a new match in a tournament

* ##### URL:

	< /api/match/{tournament} >

* ##### Method:

	`POST`
	
* ##### Success Response:
  
  	```
		{
		    "id": 25,
		    "date": "2019-03-06",
		    "played": false,
		    "stadistics_1": null,
		    "stadistics_2": null,
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
	
#### Save Stadistics Match
Allows an admin save stadistics from a match

* ##### URL:

	< /api/match/{id} >

* ##### Method:

	`PUT`
	
* ##### Success Response:
  
  	```
		{
		    "id": 19,
		    "date": "2020-03-22",
		    "played": false,
		    "stadistics_1": {
			"acurracy": 5,
			"effectiveness": 10,
			"games_wins": 30,
			"unforcedErrors": 4,
			"win": false,
			"sets": [
			    {
				"id": 109,
				"games": 6,
				"setNumber": 1
			    },
			    {
				"id": 110,
				"games": 6,
				"setNumber": 1
			    },
			    {
				"id": 111,
				"games": 6,
				"setNumber": 1
			    }
			]
		    },
		    "stadistics_2": {
			"acurracy": 5,
			"effectiveness": 10,
			"games_wins": 30,
			"unforcedErrors": 4,
			"win": true,
			"sets": [
			    {
				"id": 112,
				"games": 6,
				"setNumber": 1
			    },
			    {
				"id": 113,
				"games": 6,
				"setNumber": 1
			    },
			    {
				"id": 114,
				"games": 6,
				"setNumber": 1
			    }
			]
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
		}
	```
  
* ##### Error response:

	**Code**: NOT.FOUND

#### Save New Tournament
Allows an admin save new tournament

* ##### URL:

	< /api/tournament/ >

* ##### Method:

	`POST`
	
* ##### Success Response:
  
  	```
		{
		    "id": 4,
		    "name": "Tournament 4",
		    "nonspacename": "Tournament4",
		    "matches": [],
		    "teams": []
		}
	```
  
* ##### Error response:

	**Code**: NOT.FOUND
	
	
	
	
## Tournament related

#### Tournaments info By TeamId
Allows a anonymous user to see info of the tournaments by teamID
* ##### URL: </api/tournaments/?teamId=Long>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
  	```
		 {
        "id": 3,
        "name": "Tournament 3",
        "nonspacename": "Tournament3",
        "matches": [
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
                }
            },
            {
                "id": 14,
                "date": "2019-11-21",
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
                    "games_wins": 16,
                    "unforcedErrors": 50,
                    "win": true
                }
            },
            {
                "id": 15,
                "date": "2019-11-22",
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
                    "games_wins": 15,
                    "unforcedErrors": 50,
                    "win": true
                }
            },
            {
                "id": 16,
                "date": "2019-11-23",
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
                }
            },
            {
                "id": 17,
                "date": "2019-11-24",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 14,
                    "unforcedErrors": 50,
                    "win": true
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 9,
                    "unforcedErrors": 50,
                    "win": false
                }
            },
            {
                "id": 18,
                "date": "2019-11-25",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 10,
                    "unforcedErrors": 50,
                    "win": false
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 14,
                    "unforcedErrors": 50,
                    "win": true
                }
            },
            {
                "id": 19,
                "date": "2020-03-22",
                "played": false,
                "stadistics_1": null,
                "stadistics_2": null
            },
            {
                "id": 20,
                "date": "2020-10-29",
                "played": false,
                "stadistics_1": null,
                "stadistics_2": null
            },
            {
                "id": 21,
                "date": "2020-11-19",
                "played": false,
                "stadistics_1": null,
                "stadistics_2": null
            },
            {
                "id": 22,
                "date": "2020-03-09",
                "played": false,
                "stadistics_1": null,
                "stadistics_2": null
            },
            {
                "id": 23,
                "date": "2020-03-09",
                "played": false,
                "stadistics_1": null,
                "stadistics_2": null
            },
            {
                "id": 24,
                "date": "2020-04-14",
                "played": false,
                "stadistics_1": null,
                "stadistics_2": null
            }
        ],
        "teams": [
            {
                "id": 6,
                "name": "Donuts"
            },
            {
                "id": 8,
                "name": "VersusTeam"
            },
            {
                "id": 9,
                "name": "Las palmas PT"
            },
            {
                "id": 10,
                "name": "Getafe PT"
            }
        ]
    
    
	```
* ##### Error response:

	**Code**: NOT.FOUND



#### Tournaments Info By PlayerId
Allows a anonymous user to see info of the tournaments by playerID
* ##### URL: </api/tournaments/?playerId=Long>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
 		```
				[
		    {
			"id": 2,
			"name": "Tournament 2",
			"nonspacename": "Tournament2",
			"matches": [
			    {
				"id": 7,
				"date": "2019-11-19",
				"played": true,
				"stadistics_1": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 15,
				    "unforcedErrors": 50,
				    "win": true
				},
				"stadistics_2": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 10,
				    "unforcedErrors": 50,
				    "win": false
				}
			    },
			    {
				"id": 8,
				"date": "2019-11-20",
				"played": true,
				"stadistics_1": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 10,
				    "unforcedErrors": 50,
				    "win": false
				},
				"stadistics_2": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 14,
				    "unforcedErrors": 50,
				    "win": true
				}
			    },
			    {
				"id": 9,
				"date": "2019-11-21",
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
				    "games_wins": 16,
				    "unforcedErrors": 50,
				    "win": true
				}
			    },
			    {
				"id": 10,
				"date": "2019-11-22",
				"played": true,
				"stadistics_1": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 14,
				    "unforcedErrors": 50,
				    "win": true
				},
				"stadistics_2": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 8,
				    "unforcedErrors": 50,
				    "win": false
				}
			    },
			    {
				"id": 11,
				"date": "2019-11-23",
				"played": true,
				"stadistics_1": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 15,
				    "unforcedErrors": 50,
				    "win": true
				},
				"stadistics_2": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 8,
				    "unforcedErrors": 50,
				    "win": false
				}
			    },
			    {
				"id": 12,
				"date": "2019-11-24",
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
				}
			    }
			],
			"teams": [
			    {
				"id": 4,
				"name": "Leones"
			    },
			    {
				"id": 5,
				"name": "Tigres"
			    },
			    {
				"id": 6,
				"name": "Donuts"
			    },
			    {
				"id": 7,
				"name": "Valencia PT"
			    }
			]
		    },
		    {
			"id": 3,
			"name": "Tournament 3",
			"nonspacename": "Tournament3",
			"matches": [
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
				}
			    },
			    {
				"id": 14,
				"date": "2019-11-21",
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
				    "games_wins": 16,
				    "unforcedErrors": 50,
				    "win": true
				}
			    },
			    {
				"id": 15,
				"date": "2019-11-22",
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
				    "games_wins": 15,
				    "unforcedErrors": 50,
				    "win": true
				}
			    },
			    {
				"id": 16,
				"date": "2019-11-23",
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
				}
			    },
			    {
				"id": 17,
				"date": "2019-11-24",
				"played": true,
				"stadistics_1": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 14,
				    "unforcedErrors": 50,
				    "win": true
				},
				"stadistics_2": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 9,
				    "unforcedErrors": 50,
				    "win": false
				}
			    },
			    {
				"id": 18,
				"date": "2019-11-25",
				"played": true,
				"stadistics_1": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 10,
				    "unforcedErrors": 50,
				    "win": false
				},
				"stadistics_2": {
				    "acurracy": 23,
				    "effectiveness": 57,
				    "games_wins": 14,
				    "unforcedErrors": 50,
				    "win": true
				}
			    },
			    {
				"id": 19,
				"date": "2020-03-22",
				"played": false,
				"stadistics_1": null,
				"stadistics_2": null
			    },
			    {
				"id": 20,
				"date": "2020-10-29",
				"played": false,
				"stadistics_1": null,
				"stadistics_2": null
			    },
			    {
				"id": 21,
				"date": "2020-11-19",
				"played": false,
				"stadistics_1": null,
				"stadistics_2": null
			    },
			    {
				"id": 22,
				"date": "2020-03-09",
				"played": false,
				"stadistics_1": null,
				"stadistics_2": null
			    },
			    {
				"id": 23,
				"date": "2020-03-09",
				"played": false,
				"stadistics_1": null,
				"stadistics_2": null
			    },
			    {
				"id": 24,
				"date": "2020-04-14",
				"played": false,
				"stadistics_1": null,
				"stadistics_2": null
			    }
			],
			"teams": [
			    {
				"id": 6,
				"name": "Donuts"
			    },
			    {
				"id": 8,
				"name": "VersusTeam"
			    },
			    {
				"id": 9,
				"name": "Las palmas PT"
			    },
			    {
				"id": 10,
				"name": "Getafe PT"
			    }
			]
		    }
		]


	```
* ##### Error response:

	**Code**: NOT.FOUND


#### Tournament Info By PlayerId
Allows a anonymous user to see info of one tournament given one playerId and tournament name
* ##### URL: </api/tournaments/?playerId=Long&name=String>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
 ```
				[
    {
        "id": 2,
        "name": "Tournament 2",
        "nonspacename": "Tournament2",
        "matches": [
            {
                "id": 7,
                "date": "2019-11-19",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 15,
                    "unforcedErrors": 50,
                    "win": true
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 10,
                    "unforcedErrors": 50,
                    "win": false
                }
            },
            {
                "id": 8,
                "date": "2019-11-20",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 10,
                    "unforcedErrors": 50,
                    "win": false
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 14,
                    "unforcedErrors": 50,
                    "win": true
                }
            },
            {
                "id": 9,
                "date": "2019-11-21",
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
                    "games_wins": 16,
                    "unforcedErrors": 50,
                    "win": true
                }
            },
            {
                "id": 10,
                "date": "2019-11-22",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 14,
                    "unforcedErrors": 50,
                    "win": true
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 8,
                    "unforcedErrors": 50,
                    "win": false
                }
            },
            {
                "id": 11,
                "date": "2019-11-23",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 15,
                    "unforcedErrors": 50,
                    "win": true
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 8,
                    "unforcedErrors": 50,
                    "win": false
                }
            },
            {
                "id": 12,
                "date": "2019-11-24",
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
                }
            }
        ],
        "teams": [
            {
                "id": 4,
                "name": "Leones"
            },
            {
                "id": 5,
                "name": "Tigres"
            },
            {
                "id": 6,
                "name": "Donuts"
            },
            {
                "id": 7,
                "name": "Valencia PT"
            }
        ]
    }
]
```
* ##### Error response:

	**Code**: NOT.FOUND
	

#### Tournament Info By TeamId
Allows a anonymous user to see info of one tournament given one teamId and tournament name
* ##### URL: </api/tournaments/?teamId=Long&name=String>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
 ```
 [
    {
        "id": 2,
        "name": "Tournament 2",
        "nonspacename": "Tournament2",
        "matches": [
            {
                "id": 7,
                "date": "2019-11-19",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 15,
                    "unforcedErrors": 50,
                    "win": true
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 10,
                    "unforcedErrors": 50,
                    "win": false
                }
            },
            {
                "id": 8,
                "date": "2019-11-20",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 10,
                    "unforcedErrors": 50,
                    "win": false
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 14,
                    "unforcedErrors": 50,
                    "win": true
                }
            },
            {
                "id": 9,
                "date": "2019-11-21",
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
                    "games_wins": 16,
                    "unforcedErrors": 50,
                    "win": true
                }
            },
            {
                "id": 10,
                "date": "2019-11-22",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 14,
                    "unforcedErrors": 50,
                    "win": true
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 8,
                    "unforcedErrors": 50,
                    "win": false
                }
            },
            {
                "id": 11,
                "date": "2019-11-23",
                "played": true,
                "stadistics_1": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 15,
                    "unforcedErrors": 50,
                    "win": true
                },
                "stadistics_2": {
                    "acurracy": 23,
                    "effectiveness": 57,
                    "games_wins": 8,
                    "unforcedErrors": 50,
                    "win": false
                }
            },
            {
                "id": 12,
                "date": "2019-11-24",
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
                }
            }
        ],
        "teams": [
            {
                "id": 4,
                "name": "Leones"
            },
            {
                "id": 5,
                "name": "Tigres"
            },
            {
                "id": 6,
                "name": "Donuts"
            },
            {
                "id": 7,
                "name": "Valencia PT"
            }
        ]
    }
]
				
    
```
* ##### Error response:

	**Code**: NOT.FOUND

Allows a anonymous user to see info of the ranking of a tournament
* ##### URL: </api/tournament/{id}/ranking>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
 ```
 [
    {
        "id": 1,
        "name": "Madrid PT",
        "gamesWon": 3,
        "gamesPlayed": 3,
        "gamesLost": 0,
        "hasLastMatches": true,
        "lastMatches": [
            "w",
            "w",
            "w"
        ]
    },
    {
        "id": 2,
        "name": "Atletico PT",
        "gamesWon": 1,
        "gamesPlayed": 3,
        "gamesLost": 2,
        "hasLastMatches": true,
        "lastMatches": [
            "l",
            "l",
            "w"
        ]
    },
    {
        "id": 3,
        "name": "Barcelona PT",
        "gamesWon": 1,
        "gamesPlayed": 3,
        "gamesLost": 2,
        "hasLastMatches": true,
        "lastMatches": [
            "l",
            "w",
            "l"
        ]
    },
    {
        "id": 4,
        "name": "Leones",
        "gamesWon": 1,
        "gamesPlayed": 3,
        "gamesLost": 2,
        "hasLastMatches": true,
        "lastMatches": [
            "l",
            "l",
            "w"
        ]
    }
]
```
* ##### Error response:

	**Code**: NOT.FOUND


Allows a anonymous user to see info of the tournament its matches and its teams 	 	 
* ##### URL: </api/tournament/{id}>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
 ```
 {
    "id": 1,
    "name": "Tournament 1",
    "nonspacename": "Tournament1",
    "matches": [
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
            }
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
            }
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
            }
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
            }
        },
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
            }
        },
        {
            "id": 6,
            "date": "2019-10-25",
            "played": true,
            "stadistics_1": {
                "acurracy": 23,
                "effectiveness": 57,
                "games_wins": 14,
                "unforcedErrors": 50,
                "win": true
            },
            "stadistics_2": {
                "acurracy": 23,
                "effectiveness": 57,
                "games_wins": 10,
                "unforcedErrors": 50,
                "win": false
            }
        }
    ],
    "teams": [
        {
            "id": 1,
            "name": "Madrid PT"
        },
        {
            "id": 2,
            "name": "Atletico PT"
        },
        {
            "id": 3,
            "name": "Barcelona PT"
        },
        {
            "id": 4,
            "name": "Leones"
        }
    ]
}
```
* ##### Error response:

	**Code**: NOT.FOUND

Allows a logged player to register into a tournament with a team.
* ##### URL: </api/tournament/{id}>

* ##### Method:

	`PUT`
* ##### Example Body
```
{
	"playerId": 8,
	"teamName": "ElEquipoDeDani"
}
```
* ##### Success Response:
```
{
    "id": 3,
    "name": "Tournament 3",
    "nonspacename": "Tournament3",
    "matches": [
        {
            "id": 13,
            "date": "2019-10-20",
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
            }
        },
        {
            "id": 14,
            "date": "2019-11-22",
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
                "games_wins": 16,
                "unforcedErrors": 50,
                "win": true
            }
        },
        {
            "id": 15,
            "date": "2019-11-23",
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
                "games_wins": 15,
                "unforcedErrors": 50,
                "win": true
            }
        },
        {
            "id": 16,
            "date": "2019-11-24",
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
            }
        },
        {
            "id": 17,
            "date": "2019-11-25",
            "played": true,
            "stadistics_1": {
                "acurracy": 23,
                "effectiveness": 57,
                "games_wins": 14,
                "unforcedErrors": 50,
                "win": true
            },
            "stadistics_2": {
                "acurracy": 23,
                "effectiveness": 57,
                "games_wins": 9,
                "unforcedErrors": 50,
                "win": false
            }
        },
        {
            "id": 18,
            "date": "2019-11-26",
            "played": true,
            "stadistics_1": {
                "acurracy": 23,
                "effectiveness": 57,
                "games_wins": 10,
                "unforcedErrors": 50,
                "win": false
            },
            "stadistics_2": {
                "acurracy": 23,
                "effectiveness": 57,
                "games_wins": 14,
                "unforcedErrors": 50,
                "win": true
            }
        },
        {
            "id": 19,
            "date": "2020-03-23",
            "played": false,
            "stadistics_1": null,
            "stadistics_2": null
        },
        {
            "id": 20,
            "date": "2020-10-30",
            "played": false,
            "stadistics_1": null,
            "stadistics_2": null
        },
        {
            "id": 21,
            "date": "2020-11-20",
            "played": false,
            "stadistics_1": null,
            "stadistics_2": null
        },
        {
            "id": 22,
            "date": "2020-03-10",
            "played": false,
            "stadistics_1": null,
            "stadistics_2": null
        },
        {
            "id": 23,
            "date": "2020-03-10",
            "played": false,
            "stadistics_1": null,
            "stadistics_2": null
        },
        {
            "id": 24,
            "date": "2020-04-15",
            "played": false,
            "stadistics_1": null,
            "stadistics_2": null
        }
    ],
    "teams": [
        {
            "id": 6,
            "name": "Donuts"
        },
        {
            "id": 8,
            "name": "VersusTeam"
        },
        {
            "id": 9,
            "name": "Las palmas PT"
        },
        {
            "id": 10,
            "name": "Getafe PT"
        },
        {
            "id": 12,
            "name": "ElEquipoDeDani"
        }
    ]
} 
```
* ##### Error response:

	**Code**: NOT.FOUND
	**Code**: UNAUTHORIZED
	**Code**: NOT_IMPLEMENTED


## Team Related

#### Team Info By TeamId
Allows a anonymous user to see info of one team by teamID
* ##### URL: </api/teamx/Long>

* ##### Method:

	`GET`
	
* ##### Success Response:
```
{
    "id": 2,
    "name": "Atletico PT",
    "players": [
        {
            "age": 23,
            "countryBirth": "Netherland",
            "user": {
                "name": "Pepe Dominguez"
            }
        },
        {
            "age": 24,
            "countryBirth": "Spain",
            "user": {
                "name": "Baltasar Cardiel"
            }
        }
    ],
    "teamStatistics": {
        "totalGames": 3,
        "totalWins": 1,
        "totalDefeats": 2,
        "totalAcurracy": 135,
        "totalEffectiveness": 173,
        "totalGamesWon": 34,
        "totalUnforcedErrors": 149,
        "gamesPerMatch": [
            {
                "games": 13
            },
            {
                "games": 8
            },
            {
                "games": 13
            }
        ]
    }
}
```
* ##### Error response:

	**Code**: NOT.FOUND

#### Get all teams basic info
Allows a anonymous user to see a list of team names
* ##### URL: </api/teamsList/>

* ##### Method:

	`GET`
	
* ##### Success Response:
```
[
    [
        "1",
        "Madrid PT"
    ],
    [
        "2",
        "Atletico PT"
    ],
    [
        "3",
        "Barcelona PT"
    ],
    [
        "4",
        "Leones"
    ],
    [
        "5",
        "Tigres"
    ],
    [
        "6",
        "Donuts"
    ],
    [
        "7",
        "Valencia PT"
    ],
    [
        "8",
        "VersusTeam"
    ],
    [
        "9",
        "Las palmas PT"
    ],
    [
        "10",
        "Getafe PT"
    ]
]
```
* ##### Error response:

	**Code**: NOT.FOUND
	
#### Get Teams Info by PlayerId
Allows a anonymous user to see a list of teams which have a player as a member
The playerId parameter is not required, if its empty then the requests allows to see the list of all the teams
* ##### URL: </api/teams/?playerId={Long}>

* ##### Method:

	`GET`
	
* ##### Success Response:
```
[
    {
        "id": 9,
        "name": "Las palmas PT",
        "players": [
            {
                "age": 29,
                "countryBirth": "Spain",
                "user": {
                    "name": "Jordi Hurtado"
                }
            },
            {
                "age": 21,
                "countryBirth": "Spain",
                "user": {
                    "name": "Marco Gutierrez"
                }
            }
        ],
        "teamStatistics": {
            "totalGames": 3,
            "totalWins": 1,
            "totalDefeats": 2,
            "totalAcurracy": 69,
            "totalEffectiveness": 171,
            "totalGamesWon": 36,
            "totalUnforcedErrors": 150,
            "gamesPerMatch": [
                {
                    "games": 16
                },
                {
                    "games": 10
                },
                {
                    "games": 10
                }
            ]
        }
    },
    {
        "id": 10,
        "name": "Getafe PT",
        "players": [
            {
                "age": 21,
                "countryBirth": "Spain",
                "user": {
                    "name": "Marco Gutierrez"
                }
            },
            {
                "age": 40,
                "countryBirth": "United Kindgdom",
                "user": {
                    "name": "Baldwin Carillo"
                }
            }
        ],
        "teamStatistics": {
            "totalGames": 3,
            "totalWins": 2,
            "totalDefeats": 1,
            "totalAcurracy": 69,
            "totalEffectiveness": 171,
            "totalGamesWon": 38,
            "totalUnforcedErrors": 150,
            "gamesPerMatch": [
                {
                    "games": 15
                },
                {
                    "games": 9
                },
                {
                    "games": 14
                }
            ]
        }
    }
]
```
* ##### Error response:

	**Code**: NOT.FOUND
	
## User related

#### Save New User
Allows a anonymous user create an account

* ##### URL:

	< /user/saveUser >

* ##### Method:

	`POST`
	
* ##### Success Response:
  
  	```
		{
		    "id": 22,
		    "name": "lucas",
		    "passwordHash": "$2a$10$gXUlEZ079uVejZ9A5Rxey.t769zEysx/ESpEViQnzfUUDOe9y4vsq",
		    "mail": "procesosoftg1@gmail.com",
		    "roles": [
			"ROLE_USER"
		    ],
		    "player": null
		}
	```
  
* ##### Error response:

	**Code**: NOT.FOUND

## Player Related

#### Save New Player
when a user is created, a player is created

* ##### URL:

	< /player/savePlayer >

* ##### Method:

	`POST`
	
* ##### Success Response:
  
  	```
		{
		    "id": 21,
		    "age": 48,
		    "countryBirth": "France",
		    "height": 1.9,
		    "weight": 45.0,
		    "speed": 10.0,
		    "strength": 1.3,
		    "endurance": 3.4,
		    "pace": 5.6,
		    "accuaracy": 5.0,
		    "aceleration": 6.7,
		    "user": {
			"name": "lucas"
		    }
		}
	```
  
* ##### Error response:

	**Code**: NOT.FOUND

#### Player Info By PlayerId
Allows a anonymous user to see info of one player by playerID
* ##### URL: </api/player/Long>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
 ```
	{
    "id": 18,
    "age": 21,
    "countryBirth": "Spain",
    "height": 1.7,
    "weight": 70.0,
    "speed": 8.0,
    "strength": 5.6,
    "endurance": 5.9,
    "pace": 3.4,
    "accuaracy": 8.0,
    "aceleration": 4.5,
    "user": {
        "name": "Marco Gutierrez",
        "mail": "marcogutierrez@gmail.com"
    }
}
    
    
```
* ##### Error response:

	**Code**: NOT.FOUND
	
#### Get Player Image
Allows a anonymous user to see the image of a player
* ##### URL: </api/player/Long/image>

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  
```
 The image of the player 
    
```
* ##### Error response:

	**Code**: NOT.FOUND

#### Set Player Image
Allows a logged player to change its image
* ##### URL: </api/player/Long/image>

* ##### Method:

	`GET`
* ##### Body:
	`Key: image| Value (file): image File Desired` 
* ##### Success Response:
  
  
```
 The new image of the player
```
* ##### Error response:

	**Code**: UNAUTHORIZED
	



