package com.ssegning.lynx.lynxbackend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LynxController {

        @GetMapping("/endpoint")
        public ResponseEntity<String> getEndpoint() {
            return ResponseEntity.ok("Hello World");
        }
}
