package middlewareEjemplo.nodes.Funcion.smallNodes;



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
public class F3 extends Activity {

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


    public F3() {
        this.ID = AreaNames.F3;
        this.namer = AreaNames.class;
    }


    @Override
    public void init() {
        SimpleLogger.log(this, "SMALL NODE F3");
    }

    @Override
    public void receive(int nodeID, byte[] data) {
        try {
            LongSpike spike = new LongSpike(data);

        } catch (Exception ex) {
            Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

     /**
     * ************************************************************************
     * METODOS
     * ************************************************************************
     */
     

}
