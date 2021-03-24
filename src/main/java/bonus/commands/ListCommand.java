package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.Item;
import bonus.items.ItemsList;

import java.util.List;

public class ListCommand implements isExecutable {
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) {
        for(Item item : catalog.getItems()){
            System.out.println(item);
        }
    }
}
