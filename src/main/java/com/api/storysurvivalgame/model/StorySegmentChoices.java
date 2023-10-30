package com.api.storysurvivalgame.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "story_segment_choices")
public class StorySegmentChoices {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private StorySegment storySegment;

    @ManyToOne
    @JoinColumn(name = "choice_id_1")
    private Choice choice1;

    @ManyToOne
    @JoinColumn(name = "choice_id_2")
    private Choice choice2;
}
