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
@JsonIgnoreProperties({"choices", "players"})
public class StorySegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "text", name = "story_segment")
    private String StorySegment;

    @OneToMany(mappedBy = "storySegment")
    private List<Choice> choices;
}