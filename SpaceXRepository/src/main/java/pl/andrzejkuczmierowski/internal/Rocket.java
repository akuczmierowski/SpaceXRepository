package pl.andrzejkuczmierowski.internal;

import lombok.Getter;

import java.util.Objects;

public class Rocket {
    private final String name;

    @Getter
    private RocketStatus status;
    @Getter
    private Mission mission;

    Rocket(String name) {
        this.name = name;
        this.status = RocketStatus.ON_GROUND;
    }
    void setStatus(RocketStatus status) {
        this.status = status;
    }
    void setMission(Mission mission) {
        this.mission = mission;
    }
    //Presume that only name must be unique
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return Objects.equals(name, rocket.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
