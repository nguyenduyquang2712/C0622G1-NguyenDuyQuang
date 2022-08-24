package ss17_binaryfile_serialization.exercises.manager_product_write_binaryfile.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadBinary {
    public static <E> List<E> ReadFile(String path, List<E> objectlist) throws IOException, ClassNotFoundException {
       try{ FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectlist = (List<E>) objectInputStream.readObject();
        objectInputStream.close();
       }
       catch (Exception e){
           System.out.println("file rỗng");
       }
        return objectlist;
    }

}
