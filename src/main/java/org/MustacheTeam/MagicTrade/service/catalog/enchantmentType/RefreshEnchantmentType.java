package org.MustacheTeam.MagicTrade.service.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType.JpaEnchantmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshEnchantmentType {
    RealScryfallGateway realScryfallGateway;
    JpaEnchantmentTypeRepository repository;

    public RefreshEnchantmentType(RealScryfallGateway realScryfallGateway, JpaEnchantmentTypeRepository jpaEnchantmentTypeRepository) {
        this.realScryfallGateway = realScryfallGateway;
        this.repository = jpaEnchantmentTypeRepository;
    }

    public void handle(String catalogElementName) {
        List<String> enchantmentType = realScryfallGateway.getScryfallCatalog(catalogElementName);
        if (enchantmentType == null || enchantmentType.isEmpty()) {
            throw new RuntimeException("Scryfall enchantment type not found");
        }
        repository.save(enchantmentType);
    }
}
