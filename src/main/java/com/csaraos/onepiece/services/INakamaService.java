package com.csaraos.onepiece.services;


import com.csaraos.onepiece.dto.ResponseDto;
import com.csaraos.onepiece.model.Nakama;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INakamaService {

    public List<Nakama> getNakamas();
    public Nakama getNakamaById(Long id);

    public ResponseEntity saveNakama(Nakama nakama);

}
