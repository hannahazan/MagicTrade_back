package org.MustacheTeam.MagicTrade.repository.catalog.power;

import org.MustacheTeam.MagicTrade.model.catalog.Power;

import java.util.ArrayList;
import java.util.List;

public class JpaPowerRepository implements PowerRepository {

    private final SpringDataPowerRepository repository;

    public JpaPowerRepository(SpringDataPowerRepository springDataPowerRepository) {
        this.repository = springDataPowerRepository;
    }

    @Override
    public List<String> getAllPowers() {
        return repository.findAllPowers();
    }

    @Override
    public void save(List<String> powers) {
        ArrayList<Power> powersList = new ArrayList<>();
        powers.forEach(power -> powersList.add(new Power(power)));
        repository.saveAll(powersList);
    }
}