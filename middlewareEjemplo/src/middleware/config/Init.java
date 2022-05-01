package middleware.config;

import cFramework.nodes.service.Igniter;
import generator.graph.MGraph;
import java.io.File;
import utils.SimpleLogger;
import middleware.nodes.Area1.Area1;
import middleware.nodes.Area2.Area2;
import middleware.nodes.Area3.Area3;
import utils.FileUtils;
//@import




public class Init extends Igniter {

    private boolean DEBUG = true;
    private byte ENTITY_ID = 33;

    public Init() {
        String[] areaNames = {
		Area1.class.getName(),
		Area2.class.getName(),
		Area3.class.getName(),
		//@addNodes
        };

        SimpleLogger.setDebug(DEBUG);

        configuration.setLocal(true);
        configuration.setDebug(!DEBUG);
        configuration.setTCP();
        configuration.setEntityID(ENTITY_ID);
        setAreas(areaNames);
        run();
        MGraph.generateGraphs(FileUtils.readFile(new File("route.txt")).trim());
    }

    public static void main(String[] args) {
        new Init();
    }
}
