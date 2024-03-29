# PadelVersus
## Table of content
- [Fase 0](#fase-0)
    + [Team members](#team-members)
    + [Other tools used](#other-tools-used)
      - [Trello](#trello)
    + [Sections description](#sections-description)
      - [Entities](#entities)
      - [Users and permissions](#users-and-permissions)
      - [Images](#images)
      - [Graphics](#graphics)
      - [Complementary technology](#complementary-technology)
      - [Advanced Algorithmic](#advanced-algorithmic)
- [Fase 1](#fase-1)
    + [Snapshots](#snapshots)
      - [Home](#home)
      - [Loggin](#loggin)
      - [SignUp](#signup)
      - [Matches](#matches)
      - [SpecificMatch](#specificmatch)
      - [Teams](#teams)
      - [SpecificTeam](#specificteam)
      - [Player/User](#playeruser)
      - [Registration Tournament](#registration-tournament)
      - [Calendar](#calendar)
    + [Flow Diagram](#flow-diagram)
- [Fase 2](#fase-2)
  * [Description of the Fase](#description-of-the-fase)
  * [Top 5 Most Important Commits](#top-5-most-important-commits)
  * [Files focused on](#files-focused-on)
  * [Textual Description Of Work](#textual-description-of-work)
  * [Steps for making the website:](#steps-for-making-the-website)
    + [We start with the player class:](#we-start-with-the-player-class)
    + [Highlighting the creation of security:](#highlighting-the-creation-of-security)
  * [New templates](#new-templates)
    + [Registration For a Tournament](#registration-for-a-tournament)
    + [SignUp Form](#signup-form)
    + [Admin Page](#admin-page)
    + [LogOut Page](#logout-page)
    + [Specific Team Page Update](#specific-team-page-update)
    + [404 Page](#404-page)
    + [Comming Soon](#comming-soon)
    + [Unexpected Error](#unexpected-error)
  * [Navigation](#navigation)
  * [Entity Diagram](#entity-diagram)
  * [Class/Template Diagram](#classtemplate-diagram)
  * [Demo Structure](#demo-structure)
  * [Changes:](#changes)
    + [Complementary technology](#complementary-technology-1)
    + [Advanced Algorithms](#advanced-algorithms)
- [Fase 3](#fase-3)
  * [Description of the Fase](#description-of-the-fase-1)
  * [Top 5 Most Important Commits](#top-5-most-important-commits-1)
  * [Files focused on](#files-focused-on-1)
  * [Textual Description Of Work](#textual-description-of-work-1)
  * [Steps for making the API:](#steps-for-making-the-api)
  * [Steps for use Docker:](#steps-for-use-docker)
  * [API Documentation](#api-documentation)
  * [Class/Template Diagram Updated](#classtemplate-diagram-updated)
  * [Dockerized application execution instructions](#dockerized-application-execution-instructions)
  * [Demo Structure](#demo-structure-1)
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
![Home](WebImages/Captura.JPG)
#### Loggin
Here, you will can log in on the site with your username and your password.
![Log](WebImages/Loggin.JPG)
#### SignUp
Here, you will can sign up on the page, with your username, your password and your email.
![SingUp](WebImages/singup.JPG)
#### Matches
Contains two list. One for the latest matches and another one for the next matches shown in a slider where you can navigate through next days.
#### SpecificMatch
Contains the score of the match and their  Match Statistics.
![SpecMatch](WebImages/SpecificMatch.PNG)
#### Teams
Contains a slider where you can navigate between tournaments to see which teams are inscribed in them.
![Teams](WebImages/Teams.PNG)
#### SpecificTeam
A page where the team logo, the team name and its two members are shown. Below this information we find statistics about the team.

![SpecTeam](WebImages/SpecificTeam.PNG)
#### Player/User
This window will show you main features of the players of each team, the last five matches, the club history and the trophies. Moreover, it shows you the minutes played, one summary of the player, detailed player statistics (graphic)and his points per game (graphic).

![UserView](WebImages/PlayerView.JPG)
#### Registration Tournament
You will can choose tournament, write your team name and upload team logo. Moreover, you will can write the first name (player1) and the second player will be found for join to first player.
![RegTournament](WebImages/RegistrationTournament.JPG)
#### Calendar
Contains one calendar with the matches of each month.

![Calendar](WebImages/Calendar.JPG)
### Flow Diagram
![Diagram](WebImages/flowDiagram.JPG)

# Fase 2
## Description of the Fase
Implements web app with Spring Boot, moustache for templating, MySQL for data base.
## Top 5 Most Important Commits
| Name | Github user | Most Important | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |[Admin Page](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/9f20e8eea84c41ba3f46370919e08cbf6c793c26)|[Sign Up](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/1fc40aaa71d98cf12a075acda600d6ee86f413af)|[Automatic Email](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/165a8af7b312e2d231850faa3fe1fb89cfd30334)|[Log In Page](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/29e373af2504503ee12e07ffa6cceeb171914ca0)|[Spring Security](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/2f56a759a3b6f6eb5cbf58922587467ae8dea98b)
|Iván Martín Sanz| i100van |[Querys for replace filtrating](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/99/commits/1b85ee8a3088fe5d7b0a4f001b14fceed9ef9ca2)|[Port a MySql](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/94/commits/5478a687bb00bf60b6e1562ddbd051419fbc0ead)|[Loggin with FaceBook](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/59/commits/7e8c8814a3e0abfc990ec2a1f0778d8a1afe088e)|[OverviewMatches](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/61/commits/ebb38fada33539d8eedc7d311b79304ba27a9eae)|[Pageable for Teams](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/pull/79)|
|José Luis Lavado Sánchez | lujoselu98 |[Tournaments](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/280ae432237e6b7595b751fae3dc9535d470adf6)|[Tournaments pdf](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/a417cf136e03161e2b1732810d60b5343fbab49a)|[Link player with users](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/14fd350a32320741ab33691ef119a0cb2990a489)|[Error handling](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/c46870b7ffadc076c9839487cd0dbb9ecc476adb)|[Navbar based on logged user](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/af8c2c0c555cd6252e70e32b28f32a06a7f2d11a)|
|Lucas Gómez Torres | LucasGomezTorres |[Matches Page Mustache](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/e26730f6ab91259798696caf017d55c2e74ca619)|[Index Page Mustache](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/368f9b73872e730d7205d4fad6bf45020402f3ae)|[Player_Profile](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/69c405b74118de66ac10e8e84dc57c707904351f)|[Player_Graphics](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/51ac63ceceaaab61433c9bf8c814d964d96201fb)|[Logic_Player](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/0d4eb3beb655b006426726f78bc1aa15d2c136fe)|
|Daniel Carmona Pedrajas | Dacarpe03 | [Team Service](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/a39d30ad9e38b3e6768799ccf7ec890d7cfa2f24) | [Player Profile Editing](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/5d5bf1b79bb99b0f7b08747cf8ac8f6fcb5f0f9c) | [Teamx Page Mustache](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/a5a059cf41f9a0c7d94a4f65b49077221f6c33a7) | [TeamStatistics](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/9fa9062167c712b516ac248fc21b69192747c70b) | [TeamEntity](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/676b7cf1a527192674cdf77663347693a2739b9f) |

## Files focused on
| Name | Github user | 1 | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98|AdminController.java|UserController.java|adminPage.html|signUp.html/logIn.html|SecurityConfiguration.java
|Iván Martín Sanz | i100van |SocialFacebookControler.java|MatchStadistics.java|overviewMatch.html|index.html|MatchStadisticsControler.java|
|José Luis Lavado Sánchez | lujoselu98 |TournamentService.java|ImageService.java|tournaments.html|registerTournament.html|PdfService.java|
|Lucas Gómez Torres | LucasGomezTorres |MatchService.java|Matches.html|index.html|PlayerController.java|Player.java|
|Daniel Carmona Pedrajas | Dacarpe03 |TeamService.java|LastMatchDisplay.java|teamx.html|Team.java|AdminController.java|

## Textual Description Of Work
| Name | Github user | Description |
|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |All the securityof spring boot. The log in and sign up form with their controllers. Email automatic sending when sign up and start spring boot proyect and merging the page in phase 1 with my teammates.|
|Iván Martín Sanz|  i100van |Normally tasks of use of API, application of templates Mustache, port to mySQL, and html files of matches.|
|José Luis Lavado Sánchez | lujoselu98 |Mainly task related with tournaments logic on TournamentService and display on mustache template, also logic to register team into tournament and pdf library to generate tournament ranking exportable pdf. All error handling via html for wellkonwn errors and via ``` @ControllerAdvice ``` for unexpected unhandled errors. Interceptor to generate the navbar links based on logged user. Link the player and user entity on the database at signup.|
|Lucas Gómez Torres |  LucasGomezTorres |Mainly tasks related to the player entity  such as playerController or playerService besides templating html with mustache in files as index.html or player.html, also helped on matches. |
|Daniel Carmona Pedrajas | Dacarpe03 |Mainly tasks related to the team entity such as teamController or teamService besides templating html pages with Mustache, also helped on player and admin tasks and a minor SQL query|

## Steps for making the website: 
1. Create the html template with css, js ... 
2. Create a spring project with maven and web dependencies, devtools, jpa, h2, mustache. 
3. Create in resources a static folder and another of templates. 
4. We put all our css, js, images and static elements that we already had in the static folder. 
5. We put the html in the templates folder because we will use mustache and it is the configuration that it requires. 
6. We will have to change the links to all the css, js from the html because the static address does not work, so we will have to put, for example, /css/library/bootstrap.css 
7. In the application.properties file we add: 
  a. ``` spring.mustache.suffix = .html ``` 
    i. so that mustache understands the .html files. 
  b. ``` spring.h2.console.enabled = true ```
    i. For h2 to work. 
8. We tried to make everything work. 
9. To see that the bbdd works, we load localhost: ```port / h2-console ``` and on the screen that comes out, we will have to leave everything the same changing what is in JDBC URL by jdbc: h2: mem: testdb and should connect and see the administrator of the bbdd. 
10 .The project could already be uploaded to github, because it works, even if it doesn't detect the links between html (index load only). 

### We start with the player class: 

1. We create a controller class and add the request Mapping in the controller to have the url defined. 
2. Later, we create the java class to define the entity (@Entity) in the bbdd, we put the attributes, define the id with @Id and ```java @GeneratedValue (strategy = GenerationType.IDENTITY)``` together with all the getters and setters and constructor (empty and with all the parameters minus id) 
3. We create a repository class of the previous entity, for example: 
  a. ```java public interface PlayerRepository extends JpaRepository <Player, Long> ```
4. Next, we create: 
  a. ```java public Optional <Player> findById (long id)  ```
    i. This method method in the PlayerRepository, so we can search for the Id from the class. 
5. To initialize the database with sample data we have Application implement ApplicationRunner. We add an @Autowired from each repository and initialize the values in the main method using the save method of the repository. 
6. An example we are talking about is: 
 ```java
      @GetMapping("/{id}")  
      public String player(Model model, @PathVariable Long id){  
              Optional<Player> player = playerRepository.findById(id);  
              if (player.isPresent()) {  
                  model.addAttribute("name", player.get().getUsername());  
                  return "player";  
              } else {  
                  return "404";  
              }  
      }  
```
This is what we have done with the rest of the classes to generate our bbdd scheme. 

### Highlighting the creation of security: 

  You have to add the security dependency to the pom, and after that, define a class where you set the privileges for the different roles, and the restricted pages based on each role. In addition, to specifying how to log in, and the methods that will manage this, the logout... Finally, it would be necessary to create the keystore (certificate) that is what will accredit the https page, and add in the application properties server.ssl.key-store = classpath: keystore.jks, server.ssl.key-store-password = password and server.ssl.key-password = secret 

Once everything is configured, what we will do is create the necessary queries to load our information on the page, which will be done in a java class called repository, and where each sentence will be preceded by @Query, indicating that it is a query, being an example the following: 
```java
      @Query (value = 
      "SELECT m. *" + 
      "FROM tournament_matches tm" + 
      "INNER JOIN tournament t ON tm.tournament_id = t.id" + 
      "INNER JOIN games m ON tm.matches_id = m.id" + 
      "WHERE NOT played and t.name =? 1", 
      nativeQuery = true) 
      List <Match> findNotPlayedByTournamentName (String name); 
```
Later, we will make the change from h2 to mysql, adding the dependency of mysql to the pom and removing the h2, and adding in the application properties the url, username and pass of access to the bbdd. 
Finally, if you want you can add CSRF to avoid this type of attacks, deleting in the security configuration class the line crsf.disable (); and adding in all html where there is a form the following: <input type = "hidden" name = "_ csrf" value = "{{token}}" />. In addition to a CSRF Handler class that handles the configuration. 
As we said, all this page was done with mustache, html, css, java and javascript, in addition to spring boot and Maven. 

## New templates
### Registration For a Tournament
![ResgistationTournament](WebImages/RegistrationTorunament.JPG)
### SignUp Form
![SignUp Form](WebImages/SignUpForm.JPG)
### Admin Page
![Admin Page](WebImages/AdminPage.JPG)
### LogOut Page
![LogOut Page](WebImages/LogOutPage.JPG)
### Specific Team Page Update
![Specific Team Page Update](WebImages/SpecificTeam.JPG)
### 404 Page
![404Error](WebImages/Error404.JPG)
### Comming Soon
![ComingSoon](WebImages/CommingSoon.JPG)
### Unexpected Error
![UnexpectedError](WebImages/UnexpectedError.JPG)

## Navigation
![FlowDiagramFase2](WebImages/FlowDiagramF2.png)
## Entity Diagram
![EntityDiagram](WebImages/entityDiagram.png)
## Class/Template Diagram
![TemplateDiagram](WebImages/TemplatesDiagram-Class.png)
## Demo Structure
1. Open Index.html and show all in it
2. Go to matches for consulting info of next matches
3. Go to teams and show ajax functionality
4. Go to Ranking and use save PDF
5. Go to registration tournament
6. Use sign up functionality and fill all the fields and upload a image
7. Show email fuctionality.
8. Log in.
9. Go again to registration tournament an fill the fields.
10. Show the ranking of the tournament.
11. On the ranking select the first teams, to show the graphics.
12. On the main bar, got to your profile, and change your image.
13. Log out and log in with the admin password: adminpass
14. Add a new match with the team we have made before.
15. Go to matches and show the match have been added.
16. Return to admin page and fill the data of that match.
17. Go to the ranking and show the consecuences, thats our advance consulting.
18. Go to matches and show the match is change from next matches to last matches, and go into the match overview and show that it have the data we have fill.
19. Then go to the team and show that the statistics have change.

 ## Changes:
### Complementary technology
* API from GoogleCalendar to be able to show the matches loaded from the database has been changed by the generation of a pdf with the data of a tournament.
* Emails sent to the players as a remainder of the game has been changed by an email sent when user create a new account.
* Login with facebook, twitter or google changed by a twitter collection in main page.
### Advanced Algorithms
The ELO system has been replaced by the calculation of the ranking in each update made by the admin of the games played, and advanced querys to fill the data such as:
```java
   @Query(value = "SELECT m.* " +
            "FROM tournament_matches AS tm " +
            "INNER JOIN tournament t ON tm.tournament_id = t.id " +
            "INNER JOIN(" +
            "SELECT id, date, played, stadistics_1_id, stadistics_2_id " +
            "FROM (" +
            "SELECT t.name as team_name , g.id as match_id, g.* " +
            "FROM games_teams AS gt " +
            "INNER JOIN games g ON gt.match_id = g.id " +
            "INNER JOIN team t ON gt.teams_id = t.id " +
            "WHERE t.name=?1 OR t.name=?2 " +
            "GROUP BY g.id " +
            "HAVING count(g.id)>1 " +
            ") AS joinned_table " +
            ") m ON tm.matches_id = m.id " +
            "WHERE NOT played and t.name = ?3 ",
            nativeQuery = true)
    Optional<Match> findIdByTeamsNameAndTournamentName(String t1, String t2, String tName);
  ```
# Fase 3
## Description of the Fase
Creating API services of our website, and use Docker to launch.
## Top 5 Most Important Commits
| Name | Github user | Most Important | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |[NewPlayerApi](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/c98031c1498c5455b975215b2ec7bd3d3230737b)|[NewUserApi](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/eec5492057e301a3135d70cf5f08029e864dcedd)|[AdminPageApi](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/fcadb39fd8373520af5176140b8cfc539a54cae3)|[StatsMatchApi](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/2ec87017bec749bbc47a36ab58337eb7a2a64967)|[NewTournamentApi](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/b214be752d039eafae4da5708f4f50be690df440)|
|Iván Martín Sanz| i100van |[MatchApiCompleted](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/8b181b23047ed1e425f16184113674d3e20602a5)|[APIDocumentation](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/e52337d6253793b567b5a8a83db6bd69628e74b1)|[FutureMatches](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/6af0abe4de17dae0bde2c87c8c62ab9a7a9d08f1)|[ConcreteMatchAndAllMacthes](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/e666e13a0070bead8f55f21706a986917e5e39c6)|[MatchAPISimplified](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/cf9102316519b6b910a471f5e7c14cf328316953)|
|José Luis Lavado Sánchez | lujoselu98 |[Tournament Rest Controller](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/6ec2b57bb212fb8ec5e03d4331bb4ad8a19f6625)|[Pom and Script for docker](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/337e04b793aeddaf11afde7cea8523d2169b3def)|[ErrorHandling](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/57b38d563df2b3dc1f658163e2a84091f5b808f8)|[Docker Compose](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/7b8db2e268d651bad37b69cb6c7b73c5af1feddc)|[Manage session](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/758c7206d1a1d229dd6231e86ccbec57643f874d)|
|Lucas Gómez Torres | LucasGomezTorres |[TournamentRestController](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/e95f4f0d448cbf826e6b1b211f48adcb8ba92d69)|[PlayerRestController](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/bf2be34256b32e7b8e62e4f52a1f516c68d26649)|[PlayerEntityApi](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/338ddead407b4dd35f7957e739dde3cf5a585022)|[TeamsByPlayerIdRequest](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/2752231e42cac2d92966e4cbece5630258bb6b7b)|[AddDiagramTemplate](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/02dff9009d18d035d28967e702f19d2bebca68ec)|
|Daniel Carmona Pedrajas | Dacarpe03 |[TeamRestController](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/d50874f9aec3045e7254369887d693db5dc1acc6)|[PlayerRestController](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/16b1b275bf0db5b8d7ff2c8f97083efbd488e710)|[TeamsByPlayerIdRequest](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/2752231e42cac2d92966e4cbece5630258bb6b7b)|[PlayerImageEditing](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/16b1b275bf0db5b8d7ff2c8f97083efbd488e710)|[TeamStatistics](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/ad9dbda9bea2b666e5d514bbbc48cff878e86f8b)|
## Files focused on
| Name | Github user | 1 | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98|PlayerRestController.java|UserRestController.java|MatchRestController.java|MatchCreate.java|RestLoginController.java|
|Iván Martín Sanz | i100van |MatchRestControler.java|Match.java|MatchStatistics.java|API.md|MatchService.java|
|José Luis Lavado Sánchez | lujoselu98 |TournamentRestController.java |RestSecurityConfiguration.java |ExceptionHandlerControllerApi.java | Script.ps1| docker-compose.yml|
|Lucas Gómez Torres | LucasGomezTorres |TournamentRestController.java|PlayerRestController.java|Player.java|TeamsRestController.java|API.md|
|Daniel Carmona Pedrajas | Dacarpe03 |TeamxRestController.java|TeamsRestController.java|PlayerRestController.java|RestSecurityConfiguration.java|API.md|

## Textual Description Of Work
| Name | Github user | Description |
|--------|--------|--------|
|Alejandro Checa Folguera | AlexCh98 |Focus on all put and post api request. Basically the admin page form and the user and player creation|
|Iván Martín Sanz|  i100van |Focus on all related to matches API for API Rest service of PadelVersus,obtaining all the necessary information of the matches in Postman, document and prepare all related with the readme.md and API.md |
|José Luis Lavado Sánchez | lujoselu98 |Focus mainly on Tournament entity api queries. Also part of securing api urls and error handling. Most of the docker deployment logic.|
|Lucas Gómez Torres |  LucasGomezTorres |As a summary, I have done tasks related to the PlayerApi and TournamentApi, i have worked in PlayerRestController class and tournamentRestController class. Also I contributed on Postman to Player and Tournament Api and I did the diagramTemplate. Finally i helped a little in the TeamApi to get information about TeamsByPlayerIdRequest |
|Daniel Carmona Pedrajas | Dacarpe03 |Mainly tasks related to team API, also helped on PlayerRestController to control the image editing of an unauthorized user. Requests on Postman related to team API and player images.|

## Steps for making the API: 


## Steps for use Docker: 
1. As we are going to use a network with two dockers that communicate with each other app and database we need a docker network
```
    docker network create padelVersus-network 
```
2. Download and run the mysql:8 docker container 
```
    docker container run --name mysqldb --network padelVersus-network -e MYSQL_ROOT_PASSWORD=123456789 -e MYSQL_DATABASE=padelversus -d     mysql:8
```

To check that everything went well: 
```
    docker container logs -f mysqldb 
```
(If everything goes well put Initializaing database ... and more)
```
    docker container exec -it mysqldb bash
```
You open a bash console in the mysql base let's see that the schema has been created well
```
    mysql -uroot -p123456789
```
show databases;
(See that padelversus comes out as schema to exit and then logout)

3. Go to the intellij and change in the application.properties 
```
    spring.datasource.url=jdbc:mysql://localhost:3306/padelversus?           useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
```
by
```
    spring.datasource.url=jdbc:mysql://mysqldb:3306/padelversus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
```
and in the pom.xl+
```
    <properties>
            <java.version>1.8</java.version>
    </properties>

    <properties>
            <java.version>11</java.version>
            <start-class>com.example.padelversus.PadelversusApplication</start-class>
    </properties>
```
Go to the maven menu and running the install step creates a .jar in target to move it to a folder to organize the docker and rename it topadelverus.jar

4. Create Dockerfile
In the folder where we moved the jar create a file called Dockerfile with 
From openjdk:11
```
    copy ./padelversus.jar padelversus.jar
    CMD ["java","-jar","padelversus.jar"]
```
5. Mount the new container with from cmd (terminal) in the folder where the Dockerfile and the jar are
```
    docker image build -t padelversus -f Dockerfile .
```
6. Run the container with
```
    docker container run --network padelVersus-network --name padelversus-container -p 8443:8443 -d padelversus
```
To see that everything works 
```
    docker container logs -f padelVersus-network
```
(You have to see the typical start the spring but without colors)

Everything is ready to try, go **https: // localhost: 8443 /** and see what the page is going

And now why have to deploy Doker Compose:
```
    version: "3"
services:
  padelversus:
    image: teampina/padelversus:latest
    restart: always
    ports:
      - "8443:8443"
    networks:
      - padelVersus-network
    environment:
      WAIT_HOSTS: mysql:3306
    depends_on:
      - mysqldb
 
  mysqldb:
    image: mysql:8
    restart: on-failure
    healthcheck:
      test: "/usr/bin/mysql --user=root --password=123456789--execute \"SHOW DATABASES;\""
      interval: 2s
      timeout: 20s
      retries: 10
    networks:
      - padelVersus-network
    environment:
      - MYSQL_ROOT_PASSWORD=123456789
      - MYSQL_DATABASE=padelversus  

networks:
  padelVersus-network: 
```
Now, to prepare the folder with the necessary files to do the docker-compose up, we will use a Power Shell Script with the following commands:
```
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

```

## API Documentation

In the following link you can find everything related to the PadelVersus Rest API documentation [APIDocuments](API.md).

You can also see some examples at [Postman PadelVersus Colection](DAW.postman_collection.json)

And if you want to se documents in postamn format: [Postman Documentation](https://documenter.getpostman.com/view/10553995/SzKbNFpr?version=latest)

## Class/Template Diagram Updated
![Fase3_Diagram](WebImages/Fase3_Diagram.png)

## Dockerized application execution instructions
To run the application in docker containers, you just have to launch the Power Shell script, this will be responsible for executing the container with maven that is responsible for the construction of the jar, then moves to the Docker folder, and there we create the image, and push to the repository on docker hub.
To run the script on Windows standard cmd:
```
   C:/Windows/System32/WindowsPowerShell/v1.0/powershell.exe -File <ProjectPath>/Script.ps1
```
If you wanted to run for other os, install powershell, run pwsh, go to the project path and run the script: 
```
   ./Script.ps1
```
If you want to get the image:
```
  docker push teampina/padelversus:latest
```
To run application (daemon mode of docker):
```
  docker-compose up -d
```
To stop the application and remove containers and network (it does not remove the images).
```
  docker-compose down
```
## Demo Structure
1. First, show fuctionality of Teams and matches, notice that you dont have to be logged.
2. Make the pageable request.
3. Try to register on a tournament.
4. Notice that you need to be logged.
5. Create new user.
6. Register for a tournament.
7. Request to see tournament info.
8. Request the player info.
9. Request the player image.
10. Try to change the image of another player different from the logged user.
11. Change the image from logged player
12. Log out.
13. Log in as admin (Clean cookies first)
14. Post request to create new match with the team we have made before.
15. Request that match to see info
16. Put request to update match statistics
17. Get request to se tournament info


# Fase 4
## Description of the Fase

In this phase, we have to create an angular application connected with the api rest created in the phase 3.
The first step is installing ```node.js, npm and angular cli```. With all this correctly installed, we can create a new angular proyect in the IDE you are working on.
The next step is creating all the configuration necessary to create each module. Each part is in a folder with a component.ts where is all the logic connected with a componen.html, also a component.css with the style for this html and service.ts where you make the get, post, put or delete request to the API.
Finally, you can modify the html template making it more beautiful using ng-material, Bootstrap or primeng.
The last step, if you want to upload to Docker. You have to add the node.js container to Docker-compose and in the dockerfile, add the configuration for doing ng-build. 
With al this steps done, you have an angular application connected with an api, and Working all of this in Docker, with an springboot backend and an independent front with mustache.

## Top 5 Most Important Commits
| Name | Github user | Most Important | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
|Lucas Gómez Torres|LucasGomezTorres|[FuncionalitiesPlayerPage](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/eeb0eb1bf52b426e6d32ade7543a721db257cfe8)|[DesignPlayerPage](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/30b0ba29e4c5a0afbcf68842b84353713add21d7)|[Upload Images Working](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/4a5f0d003a8268190dceb782320c76319cd77dbf)|[Changes Images Working](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/59576e85b3f59a65f6cce199fff44b396f3247b0)|[showEmailIfPlayerIsLogged](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/84104db78f6557e688c85691786b20dec2b2f33e)|
| Ivan Martin Sanz | i100van | [FinishedMatchPage](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/aba78e9643dd8fdab6bedf5e339a11761d9a3925) | [NavBar](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/286c7bd50f79992a7af3ad95f3b0b354df30f69e) | [Footer](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/a73746dd590fc752d0bdb2c4b1152953a181b515) | [AllMatches](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/55974b44a83a1aacd0728efcdcd8f58543435402) | [LogicButtons](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/cf6f4b93be3ced213991889bcd22effda18962c2)|
| Daniel Carmona Pedrajas | Dacarpe03 | [TeamPageRemake](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/4453a96f9e6942683eb4057a6e377e81f44a5cde) | [TeamsPagination](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/3cc4eff01077f7ec77b8f65541a72de759290b88) | [ListTeamsPage](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/f5108275e040066a3e2ca7bd3d44215f0863cc9e) | [TeamService](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/bee62d4e7db0bae526a7d94fd204f97c2dbee2d5) | [PhotosCard](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/af569a7ccc2e63b1d538f63870fc3d35fcf2831e) |
| Alejandro Checa Folguera | AlexCh98 | [log in, sign up, sign up player working](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/da2cd42fa72890b707bc34b37bde710f54d3adab) | [Admin Page working](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/9140434c395acfef40bcdb816271c94b6199e762) | [Sign up player working](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/3fd3c282f165d102bd685acd3e5da7c47dc11938) | [Sign Up User working](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/619f09fe3d8fa1e0708d83a18ffacb0cf93360b3) | [Log In working](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/21df56ff0d38d9ecabb1a509bcb824ad9f7f7576) |
| José Luis Lavado Sánchez | lujoselu98 | [Tournament ranking](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/deaf21b04a3c16a3d1c38202e61884073c1a002d) | [Home](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/76c1e26af1d5319a0025b8d5645076ff36ba4bc3) | [Matches](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/210615084df7f99172bf2f5980223983dc37fb7d) | [Navigation](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/f1aef5d94ccde278c672461163706e9118f628b7) | [Error Pages](https://github.com/CodeURJC-DAW-2019-20/PadelVersus/commit/1f9105df7d72134eb4103b3e6dee4c0e1fc44948) |
## Files focused on
| Name | Github user | 1 | 2 | 3 | 4 | 5 |
|--------|--------|--------|--------|--------|--------|--------|
| Lucas Gómez Torres | LucasGomezTorres | player.component.ts | player.service.ts | radar.component.ts | images.component.ts | player.component.html | 
| Ivan Martin Sanz | i100van | match.component.ts | match.service.ts | header.component.ts | header.service.ts | footer.component.ts |
| Daniel Carmona Pedrajas | Dacarpe03 | team.component.ts | team.service.ts | teamsOfTournament.component.ts | linechart.component.ts | donutchart.component.ts |
| Alejandro Checa Folguera | AlexCh98 | signUp.component.ts | signUpPlayer.service.ts | admin.component.ts | admin.service.ts | authentication.service.ts |
| José Luis Lavado Sánchez | lujoselu98 | tournament.service.ts | tournament-registration.component.ts | tournament-ranking.component.ts | home.component.ts | next-matches-date.component.ts |
## Textual Description Of Work
| Name | Github user | Description |
|--------|--------|--------|
| Lucas Gómez Torres | LucasGomezTorres | All the funcionalities of the player component and their templates. Also all the funcionalities of the images of the page, uploads images and change images |
| Ivan Martin Sanz | i100van | Mainly tasks related to matches, and how to show them. Also header and footer with logic related to the kind of user, in all cases services to the templates of each component |
| Daniel Carmona Pedrajas | Dacarpe03 | Mainly tasks related to teams component, from the services to the templates of each component and pagination functionality. Also helped in changing the image of a player |
| Alejandro Checa Folguera | AlexCh98 | Mainly all the login, log out, sign up, sign up player tasks. Also all the authentication service logic and all the admin page for adding new match, new stats match... |
| José Luis Lavado Sánchez | lujoselu98 |Mainly all home, matches and tournament ranking and registration pages. Also make navigation and error pages (404, 403) and help with style apperance|

## Prepare Develop Enviroment
    1. The first step is installing node.js, npm and angular cli. With all this correctly installed, we can create a new angular proyect in the IDE you are working on. 
    2. The next step is creating all the configuration necessary to create each module.
    3. Each part is in a folder with a component.ts where is all the logic connected with a componen.html, also a component.css with the style for this html and service.ts where you make the get, post, put or delete request to the API.
    4. You can modify the html template making it more beautiful using ng-material, Bootstrap or primeng. The last step, if you want to upload to Docker.
    5. ```DOCKER:``` add the node.js container to Docker-compose and in the dockerfile, add the configuration for doing ng-build.
    6. Last step, there is an angular application connected with an api, and working all of this in Docker, with an springboot backend and an independent front with mustache.
## Class/Templates Diagram
Here we can see the SPA diagram os the angular application.

![Fase4_Diagram](WebImages/SPADiagram_1.png)
## Link to youtube
https://youtu.be/4jhL8U50lIA
