package pl.andrzejkuczmierowski.mission;

public class MissionService {

    public void changeStatus(Mission mission, MissionStatus newStatus) {
        mission.setStatus(newStatus);
    }

}
