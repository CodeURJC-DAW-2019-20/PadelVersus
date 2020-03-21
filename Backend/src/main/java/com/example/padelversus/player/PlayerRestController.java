package com.example.padelversus.player;

import com.example.padelversus.ImageService;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserService;
import com.example.padelversus.user.UserComponent;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.ValueExp;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.MediaType.IMAGE_JPEG;

@RestController
@RequestMapping("/api")
public class PlayerRestController {
    interface BasicPlayerUser extends Player.Basic, Player.UserPlayer, User.Name, User.Email {
    }
    public static class PlayerApi{

        private int age;

        private String countryBirth;

        private double height;

        private double weight;

        private double speed;

        private double strength;

        private double endurance;

        private double pace;

        private double accuaracy;

        private double aceleration;

        private Long idUser;

        public PlayerApi(){

        }
        public PlayerApi(int age, double height, double weight, double speed, double strength, double endurance, double pace, double accuaracy, double aceleration, String countryBirth, Long id) {
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.speed = speed;
            this.strength = strength;
            this.endurance = endurance;
            this.pace = pace;
            this.accuaracy = accuaracy;
            this.aceleration = aceleration;
            this.countryBirth = countryBirth;
            this.idUser = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCountryBirth() {
            return countryBirth;
        }

        public void setCountryBirth(String countryBirth) {
            this.countryBirth = countryBirth;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getStrength() {
            return strength;
        }

        public void setStrength(double strength) {
            this.strength = strength;
        }

        public double getEndurance() {
            return endurance;
        }

        public void setEndurance(double endurance) {
            this.endurance = endurance;
        }

        public double getPace() {
            return pace;
        }

        public void setPace(double pace) {
            this.pace = pace;
        }

        public double getAccuaracy() {
            return accuaracy;
        }

        public void setAccuaracy(double accuaracy) {
            this.accuaracy = accuaracy;
        }

        public double getAceleration() {
            return aceleration;
        }

        public void setAceleration(double aceleration) {
            this.aceleration = aceleration;
        }

        public Long getIdUser() {
            return idUser;
        }

        public void setIdUser(Long idUser) {
            this.idUser = idUser;
        }
        public Player getPlayer(){
            return new Player(age,height,weight,speed,strength,endurance,pace,accuaracy,aceleration,countryBirth);
        }
    }
    @Autowired
    private UserService userService;
    @Autowired
    private PlayerService playerService;

    @Autowired
    private UserComponent userOnline;

    @JsonView(BasicPlayerUser.class)
    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> playerOptional = playerService.findPlayerById(id);
        return playerOptional.map(player -> new ResponseEntity<>(player, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/player/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getPlayerImage(@PathVariable Long id) {
        Optional<Player> playerOptional = playerService.findPlayerById(id);
        if (!playerOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Player player = playerOptional.get();
        byte[] image = player.getImage();
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @PostMapping(value = "player/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> setPlayerImage(@PathVariable Long id, @RequestParam MultipartFile image) throws IOException {
        Optional<Player> playerOptional = playerService.findPlayerById(id);
        if (!playerOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Player player = playerOptional.get();
        if(userOnline.isLoggedUser() && userOnline.getLoggedUser().getPlayer().getId() == id) {
            player.setImage(image.getBytes());
            playerService.savePlayer(player);
            return new ResponseEntity<>(player.getImage(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(path = "/player",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(BasicPlayerUser.class)
    public ResponseEntity<Player> savePlayer (@RequestBody PlayerApi player) {
        Player playerPojo = player.getPlayer();
        Optional<User> user = userService.findUserById(player.getIdUser());
        if(user.isPresent()){
            if(!user.get().getId().equals(userOnline.getLoggedUser().getId())){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            playerPojo.setUser(user.get());
            playerService.savePlayer(playerPojo);

            user.get().setPlayer(playerPojo);
            userService.saveUser(user.get());
            return new ResponseEntity<>(playerPojo, HttpStatus.CREATED);

        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
