package org.MustacheTeam.MagicTrade.repository.catalog.cardname;

import java.util.List;

public interface CardNameRepository {
    void save(List<String> cardNameToSave);
}
