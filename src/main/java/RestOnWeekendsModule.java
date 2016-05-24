import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class RestOnWeekendsModule extends AbstractModule {

    protected void configure() {
        WeekendsBlocker weekendsBlocker = new WeekendsBlocker();
        this.requestInjection(weekendsBlocker);
        this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(NotOnWeekends.class), weekendsBlocker);
    }
}
