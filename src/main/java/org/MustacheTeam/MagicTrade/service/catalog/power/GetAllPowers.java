package org.MustacheTeam.MagicTrade.service.catalog.power;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.repository.catalog.power.JpaPowerRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.power.PowerRepository;
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
