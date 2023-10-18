package com.api.storysurvivalgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "choice")
public class Choice {

    @Id
    private String id;

    @Column(name = "choices")
    private String choices;

    @ManyToOne
    @JoinColumn(name = "story_segment_id")
    @JsonIgnoreProperties({"story_segment"})
    private StorySegment storySegment;
}