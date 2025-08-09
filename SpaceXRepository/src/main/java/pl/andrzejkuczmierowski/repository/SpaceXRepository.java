package pl.andrzejkuczmierowski.repository;

import pl.andrzejkuczmierowski.exception.AssignmentException;
import pl.andrzejkuczmierowski.mission.Mission;
import pl.andrzejkuczmierowski.mission.MissionService;
import pl.andrzejkuczmierowski.mission.MissionStatus;
import pl.andrzejkuczmierowski.rocket.Rocket;
import pl.andrzejkuczmierowski.rocket.RocketService;
import pl.andrzejkuczmierowski.rocket.RocketStatus;

public class SpaceXRepository {

    private final MissionService missionService;
    private final RocketService rocketService;

    public SpaceXRepository(MissionService missionService, RocketService rocketService) {
        this.missionService = missionService;
        this.rocketService = rocketService;
    }

    public void assignRocketToMission(Rocket rocket, Mission mission) throws AssignmentException {
        if (mission.getStatus() == MissionStatus.ENDED) {
            throw new AssignmentException("Mission finished, cannot assign Rocket");
        }

        missionService.changeStatus(mission,MissionStatus.IN_PROGRESS);
        rocketService.changeRocketStatus(rocket, RocketStatus.IN_SPACE);
        mission.getRockets().add(rocket);
    }
}
