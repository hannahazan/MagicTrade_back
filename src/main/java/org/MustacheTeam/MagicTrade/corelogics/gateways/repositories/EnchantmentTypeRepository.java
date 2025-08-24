package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnchantmentTypeRepository {
    void save(List<String> enchantments);
    Filters getAllEnchantmentTypes();
}
