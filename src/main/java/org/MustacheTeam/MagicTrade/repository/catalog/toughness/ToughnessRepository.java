package org.MustacheTeam.MagicTrade.repository.catalog.toughness;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToughnessRepository {
    void save(List<String> toughnesses);
}