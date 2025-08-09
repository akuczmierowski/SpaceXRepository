package pl.andrzejkuczmierowski.internal;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RocketFactoryTest {

    @Test
    public void createRocket(){
        RocketFactory rocketFactory=new RocketFactory();
        Rocket rocket = rocketFactory.createRocket("Sputnik");
        assertEquals( RocketStatus.ON_GROUND,rocket.getStatus());
        assertTrue(Objects.isNull(rocket.getMission()));
    }
}
