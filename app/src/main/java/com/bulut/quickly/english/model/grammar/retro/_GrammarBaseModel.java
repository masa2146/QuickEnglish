package com.bulut.quickly.english.model.grammar.retro;

import com.bulut.quickly.english.model.grammar.GrammarBaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public abstract class _GrammarBaseModel {

    @SerializedName("content")
    @Expose
    private List<GrammarBaseModel> content = null;
}
