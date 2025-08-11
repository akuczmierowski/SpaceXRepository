package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.*;

public class MissionRepositoryTest {

    @Test
    public void changeMissionStatusTest() throws AssignmentException {
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionRepository missionRepository = new MissionRepository();
        missionRepository.changeStatus(mission, MissionStatus.SCHEDULED);
        assertEquals(MissionStatus.SCHEDULED, mission.getStatus());
    }

    @Test
    public void changeMissionStatusToEndedTryAssignRocketTest() {
        //having
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        //when
        missionRepository.changeStatus(mission, MissionStatus.ENDED);
        //then
        assertThrows(AssignmentException.class, () -> spaceXRepository.assignRocketToMission(rocket, mission));
    }

    @Test
    public void changeMissionStatusToEnded() throws AssignmentException {
        //having
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocketLuna = rocketFactory.createRocket("Luna");
        Rocket rocketMoonRacker = rocketFactory.createRocket("MoonRacker");
        spaceXRepository.assignRocketToMission(rocketLuna, mission);
        spaceXRepository.assignRocketToMission(rocketMoonRacker, mission);
        //when
        missionRepository.changeStatus(mission, MissionStatus.ENDED);
        //then
        assertTrue(mission.getRockets().isEmpty());
    }
}
