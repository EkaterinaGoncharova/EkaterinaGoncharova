package hw_api;

import core.YandexSpellerAnswer;
import core.YandexSpellerRestApi;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static core.YandexSpellerConstants.ErrorCodes.ERROR_REPEAT_WORD;
import static core.YandexSpellerConstants.Options.FIND_REPEAT_WORDS;
import static core.YandexSpellerRestApi.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class RepeatWordErrorTests {

    @DataProvider()
    public Object[][] repeatedWords() {
        return new Object[][]{
                {"I fly to to Cyprus", "to"},
                {"I go go to school", "go"}
        };
    }

    @Test(dataProvider = "repeatedWords")
    public void repeatedWordsErrorTest(String text, String suggestion) {
        List<List<YandexSpellerAnswer>> answers = YandexSpellerRestApi.getYandexSpellerAnswersList(with().text(text).callApi());
        assertThat(answers.get(0), empty());
        answers = YandexSpellerRestApi.getYandexSpellerAnswersList(with().text(text).options(FIND_REPEAT_WORDS).callApi());
        assertThat(answers.get(0).get(0).code, is(ERROR_REPEAT_WORD.getErrorCode()));
        assertThat(answers.get(0).get(0).word, is(suggestion));
    }
}
