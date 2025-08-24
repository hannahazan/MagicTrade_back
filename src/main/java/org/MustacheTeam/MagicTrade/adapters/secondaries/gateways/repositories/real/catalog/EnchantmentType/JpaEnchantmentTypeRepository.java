package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.EnchantmentType;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.EnchantmentTypeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.ArrayList;
import java.util.List;

public class JpaEnchantmentTypeRepository implements EnchantmentTypeRepository {

    private final SpringDataEnchantmentTypeRepository repository;

    public JpaEnchantmentTypeRepository(SpringDataEnchantmentTypeRepository springDataEnchantmentTypeRepository) {
        this.repository = springDataEnchantmentTypeRepository;
    }

    @Override
    public Filters getAllEnchantmentTypes(){
        return new Filters(repository.findAllEnchantmentType());
    }

    public void save(List<String> enchantmentTypes) {
        ArrayList<EnchantmentTypeEntity> enchantmentTypeList = new ArrayList<>();
        enchantmentTypes.forEach(enchantmentType -> enchantmentTypeList.add(new EnchantmentTypeEntity(enchantmentType)));
        repository.saveAll(enchantmentTypeList);
    }
}
