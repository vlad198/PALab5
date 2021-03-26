package optional.commands;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that describes a generic command
 */
@EqualsAndHashCode
@Getter
public class Command implements Serializable {
    private final String commandName;
    private final List<String> commandArgs = new LinkedList<>();

    /**
     * Constructor for the command. First word in the string represents the command name and the rest represents the arguments of the command.
     * @param fullCommand a string which represents the command
     */
    public Command(String fullCommand) {
        String[] words = fullCommand.split(" ");
        commandName = words[0];
        commandArgs.addAll(Arrays.asList(words).subList(1, words.length));
    }
}
