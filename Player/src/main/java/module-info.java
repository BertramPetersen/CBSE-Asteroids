
import dk.sdu.mmmi.cbse.common.services.ICollideable;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.ISplitPackages;
import dk.sdu.mmmi.cbse.missilesystem.MissileSPI;

module Player {
    requires Common;
    requires CommonBullet;
    requires Missile;
    uses MissileSPI;
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;
    provides ISplitPackages with dk.sdu.mmmi.cbse.playersystem.splitpackage;
    provides ICollideable with dk.sdu.mmmi.cbse.playersystem.Player;
    
}
