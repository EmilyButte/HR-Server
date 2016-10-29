package butte.emily.hrproject.domain;

import butte.emily.hrproject.utils.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    User(){}

    @JsonSerialize(using = JsonDateSerializer.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //FORMAT WITH JSON
    public String toString(){
        StringBuilder value = new StringBuilder("{");
        value.append("\"user_name\": ");
        value.append("\"" + username + "\"");
        value.append(",\"password\": ");
        value.append("\"" + password + "\"");
        value.append("},");
        return value.toString();
    }
}
