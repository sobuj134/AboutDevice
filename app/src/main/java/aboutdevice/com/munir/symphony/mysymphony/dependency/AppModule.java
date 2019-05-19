package aboutdevice.com.munir.symphony.mysymphony.dependency;

import java.util.List;

import javax.inject.Singleton;

import aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp;
import aboutdevice.com.munir.symphony.mysymphony.data.model.Feature;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.IAppGames;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.INewsModel;
import aboutdevice.com.munir.symphony.mysymphony.networking.APIClients;
import aboutdevice.com.munir.symphony.mysymphony.networking.APIServices;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Singleton
@Module
public class AppModule {

    private MySymphonyApp app;
    private CompositeDisposable compositeDisposable;

    AppModule(MySymphonyApp app){
        this.app = app;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Provides
    @Singleton
    MySymphonyApp provideContext(){
        return app;
    }

    @Singleton
    @Provides
    APIServices provideAPIServices(){
        return APIClients.getInstance().create(APIServices.class);
    }

    @Singleton
    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return compositeDisposable;
    }

    @Singleton
    @Provides
    Realm provideRealm(){
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        //return Realm.getDefaultInstance();
        return Realm.getInstance(config);
    }

    @Singleton
    @Provides
    List<INewsModel> provideINewsModels(){
        return provideRealm().where(INewsModel.class).findAll();
    }

    @Singleton
    @Provides
    List<IAppGames> provideIAppGames(){
        return provideRealm().where(IAppGames.class).findAll();
    }

    @Singleton
    @Provides
    Feature provideFeature(){
        return provideRealm().where(Feature.class).findFirst();
    }
}
