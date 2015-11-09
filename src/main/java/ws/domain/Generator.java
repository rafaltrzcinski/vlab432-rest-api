package ws.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Generator {

    @Id
    private Long id;
    private String address;
    private String type;

    protected Generator() {
    }

    public Generator(Long id, String address, String type) {
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
