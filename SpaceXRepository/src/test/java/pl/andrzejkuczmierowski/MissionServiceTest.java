package pl.andrzejkuczmierowski;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;
import pl.andrzejkuczmierowski.mission.Mission;
import pl.andrzejkuczmierowski.mission.MissionFactory;
import pl.andrzejkuczmierowski.mission.MissionService;
import pl.andrzejkuczmierowski.mission.MissionStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissionServiceTest {

    @Test
    public void changeMissionStatusTest() throws AssignmentException {
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionService missionService = new MissionService();
        missionService.changeStatus(mission, MissionStatus.SCHEDULED);
       assertEquals(mission.getStatus(), MissionStatus.SCHEDULED);
    }
}
