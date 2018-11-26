package core;

public class YandexSpellerConstants {

    static final String PARAM_TEXT = "text";
    static final String PARAM_OPTIONS = "options";
    static final String PARAM_LANG = "lang";
    static final String PARAM_FORMAT = "format";


    public enum Language {
        RU("ru"),
        UK("uk"),
        EN("en"),
        WRONG_LANG("enn");

        private String languageCode;

        public String langCode() {
            return languageCode;
        }

        Language(String lang) {
            this.languageCode = lang;
        }
    }

    public enum Options {
        IGNORE_DIGITS(2),
        IGNORE_URLS(4),
        FIND_REPEAT_WORDS(8),
        IGNORE_CAPITALIZATION(512);

        private Integer optionsCode;

        public Integer getOptionsCode() {
            return optionsCode;
        }

        Options(Integer optionsCode) {
            this.optionsCode = optionsCode;
        }
    }

    public enum ErrorCodes {
        ERROR_UNKNOWN_WORD(1),
        ERROR_REPEAT_WORD(2),
        ERROR_CAPITALIZATION(3),
        ERROR_TOO_MANY_ERRORS(4);

        private int value;

        public Integer getErrorCode() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        ErrorCodes(int value) {
            this.value = value;
        }
    }
}
