package bonus.commands;

import bonus.Main;
import bonus.catalog.Catalog;
import bonus.items.Item;
import bonus.items.ItemsList;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes the play command in our shell.
 */
public class PlayCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(PlayCommand.class.getName());

    /**
     * This function searches an item in a list of items
     * @param name the search criteria: search by the name of the item
     * @param catalogItemList the list of items in which we want to search the item with the given name
     * @return the item if it finds it, otherwise null.
     */
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

       logger.info("play");
    }
}
