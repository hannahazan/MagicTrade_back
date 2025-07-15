package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.power;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.PowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPowers {

    private final PowerRepository repository;

    public GetAllPowers(PowerRepository powerRepository) {
        this.repository = powerRepository;
    }

    public Filters handle() {
        List<String> powers = repository.getAllPowers();
        return new Filters(powers);
    }
}
