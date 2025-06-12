package org.MustacheTeam.MagicTrade.repository.catalog.toughness;

import org.MustacheTeam.MagicTrade.model.catalog.Toughness;

import java.util.ArrayList;
import java.util.List;

public class JpaToughnessRepository implements ToughnessRepository {

    private final SpringDataToughnessRepository repository;

    public JpaToughnessRepository(SpringDataToughnessRepository springDataToughnessRepository) {
        this.repository = springDataToughnessRepository;
    }

    @Override
    public List<String> getAllToughnesses() {
        return repository.findAllToughnesses();
    }

    @Override
    public void save(List<String> toughnesses) {
        ArrayList<Toughness> toughnessesList = new ArrayList<>();
        toughnesses.forEach(toughness -> toughnessesList.add(new Toughness(toughness)));
        repository.saveAll(toughnessesList);
    }
}