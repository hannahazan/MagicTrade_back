package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.EnchantmentType;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.EnchantmentRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaEnchantmentTypeRepository implements EnchantmentRepository {

    private final SpringDataEnchantmentTypeRepository repository;

    public JpaEnchantmentTypeRepository(SpringDataEnchantmentTypeRepository springDataEnchantmentTypeRepository) {
        this.repository = springDataEnchantmentTypeRepository;
    }

    @Override
    public List<String> getAllEnchantmentTypes(){

        return repository.findAllEnchantmentType();
    }

    public void save(List<String> enchantmentTypes) {
        ArrayList<EnchantmentTypeEntity> enchantmentTypeList = new ArrayList<>();
        enchantmentTypes.forEach(enchantmentType -> enchantmentTypeList.add(new EnchantmentTypeEntity(enchantmentType)));
        repository.saveAll(enchantmentTypeList);
    }
}
