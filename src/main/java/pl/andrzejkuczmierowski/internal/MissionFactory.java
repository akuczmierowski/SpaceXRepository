package pl.andrzejkuczmierowski.internal;

public class MissionFactory {
    public Mission createMission(String name) {
        return new Mission(name);
    }
}
