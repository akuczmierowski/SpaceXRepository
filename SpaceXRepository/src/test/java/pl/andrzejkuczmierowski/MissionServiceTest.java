package pl.andrzejkuczmierowski;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.mission.Mission;
import pl.andrzejkuczmierowski.mission.MissionFactory;
import pl.andrzejkuczmierowski.rocket.Rocket;
import pl.andrzejkuczmierowski.rocket.RocketFactory;
import pl.andrzejkuczmierowski.rocket.RocketStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MissionServiceTest {

    @Test
    public void assignRocketToValidMission() {
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("MoonRacker");
        MissionService missionService = new MissionService();
        assertTrue(mission.getRockets().contains(rocket));
        assertEquals(rocket.getStatus(), RocketStatus.IN_SPACE);
        assertEquals(rocket.getMission(), mission);
    }
}
