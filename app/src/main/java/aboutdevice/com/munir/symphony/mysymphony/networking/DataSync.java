package aboutdevice.com.munir.symphony.mysymphony.networking;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp;
import aboutdevice.com.munir.symphony.mysymphony.data.model.Feature;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.IAppGames;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.ICCAddress;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.INewsModel;
import aboutdevice.com.munir.symphony.mysymphony.utils.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

public class DataSync {

    public static final String TAG = "DataSync";

    @Inject
    APIServices apiServices;
    @Inject
    Realm r;
    @Inject
    CompositeDisposable compositeDisposable;

    public boolean isErrorOccurred = false;
    public DataSync(DataSyncListener dataSyncListener){
        MySymphonyApp.getComponent().inject(this);
        this.dataSyncListener = dataSyncListener;
    }

    DataSyncListener dataSyncListener;


    public void getFeature(){
        String modelName = getSystemProperty("ro.product.device");
        if(TextUtils.isEmpty(modelName)){
            modelName = getSystemProperty("ro.build.product");
        }

        modelName = "V135";

        Log.e(TAG, "getFeature: "+modelName);

        compositeDisposable.add(apiServices.getFeature(modelName)
                .subscribeOn(Schedulers.io())  // Run on a background thread
                .observeOn(AndroidSchedulers.mainThread()) // Be notified on the main thread
                .subscribeWith(new DisposableObserver<FeatureResponse<Feature>>() {
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: getFeature()");
                        getNews();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: getFeature():"+e.getLocalizedMessage());
                        isErrorOccurred = true;
                        getNews();
                    }

                    @Override
                    public void onNext(final FeatureResponse<Feature> value) {
                        if (value.getStatus().equalsIgnoreCase(Constants.STATUS_SUCCESS)) {
                            r.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm r) {
                                    r.delete(Feature.class);
                                    r.insertOrUpdate(value.getData());
                                }
                            });

                        } else {
                            Log.d(TAG, "onNext: Feature data not found");
                        }
                    }
                }));

    }

    public void getNews(){

        compositeDisposable.add(apiServices.getNews()
                .subscribeOn(Schedulers.io())  // Run on a background thread
                .observeOn(AndroidSchedulers.mainThread()) // Be notified on the main thread
                .subscribeWith(new DisposableObserver<ResponseWrapper<INewsModel>>() {
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: getNews()");
                        getCCAddress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: getNews():"+e.getLocalizedMessage());
                        isErrorOccurred = true;
                        getCCAddress();
                    }

                    @Override
                    public void onNext(final ResponseWrapper<INewsModel> value) {
                        if (value.getStatus().equalsIgnoreCase(Constants.STATUS_SUCCESS)) {
                            r.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm r) {
                                    r.delete(INewsModel.class);
                                    for(INewsModel iNewsModel:value.getData()){
                                        r.insertOrUpdate(iNewsModel);
                                    }
                                }
                            });

                        } else {
                            Log.d(TAG, "onNext: News data not found");
                        }
                    }
                }));
    }

    public  void getCCAddress(){
        compositeDisposable.add(apiServices.getCCAddress()
                .subscribeOn(Schedulers.io())  // Run on a background thread
                .observeOn(AndroidSchedulers.mainThread()) // Be notified on the main thread
                .subscribeWith(new DisposableObserver<ResponseWrapper<ICCAddress>>() {
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: getCCAddress()");
                        getAppsGames();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: getCCAddress()"+e.getLocalizedMessage());
                        isErrorOccurred = true;
                        getAppsGames();
                    }

                    @Override
                    public void onNext(final ResponseWrapper<ICCAddress> value) {
                        if (value.getStatus().equalsIgnoreCase(Constants.STATUS_SUCCESS)) {
                            r.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm r) {
                                    r.delete(ICCAddress.class);
                                    for(ICCAddress iccAddress:value.getData()){
                                        r.insertOrUpdate(iccAddress);
                                    }
                                }
                            });

                        } else {
                            Log.d(TAG, "onNext: ccAddress data not found");
                        }
                    }
                }));

    }

    public  void getOffers(){

    }

    public  void getAppsGames(){
        compositeDisposable.add(apiServices.getGameApps()
                .subscribeOn(Schedulers.io())  // Run on a background thread
                .observeOn(AndroidSchedulers.mainThread()) // Be notified on the main thread
                .subscribeWith(new DisposableObserver<ResponseWrapper<IAppGames>>() {
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: getAppsGames()");
                        if(!isErrorOccurred)
                            dataSyncListener.onSuccess();
                        else dataSyncListener.onError();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: getAppsGames():"+e.getLocalizedMessage());
                        dataSyncListener.onError();
                    }

                    @Override
                    public void onNext(final ResponseWrapper<IAppGames> value) {
                        if (value.getStatus().equalsIgnoreCase(Constants.STATUS_SUCCESS)) {
                            r.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm r) {
                                    r.delete(IAppGames.class);
                                    for(IAppGames iAppGames:value.getData()){
                                        r.insertOrUpdate(iAppGames);
                                    }
                                }
                            });

                        } else {
                            Log.d(TAG, "onNext: Apps and games not found");
                        }
                    }
                }));

    }

    public  void getUser(){

    }

    public String getSystemProperty(String key) {
        String value = null;
        try {
            value = (String) Class.forName("android.os.SystemProperties")
                    .getMethod("get", String.class).invoke(null, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
