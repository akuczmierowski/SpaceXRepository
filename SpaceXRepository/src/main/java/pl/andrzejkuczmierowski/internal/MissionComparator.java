package pl.andrzejkuczmierowski.internal;

import java.util.Comparator;

public class MissionComparator implements Comparator<Mission> {
    @Override
    public int compare(Mission o1, Mission o2) {
        return o1.getRockets().size() - o2.getRockets().size();
    }

    @Override
    public Comparator<Mission> reversed() {
        return (o1, o2) -> o2.getRockets().size() - o1.getRockets().size();
    }
}
