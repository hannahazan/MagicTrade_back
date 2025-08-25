package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.power;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.PowerRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.ArrayList;
import java.util.List;

public class JpaPowerRepository implements PowerRepository {

    private final SpringDataPowerRepository repository;

    public JpaPowerRepository(SpringDataPowerRepository springDataPowerRepository) {
        this.repository = springDataPowerRepository;
    }

    @Override
    public Filters getAllPowers() {
        return new Filters(repository.findAllPowers());
    }

    @Override
    public void save(List<String> powers) {
        ArrayList<PowerEntity> powersList = new ArrayList<>();
        powers.forEach(power -> powersList.add(new PowerEntity(power)));
        repository.saveAll(powersList);
    }
}