package optional.commands;

import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.Serializable;
import java.util.Arrays;
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