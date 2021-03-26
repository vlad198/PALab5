package optional.commands;

import optional.catalog.Catalog;
import optional.items.Item;
import optional.items.ItemsList;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes the list command in our shell
 */
public class ListCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(ListCommand.class.getName());
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) {
        for(Item item : catalog.getItems()){
           logger.info(item.toString());
        }
    }
}
