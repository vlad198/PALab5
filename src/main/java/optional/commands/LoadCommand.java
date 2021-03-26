package optional.commands;

import freemarker.template.TemplateException;
import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes the load command in our shell.
 */
public class LoadCommand implements isExecutable{
    private static final Logger logger = Logger.getLogger(LoadCommand.class.getName());
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir").toString() + "/catalogues/" + args.get(0) + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Catalog copy = (Catalog) in.readObject();

        catalog.setName(copy.getName());
        catalog.setPath(copy.getPath());
        catalog.setItems(copy.getItems());

        logger.info("loaded");
    }
}
