package middlewareEjemplo.nodes.Area1;



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
public class A1Process2 extends Activity {

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
    public void receive(int nodeID, byte[] data) {
        try {
            LongSpike spike = new LongSpike(data);
            String message = (String) spike.getIntensity();
            System.out.println(message);

        } catch (Exception ex) {
            Logger.getLogger(A1Process2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

     /**
     * ************************************************************************
     * METODOS
     * ************************************************************************
     */

     public void send(){
     	/*String info="mensaje";
     	/*Lo que se va a enviar en el spike debe ser serializable o un objeto simple como un string o entero*/
     	/*LongSpike sendSpike1 = new LongSpike(Modalities.VISUAL, new Location(0), info, 0);*/
     }
     

}
