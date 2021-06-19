package middlewareEjemplo.nodes.Funcion.smallNodes;

import spike.Location;
import kmiddle2.nodes.activities.Activity;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewareEjemplo.config.AreaNames;
import spike.Modalities;
import utils.LongSpike;
import utils.SimpleLogger;
import utils.numSync;

/**
 *
 *
 */
public class F2 extends Activity {

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
    public F2() {
        this.ID = AreaNames.F2;
        this.namer = AreaNames.class;
    }

    @Override
    public void init() {
        SimpleLogger.log(this, "SMALL NODE F2");
    }

    numSync sync = new numSync(4);

    @Override
    public void receive(int nodeID, byte[] data) {
        try {
            LongSpike spike = new LongSpike(data);
            if (spike.getModality() == Modalities.VISUAL) {
                Location l = (Location) spike.getLocation();
                int index = l.getValues()[0];
                String message = (String) spike.getIntensity();
                System.out.println("mensaje recibido " + message);
                sync.addReceived(index);
                if (sync.isComplete()) {
                    doAll();
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ************************************************************************
     * METODOS
     * ************************************************************************
     */
    public void doAll() {
        System.out.println("se hace proceso");
    }

}
