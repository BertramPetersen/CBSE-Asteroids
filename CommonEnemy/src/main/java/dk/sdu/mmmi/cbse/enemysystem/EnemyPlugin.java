package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemySpaceShip(gameData);
        world.addEntity(enemy);
        enemy = createEnemySpaceShip(gameData);
        world.addEntity(enemy);
        enemy = createEnemySpaceShip(gameData);
        world.addEntity(enemy);
        enemy = createEnemySpaceShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemySpaceShip(GameData gameData) {
        Entity enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemyShip.setX( Math.random() * gameData.getDisplayWidth() );
        enemyShip.setY( Math.random() * gameData.getDisplayHeight() );
        enemyShip.setRadius(6);
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}
