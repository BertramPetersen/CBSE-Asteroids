package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        world.addEntity(createAsteroid(gameData));
    }

    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Asteroid();
        asteroid.setRotation(Math.random() * 360);
        asteroid.setPolygonCoordinates(-8, -8, 8, -8, 8, 8, -8, 8);
        asteroid.setX(Math.random() * gameData.getDisplayWidth());
        asteroid.setY(Math.random() * gameData.getDisplayHeight());
        asteroid.setRadius(10);
        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
