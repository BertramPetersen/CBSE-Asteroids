package dk.sdu.mmmi.cbse.missilesystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class MissileControlSystem implements IEntityProcessingService, MissileSPI {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity missile : world.getEntities(Missile.class)) {
            double changeX = Math.cos(Math.toRadians(missile.getRotation()));
            double changeY = Math.sin(Math.toRadians(missile.getRotation()));
            missile.setX(missile.getX() + changeX * 6);
            missile.setY(missile.getY() + changeY * 6);
        }
    }
    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        Entity missile = new Missile();
        double centerY = shooter.getY() + (shooter.getHeight() / 2);
        double rotation = shooter.getRotation();
        // Calculate shot point from center of shooter and the rotation in degrees
        missile.setX(shooter.getX() + shooter.getWidth());
        missile.setY(centerY + (shooter.getHeight() / 2) * Math.sin(Math.toRadians(rotation)));
        missile.setRotation(shooter.getRotation());
        return missile;
    }
}
