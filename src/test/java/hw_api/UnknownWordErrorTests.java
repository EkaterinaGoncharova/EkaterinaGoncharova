package hw_api;

import core.YandexSpellerAnswer;
import core.YandexSpellerRestApi;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static core.YandexSpellerConstants.ErrorCodes.ERROR_UNKNOWN_WORD;
import static core.YandexSpellerRestApi.successResponse;
import static core.YandexSpellerRestApi.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class UnknownWordErrorTests {

    @DataProvider()
    public Object[][] misspelledWords() {
        return new Object[][]{
                {"carrry", new String[]{"carry", "carrey", "garry"}},
                {"motherr", new String[]{"mother", "mothers", "other"}}
        };
    }

    @Test(dataProvider = "misspelledWords")
    public void unknownWordErrorTest(String texts, String[] suggestions) {
        List<List<YandexSpellerAnswer>> answers = YandexSpellerRestApi.getYandexSpellerAnswersList(with().text(texts).callApi());
        for (int i = 0; i < suggestions.length; i++) {
            assertThat(answers.get(0).get(0).s.get(i), is(suggestions[i]));
        }
        assertThat(answers.get(0).get(0).code, is(ERROR_UNKNOWN_WORD.getErrorCode()));
    }

    @Test(dataProvider = "misspelledWords")
    public void correctWordsTest(String texts, String[] suggestions) {
        List<List<YandexSpellerAnswer>> answers = YandexSpellerRestApi.getYandexSpellerAnswersList(with().text(suggestions).callApi());
        for (int i = 0; i < suggestions.length; i++) {
            assertThat(answers.get(i), empty());
        }
    }

    @Test
    public void emptyTextTest() {
        Response response = with().text("").callApi();
        List<List<YandexSpellerAnswer>> answers = YandexSpellerRestApi.getYandexSpellerAnswersList(response);
        assertThat(answers.get(0), empty());
        response.then().specification(successResponse());
    }

    @Test
    public void specialCharactersTextTest() {
        Response response = with().text("!@$ %^#!~&*{}|?><").callApi();
        List<List<YandexSpellerAnswer>> answers = YandexSpellerRestApi.getYandexSpellerAnswersList(response);
        assertThat(answers.get(0), empty());
        response.then().specification(successResponse());
    }
}
