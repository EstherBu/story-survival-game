package com.api.storysurvivalgame.controller;

import com.api.storysurvivalgame.model.Choice;
import com.api.storysurvivalgame.repository.ChoiceRepository;
import com.api.storysurvivalgame.repository.StorySegmentRepository;
import com.api.storysurvivalgame.response.ChoiceListResponse;
import com.api.storysurvivalgame.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/choices")
public class ChoiceController {

    @Autowired
    private ChoiceRepository choiceRepository;

    @Autowired
    private StorySegmentRepository storySegmentRepository;

    @GetMapping
    public ResponseEntity<ChoiceListResponse> getChoices() {
        ChoiceListResponse choiceListResponse = new ChoiceListResponse();
        choiceListResponse.set(this.choiceRepository.findAll());

        return ResponseEntity.ok(choiceListResponse);
    }

    @GetMapping("/{choiceId}")
    public ResponseEntity<?> getChoiceById(@PathVariable int choiceId) {
        Choice choice = this.choiceRepository.findById(choiceId).orElse(null);

        if (choice == null) {
            ErrorResponse error = new ErrorResponse();
            error.set("Choice not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok(choice);
    }
}




