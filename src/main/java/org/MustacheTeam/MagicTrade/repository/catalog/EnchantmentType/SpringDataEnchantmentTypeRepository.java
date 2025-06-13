package org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType;

import org.MustacheTeam.MagicTrade.model.catalog.EnchantmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataEnchantmentTypeRepository extends JpaRepository<EnchantmentType, Long> {
    @Query(value="SELECT value from enchantment_type", nativeQuery=true)
    List<String> findAllEnchantmentType();
}
