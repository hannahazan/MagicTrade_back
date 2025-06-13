package org.MustacheTeam.MagicTrade.service.catalog.enchantmentType;

import org.MustacheTeam.MagicTrade.model.catalog.EnchantmentType;
import org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType.JpaEnchantmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEnchantmentTypes {
    private final JpaEnchantmentTypeRepository repository;

    public GetAllEnchantmentTypes(JpaEnchantmentTypeRepository jpaEnchantmentTypeRepository) {
        this.repository = jpaEnchantmentTypeRepository;
    }

    public List<String> handle() {

        return repository.getAllEnchantmentTypes();
    }
}
