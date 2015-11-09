package ws.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measurement_seq_gen")
    @SequenceGenerator(name = "measurement_seq_gen", sequenceName = "measurement_id_seq")
    private Long id;
    private Long stationId;
    private String modulation;
    private double signalValue;
    private String function;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
    private Date measurementTime;
    private int userId;

    protected Measurement() {
    }

    public Measurement(Long stationId, String modulation, double signalValue, String function,
                       Date measurementTime, int userId) {
        this.stationId = stationId;
        this.modulation = modulation;
        this.signalValue = signalValue;
        this.function = function;
        this.measurementTime = measurementTime;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getStationId() {
        return stationId;
    }

    public String getModulation() {
        return modulation;
    }

    public double getSignalValue() {
        return signalValue;
    }

    public String getFunction() {
        return function;
    }

    public Date getMeasurementTime() {
        return measurementTime;
    }

    public int getUserId() {
        return userId;
    }
}
