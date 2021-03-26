package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.Item;
import bonus.items.ItemsList;

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
