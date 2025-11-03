package org.MustacheTeam.MagicTrade.corelogics.usecases.traders;

import org.MustacheTeam.MagicTrade.corelogics.gateways.TraderGateway;
import org.MustacheTeam.MagicTrade.corelogics.models.trader.TraderPreview;
import java.util.List;

public class GetAllTraders {
    private final TraderGateway traderGateway;

    public GetAllTraders(TraderGateway traderGateway) {this.traderGateway = traderGateway;}

    public List<TraderPreview> handle() {return traderGateway.findAllWithCollections();}
}
