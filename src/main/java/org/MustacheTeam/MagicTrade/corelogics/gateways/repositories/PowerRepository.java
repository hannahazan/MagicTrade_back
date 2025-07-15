package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerRepository {
    void save(List<String> powers);
    List<String> getAllPowers();
}