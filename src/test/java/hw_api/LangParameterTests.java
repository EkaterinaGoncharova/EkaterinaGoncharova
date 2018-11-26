package hw_api;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static core.YandexSpellerConstants.Language.WRONG_LANG;
import static core.YandexSpellerRestApi.failedResponse;
import static core.YandexSpellerRestApi.with;

public class LangParameterTests {

    @Test
    public void wrongLangTest() {
        with()
                .language(WRONG_LANG)
                .text("")
                .callApi()
                .then()
                .specification(failedResponse(HttpStatus.SC_BAD_REQUEST))
                .body(Matchers.equalTo("SpellerService: Invalid parameter 'lang'"));
    }
}
