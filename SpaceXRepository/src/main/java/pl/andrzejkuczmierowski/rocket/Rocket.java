package pl.andrzejkuczmierowski.rocket;

import lombok.Getter;
import pl.andrzejkuczmierowski.mission.Mission;

import java.util.Objects;

public class Rocket {
    private final String name;

    void setStatus(RocketStatus status) {
        this.status = status;
    }

    @Getter
    private RocketStatus status;
    @Getter
    private Mission mission; // package-private mutation via RocketService

    Rocket(String name) {
        this.name = name;
        this.status = RocketStatus.ON_GROUND;
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
