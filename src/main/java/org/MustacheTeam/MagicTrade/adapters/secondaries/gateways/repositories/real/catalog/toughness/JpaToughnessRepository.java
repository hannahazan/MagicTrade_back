package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.toughness;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.ToughnessRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.ArrayList;
import java.util.List;

public class JpaToughnessRepository implements ToughnessRepository {

    private final SpringDataToughnessRepository repository;

    public JpaToughnessRepository(SpringDataToughnessRepository springDataToughnessRepository) {
        this.repository = springDataToughnessRepository;
    }

    @Override
    public Filters getAllToughnesses() {
        return new Filters(repository.findAllToughnesses());
    }

    @Override
    public void save(List<String> toughnesses) {
        ArrayList<ToughnessEntity> toughnessesList = new ArrayList<>();
        toughnesses.forEach(toughness -> toughnessesList.add(new ToughnessEntity(toughness)));
        repository.saveAll(toughnessesList);
    }
}