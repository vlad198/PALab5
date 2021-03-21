package compulsory.items;

import compulsory.exceptions.NotAnAudioException;
import lombok.*;
import org.apache.tika.Tika;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public @Data
@ToString(callSuper = true)
@AllArgsConstructor
class Song extends Item {
    private List<String> authors;
    private String songName;

    public Song(String name, String path, String songName, String... authors) {
        super(name, path);
        this.authors = new LinkedList<>(Arrays.asList(authors));
        this.songName = songName;
    }

    public void play() throws IOException {
        File f = new File(getPath());

        Tika tika = new Tika();
        String type = tika.detect(f);

        if (!type.startsWith("audio/")) {
            throw new NotAnAudioException("File must be an audio.");
        }

        Desktop.getDesktop().open(new File(this.getPath()));
    }

}
