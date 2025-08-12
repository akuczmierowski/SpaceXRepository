package pl.andrzejkuczmierowski.internal;

import pl.andrzejkuczmierowski.repository.RocketRepositoryInterface;

import java.util.HashSet;
import java.util.Set;

class RocketRepository implements RocketRepositoryInterface {



    private final Set<Rocket> rockets;

    RocketRepository() {
        this.rockets = new HashSet<>();
    }
    public Set<Rocket> getRockets() {
        return rockets;
    }
    @Override
    public void addMission(Mission mission, Rocket rocket) {
        if (rocket.getMission() != null) {
            throw new AssertionError("Rocket already assigned to mission");
        }
        rocket.setStatus(RocketStatus.IN_SPACE);
        rocket.setMission(mission);
    }

    @Override
    public void changeStatus(Rocket rocket, RocketStatus newStatus) {
        Mission mission = rocket.getMission();
        if (mission != null && newStatus == RocketStatus.IN_REPAIR) {
            mission.setStatus(MissionStatus.PENDING);
        }
        rocket.setStatus(newStatus);
    }

    @Override
    public void addRocket(Rocket rocket) {
        rockets.add(rocket);
    }


}
