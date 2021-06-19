package middlewareEjemplo.config;

import kmiddle2.nodes.service.Igniter;
import utils.SimpleLogger;
import middlewareEjemplo.nodes.Funcion.Area1;
//@import




public class Init extends Igniter {

    private boolean DEBUG = true;
    private byte ENTITY_ID = 33;

    public Init() {
        String[] areaNames = {
		Area1.class.getName(),
		//@addNodes
        };

        SimpleLogger.setDebug(DEBUG);

        configuration.setLocal(true);
        configuration.setDebug(!DEBUG);
        configuration.setTCP();
        configuration.setEntityID(ENTITY_ID);
        setAreas(areaNames);
        run();
    }

    public static void main(String[] args) {
        new Init();
    }
}
