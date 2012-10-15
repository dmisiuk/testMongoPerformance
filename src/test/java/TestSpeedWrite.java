import bean.Car;
import bean.CarMorphia;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * User: dzmitry.misiuk
 * Date: 10/15/12
 * Time: 10:38 AM
 */
public class TestSpeedWrite {

    int testNumber = 100000;
    String dbName = "testspeed";
    WriteConcern type = WriteConcern.NORMAL;
    Mongo m;
    DB db;
    Datastore ds;
    Morphia morphia;

    @Before
    public void init() throws UnknownHostException {
        m =  new Mongo();
        m.setWriteConcern(type);
        db = m.getDB(dbName);
        morphia = new Morphia();
        ds = new Morphia().createDatastore(m,dbName);
        ds.setDefaultWriteConcern(type);
    }

    @Test
    public void createBasicDBObject(){
        System.out.println("Start basic... " );

        DBCollection coll = db.getCollection("basic");
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < testNumber;i++){
            BasicDBObject o = createBasicDBObject(i);
            coll.save(o);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("basic time: " + (endTime - startTime) + " ms");

    }


    @Test
    public void createReflectionDBObject(){
        System.out.println("Start reflection... " );
        DBCollection coll = db.getCollection("reflection");
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < testNumber;i++){
            DBObject o = createReflectionDBObject(i);
            coll.save(o);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("reflection time: " + (endTime - startTime) + " ms");

    }

    @Test
    public void createMorphiaObject(){
        System.out.println("Start morphia... " );
        morphia.map(CarMorphia.class);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < testNumber;i++){
            CarMorphia car = createMorphiaObject(i);
            ds.save(car);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Morphia time: " + (endTime - startTime) + " ms");

    }

    private CarMorphia createMorphiaObject(int i) {
        CarMorphia car = new CarMorphia(i);
        car.setName("Dzmitry");
        car.setWeight(100);
        car.setArguments(new String[]{"new", "old", "older"});
        return car;
    }

    private DBObject createReflectionDBObject(int i) {
         Car car = new Car(i);
        car.setName("Dzmitry");
        car.setWeight(100);
        car.setArguments(new String[]{"new", "old", "older"});
        return car;
    }

    private BasicDBObject createBasicDBObject(int i) {
        BasicDBObject bo = new BasicDBObject();
        bo.put("name", "Dzmitry");
        bo.put("weight", 100);
        bo.put("num", i);
        String arguments[] =  {"new", "old", "older"};
        bo.put("arguments", arguments);
        return  bo;
    }



    @After
    public void dropDb(){
        db.dropDatabase();
    }
}