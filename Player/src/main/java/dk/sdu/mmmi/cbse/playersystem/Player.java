package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.services.ICollideable;

import java.security.Timestamp;

/**
 *
 * @author Emil
 */
public class Player extends Entity implements ICollideable {

    private long last_shot_time = 0;

    private boolean can_shoot = true;


    public void shoot(){
        if(can_shoot){
            // Current epoch time
            this.last_shot_time = System.currentTimeMillis();
            can_shoot = false;
        }
    }

    public boolean canShoot() {
        long current_time = System.currentTimeMillis();
        if(current_time - last_shot_time > 500){
            can_shoot = true;
        }
        return can_shoot;
    }

    @Override
    public void onCollision() {
        System.out.println("Player collided");
    }
}
