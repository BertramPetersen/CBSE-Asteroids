package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleReference;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

import dk.sdu.mmmi.cbse.common.services.ISplitPackages;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();
    private final Pane gameWindow = new Pane();
    private static ModuleLayer layer;

    public static void main(String[] args) {
        Path pluginsDir = Paths.get("plugins");

        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        // Find names of plugins in the plugins directory
        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());
        for (String plugin : plugins) {
            System.out.println("Found plugin: " + plugin);
        }


        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        // Create a module layer for plugins
        layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        // Demonstrate split package
        var layer1 = createLayer(args[0], "Asteroids");
        ServiceLoader.load(layer1, ISplitPackages.class).
                stream().map(ServiceLoader.Provider::get).
                forEach(splitPackage -> System.out.println(splitPackage.splitPackage()));
        var layer2 = createLayer(args[0], "Player");
        ServiceLoader.load(layer2, ISplitPackages.class).
                stream().map(ServiceLoader.Provider::get).
                forEach(splitPackage -> System.out.println(splitPackage.splitPackage()));


        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GameConfiguration.class);

        // Print names of all beans
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Game game = context.getBean(Game.class);
        game.start(window);
        game.render();
    }


    private static ModuleLayer createLayer(String from, String module) {
        System.out.println("Layer created");

        var finder = ModuleFinder.of(Paths.get(from));
        var parent = ModuleLayer.boot();
        var cf = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of(module));
        return parent.defineModulesWithOneLoader(cf, ClassLoader.getSystemClassLoader());
    }
}
