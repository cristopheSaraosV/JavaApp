package com.csaraos.onepiece.controller;

import com.csaraos.onepiece.model.Nakama;
import com.csaraos.onepiece.model.Tripulation;
import com.csaraos.onepiece.services.impl.NakamaServiceImpl;
import com.csaraos.onepiece.services.impl.TripulationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripulationController {

    @Autowired
    TripulationServiceImpl tripulationService;

    @GetMapping("tripulation/all")
    @ResponseBody
    public ResponseEntity getNakamas() {
        return tripulationService.getTripulation();
    };

    @GetMapping("tripulation")
    @ResponseBody
    public ResponseEntity getNakamaById(@RequestParam Long id) {
        return tripulationService.getTripulationById(id);
    };

    @PostMapping("tripulation/save")
    @ResponseBody
    public ResponseEntity saveNakama(@RequestBody Tripulation tripulationReq) {
        return tripulationService.saveTripulation(tripulationReq);
    };


};