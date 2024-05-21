import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.ISplitPackages;

module Asteroids {
    requires Common;
    requires java.net.http;
    provides IGamePluginService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidControlSystem;
    provides ISplitPackages with dk.sdu.mmmi.cbse.asteroidsystem.splitpackage;
}

