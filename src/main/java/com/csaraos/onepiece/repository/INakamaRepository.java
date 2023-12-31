package com.csaraos.onepiece.repository;

import com.csaraos.onepiece.model.Nakama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface INakamaRepository extends JpaRepository<Nakama, Long> {

    public Optional<Nakama> findTopByNameAndLastname(@Param("name") String name, @Param("lastname") String lastname);

    @Query("SELECT n FROM Nakama n WHERE n.tripulation.id = :tripulationId")
    Optional<List<Nakama> > findNakamaByTripulationId(@Param("tripulationId") Long tripulationId);

}
