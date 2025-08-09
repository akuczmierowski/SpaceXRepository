package pl.andrzejkuczmierowski.internal;

import pl.andrzejkuczmierowski.exception.AssignmentException;

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
        rocketService.changeStatus(rocket, RocketStatus.IN_SPACE);
        mission.getRockets().add(rocket);
    }

}
