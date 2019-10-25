package com.puneet.serialization;

import java.beans.SimpleBeanInfo;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        performWrite(true);
        readModel(true);
    }

    private static void performWrite(boolean createSimple) {

        final Object model = createModel(createSimple);
        System.out.println("---model created = "+ model.toString());
        writeModel(model);
    }

    private static void readModel(boolean readSimple) {
        try(final FileInputStream fileInputStream = new FileInputStream(readSimple ? SimpleModel.class.getName() : Model.class.getName());
            final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            System.out.println("About to read model");
            if(!readSimple){
                final Model model = (Model) objectInputStream.readObject();
                if(model != null)
                    System.out.println("model read, value is "+ model.toString());
                else
                    System.out.println("model could not be read");
            }else{
                final SimpleModel model = (SimpleModel) objectInputStream.readObject();
                if(model != null)
                    System.out.println("model read, value is "+ model.toString());
                else
                    System.out.println("model could not be read");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeModel(final Object model) {
        try(final FileOutputStream fileOutputStream = new FileOutputStream(new File(model.getClass().getName()));
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(model);
            System.out.println("Wrote model successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object createModel(boolean createSimple) {
        if(!createSimple) {
            final Map<String, String> data = new HashMap<>();
            data.put("puneet", "akhouri");
            data.put("abc", "pqr");

            final CustomFile customFile = new CustomFile("value1", "value2");

            return new Model("modeltest", "31", 3L, true, Gender.MALE, data, customFile);
        }
        return new SimpleModel("puneet", 2);
        //return new SimpleModel("puneet");
        //return new SimpleModel(2);
    }
}
