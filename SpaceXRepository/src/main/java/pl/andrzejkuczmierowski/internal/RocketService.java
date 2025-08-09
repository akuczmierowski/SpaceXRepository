package pl.andrzejkuczmierowski.internal;

import pl.andrzejkuczmierowski.exception.AssignmentException;

class RocketService {

     void changeStatus(Rocket rocket, RocketStatus newStatus) {
        rocket.setStatus(newStatus);
    }

     void assignMission(Mission mission, Rocket rocket) throws AssignmentException {
        if (rocket.getMission() != null||mission.getStatus()== MissionStatus.ENDED) {
            throw new AssignmentException("Cannot assign mission to rocket");
        }
            rocket.setMission(mission);
    }
}
