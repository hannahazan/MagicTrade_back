package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTypeRepository {
    void save(List<String> cardTypes);
    List<String> getAllCardTypes();
}