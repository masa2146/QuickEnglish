package com.bulut.quickly.english.constant;

import com.bulut.quickly.R;
import com.bulut.quickly.english.model.adapter.GrammarPageData;
import com.bulut.quickly.english.model.adapter.MainPageData;
import com.bulut.quickly.english.model.adapter.PodcastPageData;
import com.bulut.quickly.english.view.main.MainChatBotFragment;
import com.bulut.quickly.english.view.main.MainGrammarFragment;
import com.bulut.quickly.english.view.main.MainPodcastFragment;
import com.bulut.quickly.english.view.main.MainTranslatorFragment;
import com.bulut.quickly.english.view.main.MainVocabularyFragment;

public class PagesNames {
    public static final String GRAMMAR_ADJECTIVES_WITH_PAGE = "adjectives";
    public static final String GRAMMAR_ADJECTIVES_ALL = "adjectives/all";

    public static final String GRAMMAR_ADVERBS_WITH_PAGE = "adverbs";
    public static final String GRAMMAR_ADVERBS_ALL = "adverbs/all";

    public static final String GRAMMAR_NOUNS_WITH_PAGE = "nouns";
    public static final String GRAMMAR_NOUNS_ALL = "nouns/all";

    public static final String GRAMMAR_PREPOSTIONS_WITH_PAGE = "prepositions";
    public static final String GRAMMAR_PREPOSTIONS_ALL = "prepositions/all";

    public static final String GRAMMAR_PRONOUNS_WITH_PAGE = "pronouns";
    public static final String GRAMMAR_PRONOUNS_ALL = "pronouns/all";

    public static final String GRAMMAR_VERBS_WITH_PAGE = "verbs";
    public static final String GRAMMAR_VERBS_ALL = "verbs/all";

    public static final String NEWS_WITH_PAGE = "news";
    public static final String NEWS_ALL = "news/all";

    public static final String PODCAST_LEVEL1_WITH_PAGE = "level_1";
    public static final String PODCAST_LEVEL1_ALL = "level1/all";

    public static final String PODCAST_LEVEL2_WITH_PAGE = "level_2";
    public static final String PODCAST_LEVEL2_ALL = "level2/all";

    public static final String PODCAST_LEVEL3_WITH_PAGE = "level_3";
    public static final String PODCAST_LEVEL3_ALL = "level3/all";

    public static final String PODCAST_LEVEL_BUSINESS_WITH_PAGE = "level_business";
    public static final String PODCAST_LEVEL_BUSINESS_ALL = "level_business/all";

    public static final String PODCAST_VOA1_WITH_PAGE = "level_voa_level_1";
    public static final String PODCAST_VOA1_ALL = "level_voa_level_1/all";

    public static final String PODCAST_VOA2_WITH_PAGE = "level_voa_level_2";
    public static final String PODCAST_VOA2_ALL = "level_voa_level_2/all";

    public static final MainPageData[] mainPageDataArray = new MainPageData[]{
            new MainPageData(R.drawable.profile_img, "Vocabulary", "Learn vocabulary", new MainVocabularyFragment()),
            new MainPageData(R.drawable.profile_img, "Grammar", "Learn grammar", new MainGrammarFragment()),
            new MainPageData(R.drawable.profile_img, "Listening", "Learn listening", new MainPodcastFragment()),
            new MainPageData(R.drawable.profile_img, "ChatBot", "Speaking with AI", new MainChatBotFragment()),
            new MainPageData(R.drawable.profile_img, "Translator", "Translate is any word", new MainTranslatorFragment())
    };

    public static final GrammarPageData[] grammarPageDataArray = new GrammarPageData[]{
            new GrammarPageData(R.drawable.profile_img, "Adjective", "Learn adjectives", GrammarType.ADJECTIVES),
            new GrammarPageData(R.drawable.profile_img, "Adverbs", "Learn adverbs", GrammarType.ADVERBS),
            new GrammarPageData(R.drawable.profile_img, "Nouns", "Learn nouns", GrammarType.NOUNS),
            new GrammarPageData(R.drawable.profile_img, "Prepositions", "Learn prepositions", GrammarType.PREPOSITIONS),
            new GrammarPageData(R.drawable.profile_img, "Pronouns", "Learn pronouns", GrammarType.PRONOUNS),
            new GrammarPageData(R.drawable.profile_img, "Verbs", "Learn verbs", GrammarType.VERBS),
    };

    public static final PodcastPageData[] podcastPageDataArray = new PodcastPageData[]{
            new PodcastPageData(R.drawable.profile_img, "Podcast level 1", "Listen level 1 podcast", PodcastType.PODCAST_LEVEL_1),
            new PodcastPageData(R.drawable.profile_img, "Podcast level 2", "Listen level 2 podcast", PodcastType.PODCAST_LEVEL_2),
            new PodcastPageData(R.drawable.profile_img, "Podcast level 3", "Listen level 3 podcast", PodcastType.PODCAST_LEVEL_3),
            new PodcastPageData(R.drawable.profile_img, "Podcast level business", "Listen level business podcast", PodcastType.PODCAST_LEVEL_BUSINESS),
            new PodcastPageData(R.drawable.profile_img, "Podcast voice of America part 1", "Listen level voice of America podcast", PodcastType.PODCAST_VOA_1),
            new PodcastPageData(R.drawable.profile_img, "Podcast voice of America part 2", "Listen level voice of America podcast", PodcastType.PODCAST_VOA_2),
    };


}
