package pl.andrzejkuczmierowski.rocket;

public class RocketFactory {
    public Rocket createRocket(String name){
        return new Rocket(name);
    }
}
