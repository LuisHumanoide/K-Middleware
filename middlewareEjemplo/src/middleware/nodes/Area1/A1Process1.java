package middleware.nodes.Area1;

import java.io.IOException;
import spike.Location;
import kmiddle2.nodes.activities.Activity;
import java.util.logging.Level;
import java.util.logging.Logger;
import middleware.config.AreaNames;
import spike.Modalities;
import spike.LongSpike;
import spike.Spike;
import utils.SimpleLogger;
import utils.numSync;

/**
 *
 *
 */
public class A1Process1 extends Activity {

    public A1Process1() {
        this.ID = AreaNames.A1Process1;
        this.namer = AreaNames.class;
    }

    @Override
    public void init() {
        send();       
    }

    numSync sync = new numSync(0);

    @Override
    public void receive(int nodeID, byte[] data) {
        try {
            

        } catch (Exception ex) {
            Logger.getLogger(A1Process1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ************************************************************************
     * METODOS
     * ************************************************************************
     */
    public void send() {
        String info="mensaje";
        int n=5;
     	/*Lo que se va a enviar en el spike debe ser serializable o un objeto simple como un string o entero*/
        Spike sendSpike1 = new Spike(Modalities.VISUAL, new Location(0), info, 0);
        Spike sendSpike2 = new Spike(Modalities.MEMORY, new Location(0), n, 0);
        try {
            send(AreaNames.A1Process2, sendSpike1.getByteArray());
            send(AreaNames.A2Process1, sendSpike2.getByteArray());
        } catch (IOException ex) {
            Logger.getLogger(A1Process1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
