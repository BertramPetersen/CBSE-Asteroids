package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.services.ICollideable;

/**
 *
 * @author corfixen
 */
public class Bullet extends Entity implements ICollideable {
    @Override
    public void onCollision() {
        return;
    }
}
