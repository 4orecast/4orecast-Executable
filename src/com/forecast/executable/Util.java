package edu.wit.sheltonz.forecast;

import java.io.*;

/**
 * Created by Zachary on 4/3/2017.
 */
public class Util {

    public static void saveObjToFile(final File file, final Serializable obj) throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    public static <T> T readObjFromFile(final File file, Class<T> clazz) throws IOException, ClassNotFoundException {
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final T obj = (T) objectInputStream.readObject();
        return obj;
    }
}
