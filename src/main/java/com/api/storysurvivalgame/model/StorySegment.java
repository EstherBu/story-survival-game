package com.api.storysurvivalgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "story_segment")
public class StorySegment {

    @Id
    private String id;

    @Column(name = "story_segment")
    private String StorySegment;

    @OneToMany(mappedBy = "story_segment")
    @JsonIgnoreProperties({"story_segment"})
    private List<Player> players;

    @OneToMany(mappedBy = "storySegment")
    @JsonIgnoreProperties({"storySegment"})
    private List<Choice> choices;
}