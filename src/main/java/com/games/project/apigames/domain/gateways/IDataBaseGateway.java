package com.games.project.apigames.domain.gateways;

import com.games.project.apigames.domain.entities.Game;

import java.util.List;

public interface IDataBaseGateway {

    public Game criarGame(Game game);
    public Game buscarGame(int id);
    public void deletarGame(int id);
    public Game alterarGame(Game game);
    public List<Game> listarGames();

}
