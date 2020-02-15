package com.bulut.quickly.english.model.adapter;

import com.bulut.quickly.english.constant.PodcastType;
import com.bulut.quickly.english.constant.ResponseType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fatih Bulut
 * This class is for card_podcast_page.xml file.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodcastPageData {

    private int contentImage;
    private String contextHeader;
    private String contentText;
    private PodcastType podcastType;
    private ResponseType responseType;
}
