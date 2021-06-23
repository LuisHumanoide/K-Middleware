package middleware.nodes.Area1;

import cFramework.communications.spikes.Spike;
import java.io.IOException;
import spike.Location;
import cFramework.nodes.process.Process;
import java.util.logging.Level;
import java.util.logging.Logger;
import middleware.config.AreaNames;
import spike.Modalities;
import utils.numSync;

/**
 *
 *
 */
public class A1Process1 extends Process {

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
    public void receive(long nodeID, byte[] data) {
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
        //Modalidad visual
        String info="mensaje";
        Spike sendSpike1 = new Spike(Modalities.VISUAL, new Location(0), info, 0);
        //Modalidad memoria
        int value=5;
        Spike sendSpike2=new Spike(Modalities.MEMORY,new Location(0),value,0);
        try {
            send(AreaNames.A1Process2, sendSpike1.getByteArray());
            send(AreaNames.A2Process1, sendSpike2.getByteArray());
        } catch (IOException ex) {
            Logger.getLogger(A1Process1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
