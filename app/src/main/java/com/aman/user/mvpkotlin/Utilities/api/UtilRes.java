package com.aman.user.mvpkotlin.Utilities.api;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by amanpreetsinghmehal on 09/03/18.
 */

public class UtilRes {

    public static String BASE_URL = "https://en.wikipedia.org/w/";

    public static String getDateFormat(String presentfromat, String date, String reqFormat) throws ParseException {
        String strNewDate = "";
        try {
            DateFormat df = new SimpleDateFormat(presentfromat, Locale.ENGLISH);
            Date d = df.parse(date);
            SimpleDateFormat sdf = new SimpleDateFormat(reqFormat, Locale.ENGLISH);


            strNewDate = sdf.format(d);
            Log.e("New Date", "Date==  " + strNewDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return strNewDate;
    }
}
