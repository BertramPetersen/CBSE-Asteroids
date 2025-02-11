package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {

        @Override
        public void process(GameData gameData, World world) {
            for (Entity asteroid : world.getEntities(Asteroid.class)) {
                double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
                double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
                asteroid.setX(asteroid.getX() + changeX * 0.5);
                asteroid.setY(asteroid.getY() + changeY * 0.5);
            }
        }
}
