package middleware.nodes.Area3;



import cFramework.nodes.area.Area;
import middleware.config.AreaNames;
import utils.SimpleLogger;

/**
 *
 * 
 */
public class Area3 extends Area{
    public Area3() {
        this.ID = AreaNames.Area3;
        this.namer = AreaNames.class;
        addProcess(A3Process1.class);	
	//@AddProcess
    }

    @Override
    public void init() {
        SimpleLogger.log(this,"BIG NODE Area3");
    }

    @Override
    public void receive(long nodeID, byte[] data) {
        send(AreaNames.A3Process1,data);	
	//@SendProcess
    }
    
}
