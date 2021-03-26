package optional.catalog;

import optional.items.Item;
import lombok.Data;
import org.apache.tika.sax.Link;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public @Data
class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new LinkedList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
        this.items = new LinkedList<>();
    }

    /**
     * This function adds a new item in the current catalog
     * @param item the item to be added
     */
    public void add(Item item) {
        items.add(item);
    }
}