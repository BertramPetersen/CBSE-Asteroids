import dk.sdu.mmmi.cbse.missilesystem.MissileSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.missilesystem.MissileControlSystem;
import dk.sdu.mmmi.cbse.missilesystem.MissilePlugin;

module Missile {
    exports dk.sdu.mmmi.cbse.missilesystem;
    requires Common;
    requires CommonBullet;
    provides IGamePluginService with MissilePlugin;
    provides MissileSPI with MissileControlSystem;
    provides IEntityProcessingService with MissileControlSystem;
}