package org.MustacheTeam.MagicTrade.repository.catalog.EnchantmentType;

import org.MustacheTeam.MagicTrade.model.catalog.EnchantmentType;

import java.util.ArrayList;
import java.util.List;

public class JpaEnchantmentTypeRepository implements EnchantmentRepository {

    private final SpringDataEnchantmentTypeRepository repository;

    public JpaEnchantmentTypeRepository(SpringDataEnchantmentTypeRepository springDataEnchantmentTypeRepository) {
        this.repository = springDataEnchantmentTypeRepository;
    }

    public List<EnchantmentType> getAllEnchantmentType(){
        return repository.findAll();
    }

    public void save(List<String> enchantmentTypes) {
        ArrayList<EnchantmentType> enchantmentTypeList = new ArrayList<>();
        enchantmentTypes.forEach(enchantmentType -> enchantmentTypeList.add(new EnchantmentType(enchantmentType)));
        repository.saveAll(enchantmentTypeList);
    }
}
