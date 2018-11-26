package hw_api;

import core.YandexSpellerAnswer;
import core.YandexSpellerRestApi;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static core.YandexSpellerConstants.ErrorCodes.ERROR_CAPITALIZATION;
import static core.YandexSpellerConstants.Options.IGNORE_CAPITALIZATION;
import static core.YandexSpellerRestApi.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CapitalizationErrorTests {

    @DataProvider()
    public Object[][] uncapitalizedWords() {
        return new Object[][]{
                {"moscow", "Moscow"},
                {"russia", "Russia"}
        };
    }

    @Test(dataProvider = "uncapitalizedWords")
    public void capitalizationErrorTest(String text, String suggestion) {
        List<List<YandexSpellerAnswer>> answers = YandexSpellerRestApi.getYandexSpellerAnswersList(with().text(text).callApi());
        assertThat(answers.get(0).get(0).code, is(ERROR_CAPITALIZATION.getErrorCode()));
        assertThat(answers.get(0).get(0).s, is(suggestion));
        answers = YandexSpellerRestApi.getYandexSpellerAnswersList(with().text(text).options(IGNORE_CAPITALIZATION).callApi());
        assertThat(answers.get(0), empty());
    }
}
