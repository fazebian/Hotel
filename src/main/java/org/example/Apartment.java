package org.example;

import java.util.List;
import java.util.Objects;
 class Apartment {
    public int area;
    public List<String>persons;
    public double efficiency;

    public int price(){
        return 20 * persons.size();
    }
    public Apartment(int area , List<String>persons){
        if(area < 0) throw new IllegalArgumentException("Must be > 0");
        this.area = area;
        Objects.requireNonNull(persons, " minimum 1 person in da house");
        this.persons = List.copyOf(persons);
        this.efficiency = (persons.size() == 1) ? 0.5 : 1.0;
    }
    public String toString(){
        return "Apartment" + " "+area + " m2 with "+ String.join(",", persons) + " "+efficiency  ;
    }
}
