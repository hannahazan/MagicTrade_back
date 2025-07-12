package org.MustacheTeam.MagicTrade.service.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType.EnchantmentRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType.JpaEnchantmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshEnchantmentType {
    private final ScryfallGateway scryfallGateway;
    private final EnchantmentRepository repository;

    public RefreshEnchantmentType(ScryfallGateway scryfallGateway, EnchantmentRepository enchantmentRepository) {
        this.scryfallGateway = scryfallGateway;
        this.repository = enchantmentRepository;
    }

    public void handle(String catalogElementName) {
        List<String> enchantmentType = scryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(enchantmentType);
        } catch (Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall enchantment types");
        }
    }
}
