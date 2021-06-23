package middleware.nodes.Area1;

import cFramework.communications.spikes.Spike;
import spike.Location;
import cFramework.nodes.process.Process;
import java.util.logging.Level;
import java.util.logging.Logger;
import middleware.config.AreaNames;
import spike.Modalities;
import utils.SimpleLogger;
import utils.numSync;

/**
 *
 *
 */
public class A1Process2 extends Process {

    /**
     * *************************************************************************
     * CONSTANTES
     * *************************************************************************
     */
    /**
     * *************************************************************************
     * CONSTRUCTOR Y METODOS PARA RECIBIR
     * *************************************************************************
     */
    public A1Process2() {
        this.ID = AreaNames.A1Process2;
        this.namer = AreaNames.class;
    }

    @Override
    public void init() {
        SimpleLogger.log(this, "SMALL NODE A1Process2");
    }

    numSync sync = new numSync(0);

    @Override
    public void receive(long nodeID, byte[] data) {
        try {
            Spike spike = new Spike(data);
            if (spike.getModality() == Modalities.VISUAL) {
                String message = (String) spike.getIntensity();
                System.out.println("Spike from A1Process1: " + message);
                
                int value=9;
                Spike sendSpike=new Spike(Modalities.MEMORY,new Location(1),value,0);
                send(AreaNames.A2Process1, sendSpike.getByteArray());
            }

        } catch (Exception ex) {
            Logger.getLogger(A1Process2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ************************************************************************
     * METODOS
     * ************************************************************************
     */
    public void send() {
        /*String info="mensaje";
     	/*Lo que se va a enviar en el spike debe ser serializable o un objeto simple como un string o entero*/
 /*LongSpike sendSpike1 = new LongSpike(Modalities.VISUAL, new Location(0), info, 0);*/
    }

}
