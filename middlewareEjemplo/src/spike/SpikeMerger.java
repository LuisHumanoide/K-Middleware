/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spike;

/**
 *
 * @author Laptop
 */
import java.util.HashMap;

public interface SpikeMerger
{
    byte[] merge(final HashMap<Long, byte[]> p0);
}
