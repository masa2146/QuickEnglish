package com.bulut.quickly.english.model.adapter;

import com.bulut.quickly.english.constant.GrammarType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fatih Bulut
 * This class is for card_grammar_page.xml file.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrammarPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;
    private GrammarType grammarType;


}
