package middleware.nodes.Area2;

import cFramework.communications.spikes.Spike;
import spike.Location;
import cFramework.nodes.process.Process;
import java.io.IOException;
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
public class A2Process1 extends Process {

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
    public A2Process1() {
        this.ID = AreaNames.A2Process1;
        this.namer = AreaNames.class;
    }

    @Override
    public void init() {
        //SimpleLogger.log(this, "SMALL NODE A2Process1");
    }

    

    int n1 = 0;
    int n2 = 0;
    numSync sync = new numSync(2);
    @Override
    public void receive(long nodeID, byte[] data) {
        try {
            Spike spike = new Spike(data);
            if (spike.getModality() == Modalities.MEMORY) {
                System.out.println(this.namer.toString() + " value " + (int) spike.getIntensity());
                Location l = (Location) spike.getLocation();
                if (l.getValues()[0] == 0) {
                    n1 = (int) spike.getIntensity();
                }
                if (l.getValues()[0] == 1) {
                    n2 = (int) spike.getIntensity();
                }
                sync.addReceived(l.getValues()[0]);
                if (sync.isComplete()) {
                    System.out.println("La suma es " + (n1 + n2));
                    send();
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(A2Process1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ************************************************************************
     * METODOS
     * ************************************************************************
     */
    public void send() {
        float floatArray[]={0.1f,0.2f,0.5f,0.8f};
        String string="DLPFC";
        CustomClass custom=new CustomClass(string,floatArray);
        
        Spike spike=new Spike(Modalities.PYtD,0,custom,0);

        try {
            send(AreaNames.A3Process1, spike.getByteArray());
        } catch (IOException ex) {
            Logger.getLogger(A2Process1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
