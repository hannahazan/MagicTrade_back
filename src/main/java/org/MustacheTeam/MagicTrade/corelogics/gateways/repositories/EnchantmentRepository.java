package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnchantmentRepository {
    void save(List<String> enchantments);
    List<String> getAllEnchantmentTypes();
}
