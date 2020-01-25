package com.bulut.quicklyenglish.model.grammar.retro;

import com.bulut.quicklyenglish.model.grammar.Adverbs;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _Adverbs {

    @SerializedName("content")
    @Expose
    private List<Adverbs> content = null;
}
