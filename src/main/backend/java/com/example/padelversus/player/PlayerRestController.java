package com.example.padelversus.player;

import com.example.padelversus.ImageService;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserComponent;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.MediaType.IMAGE_JPEG;

@RestController
@RequestMapping("/api")
public class PlayerRestController {
    interface BasicPlayerUser extends Player.Basic, Player.UserPlayer, User.Name, User.Email {
    }

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
}
