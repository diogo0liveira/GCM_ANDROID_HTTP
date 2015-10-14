package com.diogo.mobile.app.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.diogo.mobile.app.util.Extras;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

/**
 * Created on 08/10/2015 15:06.
 *
 * @author Diogo Oliveira.
 */
public class RegistrationIntentService extends IntentService
{
    private static final String LOG = "LOG";

    public RegistrationIntentService()
    {
        super(LOG);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        synchronized(LOG)
        {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            boolean bolStatus = preferences.getBoolean(Extras.PREFERENCES_STATUS, false);

            InstanceID instanceID = InstanceID.getInstance(this);

            try
            {
                if(!bolStatus)
                {
                    String strToken = instanceID.getToken(Extras.SENDER_ID, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                    preferences.edit().putBoolean(Extras.PREFERENCES_STATUS, ((strToken != null) && (TextUtils.isEmpty(strToken.trim())))).apply();
                    sendRegistrationToServer(strToken);
                    Log.e("TAG", strToken);
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void sendRegistrationToServer(String token)
    {

    }
}
