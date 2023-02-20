package kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }


    public boolean addChild(Child child){
        if(registry.size() + 1 <= capacity){
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName){
        Child childToRemove = registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);

        if(childToRemove != null){
            registry.remove(childToRemove);
            return true;
        }
        return false;
    }

    public int getChildrenCount(){
        return registry.size();
    }
    public Child getChild(String firstName){
        return this.registry.stream().filter(child -> child.getFirstName().equals(firstName))
                .findFirst().get();
    }


   /* public String registryReport(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Registered children in %s:%n",this.name));

       // List<Child> childCollection = registry.stream().sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
             //   .sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
               // .sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName())).collect(Collectors.toList());

        List<Child> childCollection = registry.stream().sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
                .sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()))
                .sorted((a, b) -> a.getLastName().compareTo(b.getLastName())).collect(Collectors.toList());

        for (Child child : childCollection) {
            builder.append(String.format("%s%n", child.toString()));
        }
        return builder.toString();
    }*/
   public String registryReport() {
       Collections.sort(registry, Comparator.comparing(Child::getAge)
               .thenComparing(Child::getFirstName)
               .thenComparing(Child::getLastName));

       StringBuilder builder = new StringBuilder();
       builder.append("Registered children in ").append(this.name).append(":").append(System.lineSeparator());

       for (Child child : this.registry) {
           builder.append("--").append(System.lineSeparator());
           builder.append(child).append(System.lineSeparator());
       }
       // return the report string
       return builder.toString();
   }
}
