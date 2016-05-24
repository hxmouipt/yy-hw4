
import com.google.inject.Singleton;

import java.util.Date;


@Singleton
public class CurrentTime implements Now {
    @Override
    public Date get() {
        return new Date();
    }



    @Override
    public void set(Date date) {
        System.err.println("Warning: It does not make sense to set current time and it won't effect anything.");
    }
}
