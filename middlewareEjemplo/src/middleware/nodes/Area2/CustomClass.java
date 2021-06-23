/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware.nodes.Area2;
import java.io.Serializable;
public class CustomClass implements Serializable{
    
    String name;
    float arrayFloat[];

    public CustomClass(String name, float[] arrayFloat) {
        this.name = name;
        this.arrayFloat = arrayFloat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float[] getArrayFloat() {
        return arrayFloat;
    }

    public void setArrayFloat(float[] arrayFloat) {
        this.arrayFloat = arrayFloat;
    }   
}
