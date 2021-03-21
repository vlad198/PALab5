package compulsory.catalog;

import compulsory.Main;
import compulsory.items.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public @Data
@AllArgsConstructor
class Catalog implements Serializable {
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());

    private String name;
    private String path;
    private List<Item> items = new LinkedList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Catalog(Catalog readObject) {
        this.name = readObject.getName();
        this.path = readObject.getPath();
        this.items = new ArrayList<>(readObject.getItems());
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id))
                return item;
        }
        return null;
    }

    public void list() {
        for (Item item : items)
            logger.info("item: " + item);
    }

    public void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(getPath() + "\\" + name + ".ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(this);

        fileOutputStream.close();
        out.close();
    }

    public void load(String catalogName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir").toString() + "/catalogues/" + catalogName + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Catalog copy = (Catalog) in.readObject();

        this.name = copy.getName();
        this.path = copy.getPath();
        this.items = copy.getItems();
    }

}
