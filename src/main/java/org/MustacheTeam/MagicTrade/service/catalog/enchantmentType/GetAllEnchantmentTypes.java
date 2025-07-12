package org.MustacheTeam.MagicTrade.service.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.model.catalog.EnchantmentType;
import org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType.EnchantmentRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType.JpaEnchantmentTypeRepository;
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
