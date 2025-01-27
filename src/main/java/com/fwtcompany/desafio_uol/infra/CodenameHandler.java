package com.fwtcompany.desafio_uol.infra;

import com.fwtcompany.desafio_uol.model.GroupType;
import com.fwtcompany.desafio_uol.service.CodenameService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CodenameHandler {

    private final CodenameService service;

    public CodenameHandler(CodenameService codenameService) {
        this.service = codenameService;
    }

    public String findCodename(GroupType groupType) {
        List<String> group;

        if (groupType == GroupType.AVENGERS) {
            group = service.getAvengersCodenameList();
        } else if (groupType == GroupType.JUSTICE_LEAGUE) {
            group = service.getJusticeLeagueCodenameList();
        } else {
            throw new IllegalArgumentException("GroupType desconhecido: " + groupType);
        }

        String firstMatch = group.stream().findFirst().orElseThrow(() -> new NoSuchElementException("Nenhum codename disponível para o grupo: " + groupType));

        group.remove(firstMatch);
        return firstMatch;
    }


}
