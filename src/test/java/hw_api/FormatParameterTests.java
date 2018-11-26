package hw_api;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static core.YandexSpellerRestApi.failedResponse;
import static core.YandexSpellerRestApi.with;

public class FormatParameterTests {

    @Test
    public void wrongFormatTest() {
        with()
                .format("wrong_format")
                .text("")
                .callApi()
                .then()
                .specification(failedResponse(HttpStatus.SC_BAD_REQUEST))
                .body(Matchers.equalTo("SpellerService: Invalid parameter 'format'"));
    }
}
