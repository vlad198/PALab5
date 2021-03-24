package bonus.catalog;

import bonus.items.Item;
import lombok.Data;

import java.io.Serializable;
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

    public void add(Item item) {
        items.add(item);
    }
}