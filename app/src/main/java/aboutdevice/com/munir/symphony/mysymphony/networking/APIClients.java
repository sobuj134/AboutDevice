package aboutdevice.com.munir.symphony.mysymphony.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by monir.sobuj on 5/25/17.
 */

public class  APIClients {


    //web server
    private final static String BaseURL = "http://gonona-lab.com/api/"; // live


    private static Retrofit retrofit = null;

    public static Retrofit getInstance(){
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseURL).client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
    private APIClients(){}
}
