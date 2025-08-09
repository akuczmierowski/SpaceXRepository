package pl.andrzejkuczmierowski;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.mission.Mission;
import pl.andrzejkuczmierowski.mission.MissionFactory;
import pl.andrzejkuczmierowski.mission.MissionStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MissionFactoryTest {
    @Test
    public void createMissionTest() {
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Mars");
        assertEquals(mission.getStatus(), MissionStatus.IN_PROGRESS);
        assertTrue(mission.getRockets().isEmpty());
    }
}
