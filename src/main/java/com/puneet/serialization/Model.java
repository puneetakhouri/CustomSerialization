package com.puneet.serialization;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Model implements Serializable {

    static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    //private String age;
    private Long id;
    private Boolean isMale;
    private Gender gender;
    private Map<String, String> data;
    private CustomFile customFile;

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class),
            new ObjectStreamField("age", Integer.class),
            new ObjectStreamField("id", Long.class),
            new ObjectStreamField("isMale", Boolean.class),
            new ObjectStreamField("gender", Gender.class),
            new ObjectStreamField("data", Map.class),
            new ObjectStreamField("customFile", CustomFile.class)
    };

    public Model(String name, Integer age, Long id, Boolean isMale, Gender gender, Map<String, String> data, CustomFile customFile) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.isMale = isMale;
        this.gender = gender;
        this.data = data;
        this.customFile = customFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public CustomFile getCustomFile() {
        return customFile;
    }

    public void setCustomFile(CustomFile customFile) {
        this.customFile = customFile;
    }

    @Override
    public String toString() {

        final StringBuilder dataBuilder = new StringBuilder();
        for(Map.Entry<String, String> entry : data.entrySet()) {
            dataBuilder.append(String.format("%s = %s", entry.getKey(), entry.getValue()));
        }
        return "Model{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", isMale=" + isMale +
                ", gender=" + gender.getValue() +
                ", data=" + data.toString() +
                ", customFile=" + customFile.toString() +
                '}';
    }

    /*private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("Entered readObject");
        this.name = objectInputStream.readUTF();
        this.age = objectInputStream.readInt();
        this.id = objectInputStream.readLong();
        this.gender = (Gender) objectInputStream.readObject();
        this.data = (Map<String, String>) objectInputStream.readObject();
        this.customFile = (CustomFile) objectInputStream.readObject();
        System.out.println("Exiting readObject");
    }*/

    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("Entered readObject");
        ObjectInputStream.GetField getField = objectInputStream.readFields();
        this.name = (String) getField.get("name", null);
        try{
            this.age = (Integer) getField.get("age", null);
        }catch(ClassCastException e) {
            e.printStackTrace();
            System.out.println("Error in casting age");
            this.age = Integer.parseInt((String) getField.get("age", null));
            //this.age = null;
        }
        this.id = (Long) getField.get("id", null);
        this.isMale = (Boolean) getField.get("isMale", null);
        this.gender = (Gender) getField.get("gender", null);
        this.data = (Map<String, String>) getField.get("data", null);
        this.customFile = (CustomFile) getField.get("customFile", null);
        System.out.println("Exiting readObject");
    }

    /*private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        System.out.println("Entered writeObject");
        objectOutputStream.writeUTF(this.name);
        //objectOutputStream.writeUTF(this.age);
        objectOutputStream.writeInt(this.age);
        objectOutputStream.writeLong(this.id);
        objectOutputStream.writeObject(this.gender);
        objectOutputStream.writeObject(this.data);
        objectOutputStream.writeObject(this.customFile);
        objectOutputStream.defaultWriteObject();
        System.out.println("Exiting writeObject");
    }

 /*   private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putField = objectOutputStream.putFields();
        putField.put("name", name);
        putField.put("age", age);
        putField.put("id", id);
        putField.put("gender", gender);
        putField.put("data", data);
        putField.put("customFile", customFile);
    }*/
}
