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

## Most Important Commits
| Name | Github user | BestCommit | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |--------|--------|--------|--------|--------|
|Iván Martín Sanz| i.martins.2016@alumnos.urjc.es | i100van |--------|--------|--------|--------|--------|
|José Luis Lavado Sánchez | jl.lavado.2016@alumnos.urjc.es | lujoselu98 |--------|--------|--------|--------|--------|
|Lucas Gómez Torres | l.gomezt.2016@alumnos.urjc.es | LucasGomezTorres |--------|--------|--------|--------|--------|
|Daniel Carmona Pedrajas | d.carmonape@alumnos.urjc.es | Dacarpe03 |--------|--------|--------|--------|--------|

## More worked file
| Name | Github user | 1 | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |--------|--------|--------|--------|--------|
|Iván Martín Sanz| i.martins.2016@alumnos.urjc.es | i100van |--------|--------|--------|--------|--------|
|José Luis Lavado Sánchez | jl.lavado.2016@alumnos.urjc.es | lujoselu98 |--------|--------|--------|--------|--------|
|Lucas Gómez Torres | l.gomezt.2016@alumnos.urjc.es | LucasGomezTorres |--------|--------|--------|--------|--------|
|Daniel Carmona Pedrajas | d.carmonape@alumnos.urjc.es | Dacarpe03 |--------|--------|--------|--------|--------|

## Textual Description Of Work
| Name | Github user | Description |
|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |--------|--------|--------|
|Iván Martín Sanz| i.martins.2016@alumnos.urjc.es | i100van |--------|--------|--------|
|José Luis Lavado Sánchez | jl.lavado.2016@alumnos.urjc.es | lujoselu98 |--------|--------|--------|
|Lucas Gómez Torres | l.gomezt.2016@alumnos.urjc.es | LucasGomezTorres |--------|--------|--------|
|Daniel Carmona Pedrajas | d.carmonape@alumnos.urjc.es | Dacarpe03 |--------|--------|--------|
## Navigation

## Entity Diagram

## Class/Template Diagram

## Demo Structure
