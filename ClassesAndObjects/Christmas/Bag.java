package ExamPrepChristmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public String getColor(){
        return color;
    }

    public int count(){
        return data.size();
    }

    public void add(Present present){
        if(count() + 1 > getCapacity()){
            return;
        }
        data.add(present);
    }
    public boolean remove(String name){
        for (Present datum : data) {
            if(datum.getName().equals(name)){
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public String heaviestPresent(){
        Present heaviest = this.data.get(0);
        for (Present datum : data) {
            if(datum.getWeight() > heaviest.getWeight()){
                heaviest = datum;
            }
        }
        return  heaviest.toString();
    }

    public Present getPresent(String name){
        for (Present datum : data) {
            if(datum.getName().equals(name)){
                return datum;
            }
        }
        return null;
    }
public String presentsToString(){
    StringBuilder sb = new StringBuilder();
        for (Present datum : data) {
        sb.append(datum.toString());
        sb.append("\n");

    }
        return sb.toString();
}
    public String report(){
        return String.format("%s bag contains:\n%s", this.color,presentsToString());

    }
}
