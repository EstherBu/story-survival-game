package com.api.storysurvivalgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "hp")
    private int hp;

    @ManyToOne
    @JoinColumn(name = "story_segment_id")
    @JsonIgnoreProperties({"story_segment"})
    private StorySegment storySegment;
}