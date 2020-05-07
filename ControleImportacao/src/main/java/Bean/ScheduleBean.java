package Bean;

import Dao.ScheduleDao;
import Data.CustomScheduleEvent;
import Data.ScheduleData;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class ScheduleBean implements Serializable {

    private ScheduleModel model;
    private ScheduleData scheduledata;
    private ScheduleEvent event;
    private List<ScheduleData> scheduleevents = new ArrayList();

    //CONSTRUCTOR TO INITIALIZE VARIABLES 
    public ScheduleBean() {
        model = new DefaultScheduleModel();
        event = new CustomScheduleEvent();
        scheduledata = new ScheduleData();
    }

    public ScheduleData ScheduleDataConverter(ScheduleEvent cs) {

        scheduledata = new ScheduleData();
        scheduledata.setTitletask(cs.getTitle());
        scheduledata.setDescriptiontask(cs.getDescription());
        scheduledata.setStartdate(cs.getStartDate());
        scheduledata.setEnddate(cs.getEndDate());
        scheduledata.setAllday(cs.isAllDay());
        scheduledata.setIdSchedule(cs.getId());
        //scheduledata.setTypeofcontract((Type)event.getData());
        return scheduledata;
    }

    @PostConstruct
    public void init() {

        List<ScheduleData> scheduleevents = new ScheduleDao().Deliveries();
        for (ScheduleData data : scheduleevents) {
            ScheduleEvent newevent = DefaultScheduleEvent.builder()
                    .title(data.getTitletask())
                    .description(data.getDescriptiontask())
                    .startDate(data.getStartdate())
                    .endDate(data.getEnddate())
                    .allDay(data.isAllday())
                    .build();
            model.addEvent(newevent);
            data.setIdSchedule(newevent.getId());
            new ScheduleDao().Salvar(data);

        }

    }

//CONSTRUCTOR GETTERS AND SETTERS
    public ScheduleModel getModel() {
        return model;
    }

    public void setModel(ScheduleModel model) {
        this.model = model;
    }

    public ScheduleData getScheduledata() {
        return scheduledata;
    }

    public void setScheduledata(ScheduleData scheduledata) {
        this.scheduledata = scheduledata;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public List<ScheduleData> getScheduleevents() {
        return scheduleevents;
    }

    public void setScheduleevents(List<ScheduleData> scheduleevents) {
        this.scheduleevents = scheduleevents;
    }

    public void deleteEvent() {

        scheduledata = ScheduleDataConverter(this.event);
        String eventId = new String();
        String dataId = new String();
        eventId = this.event.getId();
        List<ScheduleData> scheduleevents = new ScheduleDao().Deliveries();
        for (ScheduleData data : scheduleevents) {
            dataId = data.getIdSchedule();
            if (dataId.equals(eventId)) {
                scheduledata.setId(data.getId());
            }
        }
        new ScheduleDao().Delete(scheduledata);
        model.deleteEvent(this.event);
        scheduledata = new ScheduleData();
    }

    // METHODS SAVE EDIT AND LIST    
    public void addEvent() {

        if (this.event.getId() == null) {

            ScheduleEvent newevent = DefaultScheduleEvent.builder()
                    .id(this.event.getId())
                    .title(this.event.getTitle())
                    .description(this.event.getDescription())
                    .startDate(this.event.getStartDate())
                    .endDate(this.event.getEndDate())
                    .allDay(this.event.isAllDay())
                    .build();
            model.addEvent(newevent);
            scheduledata = ScheduleDataConverter(newevent);
            new ScheduleDao().Salvar(scheduledata);

        } else {

            scheduledata = ScheduleDataConverter(this.event);
            String eventId = new String();
            String dataId = new String();
            eventId = this.event.getId();
            List<ScheduleData> scheduleevents = new ScheduleDao().Deliveries();
            for (ScheduleData data : scheduleevents) {
                dataId = data.getIdSchedule();
                if (dataId.equals(eventId)) {
                    scheduledata.setId(data.getId());
                }
            }
            new ScheduleDao().Salvar(scheduledata);

            ScheduleEvent currentevent = DefaultScheduleEvent.builder()
                    .id(this.event.getId())
                    .title(this.event.getTitle())
                    .description(this.event.getDescription())
                    .startDate(this.event.getStartDate())
                    .endDate(this.event.getEndDate())
                    .allDay(this.event.isAllDay())
                    .build();
            model.updateEvent(currentevent);
        }
        scheduledata = new ScheduleData();
        event = new CustomScheduleEvent();

    }

    public void onEventSelect(SelectEvent<ScheduleEvent> selectevent) {

        event = selectevent.getObject();
        String eventId = event.getId();
        scheduledata.setIdSchedule(selectevent.getObject().getId());

        for (ScheduleData data : scheduleevents) {
            if (data.getIdSchedule() == event.getId()) {
                scheduledata.setId(data.getId());
            }
        }
    }

    public void onDateSelect(SelectEvent<LocalDateTime> selectEvent) {

        LocalDateTime dataSelecionada = (LocalDateTime) selectEvent.getObject();
        this.event.setStartDate(dataSelecionada);
        this.event.setEndDate(dataSelecionada.plusHours(1));

    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        LocalDateTime newdate = event.getScheduleEvent().getStartDate();
        String eventId = event.getScheduleEvent().getId();
        scheduledata.setIdSchedule(eventId);

        List<ScheduleData> scheduleevents = new ScheduleDao().Deliveries();
        for (ScheduleData data : scheduleevents) {
            if (data.getIdSchedule().equals(eventId)) {
                scheduledata.setId(data.getId());
                scheduledata.setStartdate(newdate);
                scheduledata.setTitletask(data.getTitletask());
                scheduledata.setDescriptiontask(data.getDescriptiontask());
                scheduledata.setEnddate(event.getScheduleEvent().getEndDate());
                scheduledata.setAllday(data.isAllday());
            }
        }
        new ScheduleDao().Salvar(scheduledata);

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved to: " + event.getScheduleEvent().getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), "Delta:" + event.getDeltaAsDuration());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
