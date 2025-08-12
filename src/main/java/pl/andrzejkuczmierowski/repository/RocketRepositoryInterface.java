package pl.andrzejkuczmierowski.repository;

import pl.andrzejkuczmierowski.internal.Mission;
import pl.andrzejkuczmierowski.internal.Rocket;
import pl.andrzejkuczmierowski.internal.RocketStatus;

public interface RocketRepositoryInterface {

    void addMission(Mission mission, Rocket rocket);
    void changeStatus(Rocket rocket, RocketStatus newStatus);
    void addRocket(Rocket rocket);
}

