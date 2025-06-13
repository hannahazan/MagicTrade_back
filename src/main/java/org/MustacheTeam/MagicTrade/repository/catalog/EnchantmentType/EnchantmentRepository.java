package org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnchantmentRepository {
    void save(List<String> enchantments);
}
