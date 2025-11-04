package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataCollectionRepository extends JpaRepository<CollectionEntity, Long> {
    List<CollectionEntity> findByUserId_Id(Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CollectionEntity c WHERE c.id = :collectionId AND c.userId.id = :userId")
    int deleteByIdAndUserId_Id(Long collectionId, Long userId);

    @Query(value = "select c FROM CollectionEntity c WHERE c.cardId.id = ?1")
    List<CollectionEntity> findByCardId(String cardId);

}
