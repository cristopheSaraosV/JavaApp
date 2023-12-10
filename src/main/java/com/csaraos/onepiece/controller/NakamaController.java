package com.csaraos.onepiece.controller;
import com.csaraos.onepiece.dto.ResponseDto;
import com.csaraos.onepiece.model.Nakama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.csaraos.onepiece.services.impl.NakamaServiceImpl;

@RestController
public class NakamaController {

    @Autowired
    NakamaServiceImpl characterService;

    @GetMapping("nakama/all")
    @ResponseBody
    public ResponseEntity getNakamas() {
        return characterService.getNakamas();
    };

    @GetMapping("nakama")
    @ResponseBody
    public ResponseEntity getNakamaById(@RequestParam Long id) {
        return characterService.getNakamaById(id);
    };

    @PostMapping("nakama/save")
    @ResponseBody
    public ResponseEntity saveNakama(@RequestBody Nakama nakamaReq) {
        return characterService.saveNakama(nakamaReq);
    };


};