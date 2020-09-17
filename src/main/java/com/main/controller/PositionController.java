package com.main.controller;

import com.main.exception.ResourceNotFoundException;
import com.main.models.Position;
import com.main.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/main")
public class PositionController {
    @Autowired
    PositionRepository positionRepository;

    @GetMapping("/positions")
    public ResponseEntity<List<Position>> getAllPositions(){
        return ResponseEntity.ok(positionRepository.findAll());
    }

    @GetMapping("/positions/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable(value = "id") Long id){
        Position position = positionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position", "id", id));
        if (position.getId() != id){
            throw new ResourceNotFoundException("Id Not Found");
        }
        return ResponseEntity.ok(position);
    }

    @GetMapping("/position")
    public Long getPositionCurrentSequence(){
        return positionRepository.count();
    }

    @PostMapping("positions")
    public Position savePosition(@Validated @RequestBody Position position){
        position.setLevel(position.getId());
    return positionRepository.save(position);
    }

}
