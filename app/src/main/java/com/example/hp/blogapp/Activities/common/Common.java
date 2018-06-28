package com.example.hp.blogapp.Activities.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.hp.blogapp.Activities.model.Blog;
import com.example.hp.blogapp.Activities.model.Notification;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by hp on 6/27/2018.
 */

public class Common {
    public static String sharedPreferences = "SharedPreferences";
    public static String email = "email";
    public static String imageUrl = "https://www.google.com.pk/search?q=zayn+malik&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjAq-jy8_bbAhVIvhQKHTBFCaYQ_AUICigB&biw=1366&bih=613#imgdii=kTvx_EezLOEKlM:&imgrc=dsT2cOWrxzOjLM:";

    public static void saveEmailToSharedPrefs(EditText userEmail, Context context) {
        SharedPreferences.Editor sharedEditor = context.getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE).edit();
        sharedEditor.putString(Common.email, userEmail.getText().toString());
        sharedEditor.apply();
    }

    public static List<Notification> getNotifications(List<Notification> arrayList) {
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Notification("Uploaded a picture.", "12-12-2018", "Shariq Khan"));
        }
        return arrayList;
    }

    public static List<Blog> getBlogs(List<Blog> arrayList) {
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Blog("Shariq Khan", "12-7-2018",
                    "https://www.google.com.pk/search?q=zayn+malik&tbm=isch&source=iu&ictx=1&fir=KMSgaH7eGkftNM%253A%252CLyi4cPh8DWBjRM%252C_&usg=__CFf6xyDcvaTuipWxBvL7qdnPnoI%3D&sa=X&ved=0ahUKEwj8-9m6pvfbAhVDWhQKHU_JCEMQ_h0IygEwGQ#imgrc=KMSgaH7eGkftNM:",
                    "https://en.wikipedia.org/wiki/Mountain#/media/File:Monasterio_Khor_Virap,_Armenia,_2016-10-01,_DD_25.jpg",
                    "This is the beautiful mountain",
                    "14",
                    "2"));
        }
        return arrayList;
    }

}
