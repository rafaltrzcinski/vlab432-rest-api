package ws.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Result {

    @Id
    Long measurementId;
    int stationId;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
    Date measurementTime;
    String function;
    String modulation;
    double resultValue;
    String resultUnit;

    protected Result() {
    }

    public Result(Long measurementId, int stationId, Date measurementTime, String function,
                  String modulation, double resultValue, String resultUnit) {
        this.measurementId = measurementId;
        this.stationId = stationId;
        this.measurementTime = measurementTime;
        this.function = function;
        this.modulation = modulation;
        this.resultValue = resultValue;
        this.resultUnit = resultUnit;
    }

    public Long getMeasurementId() {
        return measurementId;
    }

    public int getStationId() {
        return stationId;
    }

    public Date getMeasurementTime() {
        return measurementTime;
    }

    public String getFunction() {
        return function;
    }

    public String getModulation() {
        return modulation;
    }

    public double getResultValue() {
        return resultValue;
    }

    public String getResultUnit() {
        return resultUnit;
    }

}
