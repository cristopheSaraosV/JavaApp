package com.csaraos.onepiece.services;

import com.csaraos.onepiece.dto.ResponseDto;
import com.csaraos.onepiece.model.Nakama;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INakamaService {

    public ResponseEntity getNakamas();
    public ResponseEntity getNakamaById(Long id);
    public ResponseEntity getNakamaByIdTripulation(Long id);
    public ResponseEntity saveNakama(Nakama nakama);

}
