package org.example;
 public class Hotel {
    public final int rooms;
    public double efficiency;
    public double price(){
        return 100 * rooms * efficiency;
    }
     public Hotel(int rooms, double efficiency){
        if (rooms < 0) throw new IllegalArgumentException("room must be > 0");
        this.rooms = rooms;
        if (efficiency<=0 || efficiency>= 1) throw new IllegalArgumentException("efficiency must be [0,1]");
        this.efficiency = efficiency;
    }

    public String toString(){
        return "hotel "+ rooms + " rooms " + efficiency;
    }
}
