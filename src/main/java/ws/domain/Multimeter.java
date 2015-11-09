package ws.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Multimeter {

    @Id
    private Long id;
    private String address;
    private String type;

    protected Multimeter() {
    }

    public Multimeter(Long id, String address, String type) {
        this.id = id;
        this.address = address;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

}
