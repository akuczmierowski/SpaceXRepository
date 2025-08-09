package pl.andrzejkuczmierowski.internal;

import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Mission {
    private final String name;
    @Getter
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
}
