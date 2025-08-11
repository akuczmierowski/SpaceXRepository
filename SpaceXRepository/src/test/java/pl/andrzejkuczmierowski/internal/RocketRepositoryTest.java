package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RocketRepositoryTest {

    @Test
    public void changeRocketStatusToRepairTest() throws AssignmentException {
        //having
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        RocketRepository rocketRepository = new RocketRepository();
        MissionRepository missionRepository = new MissionRepository();
        Mission mission = missionFactory.createMission("Moon");
        Rocket rocket = rocketFactory.createRocket("Luna1");
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        //when
        spaceXRepository.assignRocketToMission(rocket, mission);
        rocketRepository.changeStatus(rocket, RocketStatus.IN_REPAIR);
        //then
        assertEquals(MissionStatus.PENDING, mission.getStatus());
    }
}
