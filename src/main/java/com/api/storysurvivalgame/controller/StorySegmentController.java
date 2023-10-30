package com.api.storysurvivalgame.controller;

import com.api.storysurvivalgame.model.StorySegment;
import com.api.storysurvivalgame.repository.StorySegmentRepository;
import com.api.storysurvivalgame.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/story")
public class StorySegmentController {

    @Autowired
    private StorySegmentRepository storySegmentRepository;

    @GetMapping("/{storyId}")
    public ResponseEntity<?> getStorySegmentById(@PathVariable int storyId) {
       StorySegment storySegment = this.storySegmentRepository.findById(storyId).orElse(null);

        if (storySegment == null) {
            ErrorResponse error = new ErrorResponse();
            error.set("Story segment not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        } else {
            return ResponseEntity.ok(storySegment);
        }
    }
}
