package bonus.items;

import compulsory.exceptions.NotAnAudioException;
import lombok.*;
import org.apache.tika.Tika;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public @Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
class Song extends Item implements CanRegenerate<Song>, Serializable {
    private List<String> authors = new LinkedList<>();
    private String songName;

    public Song(String name, String path, String songName, String... authors) {
        super(name, path);
        this.authors = new LinkedList<>(Arrays.asList(authors));
        this.songName = songName;
    }

    public Song(String name, String path, String songName, List<String> authors) {
        super(name, path);
        this.songName = songName;
        this.authors = new LinkedList<>(authors);
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

    @Override
    public Song generateObject(String... args) {
        return new Song(args[1], args[2], args[3], Arrays.asList(args).subList(4, args.length));
    }
}
