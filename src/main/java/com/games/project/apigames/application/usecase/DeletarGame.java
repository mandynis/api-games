package com.games.project.apigames.application.usecase;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.gateways.IDataBaseGateway;

public class DeletarGame implements UseCase {

    private IDataBaseGateway gateway;

    private DeletarGame(IDataBaseGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(Integer id) {
        this.gateway.deletarGame(id);
    }

}
