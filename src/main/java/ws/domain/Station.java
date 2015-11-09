package ws.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {

    @Id
    private Long id;
    private String address;
    private int multimeterId;
    private int generatorId;
    private String status;


    protected Station() {}

    public Station(Long id, String address, int multimeterId, int generatorId, String status) {
        this.id = id;
        this.address = address;
        this.multimeterId = multimeterId;
        this.generatorId = generatorId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getMultimeterId() {
        return multimeterId;
    }

    public int getGeneratorId() {
        return generatorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
