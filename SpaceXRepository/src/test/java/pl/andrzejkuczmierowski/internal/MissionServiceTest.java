package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.*;

public class MissionServiceTest {

    @Test
    public void changeMissionStatusTest() throws AssignmentException {
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionService missionService = new MissionService();
        missionService.changeStatus(mission, MissionStatus.SCHEDULED);
        assertEquals(MissionStatus.SCHEDULED, mission.getStatus());
    }

    @Test
    public void changeMissionStatusToEndedTryAssignRocketTest() {
        //having
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionService missionService = new MissionService();
        RocketService rocketService = new RocketService();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionService, rocketService);
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        //when
        missionService.changeStatus(mission, MissionStatus.ENDED);
        //then
        assertThrows(AssignmentException.class, () -> spaceXRepository.assignRocketToMission(rocket, mission));
    }

    @Test
    public void changeMissionStatusToEnded() throws AssignmentException {
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionService missionService = new MissionService();
        RocketService rocketService = new RocketService();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionService, rocketService);
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocketLuna = rocketFactory.createRocket("Luna");
        Rocket rocketMoonRacker = rocketFactory.createRocket("MoonRacker");
        spaceXRepository.assignRocketToMission(rocketLuna, mission);
        spaceXRepository.assignRocketToMission(rocketMoonRacker, mission);
        //when
        missionService.changeStatus(mission, MissionStatus.ENDED);
        //then
        assertTrue(mission.getRockets().isEmpty());
    }
}
