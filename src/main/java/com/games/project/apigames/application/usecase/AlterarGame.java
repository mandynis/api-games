package com.games.project.apigames.application.usecase;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.gateways.IDataBaseGateway;

public class AlterarGame implements UseCase {

    private IDataBaseGateway gateway;

    private AlterarGame(IDataBaseGateway gateway) {
        this.gateway = gateway;
    }
    public Game execute(int id, String nome) {
        var game = gateway.buscarGame(id);
        game.setNome(nome);
        return this.gateway.alterarGame(game);
    }
}
