package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trader;

import org.MustacheTeam.MagicTrade.corelogics.gateways.TraderGateway;
import org.MustacheTeam.MagicTrade.corelogics.models.trader.TraderPreview;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JpaTraderGateway implements TraderGateway {

    private final SpringDataTraderRepository repository;

    public JpaTraderGateway(SpringDataTraderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TraderPreview> findAllWithCollections() {
        return repository.findAllWithCollections();
    }
}
