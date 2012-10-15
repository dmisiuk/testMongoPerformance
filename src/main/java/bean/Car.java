package bean;

import com.mongodb.ReflectionDBObject;

import java.io.Serializable;

/**
 * User: dzmitry.misiuk
 * Date: 10/15/12
 * Time: 11:01 AM
 */
public class Car extends ReflectionDBObject implements Serializable {

   private int num;
   private int weight;
   private String name;
   private String[] arguments;

    public Car(int num) {
        this.num = num;
    }

    public Car(int num, int weight, String name, String[] arguments) {
        this.num = num;
        this.weight = weight;
        this.name = name;
        this.arguments = arguments;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }
}