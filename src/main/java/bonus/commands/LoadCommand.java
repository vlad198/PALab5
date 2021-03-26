package bonus.commands;

import freemarker.template.TemplateException;
import bonus.catalog.Catalog;
import bonus.items.ItemsList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Class that describes the load command in our shell.
 */
public class LoadCommand implements isExecutable {
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir").toString() + "/catalogues/" + args.get(0) + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Catalog copy = (Catalog) in.readObject();

        catalog.setName(copy.getName());
        catalog.setPath(copy.getPath());
        catalog.setItems(copy.getItems());
    }
}
