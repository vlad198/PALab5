package optional.commands;

import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes a command which can add a new item to given  catalog
 */
public class AddCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(AddCommand.class.getName());
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) {
        catalog.add(itemsList.getItemsList()
                .get(args.get(0))
                .generateObject(args.toArray(new String[0])));
        logger.info("added");
    }
}