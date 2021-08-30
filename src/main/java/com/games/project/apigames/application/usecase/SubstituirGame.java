package com.games.project.apigames.application.usecase;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.gateways.IDataBaseGateway;

public class SubstituirGame implements UseCase {

    private IDataBaseGateway gateway;

    private SubstituirGame(IDataBaseGateway gateway) {
        this.gateway = gateway;
    }

    public Game execute(Game game) {
        return this.gateway.criarGame(game);
    }

}
