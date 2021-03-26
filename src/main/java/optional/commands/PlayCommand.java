package optional.commands;

import optional.Main;
import optional.items.Item;
import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes the play command in our shell.
 */
public class PlayCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(PlayCommand.class.getName());

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
