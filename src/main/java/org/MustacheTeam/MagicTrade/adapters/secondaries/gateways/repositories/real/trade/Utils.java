package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;

public class Utils {
    private final SpringDataTradeRepository tradeRepository;
    private final SpringDataCollectionRepository collectionRepository;
    private final SpringDataUserRepository userRepository;

    public Utils(SpringDataTradeRepository tradeRepository, SpringDataCollectionRepository collectionRepository, SpringDataUserRepository userRepository){
       this.tradeRepository = tradeRepository;
       this.collectionRepository = collectionRepository;
       this.userRepository = userRepository;
    }

    public CollectionEntity findCollection(Long id){
        return collectionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Collection not found with id: " + id));
    }

    public UserEntity findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    public TradeEntity getOneTrade(Long id){
        return tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Trade not found with id: " + id)) ;
    }

}
