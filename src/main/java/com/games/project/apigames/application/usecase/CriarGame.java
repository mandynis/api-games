package com.games.project.apigames.application.usecase;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.gateways.IDataBaseGateway;
import org.springframework.stereotype.Component;

@Component
public class CriarGame implements UseCase {

    private IDataBaseGateway gateway;

    private CriarGame(IDataBaseGateway gateway) {
        this.gateway = gateway;
    }

    public Game execute(Game game) {
        return this.gateway.criarGame(game);
    }

}
