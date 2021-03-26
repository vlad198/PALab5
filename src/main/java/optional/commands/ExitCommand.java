package optional.commands;

import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes the exit command from our shell
 */
public class ExitCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(ExitCommand.class.getName());
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) {
        logger.info("Exit");
        System.exit(0);
    }
}
