package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import java.util.List;

public interface CardNameRepository {
    void save(List<String> cardNameToSave);
    List<String> getAllCardNames();
}
