package org.MustacheTeam.MagicTrade.corelogics.gateways;

import org.MustacheTeam.MagicTrade.corelogics.models.trader.TraderPreview;
import java.util.List;

public interface TraderGateway {
    List<TraderPreview> findAllWithCollections();
}
