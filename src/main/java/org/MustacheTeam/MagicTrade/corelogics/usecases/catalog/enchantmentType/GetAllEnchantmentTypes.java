package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.EnchantmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEnchantmentTypes {
    private final EnchantmentRepository repository;

    public GetAllEnchantmentTypes(EnchantmentRepository enchantmentRepository) {
        this.repository = enchantmentRepository;
    }

    public Filters handle() {
        List<String> enchantmentTypes = repository.getAllEnchantmentTypes();
        return new Filters(enchantmentTypes);
    }
}
