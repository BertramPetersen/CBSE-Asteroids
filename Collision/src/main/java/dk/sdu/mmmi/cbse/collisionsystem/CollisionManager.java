package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.ICollideable;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.List;

public class CollisionManager implements IPostEntityProcessingService {

        @Override
        public void process(GameData gameData, World world) {
            // To reduce the number of entities to check for collision, we can filter out the entities that are not ICollideable
            List<Entity> entities = world.getEntities().stream().filter(e -> e instanceof ICollideable).toList();

            for (Entity e1 : entities) {
                for (Entity e2 : entities) {
                    if (e1.getID().equals(e2.getID())) {
                        continue;
                    }
                    if (checkCollision(e1, e2)) {
                        ((ICollideable) e1).onCollision();
                        ((ICollideable) e2).onCollision();
                        world.removeEntity(e1);
                        world.removeEntity(e2);
                    }
                }
            }
        }

        public boolean checkCollision(Entity e1, Entity e2) {
            double dx = e1.getX() - e2.getX();
            double dy = e1.getY() - e2.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            return distance < e1.getRadius() + e2.getRadius();
        }
}
