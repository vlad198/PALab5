package optional.commands;

import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes the save command in our shell.
 */
public class SaveCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(SaveCommand.class.getName());
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(catalog.getPath() + "\\" + catalog.getName() + ".ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

        catalog.setItems(new LinkedList<>(catalog.getItems()));

        out.writeObject(catalog);

        fileOutputStream.close();
        out.close();

       logger.info("saved");
    }
}
