package com.example.empanada;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/")
    List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    Game getGame(@PathVariable String id){
        return gameRepository.findById(id).orElse(null);
    }
    
    @PostMapping("/")
    Game addGame(
        @RequestParam("title") String title,
        @RequestParam("developer") String developer,
        @RequestParam("file") MultipartFile file
    )throws IOException {
        Game game = new Game();
        game.setTitle(title);
        game.setDeveloper(developer);
        game.setFile(file.getBytes());
        return gameRepository.save(game);
    }

    
}
