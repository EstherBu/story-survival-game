package com.api.storysurvivalgame.controller;

import com.api.storysurvivalgame.model.StorySegmentChoices;
import com.api.storysurvivalgame.repository.StorySegmentChoicesRepository;
import com.api.storysurvivalgame.response.ErrorResponse;
import com.api.storysurvivalgame.response.StorySegmentChoicesListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/storychoices")
public class StorySegmentChoicesController {

    @Autowired
    private StorySegmentChoicesRepository storySegmentChoicesRepository;

    @GetMapping
    public ResponseEntity<?> getStorySegmentChoices() {
        StorySegmentChoicesListResponse storySegmentChoicesListResponse = new StorySegmentChoicesListResponse();
        storySegmentChoicesListResponse.set(this.storySegmentChoicesRepository.findAll());

        return ResponseEntity.ok(storySegmentChoicesListResponse);
    }

    @GetMapping("/{storySegmentChoiceId}")
    public ResponseEntity<?> getStorySegmentChoiceById(@PathVariable int storySegmentChoiceId) {
        StorySegmentChoices storySegmentChoices = this.storySegmentChoicesRepository.findById(storySegmentChoiceId).orElse(null);

        if (storySegmentChoices == null) {
            ErrorResponse error = new ErrorResponse();
            error.set("StorySegmentChoice not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok(storySegmentChoices);
    }
}

