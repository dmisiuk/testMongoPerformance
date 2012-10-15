package bean;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;
import org.bson.types.ObjectId;

/**
 * User: dzmitry.misiuk
 * Date: 10/15/12
 * Time: 11:30 AM
 */
@Entity(value="cars")
public class CarMorphia {

    @Id
    private ObjectId id;

    @Property
    private int num;
    @Property
    private int weight;
    @Property
    private String name;
    @Property
    private String[] arguments;

    public CarMorphia(int num) {
        this.num = num;
    }

    public CarMorphia(int num, int weight, String name, String[] arguments) {
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}