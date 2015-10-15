package com.diogo.mobile.app.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.diogo.mobile.app.MainActivity;
import com.diogo.mobile.app.R;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created on 08/10/2015 16:33.
 *
 * @author Diogo Oliveira.
 */
public class GCMListenerService extends GcmListenerService
{
    @Override
    public void onMessageReceived(String from, Bundle data)
    {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
        notification.setSmallIcon(R.mipmap.ic_cloud_white_36dp);

        notification.setContentTitle("GCM Notificação");
        notification.setContentText(data.getString("message"));
        notification.setWhen(System.currentTimeMillis());
        notification.setAutoCancel(true);

        notification.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        notification.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
        notification.setLights(Color.RED, 3000, 3000);

        notification.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));
        NotificationManager notificationManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification.build());
    }
}
