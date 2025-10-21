package org.MustacheTeam.MagicTrade.corelogics.models.trade;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.MapperPorposalStatus;

public record ProposalUpdate(Long proposalId, String proposalStatus, String tradeStatus) {

    public ProposalStatus mapProposalStatus(String status){
       return MapperPorposalStatus.mapProposalStatus(status);
    }
}
