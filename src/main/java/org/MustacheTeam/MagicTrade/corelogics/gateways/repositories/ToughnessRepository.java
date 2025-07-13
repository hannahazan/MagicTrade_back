package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToughnessRepository {
    void save(List<String> toughnesses);
    List<String> getAllToughnesses();
}