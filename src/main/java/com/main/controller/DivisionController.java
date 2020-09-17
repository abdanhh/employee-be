package com.main.controller;

import com.main.exception.ResourceNotFoundException;
import com.main.models.Division;
import com.main.models.Position;
import com.main.repositories.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class DivisionController {

    @Autowired
    DivisionRepository divisionRepository;

    @GetMapping("/divisions")
    public ResponseEntity<List<Division>> getAllDivisions(){
        return ResponseEntity.ok(divisionRepository.findAll());
    }

    @GetMapping("/division-sequence")
    public Long getDivisionsCurrentSequence(){
        return divisionRepository.count();
    }

    @GetMapping("/divisions/{id}")
    public ResponseEntity<Division> getDivisionsById(@PathVariable(value = "id") Long id){
        Division division = divisionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Divisions", "id", id));
        if (division.getId() != id){
            throw new ResourceNotFoundException("Id Not Found");
        }
        return ResponseEntity.ok(division);
    }

    @PostMapping("/divisions")
    public Division saveDivisions(@Validated @RequestBody Division division){
        return divisionRepository.save(division);
    }
}
