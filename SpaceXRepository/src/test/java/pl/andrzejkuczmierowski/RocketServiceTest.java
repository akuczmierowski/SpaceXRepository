package pl.andrzejkuczmierowski;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.mission.Mission;
import pl.andrzejkuczmierowski.mission.MissionFactory;
import pl.andrzejkuczmierowski.mission.MissionStatus;
import pl.andrzejkuczmierowski.rocket.Rocket;
import pl.andrzejkuczmierowski.rocket.RocketFactory;
import pl.andrzejkuczmierowski.rocket.RocketService;
import pl.andrzejkuczmierowski.rocket.RocketStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RocketServiceTest {

    @Test
    public void assignMissionToRocketTest(){
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        RocketService rocketService = new RocketService();
        Mission mission = missionFactory.createMission("Moon");
        Rocket rocket =rocketFactory.createRocket("Luna1");
        rocketService.assignMissionToRocket(mission,rocket);
        assertEquals(rocket.getStatus(), RocketStatus.IN_SPACE);
        assertEquals(mission.getStatus(), MissionStatus.IN_PROGRESS);

    }
}
