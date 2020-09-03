package com.bariserden.arackontroldemo.api;

import com.bariserden.arackontroldemo.dto.AracDto;
import com.bariserden.arackontroldemo.services.impl.AracServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/arac")
@CrossOrigin(origins = "http://localhost:3000")
public class AracController {

    @Autowired
    AracServiceImpl aracServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<AracDto> getById(@PathVariable("id") Long id) {
        AracDto arac = aracServiceImpl.getById(id);
        return ResponseEntity.ok(arac);
    }

    @GetMapping("/tumaraclar")
    public ResponseEntity<List<AracDto>> getAll() {
        List<AracDto> tumAraclar = aracServiceImpl.getAll();
        return ResponseEntity.ok(tumAraclar);
    }

    @PostMapping("/tumaraclar2")
    public ResponseEntity<List<AracDto>> getAllPost() {
        
        List<AracDto> tumAraclar = aracServiceImpl.getAll();
        return ResponseEntity.ok(tumAraclar);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AracDto> createArac(@Valid @RequestBody AracDto arac) {
        return ResponseEntity.ok(aracServiceImpl.save(arac));
    }

}
