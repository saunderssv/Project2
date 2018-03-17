package p2.backend.Beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Events")
public class Events {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "eventId")
    private int eventId;

    @Column(name = "what")
    private String what;

    @Column(name = "where")
    private String where;

    @Column(name = "when")
    private String when;

    public Events(){

    }

    public Events(String what, String where, String when) {
        this.what = what;
        this.where = where;
        this.when = when;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return eventId == events.eventId &&
                Objects.equals(what, events.what) &&
                Objects.equals(where, events.where) &&
                Objects.equals(when, events.when);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eventId, what, where, when);
    }

    @Override
    public String toString() {
        return "Events{" +
                "eventId=" + eventId +
                ", what='" + what + '\'' +
                ", where='" + where + '\'' +
                ", when='" + when + '\'' +
                '}';
    }
}
