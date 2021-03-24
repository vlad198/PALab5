package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.ItemsList;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;

public interface isExecutable {
    void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException;
}
