package com.example.amitrai.demo.ui.Utility;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by amitrai on 17/1/17.
 * see more at www.github.com/amitrai98
 */

public class AppUtils {

    public String getTimeAgo(Date server_time){

//        String givenDateString = "2017-01-04 15:45:39";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");//("EEE MMM dd HH:mm:ss z yyyy");
        try {

            Calendar c = Calendar.getInstance();
            System.out.println("Current time => " + c.getTime());

            String formattedDate = sdf.format(c.getTime());

            Date current_date = sdf.parse(formattedDate);
//            Date mDate = sdf.parse(server_time);
            long timeInMilliseconds = server_time.getTime();
            long cttimeInMilliseconds = current_date.getTime();

            System.out.println("Date in milli :: " + timeInMilliseconds);
            return
                    DateUtils.getRelativeTimeSpanString(timeInMilliseconds,
                            cttimeInMilliseconds, DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
