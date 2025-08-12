package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.exception.AssignmentException;

import static org.junit.jupiter.api.Assertions.*;

public class MissionRepositoryTest {

    @Test
    public void changeMissionStatusTest() throws AssignmentException {
        //having
        MissionFactory missionFactory = new MissionFactory();
        Mission mission = missionFactory.createMission("Moon");
        MissionRepository missionRepository = new MissionRepository();
        //when
        missionRepository.changeStatus(mission, MissionStatus.SCHEDULED);
        //then
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
        assertEquals(null, rocketLuna.getMission());
        assertEquals(null, rocketMoonRacker.getMission());
    }

    @Test
    public void getSummary() throws AssignmentException {
        //having
        MissionRepository missionRepository = new MissionRepository();
        RocketRepository rocketRepository = new RocketRepository();
        SpaceXRepository spaceXRepository = new SpaceXRepository(missionRepository, rocketRepository);
        MissionFactory missionFactory = new MissionFactory();
        RocketFactory rocketFactory = new RocketFactory();
        Mission missionMars = missionFactory.createMission("Mars");
        Mission missionLuna1 = missionFactory.createMission("Luna 1");
        Mission missionTransit = missionFactory.createMission("Transit");
        Rocket dragon1 = rocketFactory.createRocket("Dragon 1");
        Rocket dragon2 = rocketFactory.createRocket("Dragon 2");
        Rocket redDragon = rocketFactory.createRocket("Red Dragon");
        Rocket falcon = rocketFactory.createRocket("Falcon");
        Rocket dragonXL = rocketFactory.createRocket("DragonXL");
        spaceXRepository.assignRocketToMission(dragon1, missionLuna1);
        spaceXRepository.assignRocketToMission(dragon2, missionLuna1);
        spaceXRepository.assignRocketToMission(redDragon, missionTransit);
        spaceXRepository.assignRocketToMission(falcon,missionTransit);
        spaceXRepository.assignRocketToMission(dragonXL,missionTransit);
        spaceXRepository.addMission(missionMars);
        spaceXRepository.addMission(missionLuna1);
        spaceXRepository.addMission(missionTransit);
        //when
        String summary = missionRepository.getSummary();
        //then
        assertTrue(summary.contains("Luna 1 - In progress - Dragons: 2"));
        assertTrue(summary.contains("Dragon 1 - In space"));
        assertTrue(summary.contains("Mars - Scheduled - Dragons: 0"));

    }
}
