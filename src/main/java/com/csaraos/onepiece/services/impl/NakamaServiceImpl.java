package com.csaraos.onepiece.services.impl;

import com.csaraos.onepiece.dto.ResponseDto;
import com.csaraos.onepiece.model.Nakama;
import com.csaraos.onepiece.repository.INakamaRepository;
import com.csaraos.onepiece.services.INakamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class NakamaServiceImpl implements INakamaService {

    @Autowired
    private INakamaRepository repositoryNakama;

    @Override
    public List<Nakama> getNakamas() {
        List<Nakama> listNakama = (List<Nakama>) repositoryNakama.findAll();
        return listNakama;
    }

    @Override
    public Nakama getNakamaById(Long id) {
        Optional<Nakama> nakamaSelected = repositoryNakama.findById(id);
        return nakamaSelected.orElse(null);
    };

    @Override
    public ResponseEntity saveNakama(Nakama nakama) {
        ResponseDto res = new ResponseDto();
        try {
            Optional<Nakama> existingNakama = repositoryNakama.findTopByNameAndLastname(nakama.getName(), nakama.getLastname());
            if (existingNakama.isPresent()) {
                res.setMsg("Ya existe un nakama");
                res.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.badRequest().body(res);
            }
            Optional<Nakama> nakamaCreated = Optional.of(repositoryNakama.save(nakama));
            res.setCode(200);
            res.setNakama(nakamaCreated.orElse(null));
            return ResponseEntity.ok().body(nakamaCreated);
        } catch (Exception error) {
            res.setMsg("Tuvimos un error:" + error);
            res.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(res);
        }


    }
};
