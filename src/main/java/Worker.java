import com.google.inject.Guice;
import com.google.inject.Inject;

import java.text.SimpleDateFormat;

class Worker {
    @Inject private Now now;

    @NotOnWeekends
    public void workLikeADog() {
        String dayOfWeek = new SimpleDateFormat("EEEE").format(now.get());
        System.out.println("I am working now(" + dayOfWeek + ")...and I want to work even on Weekends to make more money...");
    }

    public static void main(String[] args) {
        Worker worker = Guice.createInjector(new DateModule(), new RestOnWeekendsModule()).getInstance(Worker.class);
        worker.workLikeADog();
    }

}