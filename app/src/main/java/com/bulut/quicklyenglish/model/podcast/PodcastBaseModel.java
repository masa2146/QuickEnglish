package com.bulut.quicklyenglish.model.podcast;

import lombok.Data;

@Data
abstract class PodcastBaseModel {
    private String title;
    private String url;

}
