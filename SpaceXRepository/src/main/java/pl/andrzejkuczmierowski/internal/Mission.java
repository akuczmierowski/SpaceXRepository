package pl.andrzejkuczmierowski.internal;

import lombok.Getter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Mission {
    private final String name;
    private final Set<Rocket> rockets;

    void setStatus(MissionStatus status) {
        this.status = status;
    }

    @Getter
    private MissionStatus status;

    Mission(String name) {
        this.name = name;
        this.rockets = new LinkedHashSet<>();
        this.status = MissionStatus.SCHEDULED;
    }

    Set<Rocket> getRockets() {
        return Collections.unmodifiableSet(rockets);
    }

    void addRocket(Rocket rocket) {
        rockets.add(rocket);
    }

    void removeRocket(Rocket rocket) {
        rockets.remove(rocket);
    }

    void removeAllRockets() {
        rockets.clear();
    }

    void addAll(Set<Rocket> rockets) {
        this.rockets.addAll(rockets);
    }

    //Presume that only name must be unique
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return Objects.equals(name, mission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" - ");
        sb.append(status.getStatus());
        sb.append(" - ");
        sb.append("Dragons: ");
        sb.append(rockets.size());
        sb.append('\n');
        if (rockets.size() > 0) {
            for (Rocket rocket : rockets) {
                sb.append('\n');
                sb.append(rocket.toString());
            }
        }
        sb.append("\n");

        return sb.toString();
    }
}
