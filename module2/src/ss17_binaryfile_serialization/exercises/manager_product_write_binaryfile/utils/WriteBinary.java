package ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.utils;

import java.io.*;
import java.util.List;

public class WriteBinary {
    public static <E> void WriteFile(String path, List<E> objectlist) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
       try{
        objectOutputStream.writeObject(objectlist);
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
       objectOutputStream.close();
    }

}
