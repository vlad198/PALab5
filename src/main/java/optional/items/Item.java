package optional.items;

import lombok.*;
import optional.exceptions.NotAPathException;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

public @Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
abstract class Item implements Serializable {
    private String id;
    private String name;
    private String path;

    public Item(String name, String path) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.path = path;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name should not be empty.");
        }

        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException(
                    "Name should only contain characters: " + name);
        }
        this.name = name;
    }

    public void setPath(String path) throws NotAPathException {
        File f = new File(path);

        if (!(f.exists() && f.isDirectory())) {
            throw new NotAPathException("Path should exist in this system.");
        }

        this.path = path;
    }

    public abstract void play() throws IOException;
}
