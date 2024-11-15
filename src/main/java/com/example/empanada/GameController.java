package com.example.empanada;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/")
    public List<Game> getAllGames(){
        List<Game> games = gameRepository.findAll();
        games.forEach(game->{
            if(game.getFile() != null){
                game.setFileBase64(Base64.getEncoder().encodeToString(game.getFile()));
            }
        });

        return games;
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable String id){
        Game game = gameRepository.findById(id).orElse(null);

        if(game!= null && game.getFile()!=null){
            game.setFileBase64(Base64.getEncoder().encodeToString(game.getFile()));
        }

        return game;
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

    /*@GetMapping("/")
    public List<Game> getAlGames(){
        return gameRepository.findAll().stream().map(game -> {
            if(game.getFile() != null){
                String base64File = Base64.getEncoder().encodeToString(game.getFile());
                game.setFile(base64File.getBytes());
            }
            return game;
        }).collect(Collectors.toList());
    }*/
    
}
