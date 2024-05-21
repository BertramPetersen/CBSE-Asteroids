import dk.sdu.mmmi.cbse.collisionsystem.CollisionManager;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;


module Collision {
    requires Common;
    provides IPostEntityProcessingService with CollisionManager;
}