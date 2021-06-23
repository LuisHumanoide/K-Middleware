@package

import cFramework.nodes.area.Area;
import @route.config.AreaNames;
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
    public void receive(long nodeID, byte[] data) {
        @SendProcess
    }
    
}