
import com.google.inject.AbstractModule;

public class DummyDateModule extends AbstractModule {

    protected void configure() {
        this.bind(Now.class).to(DummyNow.class).asEagerSingleton();
    }

}
