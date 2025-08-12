package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceXRepositoryTest {

    @Test
    public void assignValidRocketToValidMission() throws AssignmentException {
        //having
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Mars");
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        //when
        spaceXRepository.assignRocketToMission(rocket, mission);
        //then
        assertTrue(mission.getRockets().contains(rocket));
        assertEquals(RocketStatus.IN_SPACE, rocket.getStatus());
        assertEquals(MissionStatus.IN_PROGRESS, mission.getStatus());
        assertEquals(rocket.getMission(), mission);

    }

    @Test
    public void assignSameRocketToManyMissions() throws AssignmentException {
        //having
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Luna");
        Mission missionMars = missionFactory.createMission("Mars");
        Mission missionMoon = missionFactory.createMission("Moon");
        spaceXRepository.assignRocketToMission(rocket, missionMars);
        //then
        assertThrows(AssignmentException.class, () -> spaceXRepository.assignRocketToMission(rocket, missionMoon));
    }

    @Test
    public void addMission() {
        //having
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Mars");
        //when
        spaceXRepository.addMission(mission);
        spaceXRepository.addMission(mission);
        spaceXRepository.addMission(mission);
        //then
        assertTrue(missionRepository.getMissions().contains(mission));
        assertEquals(1, missionRepository.getMissions().size());
    }

    @Test
    public void addRocket() {
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        RocketFactory rocketFactory = new RocketFactory();
        Rocket rocketLuna = rocketFactory.createRocket("Luna");
        //when
        spaceXRepository.addRocket(rocketLuna);
        spaceXRepository.addRocket(rocketLuna);
        spaceXRepository.addRocket(rocketLuna);
        //then
        assertTrue(rocketRepository.getRockets().contains(rocketLuna));
        assertEquals(1, rocketRepository.getRockets().size());
    }

    @Test
    public void addRocketsToMissionWithoutRockets() {
        //having
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        RocketFactory rocketFactory = new RocketFactory();
        MissionFactory missionFactory = new MissionFactory();
        Rocket rocket1 = rocketFactory.createRocket("Luna1");
        Rocket rocket2 = rocketFactory.createRocket("Luna2");
        Rocket rocket3 = rocketFactory.createRocket("Luna3");
        Set<Rocket> rockets = new LinkedHashSet<>();
        rockets.add(rocket1);
        rockets.add(rocket2);
        rockets.add(rocket3);
        Mission mission = missionFactory.createMission("Mars");
        //when
        spaceXRepository.addRockets(mission, rockets);
        //then
        assertTrue(rockets.equals(mission.getRockets()));
    }

    @Test
    public void addRocketsToMissionWithRockets() {
        //having
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        RocketFactory rocketFactory = new RocketFactory();
        MissionFactory missionFactory = new MissionFactory();
        Rocket rocket1 = rocketFactory.createRocket("Luna1");
        Rocket rocket2 = rocketFactory.createRocket("Luna2");
        Rocket rocket3 = rocketFactory.createRocket("Luna3");
        Mission mission = missionFactory.createMission("Mars");
        Set<Rocket> rockets1 = new LinkedHashSet<>();
        rockets1.add(rocket1);
        rockets1.add(rocket2);
        rockets1.add(rocket3);
        Rocket rocket4 = rocketFactory.createRocket("Luna4");
        Rocket rocket5 = rocketFactory.createRocket("Luna5");
        Rocket rocket6 = rocketFactory.createRocket("Luna6");
        Set<Rocket> rockets2 = new LinkedHashSet<>();
        rockets2.add(rocket4);
        rockets2.add(rocket5);
        rockets2.add(rocket6);
        //when
        spaceXRepository.addRockets(mission, rockets1);
        spaceXRepository.addRockets(mission, rockets2);
        //then
        assertTrue(mission.getRockets().containsAll(rockets1));
    }


}
