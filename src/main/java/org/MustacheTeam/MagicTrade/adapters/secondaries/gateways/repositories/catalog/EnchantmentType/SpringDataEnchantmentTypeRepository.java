package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.EnchantmentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataEnchantmentTypeRepository extends JpaRepository<EnchantmentTypeEntity, Long> {
    @Query(value="SELECT value from enchantment_type", nativeQuery=true)
    List<String> findAllEnchantmentType();
}
