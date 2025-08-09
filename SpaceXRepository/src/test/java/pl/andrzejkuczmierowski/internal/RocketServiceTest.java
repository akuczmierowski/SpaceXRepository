package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RocketServiceTest {

    @Test
    public void assignMissionToRocketTest() throws AssignmentException {
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        RocketService rocketService = new RocketService();
        Mission mission = missionFactory.createMission("Moon");
        Rocket rocket = rocketFactory.createRocket("Luna1");
        rocketService.assignMission(mission, rocket);
        assertEquals(rocket.getStatus(), RocketStatus.IN_SPACE);
        assertEquals(mission.getStatus(), MissionStatus.IN_PROGRESS);
        assertTrue(mission.getRockets().contains(rocket));
        assertEquals(rocket.getMission(), mission);

    }
}
