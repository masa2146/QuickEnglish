package com.bulut.quickly.english.model.podcast;

import lombok.Data;

@Data
abstract class PodcastBaseModel {
    private String title;
    private String url;

}
