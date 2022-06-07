@package

import spike.Location;
import cFramework.nodes.process.Process;
import java.util.logging.Level;
import java.util.logging.Logger;
import @route.config.AreaNames;
import spike.Modalities;
import cFramework.communications.spikes.Spike;
import utils.SimpleLogger;
import utils.numSync;

/**
 *
 * 
 */
public class @Process extends Process {


    public @Process() {
        this.ID = AreaNames.@Process;
        this.namer = AreaNames.class;
    }


    @Override
    public void init() {

    }

    numSync sync = new numSync(0);

    @Override
    public void receive(long nodeID, byte[] data) {
        try {
            Spike spike = new Spike(data);

        } catch (Exception ex) {
            Logger.getLogger(@Process.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  


     public void send(){

     }
     

}