package com.mrprokey.misereremei2.controller;

import com.mrprokey.misereremei2.service.AudioBookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/speech")
public class AudioBookController {

    private final AudioBookService audioBookService;

    public AudioBookController(AudioBookService audioBookService) {
        this.audioBookService = audioBookService;
    }

    @GetMapping("/convert")
    public ResponseEntity<byte[]> convertTextToSpeech(@RequestParam String text) {
        byte[] audioContent = audioBookService.convertTextToSpeech(text);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(audioContent, headers, HttpStatus.OK);
    }
}