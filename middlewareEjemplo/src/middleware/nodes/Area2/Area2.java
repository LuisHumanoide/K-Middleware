package middleware.nodes.Area2;



import kmiddle2.nodes.areas.Area;
import middleware.config.AreaNames;
import utils.SimpleLogger;

/**
 *
 * 
 */
public class Area2 extends Area{
    public Area2() {
        this.ID = AreaNames.Area2;
        this.namer = AreaNames.class;
        addProcess(A2Process1.class);
	
	//@AddProcess
    }

    @Override
    public void init() {
        SimpleLogger.log(this,"BIG NODE Area2");
    }

    @Override
    public void receive(int nodeID, byte[] data) {
        send(AreaNames.A2Process1,data);
	
	//@SendProcess
    }
    
}
