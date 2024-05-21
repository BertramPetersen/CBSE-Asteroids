package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.services.ICollideable;

public class Asteroid extends Entity implements ICollideable {
    @Override
    public void onCollision() {
        System.out.println("Asteroid collided");
    }
}
