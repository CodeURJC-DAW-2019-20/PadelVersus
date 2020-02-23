# PadelVersus

# Fase 0
### Team members

| Name | Mail | Github user|
|--------|--------|------------|
|Alejandro Checa Folguera| a.checa.2016@alumnos.urjc.es| AlexCh98 |
|Iván Martín Sanz| i.martins.2016@alumnos.urjc.es | i100van |
|José Luis Lavado Sánchez | jl.lavado.2016@alumnos.urjc.es | lujoselu98 |
|Lucas Gómez Torres | l.gomezt.2016@alumnos.urjc.es | LucasGomezTorres |
|Daniel Carmona Pedrajas | d.carmonape@alumnos.urjc.es | Dacarpe03 |

### Other tools used 
#### Trello 
https://trello.com/b/FH0qaXPJ/daw

### Sections description

#### Entities
Users, teams, tournament, game. Relations:
* Games are played by teams.
* Tournament are composed by teams.
* Teams are composed by users.

#### Users and permissions

* **Anonymous user**:Read permission over rankings, team statistics, game's calendar and other info.
* **Loged user**: All permission of Anonymous user. Write pemission over tournament registration to join them. Write permisions over his  personal and login data and his team information data. 
* **Admin user**: Read permission over all website data. Write over all website data (not login data).

#### Images

Loged users can upload images to their profile. Loged users and Admin can upload photos of the games.

#### Graphics 

Loged users can see user graphics of their statistics they can choose between diferent formats.

#### Complementary technology

* Emails sent to the players as a remainder of the game.
* Login with facebook, twitter or google.
* API REST from diferent social media used to post info and results about the games.
* API from GoogleCalendar to be able to show the matches loaded from the database.

#### Advanced Algorithmic

The webapp will implement ELO ranking system automatically calculated.

# Fase 1

### Snapshots
#### Home
This window will show you some matches of the tournament with their dates, and their places. Moreover, will show you the latest matches and the next matches and the main managers.
![Home](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/Captura.JPG)
#### Loggin
Here, you will can log in on the site with your username and your password.
![Log](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/Loggin.JPG)
#### SignUp
Here, you will can sign up on the page, with your username, your password and your email.
![SingUp](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/singup.JPG)
#### Matches
Contains two list. One for the latest matches and another one for the next matches shown in a slider where you can navigate through next days.
#### SpecificMatch
Contains the score of the match and their  Match Statistics.
![SpecMatch](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/SpecificMatch.PNG)
#### Teams
Contains a slider where you can navigate between tournaments to see which teams are inscribed in them.
![Teams](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/Teams.PNG)
#### SpecificTeam
A page where the team logo, the team name and its two members are shown. Below this information we find statistics about the team.
![SpecTeam](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/SpecificTeam.PNG)
#### Player/User
This window will show you main features of the players of each team, the last five matches, the club history and the trophies. Moreover, it shows you the minutes played, one summary of the player, detailed player statistics (graphic)and his points per game (graphic).
![UserView](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/PlayerView.jpg)
#### Registration Tournament
You will can choose tournament, write your team name and upload team logo. Moreover, you will can write the first name (player1) and the second player will be found for join to first player.
![RegTournament](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/RegistrationTournament.JPG)
#### Calendar
Contains one calendar with the matches of each month.
![Calendar](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/Calendar.JPG)
### Flow Diagram
![Diagram](https://raw.githubusercontent.com/CodeURJC-DAW-2019-20/PadelVersus/master/WebImages/flowDiagram.JPG)

# Fase 2
## Description of the Fase

## Top 5 Most Important Commits
| Name | Github user | Most Important | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |--------|--------|--------|--------|
|Iván Martín Sanz| i100van |[Querys for replace filtrating](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/99/commits/1b85ee8a3088fe5d7b0a4f001b14fceed9ef9ca2)|[Port a MySql](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/94/commits/5478a687bb00bf60b6e1562ddbd051419fbc0ead)|[Loggin with FaceBook](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/59/commits/7e8c8814a3e0abfc990ec2a1f0778d8a1afe088e)|[OverviewMatches](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/61/commits/ebb38fada33539d8eedc7d311b79304ba27a9eae)|[Pageable for Teams](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/79)|
|José Luis Lavado Sánchez | lujoselu98 |--------|--------|--------|--------|--------|
|Lucas Gómez Torres | LucasGomezTorres |[MustacheMatches](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/e26730f6ab91259798696caf017d55c2e74ca619)|[mustacheIndex](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/368f9b73872e730d7205d4fad6bf45020402f3ae)|[Player_Profile](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/69c405b74118de66ac10e8e84dc57c707904351f)|[Player_Graphics](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/51ac63ceceaaab61433c9bf8c814d964d96201fb)|[Logic_Player](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/0d4eb3beb655b006426726f78bc1aa15d2c136fe)|
|Daniel Carmona Pedrajas | Dacarpe03 | [Team Service](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/a39d30ad9e38b3e6768799ccf7ec890d7cfa2f24) | [Player Profile Editing](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/5d5bf1b79bb99b0f7b08747cf8ac8f6fcb5f0f9c) | [Teamx Page Mustache](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/a5a059cf41f9a0c7d94a4f65b49077221f6c33a7) | [TeamStatistics](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/9fa9062167c712b516ac248fc21b69192747c70b) | [TeamEntity](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/676b7cf1a527192674cdf77663347693a2739b9f) |

## Files focused on
| Name | Github user | 1 | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98|--------|--------|--------|--------|
|Iván Martín Sanz | i100van |SocialFacebookControler.java|MatchStadistics.java|overviewMatch.html|index.html|MatchStadisticsControler.java|
|José Luis Lavado Sánchez | lujoselu98 |--------|--------|--------|--------|--------|
|Lucas Gómez Torres | LucasGomezTorres |--------|--------|--------|--------|--------|
|Daniel Carmona Pedrajas | Dacarpe03 |TeamService.java|LastMatchDisplay.java|teamx.html|Team.java|AdminController.java|

## Textual Description Of Work
| Name | Github user | Description |
|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |--------|
|Iván Martín Sanz|  i100van |Normally tasks of use of API, application of templates Mustache, port to mySQL, and html files of matches.|
|José Luis Lavado Sánchez | lujoselu98 |--------|
|Lucas Gómez Torres |  LucasGomezTorres |--------|
|Daniel Carmona Pedrajas | Dacarpe03 |Mainly tasks related to the team entity such as teamController or teamService besides templating html pages with Mustache, also helped on player and admin tasks and a minor SQL query|
## Navigation
![FlowDiagramFase2](WebImages/FlowDiagramF2.png)
## Entity Diagram
![EntityDiagram](WebImages/entityDiagram.png)
## Class/Template Diagram

## Demo Structure
