package butte.emily.hrproject.domain;

import butte.emily.hrproject.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="time_cards")
public class TimeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date timeIn;
    private Date timeOut;
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    //public Long userId = user.getId();

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public TimeCard(String username, String timeIn, String timeOut) throws ParseException {
        this.timeIn = format.parse(timeIn);
        this.timeOut = format.parse(timeOut);
        this.username = username;
    }

    public TimeCard(){}

    public User getUser() {
        return user;
    }

    public User setUser(User user) {return this.user = user;}

    public String getUsername() {
        return user.getUsername();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getTimeIn() {
        return timeIn;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    @JsonIgnore
    public String getTimeInAsShort(){
        return format.format(timeIn);
    }

    @JsonIgnore
    public String getTimeOutAsShort(){
        return format.format(timeOut);
    }

    public String toString(){
        StringBuilder value = new StringBuilder("{");
        value.append("\"id\": ");
        value.append("\"" + id + "\"");
        value.append(",\"time_in\": ");
        value.append("\"" + format.format(timeIn) + "\"");
        value.append(",\"time_out\": ");
        value.append("\"" + format.format(timeOut) + "\"");
        value.append(",\"user_name\": ");
        value.append("\"" + username + "\"");
        value.append("},");
        return value.toString();
    }
}
