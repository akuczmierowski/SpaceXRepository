package pl.andrzejkuczmierowski.mission;

import pl.andrzejkuczmierowski.exception.AssignmentException;
import pl.andrzejkuczmierowski.rocket.Rocket;
import pl.andrzejkuczmierowski.rocket.RocketService;

public class MissionService {




    public void assignRocketToMission(Rocket rocket, Mission mission) throws AssignmentException {
        if (mission.getStatus() == MissionStatus.ENDED) {
            throw new AssignmentException("Mission finished, cannot assign Rocket");
        }
        mission.setStatus(MissionStatus.IN_PROGRESS);
        mission.getRockets().add(rocket);
    }
}
