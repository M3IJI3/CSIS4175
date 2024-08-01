package com.example.remotebounddemo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class RemoteService extends Service {
    public RemoteService() {
    }

    static class ImcomingHandler extends Handler {
        String TAG = "RemoteService";

        public ImcomingHandler ()
        {
            super(Looper.getMainLooper());
        }

        public void handleMessage (Message msg)
        {
            Bundle data = msg.getData();
            String dataString = data.getString("MyString");
            Log.i(TAG, "Message = " + dataString);
        }
    }

    final Messenger myMessager = new Messenger(new ImcomingHandler());

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myMessager.getBinder();
    }
}