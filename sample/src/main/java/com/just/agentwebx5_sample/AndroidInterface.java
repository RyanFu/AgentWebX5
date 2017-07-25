package com.just.agentwebx5_sample;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.just.agentwebX5.AgentWebX5;


/**
 * Created by cenxiaozhong on 2017/5/14.
 */

public class AndroidInterface {


    private AgentWebX5 agent;
    private Context context;

    public AndroidInterface(AgentWebX5 agent, Context context) {
        this.agent = agent;
        this.context = context;
    }

    private Handler deliver = new Handler(Looper.getMainLooper());

    @JavascriptInterface
    public void callAndroid(final String msg) {


        deliver.post(new Runnable() {
            @Override
            public void run() {

                Log.i("Info", "main Thread:" + Thread.currentThread());
                Toast.makeText(context.getApplicationContext(), "" + msg, Toast.LENGTH_LONG).show();
            }
        });


        Log.i("Info", "Thread:" + Thread.currentThread());

            //对外接口


    }

}
