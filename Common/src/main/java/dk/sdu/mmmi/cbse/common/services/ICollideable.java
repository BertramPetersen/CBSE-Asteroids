package dk.sdu.mmmi.cbse.common.services;

public interface ICollideable {
    /**
     * This event handler is used to allow the entity to react to a collision event.
     * An example of this could be to start a collision animation.
     */
    void onCollision();
}
