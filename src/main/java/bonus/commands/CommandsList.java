package bonus.commands;

import bonus.catalog.Catalog;
import bonus.exceptions.NotACommandException;
import bonus.items.ItemsList;
import freemarker.template.TemplateException;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Class that contains a Map with the commands available to be executed
 * in our application.
 */
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class CommandsList implements Serializable {
    private Map<String, isExecutable> commands = new HashMap<>();
    private static final Logger logger = Logger.getLogger(CommandsList.class.getName());

    /**
     * Adds a new command in the list of commands available to be executed.
     * @param name name of the command
     * @param command the command to be executed
     */
    public void add(String name, isExecutable command) {
        commands.put(name, command);
    }

    /**
     * This function runs a command given as a parameter if it is available in the commands list.
     * @param command the command to be executed
     * @param catalog the catalog on which we want to execute the command
     * @param itemsList the items available
     * @throws IOException exception
     * @throws NotACommandException exception
     * @throws TemplateException exception
     * @throws ClassNotFoundException exception
     */
    public void runCommand(Command command, Catalog catalog, ItemsList itemsList) throws IOException, NotACommandException, TemplateException, TikaException, SAXException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if(commands.containsKey(command.getCommandName())){
            commands.get(command.getCommandName()).executeCommand(command.getCommandArgs(),catalog,itemsList);
        }
        else
           throw new NotACommandException("command not found");
    }
}
