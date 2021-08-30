package com.games.project.apigames.comunication.http.controller;

import com.games.project.apigames.application.mapper.GameMapper;
import com.games.project.apigames.application.usecase.*;
import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.request.CriarGameResquest;
import com.games.project.apigames.domain.request.SubstituirGameRequest;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1/games")
public class GameController {

    private AlterarGame alterarGame;
    private BuscarGame buscarGame;
    private CriarGame criarGame;
    private DeletarGame deletarGame;
    private ListarGames listarGames;
    private SubstituirGame substituirGame;
    private GameMapper gameMapper;

    public GameController(AlterarGame alterarGame,
                          BuscarGame buscarGame,
                          CriarGame criarGame,
                          DeletarGame deletarGame,
                          ListarGames listarGames,
                          SubstituirGame substituirGame,
                          GameMapper gameMapper) {
        this.alterarGame = alterarGame;
        this.buscarGame = buscarGame;
        this.criarGame = criarGame;
        this.deletarGame = deletarGame;
        this.listarGames = listarGames;
        this.substituirGame = substituirGame;
        this.gameMapper = gameMapper;
    }

    @PatchMapping("/{id}")
    public Game patch(@PathVariable("id") Integer id, @RequestBody String nome) {
        return alterarGame.execute(id, nome);
    }

    @GetMapping("/{id}")
    public Game get(@PathVariable("id") Integer id) {
        return buscarGame.execute(id);
    }

    @PostMapping
    public Game create(@RequestBody CriarGameResquest request) {
        Game game = gameMapper.map(request);
        return criarGame.execute(game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        deletarGame.execute(id);
    }

    @GetMapping
    public List<Game> getAll() {
        return listarGames.execute();
    }

    @PutMapping("/{id}")
    public Game put(@PathVariable("id") Integer id, @RequestBody SubstituirGameRequest request) {
        Game game = gameMapper.map(id, request);
        return substituirGame.execute(game);
    }

}
