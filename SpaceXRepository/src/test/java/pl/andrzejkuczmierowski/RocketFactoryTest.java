package pl.andrzejkuczmierowski;

import org.junit.jupiter.api.Test;
import pl.andrzejkuczmierowski.rocket.Rocket;
import pl.andrzejkuczmierowski.rocket.RocketFactory;
import pl.andrzejkuczmierowski.rocket.RocketStatus;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RocketFactoryTest {

    @Test
    public void createRocket(){
        RocketFactory rocketFactory=new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Sputnik");
        assertEquals(rocket.getStatus(), RocketStatus.ON_GROUND);
        assertTrue(Objects.isNull(rocket.getMission()));
    }
}
