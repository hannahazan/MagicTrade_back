package org.MustacheTeam.MagicTrade.repository.catalog.power;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerRepository {
    void save(List<String> powers);
}