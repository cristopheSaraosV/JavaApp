package com.csaraos.onepiece.services;

import com.csaraos.onepiece.model.Tripulation;
import org.springframework.http.ResponseEntity;

public interface ITripulationService {

    public ResponseEntity getTripulation();
    public ResponseEntity getTripulationById(Long id);
    public ResponseEntity saveTripulation(Tripulation tripulation);

}
