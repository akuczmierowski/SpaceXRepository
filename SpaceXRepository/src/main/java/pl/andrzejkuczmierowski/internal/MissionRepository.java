package pl.andrzejkuczmierowski.internal;

import pl.andrzejkuczmierowski.exception.AssignmentException;
import pl.andrzejkuczmierowski.repository.MissionRepositoryInterface;

import java.util.HashSet;
import java.util.Set;

class MissionRepository implements MissionRepositoryInterface {

    private final Set<Mission> missions;

    MissionRepository() {
        this.missions = new HashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);
    }

    @Override
    public void removeMission(Mission mission) {
        missions.remove(mission);
    }

    @Override
    public void removeRocket(Mission mission, Rocket rocket) {
        mission.removeRocket(rocket);
    }

    @Override
    public void addRocket(Mission mission, Rocket rocket) throws AssignmentException {
        if (missions.contains(mission)) {
            throw new AssignmentException("Rocket already assigned");
        }
        if (rocket.getStatus() == RocketStatus.IN_REPAIR) {
            mission.setStatus(MissionStatus.PENDING);
        }
        if(mission.getRockets().isEmpty()) {
            mission.setStatus(MissionStatus.IN_PROGRESS);
        }
        mission.addRocket(rocket);
    }

    @Override
    public Set<Mission> getMissions() {
        return missions;
    }

    @Override
    public void changeStatus(Mission mission, MissionStatus newStatus) {
        if (newStatus == MissionStatus.ENDED) {
            mission.setStatus(newStatus);
            mission.getRockets().forEach(rocket -> rocket.setMission(null));
            mission.removeAllRockets();
        }
        mission.setStatus(newStatus);
    }

    public String getSummary(){
        StringBuilder sb = new StringBuilder();
        missions.forEach(mission -> sb.append(mission.toString()));
        return sb.toString();
    }

}
