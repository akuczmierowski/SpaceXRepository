package pl.andrzejkuczmierowski.internal;

 class MissionService {

    public void changeStatus(Mission mission, MissionStatus newStatus) {
        mission.setStatus(newStatus);
    }

}
