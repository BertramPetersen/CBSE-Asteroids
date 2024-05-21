package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.ICollideable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

public class CollisionManagerTest {
    private CollisionManager collisionManager;
    private GameData gameData;
    private World world;
    private Entity entity1;
    private Entity entity2;

    @BeforeEach
    public void setup() {
        collisionManager = new CollisionManager();
        gameData = mock(GameData.class);
        world = mock(World.class);
        entity1 = mock(Entity.class, withSettings().extraInterfaces(ICollideable.class));
        entity2 = mock(Entity.class, withSettings().extraInterfaces(ICollideable.class));
    }

    @Test
    public void process_removesCollidingEntities() {
        when(entity1.getID()).thenReturn("1");
        when(entity2.getID()).thenReturn("2");
        when(entity1.getX()).thenReturn(0.0);
        when(entity1.getY()).thenReturn(0.0);
        when(entity2.getX()).thenReturn(0.0);
        when(entity2.getY()).thenReturn(0.0);
        when(entity1.getRadius()).thenReturn(5.0);
        when(entity2.getRadius()).thenReturn(5.0);
        when(world.getEntities()).thenReturn(Arrays.asList(entity1, entity2));

        collisionManager.process(gameData, world);

        verify(world, times(1)).removeEntity(entity1);
        verify(world, times(1)).removeEntity(entity2);
    }

    @Test
    public void process_doesNotRemoveNonCollidingEntities() {
        when(entity1.getID()).thenReturn("1");
        when(entity2.getID()).thenReturn("2");
        when(entity1.getX()).thenReturn(0.0);
        when(entity1.getY()).thenReturn(0.0);
        when(entity2.getX()).thenReturn(10.0);
        when(entity2.getY()).thenReturn(10.0);
        when(entity1.getRadius()).thenReturn(5.0);
        when(entity2.getRadius()).thenReturn(5.0);
        when(world.getEntities()).thenReturn(Arrays.asList(entity1, entity2));

        collisionManager.process(gameData, world);

        verify(world, times(0)).removeEntity(entity1);
        verify(world, times(0)).removeEntity(entity2);
    }

    @Test
    public void checkCollision_returnsTrueForCollidingEntities() {
        when(entity1.getX()).thenReturn(0.0);
        when(entity1.getY()).thenReturn(0.0);
        when(entity2.getX()).thenReturn(0.0);
        when(entity2.getY()).thenReturn(0.0);
        when(entity1.getRadius()).thenReturn(5.0);
        when(entity2.getRadius()).thenReturn(5.0);

        boolean result = collisionManager.checkCollision(entity1, entity2);

        assertTrue(result);
    }

    @Test
    public void checkCollision_returnsFalseForNonCollidingEntities() {
        when(entity1.getX()).thenReturn(0.0);
        when(entity1.getY()).thenReturn(0.0);
        when(entity2.getX()).thenReturn(10.0);
        when(entity2.getY()).thenReturn(10.0);
        when(entity1.getRadius()).thenReturn(5.0);
        when(entity2.getRadius()).thenReturn(5.0);

        boolean result = collisionManager.checkCollision(entity1, entity2);

        assertFalse(result);
    }
}



