package com.bulut.quicklyenglish.model.grammar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
abstract class GrammarBaseModel {

    @SerializedName("context_header")
    @Expose
    private String context_header;
    @SerializedName("context_text")
    @Expose
    private String context_text;
}
