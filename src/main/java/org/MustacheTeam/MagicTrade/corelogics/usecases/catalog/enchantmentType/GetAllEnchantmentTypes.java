package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.EnchantmentTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class GetAllEnchantmentTypes {
    private final EnchantmentTypeRepository repository;

    public GetAllEnchantmentTypes(EnchantmentTypeRepository enchantmentRepository) {
        this.repository = enchantmentRepository;
    }

    public Filters handle() {
        return repository.getAllEnchantmentTypes();
    }
}
