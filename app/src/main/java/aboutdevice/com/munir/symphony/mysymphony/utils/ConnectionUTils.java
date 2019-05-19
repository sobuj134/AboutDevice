package aboutdevice.com.munir.symphony.mysymphony.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class ConnectionUTils {

    public static boolean isNetworkConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
