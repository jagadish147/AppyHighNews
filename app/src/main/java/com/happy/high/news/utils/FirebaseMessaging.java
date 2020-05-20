package com.happy.high.news.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.happy.high.news.R;
import com.happy.high.news.ui.splash.SplashActivity;
import com.happy.high.news.ui.web.WebActivity;

import java.util.Map;
import java.util.Objects;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by Jagadish on 19/05/2020.
 */
public class FirebaseMessaging extends FirebaseMessagingService {

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "getInstanceId failed", task.getException());
                    }
                });

    }


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        Map<String, String> data = remoteMessage.getData();
        String body = Objects.requireNonNull(remoteMessage.getNotification()).getBody();
        String title = remoteMessage.getNotification().getTitle();
        String className = data.get("click_action");
        Intent intent;
        if (className != null && className.equalsIgnoreCase("URL_INITIATE")) {
            intent = new Intent(getApplicationContext(), WebActivity.class);
            intent.putExtra("url", remoteMessage.getData().get("url"));
        } else {
            intent = new Intent(getApplicationContext(), SplashActivity.class);
        }

        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager nm = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel channel;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel("222", "news_channel", NotificationManager.IMPORTANCE_HIGH);
            if (nm != null) {
                nm.createNotificationChannel(channel);
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                getApplicationContext(), "222")
                .setContentTitle(title)
                .setAutoCancel(true)
                .setLargeIcon(((BitmapDrawable) Objects.requireNonNull(getDrawable(R.mipmap.ic_launcher))).getBitmap())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(body)
                .setContentIntent(pi);

        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        if (nm != null) {
            nm.notify(101, builder.build());
        }
    }

}
