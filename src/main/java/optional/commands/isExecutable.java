package optional.commands;

import freemarker.template.TemplateException;
import optional.catalog.Catalog;
import optional.items.ItemsList;

import java.io.IOException;
import java.util.List;

public interface isExecutable {
    void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException;
}
