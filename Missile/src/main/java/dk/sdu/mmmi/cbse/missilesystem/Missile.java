package dk.sdu.mmmi.cbse.missilesystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;

public class Missile extends Bullet {

        public Missile(Entity shooter) {
            super(shooter);
            super.setPolygonCoordinates(0,0, -3,-2, -8,-2, -10, -4, -10, 4, -8, 2, -3, 2, 0,0);
        }

        @Override
        public void onCollision() {
            System.out.println("Missile collided");
        }
}
