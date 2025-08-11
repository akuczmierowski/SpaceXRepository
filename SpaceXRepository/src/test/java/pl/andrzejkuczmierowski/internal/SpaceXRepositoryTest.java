package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceXRepositoryTest {

    @Test
    public void assignValidRocketToValidMission() throws AssignmentException {
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Mars");
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        spaceXRepository.assignRocketToMission(rocket, mission);
        assertTrue(mission.getRockets().contains(rocket));
        assertEquals(RocketStatus.IN_SPACE, rocket.getStatus());
        assertEquals(MissionStatus.IN_PROGRESS, mission.getStatus());
        assertEquals(rocket.getMission(), mission);

    }

    @Test
    public void assignSameRocketToManyMissions() throws AssignmentException {
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        Mission missionMars = missionFactory.createMission("Mars");
        Mission missionMoon = missionFactory.createMission("Moon");
        spaceXRepository.assignRocketToMission(rocket, missionMars);
        assertThrows(AssignmentException.class, () -> spaceXRepository.assignRocketToMission(rocket, missionMoon));
    }

    @Test
    public void addMission() {
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        MissionFactory missionFactory = new MissionFactory();
        Mission mission=missionFactory.createMission("Mars");
        spaceXRepository.addMission(mission);
        spaceXRepository.addMission(mission);
        spaceXRepository.addMission(mission);
        assertTrue(missionRepository.getMissions().contains(mission));
        assertEquals(missionRepository.getMissions().size(), 1);
    }
}
