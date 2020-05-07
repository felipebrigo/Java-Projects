package Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleRenderingMode;


public class CustomScheduleEvent implements ScheduleEvent, Serializable {

    private String id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;  
    private boolean allDay;
    private boolean editable;
    private boolean overlapAllowed;
    private String styleClass;
    private Object data;
    
    
    public CustomScheduleEvent(){
        
    }

    public CustomScheduleEvent(String id, String title, String description, LocalDateTime startDate, LocalDateTime endDate, boolean allDay) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.allDay = allDay;
    }

    public CustomScheduleEvent(String title, String description, LocalDateTime startDate, LocalDateTime endDate, boolean allDay) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.allDay = allDay;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public boolean isOverlapAllowed() {
        return overlapAllowed;
    }

    public void setOverlapAllowed(boolean overlapAllowed) {
        this.overlapAllowed = overlapAllowed;
    }

    @Override
    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    @Override
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getGroupId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUrl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ScheduleRenderingMode getRenderingMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getDynamicProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
