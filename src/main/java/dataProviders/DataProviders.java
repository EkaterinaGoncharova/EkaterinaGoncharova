package dataProviders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DataProviders {
    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] homePageTextDataProvider() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @DataProvider
    public Object[] metalsAndColorsDataProvider() throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader("src\\test\\resources\\metalsAndColorsDataSet.json"));
        Type typeToken = new TypeToken<Map<String, MetalsAndColorsData>>() {
        }.getType();
        Map<String, MetalsAndColorsData> map = new Gson().fromJson(jsonReader, typeToken);
        return map.values().toArray();
    }
}
