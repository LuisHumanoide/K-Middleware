package middleware.nodes.Area1;



import kmiddle2.nodes.areas.Area;
import middleware.config.AreaNames;
import utils.SimpleLogger;

/**
 *
 * 
 */
public class Area1 extends Area{
    public Area1() {
        this.ID = AreaNames.Area1;
        this.namer = AreaNames.class;
        addProcess(A1Process1.class);
	addProcess(A1Process2.class);		
	//@AddProcess
    }

    @Override
    public void init() {
        SimpleLogger.log(this,"BIG NODE Area1");
    }

    @Override
    public void receive(int nodeID, byte[] data) {
        send(AreaNames.A1Process1,data);
	send(AreaNames.A1Process2,data);		
	//@SendProcess
    }
    
}
