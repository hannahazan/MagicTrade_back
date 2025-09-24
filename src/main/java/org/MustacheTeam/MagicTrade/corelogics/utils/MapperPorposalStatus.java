package org.MustacheTeam.MagicTrade.corelogics.utils;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;

public final class MapperPorposalStatus {

    public static ProposalStatus mapProposalStatus(final String status){
        if(status.equalsIgnoreCase("PENDING")){
            return ProposalStatus.PENDING;
        }
        else if(status.equalsIgnoreCase("ACCEPTED")){
            return ProposalStatus.ACCEPTED;
        }
        else if(status.equalsIgnoreCase("REJECTED")){
            return ProposalStatus.REJECTED;
        }
        else if(status.equalsIgnoreCase("CANCELLED")){
            return ProposalStatus.CANCELLED;
        }
        return null;
    }
}
