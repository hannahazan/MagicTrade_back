package org.MustacheTeam.MagicTrade.repository.cardType;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTypeRepository {
    void save(List<String> cardTypes);
}