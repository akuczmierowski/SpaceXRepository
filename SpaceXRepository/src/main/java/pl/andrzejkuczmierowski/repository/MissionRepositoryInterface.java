package pl.andrzejkuczmierowski.repository;

import pl.andrzejkuczmierowski.exception.AssignmentException;
import pl.andrzejkuczmierowski.internal.Mission;
import pl.andrzejkuczmierowski.internal.MissionStatus;
import pl.andrzejkuczmierowski.internal.Rocket;

import java.util.Set;

public interface MissionRepositoryInterface {
    void addMission(Mission mission);

    void removeMission(Mission mission);

    void removeRocket(Mission mission, Rocket rocket);

    void addRocket(Mission mission, Rocket rocket) throws AssignmentException;

    Set<Mission> getMissions();

    void changeStatus(Mission mission, MissionStatus newStatus);

}
