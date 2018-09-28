import org.junit.Ignore;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2018/9/25.
 */
public class MyTest {

    @Ignore
    @Test
    public void test6() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.set(1970, 0, 01);
        //String format = sdf.format(beforeTime.getTime());
        //   System.out.println("哈哈aaa"+ format);
        long timeInMillis = beforeTime.getTimeInMillis();
        System.out.println("当前时间戳" + timeInMillis);
        long ltime = System.currentTimeMillis();
        for (Long aa = 50000L; timeInMillis < ltime; timeInMillis = ltime - aa) {
            System.out.println("运行了。。。");
        }

    }
}
