
import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.LONG;
import static java.util.Locale.ENGLISH;

class WeekendsBlocker implements MethodInterceptor {
    @Inject private Now now;
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Calendar calendar = Calendar.getInstance();
        Date now = this.now.get();
        calendar.setTime(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, MMM d, yyyy");
        if (calendar.getDisplayName(DAY_OF_WEEK, LONG, ENGLISH).startsWith("S")){
            String errorMessage =  String.format("Today(%s) is Weekends and you shall rest in God rather than work like a dog.", dateFormat.format(now));
            System.err.println(errorMessage);
            throw new IllegalStateException(errorMessage);
        }
        return methodInvocation.proceed();
    }
}
