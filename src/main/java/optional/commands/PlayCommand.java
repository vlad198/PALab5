package optional.commands;

import optional.items.Item;
import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class PlayCommand implements isExecutable {

    private Item findByName(String name, List<Item> catalogItemList) {
        for (Item item : catalogItemList) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    }


    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException {
        Item item = findByName(args.get(0), catalog.getItems());

        if (item != null)
            item.play();

        System.out.println("play");
    }
}
