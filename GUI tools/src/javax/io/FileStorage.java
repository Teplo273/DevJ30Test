package javax.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileStorage<E extends Serializable> implements Storage<E>{

    private final File file;

    public FileStorage(String filename) {
        this.file = new File(filename);
    }
    
    @Override
    public void save(E data) throws IOException {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(data);
        }
    }

    @Override
    public E load() throws IOException {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
            return (E) stream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e.getMessage());
        }
    }
    
    
    
}
