package org.MustacheTeam.MagicTrade.service.catalog.power;

import org.MustacheTeam.MagicTrade.model.catalog.Power;
import org.MustacheTeam.MagicTrade.repository.catalog.power.JpaPowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPowers {

    private final JpaPowerRepository repository;

    public GetAllPowers(JpaPowerRepository jpaPowerRepository) {
        this.repository = jpaPowerRepository;
    }

    public List<Power> handle() {
        return repository.getAllPowers();
    }
}
