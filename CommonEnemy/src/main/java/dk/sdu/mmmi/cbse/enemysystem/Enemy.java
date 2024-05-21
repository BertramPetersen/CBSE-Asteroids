package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.services.ICollideable;

public class Enemy extends Entity implements ICollideable {
    @Override
    public void onCollision() {
        System.out.println("Enemy collided");
    }
}
