package pl.andrzejkuczmierowski.internal;

class RocketService {

    void changeStatus(Rocket rocket, RocketStatus newStatus) {
        Mission mission = rocket.getMission();
        if (mission != null && newStatus == RocketStatus.IN_REPAIR) {
            mission.setStatus(MissionStatus.PENDING);
        }
        rocket.setStatus(newStatus);
    }


}
