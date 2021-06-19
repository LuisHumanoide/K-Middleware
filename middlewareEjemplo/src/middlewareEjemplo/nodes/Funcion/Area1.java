package middlewareEjemplo.nodes.Funcion;



import middlewareEjemplo.nodes.Funcion.smallNodes.F3;
import middlewareEjemplo.nodes.Funcion.smallNodes.F2;
import middlewareEjemplo.nodes.Funcion.smallNodes.F1;
import kmiddle2.nodes.areas.Area;
import middlewareEjemplo.config.AreaNames;
import utils.SimpleLogger;

/**
 *
 * 
 */
public class Area1 extends Area{
    public Area1() {
        this.ID = AreaNames.Area1;
        this.namer = AreaNames.class;
        addProcess(F1.class);
	addProcess(F2.class);
	addProcess(F3.class);
	
	//@AddProcess
    }

    @Override
    public void init() {
        SimpleLogger.log(this,"BIG NODE Area1");
    }

    @Override
    public void receive(int nodeID, byte[] data) {
        send(AreaNames.F1,data);
	send(AreaNames.F2,data);
	send(AreaNames.F3,data);
	
	//@SendProcess
    }
    
}
