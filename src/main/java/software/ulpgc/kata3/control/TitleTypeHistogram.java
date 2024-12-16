package software.ulpgc.kata3.control;

import software.ulpgc.kata3.model.Histogram;
import software.ulpgc.kata3.model.Title;

import java.util.HashMap;
import java.util.List;

public class TitleTypeHistogram implements Histogram {
    private final HashMap<Title.TitleType, Integer> histogram;

    public TitleTypeHistogram(List<Title> titles) {
        histogram = createHistogram(titles);
    }

    private static HashMap<Title.TitleType, Integer> createHistogram(List<Title> titles) {
        HashMap<Title.TitleType, Integer> histogram = new HashMap<>();
        for (Title title : titles) {
            histogram.put(title.getTitleType(), histogram.getOrDefault(title.getTitleType(), 0)+1);
        }
        return histogram;
    }

    @Override
    public int bins() {
        return 20;
    }

    @Override
    public double[] values() {
        return histogram.values().stream().mapToDouble(Integer::doubleValue).toArray();
    }

    public HashMap<Title.TitleType, Integer> getHistogram() {
        return histogram;
    }
}
