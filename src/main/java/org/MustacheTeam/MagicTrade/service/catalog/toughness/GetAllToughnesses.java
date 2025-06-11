package org.MustacheTeam.MagicTrade.service.catalog.toughness;

import org.MustacheTeam.MagicTrade.model.catalog.Toughness;
import org.MustacheTeam.MagicTrade.repository.catalog.toughness.JpaToughnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllToughnesses {

    private final JpaToughnessRepository repository;

    public GetAllToughnesses(JpaToughnessRepository jpaToughnessRepository) {
        this.repository = jpaToughnessRepository;
    }

    public List<Toughness> handle() {
        return repository.getAllToughnesses();
    }
}
