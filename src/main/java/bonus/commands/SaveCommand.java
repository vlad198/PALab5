package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.ItemsList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class SaveCommand implements isExecutable {

    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException {
        System.out.println("save");

        FileOutputStream fileOutputStream = new FileOutputStream(catalog.getPath() + "\\" + catalog.getName() + ".ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

        catalog.setItems(new LinkedList<>(catalog.getItems()));

        out.writeObject(catalog);

        fileOutputStream.close();
        out.close();
    }
}
