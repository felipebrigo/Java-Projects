package Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScheduleData implements Serializable {

    private Integer id;
    private String idSchedule;
    private String titletask;
    private String descriptiontask;
    private LocalDateTime startdate;
    private LocalDateTime enddate;
    private boolean allday;
    //private Type typeofcontract;

    public ScheduleData() {
    }

    //CONSTRUCTOR GETTERS AND SETTERS
    public ScheduleData(Integer id, String titletask, String descriptiontask, LocalDateTime startdate, LocalDateTime enddate, boolean allday) {
        this.id = id;
        this.titletask = titletask;
        this.descriptiontask = descriptiontask;
        this.startdate = startdate;
        this.enddate = enddate;
        this.allday = allday;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public boolean isAllday() {
        return allday;
    }

    public void setAllday(boolean allday) {
        this.allday = allday;
    }

    public String getTitletask() {
        return titletask;
    }

    public void setTitletask(String titletask) {
        this.titletask = titletask;
    }

    public String getDescriptiontask() {
        return descriptiontask;
    }

    public void setDescriptiontask(String descriptiontask) {
        this.descriptiontask = descriptiontask;
    }

    public LocalDateTime getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public LocalDateTime getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDateTime enddate) {
        this.enddate = enddate;
    }

    /*
    @Transient
    public Type getTypeofcontract() {
        return typeofcontract;
    }

    public void setTypeofcontract(Type typeofcontract) {
        this.typeofcontract = typeofcontract;
    }
    */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ScheduleData other = (ScheduleData) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
