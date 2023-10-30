package com.api.storysurvivalgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "choices")
@JsonIgnoreProperties({"players"})
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int choiceId;

    @Column(columnDefinition = "text", name = "choice_options")
    private String choiceOptions;

    @ManyToOne
    @JoinColumn(name = "story_segment_id")
    @JsonIgnoreProperties({"storySegment"})
    private StorySegment storySegment;
}