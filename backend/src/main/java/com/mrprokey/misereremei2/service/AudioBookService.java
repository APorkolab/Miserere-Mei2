package com.mrprokey.misereremei2.service;

import com.google.api.client.util.Value;
import com.google.cloud.texttospeech.v1.*;
import org.springframework.stereotype.Service;

@Service
public class AudioBookService {
    @Value("${google.cloud.api-key}")
    private String apiKey;

    public byte[] convertTextToSpeech(String text) {
        try {
            TextToSpeechClient textToSpeechClient = TextToSpeechClient.create();
            SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("en-US").setSsmlGender(SsmlVoiceGender.FEMALE).build();

            AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();

            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

            return response.getAudioContent().toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error converting text to speech", e);
        }
    }
}
