package com.example.notificatinon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.RenderScript;

public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID="My Channel";
    private static final int NOTIFICATION_ID=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Drawable

        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.music,null);
        // Drawable convert to bitmap drawable
        // image convert to a datatype bitmap bitmap is a class
        BitmapDrawable bitmapDrawable=(BitmapDrawable) drawable;
        Bitmap largeIcon=bitmapDrawable.getBitmap();

        // type cast
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification=new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.music)
                    .setContentText("New Message") // its for Title
                    .setSubText("New Message from Sushil")
                    .setChannelId(CHANNEL_ID) // error show for channel id above and equal than  android 8 version
                    .build(); // without its not build
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel", NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification=new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.music)
                    .setContentText("New Message") // its for Title
                    .setSubText("New Message from Sushil")

                    .build(); // without its not build
        }

        nm.notify(NOTIFICATION_ID,notification);
        // channel define different kind of notification like //channel for messaging channel for update notification
    }
}