package aboutdevice.com.munir.symphony.mysymphony;

import android.app.Application;
import android.content.Context;

//import com.facebook.FacebookSdk;
//import com.facebook.drawee.backends.pipeline.Fresco;
import com.onesignal.OneSignal;

import aboutdevice.com.munir.symphony.mysymphony.dependency.AppComponent;
import aboutdevice.com.munir.symphony.mysymphony.dependency.DaggerAppComponent;
import aboutdevice.com.munir.symphony.mysymphony.onesignal.MyNotificationOpenedHandler;
import aboutdevice.com.munir.symphony.mysymphony.onesignal.MyNotificationReceivedHandler;
import io.realm.Realm;

/**
 * Created by munirul.hoque on 12/21/2016.
 */

public class MySymphonyApp extends Application {
    private static MySymphonyApp mInstance;
    private static AppComponent appComponent;
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        context = getApplicationContext();

        appComponent = DaggerAppComponent.Initializer.init(this);
        //initialize Realm
        Realm.init(this);

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new MyNotificationOpenedHandler())
                .setNotificationReceivedHandler( new MyNotificationReceivedHandler() )
                .init();
    }

    public static synchronized MySymphonyApp getmInstance(){
        return mInstance;
    }

    public static AppComponent getComponent(){
        return appComponent;
    }

    public MySymphonyApp getActivity(){
        return this;
    }
}
