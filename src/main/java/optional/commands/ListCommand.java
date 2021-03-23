package optional.commands;

import optional.catalog.Catalog;
import optional.items.Item;
import optional.items.ItemsList;

import java.io.Serializable;
import java.util.List;

public class ListCommand implements isExecutable {
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) {
        for(Item item : catalog.getItems()){
            System.out.println(item);
        }
    }
}
