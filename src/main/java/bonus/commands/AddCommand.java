package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.ItemsList;

import java.util.List;

public class AddCommand implements isExecutable {
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) {
        System.out.println("add");

        catalog.add(itemsList.getItemsList()
                .get(args.get(0))
                .generateObject(args.toArray(new String[0])));
    }
}

// add Movie 3 4 5