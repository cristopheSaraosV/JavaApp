package com.csaraos.onepiece.services.impl;

import com.csaraos.onepiece.dto.ResponseDto;
import com.csaraos.onepiece.model.Tripulation;
import com.csaraos.onepiece.repository.ITripulationRepository;
import com.csaraos.onepiece.services.ITripulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripulationServiceImpl implements ITripulationService {

    @Autowired
    private ITripulationRepository repositoryTripulation;

    @Override
    public ResponseEntity getTripulation() {
        ResponseDto res =  new ResponseDto();
        try {
            List<Tripulation> listNakama = repositoryTripulation.findAll();
            res.setRes(listNakama);
            res.setCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(res);
        }catch (Exception error) {
            res.setMsg("Tuvimos un error:" + error);
            res.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @Override
    public ResponseEntity getTripulationById(Long id) {
        ResponseDto res = new ResponseDto();
        try {
            Optional<Tripulation> tripulationSelected = repositoryTripulation.findById(id);
            if(tripulationSelected.isPresent()){
                res.setRes(tripulationSelected);
                res.setCode(HttpStatus.OK.value());
                return ResponseEntity.ok().body(res);
            }else{
                res.setMsg("No existe una tripulacion con ese ID:");
                res.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
            }
        } catch (Exception error) {
            res.setMsg("Tuvimos un error:" + error);
            res.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(res);
        }    }

    @Override
    public ResponseEntity saveTripulation(Tripulation tripulation) {
        ResponseDto res = new ResponseDto();
        try {
            Optional<Tripulation> existingTripulation = repositoryTripulation.findTopByName(tripulation.getName());
            if (existingTripulation.isPresent()) {
                res.setMsg("Ya existe una tripulacion con ese nombre");
                res.setCode(HttpStatus.CONFLICT.value());
                return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
            }
            Optional<Tripulation> tripulationCreated = Optional.of(repositoryTripulation.save(tripulation));
            res.setCode(200);
            res.setRes(tripulationCreated.orElse(null));
            return ResponseEntity.ok().body(tripulationCreated);
        } catch (Exception error) {
            res.setMsg("Tuvimos un error:" + error);
            res.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
        }
    }
};
