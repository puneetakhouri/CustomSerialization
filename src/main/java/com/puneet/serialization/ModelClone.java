package com.puneet.serialization;

import java.io.Serializable;
import java.util.Map;

public class ModelClone implements Serializable {

    static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private Long id;
    private Boolean isMale;
    private Gender gender;
    private Map<String, String> data;
    private CustomFile customFile;

    public ModelClone(String name, Integer age, Long id, Boolean isMale, Gender gender, Map<String, String> data, CustomFile customFile) {
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
}
