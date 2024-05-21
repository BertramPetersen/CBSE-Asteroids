package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.services.ICollideable;

public class Bullet extends Entity implements ICollideable {
    private Entity shooter;

    public Bullet(Entity shooter) {
        this.shooter = shooter;
    }
    @Override
    public void onCollision() {
        return;
    }
}
