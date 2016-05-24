
import java.util.Date;

public class DummyNow implements Now {
    private Date date;

    @Override
    public synchronized Date get() {
        return date == null ? new Date() : date;
    }

    @Override
    public synchronized void set(Date date) {
        this.date = date;
    }
}
