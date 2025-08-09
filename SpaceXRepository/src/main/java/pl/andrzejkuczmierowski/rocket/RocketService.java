package pl.andrzejkuczmierowski.rocket;

public class RocketService {

    public void changeRocketStatus(Rocket rocket, RocketStatus newStatus) {
        rocket.setStatus(newStatus);
    }
}
