package com.puneet.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class SimpleModel implements Serializable {

    private static final long serialVersionUID = 397031299393904866L;

    private String name;
    //private int age;
    private long id;

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class),
            //new ObjectStreamField("id", long.class)
    };


    public SimpleModel(String name) {
        this.name = name;
    }

    public SimpleModel(long id) {
        this.id = id;
    }

    public SimpleModel(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SimpleModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

   /* private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //this.name = in.readUTF();
        //in.defaultReadObject();
        //this.id = in.readLong();
        ObjectInputStream.GetField getField = in.readFields();
        this.name = (String) getField.get("name", null);
        this.id = getField.get("id", (long) 0);
    }*/
}
