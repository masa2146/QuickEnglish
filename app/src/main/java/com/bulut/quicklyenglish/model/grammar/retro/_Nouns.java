package com.bulut.quicklyenglish.model.grammar.retro;

import com.bulut.quicklyenglish.model.grammar.Nouns;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _Nouns {

    @SerializedName("content")
    @Expose
    private List<Nouns> content = null;
}
