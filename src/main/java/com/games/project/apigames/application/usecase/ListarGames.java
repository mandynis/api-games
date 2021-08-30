package com.games.project.apigames.application.usecase;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.gateways.IDataBaseGateway;

import java.util.List;

public class ListarGames implements UseCase {

    private IDataBaseGateway gateway;

    private ListarGames(IDataBaseGateway gateway) {
        this.gateway = gateway;
    }

    public List<Game> execute() {
        return this.gateway.listarGames();
    }

}
