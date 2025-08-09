package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MissionFactoryTest {
    @Test
    public void createMissionTest() {
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Mars");
        assertEquals( MissionStatus.IN_PROGRESS,mission.getStatus());
        assertTrue(mission.getRockets().isEmpty());
    }
}
