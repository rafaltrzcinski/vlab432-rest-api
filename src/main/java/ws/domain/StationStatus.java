package ws.domain;

public class StationStatus {

    private Long id;
    private String status;

    protected StationStatus() {
    }

    public StationStatus(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
