package com.bulut.quickly.english.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class News {

    @SerializedName("level_1")
    @Expose
    private List<Level> level_1 = new ArrayList<>();
    @SerializedName("level_2")
    @Expose
    private List<Level> level_2 = new ArrayList<>();
    @SerializedName("level_3")
    @Expose
    private List<Level> level_3 = new ArrayList<>();

}
