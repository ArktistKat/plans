/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plants_simulation;
/**
 *
 * @author Vir_ArktistKat
 */
public class Deltafa {
    private String name;
    private int water;
    private boolean alive;
    
    public Deltafa(String name, int water) {
        this.name=name;
        this.water=water;
        this.alive=true;
    }
    
    public static Deltafa makeDeltafa(String name, int water) {
        return new Deltafa(name,water);
    }
    
    public boolean getAlive() {
        return this.alive;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getWater() {
        return this.water;
    }
    
    public void changeWater(int water) {
        this.water=this.water+water;
    }
    
    public void changeStatus(boolean alive) {
        this.alive=alive;
    }
    
    public int alphaRadaition(int radiation) {
        changeWater(-3);
        if(getWater()<1) {
            changeStatus(false);
            return radiation;
        }
        if(getWater()<5) {
            return radiation+4;
        }
        else if(getWater()<10 && getWater()>4) {
            return radiation+1;
        }
        else {
            return radiation;
        }
    }
    
    public int deltaRadaition(int radiation) {
        changeWater(4);
        if(getWater()<5) {
            return radiation+4;
        }
        else if(getWater()<10 && getWater()>4) {
            return radiation+1;
        }
        else {
            return radiation;
        }
    }
    
    public int noRadaition(int radiation) {
        changeWater(-1);
        if(getWater()<1) {
            changeStatus(false);
            return radiation;
        }
        if(getWater()<5) {
            return radiation+4;
        }
        else if(getWater()<10 && getWater()>4) {
            return radiation+1;
        }
        else {
            return radiation;
        }
    }
}