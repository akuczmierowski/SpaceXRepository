package pl.andrzejkuczmierowski.internal;

import pl.andrzejkuczmierowski.exception.AssignmentException;

import java.util.Set;

public class SpaceXRepository {

    private final MissionRepository missionRepository;
    private final RocketRepository rocketRepository;

    public SpaceXRepository(MissionRepository missionRepository, RocketRepository rocketRepository) {
        this.missionRepository = missionRepository;
        this.rocketRepository = rocketRepository;
    }

    public void assignRocketToMission(Rocket rocket, Mission mission) throws AssignmentException {
        if (mission.getStatus() == MissionStatus.ENDED) {
            throw new AssignmentException("Mission finished, cannot assign Rocket");
        } else if (rocket.getMission() != null) {
            throw new AssignmentException("Rocket already assigned to this Mission");
        }

        rocketRepository.addMission(mission, rocket);
        missionRepository.addRocket(mission, rocket);
    }

    public void addMission(Mission mission) {
        missionRepository.addMission(mission);
    }

    public void addRocket(Rocket rocket) {
        rocketRepository.addRocket(rocket);
    }

    public void addRockets(Mission mission, Set<Rocket> rockets) {
        mission.addAll(rockets);
    }

    public String getMissionsSummary() {
        return missionRepository.getSummary();
    }

}
