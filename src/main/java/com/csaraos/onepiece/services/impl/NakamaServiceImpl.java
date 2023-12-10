package com.csaraos.onepiece.services.impl;

import com.csaraos.onepiece.dto.ResponseDto;
import com.csaraos.onepiece.model.Nakama;
import com.csaraos.onepiece.repository.INakamaRepository;
import com.csaraos.onepiece.services.INakamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NakamaServiceImpl implements INakamaService {

    @Autowired
    private INakamaRepository repositoryNakama;

    @Override
    public ResponseEntity getNakamas() {
        ResponseDto res = new ResponseDto();
        try {
            List<Nakama> listNakama = repositoryNakama.findAll();
            res.setRes(listNakama);
            res.setCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(res);
        } catch (Exception error) {
            res.setMsg("Tuvimos un error:" + error);
            res.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @Override
    public ResponseEntity getNakamaById(Long id) {
        ResponseDto res = new ResponseDto();
        try {
            Optional<Nakama> nakamaSelected = repositoryNakama.findById(id);
            if(nakamaSelected.isPresent()){
                res.setRes(nakamaSelected);
                res.setCode(HttpStatus.OK.value());
                return ResponseEntity.ok().body(res);
            }else{
                res.setMsg("No existe un nakama con ese ID:");
                res.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
            }
        } catch (Exception error) {
            res.setMsg("Tuvimos un error:" + error);
            res.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(res);
        }
    };

    @Override
    public ResponseEntity saveNakama(Nakama nakama) {
        ResponseDto res = new ResponseDto();
        try {
            Optional<Nakama> existingNakama = repositoryNakama.findTopByNameAndLastname(nakama.getName(), nakama.getLastname());
            if (existingNakama.isPresent()) {
                res.setMsg("Ya existe un nakama");
                res.setCode(HttpStatus.CONFLICT.value());
                return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
            }
            Optional<Nakama> nakamaCreated = Optional.of(repositoryNakama.save(nakama));
            res.setCode(200);
            res.setRes(nakamaCreated.orElse(null));
            res.setCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(res);
        } catch (Exception error) {
            res.setMsg("Tuvimos un error:" + error);
            res.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
        }
    }
};
