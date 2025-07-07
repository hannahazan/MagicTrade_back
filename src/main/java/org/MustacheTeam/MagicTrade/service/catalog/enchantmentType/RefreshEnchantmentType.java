package org.MustacheTeam.MagicTrade.service.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
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
        try {
            repository.save(enchantmentType);
        } catch (Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall enchantment types");
        }
    }
}
