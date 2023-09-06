package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssetManager {
    private final List<Object> items;
    public AssetManager(){
        this.items = new ArrayList<>();
    }
    public void add(Object item){
        switch (item){
            case Hotel hotel ->{items.add(hotel);}
            case Apartment apartment ->{items.add(apartment);}
            default -> throw new IllegalStateException("Unexpected value: " + item);
        }
    }
    public double profitPerNight() {
       return items.stream()
               .mapToDouble(item ->
                       {
                           if (item instanceof Hotel hotel) {
                               return hotel.price();
                           } else if (item instanceof Apartment apartment) {
                               return apartment.price();
                           }
                           return 0;
                       })
               .sum();

    }

   public List<Object> lowestEfficiency(double efficacite){
        return items.stream()
                .filter(item-> {
                    if (item instanceof Hotel hotel) {
                        return hotel.efficiency <= efficacite;
                    }else if (item instanceof Apartment apartment){
                         return apartment.efficiency <= efficacite;
                    }
                    return false;
                })
                .collect(Collectors.toList());

   }

   public String toString(){
        return items.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public void remove(double efficacite){

        items.removeIf(item-> {
            if (item instanceof Hotel hotel )
                return hotel.efficiency <= efficacite;
            else if (item instanceof Apartment apartment) {
                return apartment.efficiency<= efficacite;
            }
            return false;
        });

    }
}
