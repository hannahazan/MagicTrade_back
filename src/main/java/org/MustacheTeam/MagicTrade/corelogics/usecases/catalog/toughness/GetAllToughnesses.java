package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.toughness;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.ToughnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllToughnesses {

    private final ToughnessRepository repository;

    public GetAllToughnesses(ToughnessRepository toughnessRepository) {
        this.repository = toughnessRepository;
    }

    public Filters handle() {
        return repository.getAllToughnesses();
    }
}
