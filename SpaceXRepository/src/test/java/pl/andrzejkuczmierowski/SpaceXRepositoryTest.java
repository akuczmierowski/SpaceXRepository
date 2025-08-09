package pl.andrzejkuczmierowski;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;
import pl.andrzejkuczmierowski.mission.Mission;
import pl.andrzejkuczmierowski.mission.MissionFactory;
import pl.andrzejkuczmierowski.mission.MissionStatus;
import pl.andrzejkuczmierowski.repository.SpaceXRepository;
import pl.andrzejkuczmierowski.rocket.Rocket;
import pl.andrzejkuczmierowski.rocket.RocketFactory;
import pl.andrzejkuczmierowski.rocket.RocketStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpaceXRepositoryTest {

    @Test
    public void assignValidRocketToValidMission() throws AssignmentException {

        SpaceXRepository spaceXRepository = new SpaceXRepository();
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Mars");
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket=rocketFactory.createRocket("Luna");
        spaceXRepository.assignRocketToMission(rocket,mission);
        assertTrue(mission.getRockets().contains(rocket));
        assertEquals(rocket.getStatus(), RocketStatus.IN_SPACE);
        assertEquals(mission.getStatus(), MissionStatus.IN_PROGRESS);
        assertEquals(rocket.getMission(), mission);

    }
}
