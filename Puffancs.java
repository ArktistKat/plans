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
public class Puffancs {
    private String name;
    private int water;
    private boolean alive;
    
    public Puffancs(String name, int water) {
        this.name=name;
        this.water=water;
        this.alive=true;
    }
    
    public static Puffancs makePuffancs(String name, int water) {
        return new Puffancs(name,water);
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
        changeWater(2);
        if(getWater()<10 && getWater()>0) {
            return radiation+(10-getWater());
        }
        else {
            changeStatus(false);
            return radiation;
        } 
    }
    
    public int deltaRadaition(int radiation) {
        changeWater(-2);
        if(getWater()<1) {
            changeStatus(false);
            return radiation;
        }
        return radiation+(10-getWater());
    }
    
    public int noRadaition(int radiation) {
        changeWater(-1);
        if(getWater()<1) {
            changeStatus(false);
            return radiation;
        }
        return radiation+(10-getWater());
    }
}
