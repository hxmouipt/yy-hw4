
import com.google.inject.AbstractModule;

public class DateModule extends AbstractModule {

    protected void configure() {
        this.bind(Now.class).to(CurrentTime.class);
    }



}
