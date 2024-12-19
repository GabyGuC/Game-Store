package com.proyect.GameStore.Repository;

import com.proyect.GameStore.Entity.ConsolaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsolaRepository extends JpaRepository<ConsolaEntity,Integer> {

    ConsolaEntity findByName(String name);

}
