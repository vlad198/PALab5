package optional.commands;

import optional.catalog.Catalog;
import lombok.*;
import optional.exceptions.NotACommandException;
import optional.items.ItemsList;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class CommandsList implements Serializable {
    private Map<String, isExecutable> commands = new HashMap<>();
    private static final Logger logger = Logger.getLogger(CommandsList.class.getName());

    public void add(String name, isExecutable command) {
        commands.put(name, command);
    }

    public void runCommand(Command command, Catalog catalog, ItemsList itemsList) throws IOException, NotACommandException {
        if(commands.containsKey(command.getCommandName())){
            commands.get(command.getCommandName()).executeCommand(command.getCommandArgs(),catalog,itemsList);
        }
        else
           throw new NotACommandException("command not found");
    }
}
