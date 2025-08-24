package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandTypeRepository {
    void save(List<String> landTypeToSave);
    Filters getAllLandTypes();
}
