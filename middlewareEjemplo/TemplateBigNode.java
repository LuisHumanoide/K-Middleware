@package

import kmiddle2.nodes.areas.Area;
import middlewareEjemplo.config.AreaNames;
import utils.SimpleLogger;

/**
 *
 * 
 */
public class @Name extends Area{
    public @Name() {
        this.ID = AreaNames.@Name;
        this.namer = AreaNames.class;
        @AddProcess
    }

    @Override
    public void init() {
        SimpleLogger.log(this,"BIG NODE @Name");
    }

    @Override
    public void receive(int nodeID, byte[] data) {
        @SendProcess
    }
    
}