package pl.andrzejkuczmierowski.internal;

public class RocketFactory {
    public Rocket createRocket(String name){
        return new Rocket(name);
    }
}
