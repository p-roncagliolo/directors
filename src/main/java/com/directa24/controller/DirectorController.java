package com.directa24.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.directa24.service.DirectorService;

@RestController
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/api/directors")
    public ResponseEntity<List<String>> getDirectors(@RequestParam(required=true, defaultValue="0") int threshold) {
        if (threshold <= 0) {
            return ResponseEntity.badRequest().body(List.of("Threshold must be a greater than 0"));
        }
        List<String> directors = directorService.getDirectors(threshold);
        return ResponseEntity.ok(directors);
    }
}
