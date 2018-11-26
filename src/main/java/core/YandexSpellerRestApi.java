package core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static core.YandexSpellerConstants.*;
import static org.hamcrest.Matchers.lessThan;

public class YandexSpellerRestApi {

    private static final String YANDEX_SPELLER_API_URI = "https://speller.yandex.net/services/spellservice.json/checkTexts";

    private YandexSpellerRestApi() {
    }

    private HashMap<String, String> params = new HashMap<>();
    private HashMap<String, List<String>> textsparam = new HashMap<>();

    public static class ApiBuilder {
        YandexSpellerRestApi spellerApi;

        private ApiBuilder(YandexSpellerRestApi gcApi) {
            spellerApi = gcApi;
        }

        public ApiBuilder text(String... texts) {
            spellerApi.textsparam.put(PARAM_TEXT, Arrays.asList(texts));
            return this;
        }

        public ApiBuilder options(Options... options) {
            int options_sum = 0;
            for (Options option : options) {
                options_sum += option.getOptionsCode();
            }
            spellerApi.params.put(PARAM_OPTIONS, String.valueOf(options_sum));
            return this;
        }

        public ApiBuilder language(Language language) {
            spellerApi.params.put(PARAM_LANG, language.langCode());
            return this;
        }

        public ApiBuilder format(String format) {
            spellerApi.params.put(PARAM_FORMAT, format);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(spellerApi.params)
                    .queryParams(spellerApi.textsparam)
                    .log().all()
                    .get(YANDEX_SPELLER_API_URI).prettyPeek();
        }
    }

    public static ApiBuilder with() {
        YandexSpellerRestApi api = new YandexSpellerRestApi();
        return new ApiBuilder(api);
    }

    public static List<List<YandexSpellerAnswer>> getYandexSpellerAnswersList(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<List<YandexSpellerAnswer>>>() {
        }.getType());
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectHeader("Connection", "keep-alive")
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification failedResponse(int httpStatus) {
        return new ResponseSpecBuilder()
                .expectStatusCode(httpStatus)
                .expectHeader("Connection", "keep-alive")
                .expectResponseTime(lessThan(20000L))
                .build();
    }
}
