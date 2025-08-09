package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RocketServiceTest {

    @Test
    public void changeRocketStatusToRepairTest() throws AssignmentException {
        //having
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        RocketService rocketService = new RocketService();
        MissionService missionService = new MissionService();
        Mission mission = missionFactory.createMission("Moon");
        Rocket rocket = rocketFactory.createRocket("Luna1");
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionService, rocketService);
        //when
        spaceXRepository.assignRocketToMission(rocket, mission);
        rocketService.changeStatus(rocket, RocketStatus.IN_REPAIR);
        //then
        assertEquals(MissionStatus.PENDING, mission.getStatus());
    }
}
