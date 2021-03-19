package compulsory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

public @Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Item implements Serializable {
    private String id;
    private String name;
    private String path;

    public Item(String name,String path){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.path = path;
    }

    abstract void isAbstract();
}
