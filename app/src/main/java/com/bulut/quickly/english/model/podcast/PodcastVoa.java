package com.bulut.quickly.english.model.podcast;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PodcastVoa extends PodcastBaseModel {
    private String dialog;
}
