package com.games.project.apigames.application.usecase;

import com.games.project.apigames.domain.entities.Game;
import com.games.project.apigames.domain.gateways.IDataBaseGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuscarGame implements UseCase {

    private final String INICIO_BUSCAR_GAME = "[Buscar Game] - Iniciando processo de busca";
    private final String SUCESSO_BUSCAR_GAME = "[Buscar Game] - Busca efetuada com sucesso";
    private final String ERRO_BUSCAR_GAME = "[Buscar Game] - Erro ao buscar";

    private IDataBaseGateway gateway;

    private Logger log = LoggerFactory.getLogger(BuscarGame.class);

    private BuscarGame(IDataBaseGateway gateway) {
        this.gateway = gateway;
    }

    public Game execute(Integer id) {
        try {
            log.info(INICIO_BUSCAR_GAME);
            Game result = this.gateway.buscarGame(id);
            log.info(SUCESSO_BUSCAR_GAME);
            return result;
        } catch(Exception e) {
            log.error(ERRO_BUSCAR_GAME);
            return null;
        }
    }

}
