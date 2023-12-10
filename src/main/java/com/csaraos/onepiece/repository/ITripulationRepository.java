package com.csaraos.onepiece.repository;

import com.csaraos.onepiece.model.Tripulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITripulationRepository extends JpaRepository<Tripulation, Long> {

    public Optional<Tripulation> findTopByName(@Param("name") String name);
}
