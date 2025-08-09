package pl.andrzejkuczmierowski.mission;

public class MissionFactory {
    public Mission createMission(String name) {
        return new Mission(name);
    }
}
