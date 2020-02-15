package com.bulut.quickly.english.model.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fatih Bulut
 * This class is for card_grammar_content.xml file.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrammarContentData {

    private int contentImage;
    private String contextHeader;
    private String contentText;


}
