package az.rv.demoapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String name;


    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
