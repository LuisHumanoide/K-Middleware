package middlewareEjemplo.nodes.Funcion.smallNodes;

import java.io.IOException;
import spike.Location;
import kmiddle2.nodes.activities.Activity;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewareEjemplo.config.AreaNames;
import spike.Modalities;
import utils.LongSpike;
import utils.SimpleLogger;

/**
 *
 *
 */
public class F1 extends Activity {

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
    public F1() {
        this.ID = AreaNames.F1;
        this.namer = AreaNames.class;
    }

    @Override
    public void init() {
        SimpleLogger.log(this, "SMALL NODE F1");
        System.out.println("Hola");
        send();
    }

    @Override
    public void receive(int nodeID, byte[] data) {
        try {
            LongSpike spike = new LongSpike(data);
            //spike=new LongSpike()

        } catch (Exception ex) {
            Logger.getLogger(F1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ************************************************************************
     * METODOS
     * ************************************************************************
     */
    public void send() {
        String info = "mensaje";
        /*Lo que se va a enviar en el spike debe ser serializable o un objeto simple como un string o entero*/
        for (int i = 0; i < 4; i++) {
            LongSpike sendSpike1 = new LongSpike(Modalities.VISUAL, new Location(i), info+i, 0);
            try {
                send(AreaNames.F2, sendSpike1.getByteArray());
            } catch (IOException ex) {
                Logger.getLogger(F1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
