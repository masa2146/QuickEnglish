package com.bulut.quicklyenglish.model.grammar.retro;

import com.bulut.quicklyenglish.model.grammar.Pronouns;
import com.bulut.quicklyenglish.model.grammar.Verbs;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class _Verbs {
    @SerializedName("content")
    @Expose
    private List<Verbs> content = null;
}
