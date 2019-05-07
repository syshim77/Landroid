package org.androidtown.mysmsreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MySMSReceiver extends BroadcastReceiver {
    private static final String TAG = "MySMSReciver";

    public MySMSReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReciver() 호출됨.");

        Intent myIntent = new Intent(context, MainActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(myIntent);
    }


}
