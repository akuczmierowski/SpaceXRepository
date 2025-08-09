package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceXRepositoryTest {

    @Test
    public void assignValidRocketToValidMission() throws AssignmentException {
        MissionService missionService = new MissionService();
        RocketService rocketService = new RocketService();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionService, rocketService);
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Mars");
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        spaceXRepository.assignRocketToMission(rocket, mission);
        assertTrue(mission.getRockets().contains(rocket));
        assertEquals(rocket.getStatus(), RocketStatus.IN_SPACE);
        assertEquals(mission.getStatus(), MissionStatus.IN_PROGRESS);
        assertEquals(rocket.getMission(), mission);

    }
    @Test
    public void assignSameRocketToManyMissions() throws AssignmentException {
        MissionService missionService = new MissionService();
        RocketService rocketService = new RocketService();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionService, rocketService);
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        Mission missionMars = missionFactory.createMission("Mars");
        Mission missionMoon = missionFactory.createMission("Moon");
        spaceXRepository.assignRocketToMission(rocket, missionMars);
        assertThrows(AssignmentException.class, () -> spaceXRepository.assignRocketToMission(rocket, missionMoon));
    }
}
