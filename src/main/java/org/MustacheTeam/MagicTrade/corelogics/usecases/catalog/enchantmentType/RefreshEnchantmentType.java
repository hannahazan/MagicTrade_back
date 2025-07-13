package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.EnchantmentRepository;
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
