package pl.andrzejkuczmierowski.internal;

class MissionService {

    public void changeStatus(Mission mission, MissionStatus newStatus) {
        if (newStatus == MissionStatus.ENDED) {
            mission.setStatus(newStatus);
            mission.getRockets().clear();
        }
        mission.setStatus(newStatus);
    }

}
