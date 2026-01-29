package org.example.sentiment.web;

import org.example.sentiment.dto.AnalyzeRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyzerController {

    @PostMapping(value = "/analyze", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> analyze(@RequestBody AnalyzeRequest request) {
        return ResponseEntity.ok().build();
    }
}
