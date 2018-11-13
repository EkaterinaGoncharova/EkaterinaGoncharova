package entities;

import java.util.ArrayList;
import java.util.List;

public class MetalsAndColorsData {
    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    // TODO What is the point of static method ?
    // TODO Why don't you call it from the class instance ? L<S> d = data.getTextList() ?
    public List<String> getTextList() {
        List<String> textList = new ArrayList<>();
        textList.add("Summary: " + String.valueOf(summary[0] + summary[1]));
        textList.add("Elements: " + String.join(", ", elements));
        textList.add("Color: " + color);
        textList.add("Metal: " + metals);
        textList.add("Vegetables: " + String.join(", ", vegetables));
        return textList;
    }

}
