package com.bulut.quickly.english.model.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fatih Bulut
 * This class is for card_news_page.xml file.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;

}
