package pl.andrzejkuczmierowski.rocket;

import pl.andrzejkuczmierowski.mission.Mission;

import java.util.Objects;

public class Rocket {
    private final String name;
    private RocketStatus status;
    private Mission mission; // package-private mutation via RocketService

    Rocket(String name) {
        this.name = name;
        this.status = RocketStatus.ON_GROUND;
        this.mission = null;
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
