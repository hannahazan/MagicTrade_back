package org.MustacheTeam.MagicTrade.service.catalog.toughness;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.model.catalog.Toughness;
import org.MustacheTeam.MagicTrade.repository.catalog.toughness.JpaToughnessRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.toughness.ToughnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllToughnesses {

    private final ToughnessRepository repository;

    public GetAllToughnesses(ToughnessRepository toughnessRepository) {
        this.repository = toughnessRepository;
    }

    public Filters handle() {
        List<String> toughnesses = repository.getAllToughnesses();
        return new Filters(toughnesses);
    }
}
