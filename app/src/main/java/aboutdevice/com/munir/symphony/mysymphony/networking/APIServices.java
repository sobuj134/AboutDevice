package aboutdevice.com.munir.symphony.mysymphony.networking;

import aboutdevice.com.munir.symphony.mysymphony.data.model.CCAddress;
import aboutdevice.com.munir.symphony.mysymphony.data.model.Feature;
import aboutdevice.com.munir.symphony.mysymphony.data.model.GameApps;
import aboutdevice.com.munir.symphony.mysymphony.data.model.News;
import aboutdevice.com.munir.symphony.mysymphony.data.model.Offer;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.IAppGames;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.ICCAddress;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.INewsModel;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by monir.sobuj on 5/25/17.
 */

public interface APIServices {

    String TAG = APIServices.class.getSimpleName();

    @FormUrlEncoded
    @POST("api/device")
    Observable<PostResponse> postDeviceInfo(@Field("uid") String uid,
                                               @Field("name") String name,
                                               @Field("imei") String imei,
                                               @Field("mac") String mac);

    @FormUrlEncoded
    @POST("api/user")
    Observable<PostResponse> postUserInfo(@Field("uid") String uid,
                                      @Field("name") String name,
                                      @Field("email") String email,
                                      @Field("phone") String phone);

    @FormUrlEncoded
    @POST("api/user")
    Observable<PostResponse> updateUserInfo(@Field("uid") String uid,
                                          @Field("name") String name,
                                          @Field("email") String email,
                                          @Field("phone") String phone);


    @GET("api/ccAddress")
    Observable<ResponseWrapper<ICCAddress>> getCCAddress();

    @GET("api/feature/{id}")
    Observable<FeatureResponse<Feature>> getFeature(@Path("id") String modelName);

    @GET("api/user")
    Observable<ResponseWrapper<Feature>> getUserInfo(@Query("uid") String uid);

    @GET("api/news")
    Observable<ResponseWrapper<INewsModel>> getNews();

    @GET("api/offer")
    Observable<ResponseWrapper<Offer>> getOffer();

    @GET("api/appsGamesList")
    Observable<ResponseWrapper<IAppGames>> getGameApps();





}
