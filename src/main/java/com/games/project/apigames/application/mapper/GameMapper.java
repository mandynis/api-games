package com.games.project.apigames.application.mapper;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.request.CriarGameResquest;
import com.games.project.apigames.domain.request.SubstituirGameRequest;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public Game map(CriarGameResquest request) {
        Game game = new Game();
        game.setNome(request.getNome());
        game.setDesenvolvedor(request.getDesenvolvedor());
        game.setAno(request.getAno());
        return game;
    }

    public Game map(Integer id, SubstituirGameRequest request) {
        Game game = new Game();
        game.setNome(request.getNome());
        game.setDesenvolvedor(request.getDesenvolvedor());
        game.setAno(request.getAno());
        return game;
    }
}
