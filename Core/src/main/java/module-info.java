module Core {
    requires Common;
    requires CommonBullet;    
    requires javafx.graphics;
    requires spring.context;
    requires java.net.http;
    opens dk.sdu.mmmi.cbse.main to javafx.graphics, spring.core, spring.beans, spring.context, spring.aop, spring.expression;
    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.ISplitPackages;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
}


