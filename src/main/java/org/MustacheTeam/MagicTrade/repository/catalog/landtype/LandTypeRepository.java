package org.MustacheTeam.MagicTrade.repository.catalog.landtype;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandTypeRepository {
    void save(List<String> landTypeToSave);
    List<String> getAllLandTypes();
}
