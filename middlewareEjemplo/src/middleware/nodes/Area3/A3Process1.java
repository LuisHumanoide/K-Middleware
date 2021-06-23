package middleware.nodes.Area3;



import spike.Location;
import cFramework.nodes.process.Process;
import java.util.logging.Level;
import java.util.logging.Logger;
import middleware.config.AreaNames;
import spike.Modalities;
import cFramework.communications.spikes.Spike;
import middleware.nodes.Area2.CustomClass;
import utils.SimpleLogger;
import utils.numSync;

/**
 *
 * 
 */
public class A3Process1 extends Process {


    public A3Process1() {
        this.ID = AreaNames.A3Process1;
        this.namer = AreaNames.class;
    }


    @Override
    public void init() {
        //SimpleLogger.log(this, "SMALL NODE A3Process1");
    }

    numSync sync = new numSync(0);

    @Override
    public void receive(long nodeID, byte[] data) {
        try {
            Spike spike = new Spike(data);
            if(spike.getModality()==Modalities.PYtD){
                CustomClass custom=(CustomClass)spike.getIntensity();
                System.out.println("customClass string valor: "+custom.getName());
                for(float value:custom.getArrayFloat()){
                    System.out.println("valor flotante : "+value);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(A3Process1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  


     public void send(){

     }
     

}
