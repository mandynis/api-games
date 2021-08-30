package com.games.project.apigames.infrastructure.dataprovider;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.gateways.IDataBaseGateway;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataBaseDataProvider implements IDataBaseGateway {

    private static List<Game> gameDatabaseMock = new ArrayList<>();
    private static int id = 1;

    @Override
    public Game criarGame(Game game) {
        game.setId(id);
        id++;
        gameDatabaseMock.add(game);
        return game;
    }

    @Override
    public Game buscarGame(int id) {
        List<Game> games = gameDatabaseMock.stream()
                .filter(g -> g.getId() == id)
                .collect(Collectors.toList());
        if(games.isEmpty()) {
            throw new RuntimeException("Game not found");
        } else {
            return games.get(0);
        }
    }

    @Override
    public void deletarGame(int id) {
        int index = -1;
        for (int i = 0; i < gameDatabaseMock.size(); i++) {
            var game = gameDatabaseMock.get(i);
            if(game.getId() == id) {
                index = i;
            }
        } gameDatabaseMock.remove(index);
    }

    @Override
    public Game alterarGame(Game game) {
        gameDatabaseMock.forEach(g -> {
            if(g.getId() == game.getId()) {
                g.setNome(game.getNome());
                g.setDesenvolvedor(game.getDesenvolvedor());
                g.setAno(game.getAno());
            }
        });
        return game;
    }

    @Override
    public List<Game> listarGames() {
        return gameDatabaseMock;
    }
}
