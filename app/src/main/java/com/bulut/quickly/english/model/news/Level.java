package com.bulut.quickly.english.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
class Level {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("video_link")
    @Expose
    private String video_link;
    @SerializedName("video_image")
    @Expose
    private String video_image;
}
