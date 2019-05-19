package aboutdevice.com.munir.symphony.mysymphony.dependency;

import javax.inject.Singleton;

import aboutdevice.com.munir.symphony.mysymphony.MainActivity;
import aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp;
import aboutdevice.com.munir.symphony.mysymphony.networking.DataSync;
import aboutdevice.com.munir.symphony.mysymphony.ui.ContactDialogFragment;
import aboutdevice.com.munir.symphony.mysymphony.ui.FeatureFragment;
import aboutdevice.com.munir.symphony.mysymphony.ui.MainFragment;
import dagger.Component;


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {


    final class Initializer {
        private Initializer(){}

        public static AppComponent init(MySymphonyApp app){
            return DaggerAppComponent.builder().appModule(new AppModule(app)).build();
        }

    }
    void inject(DataSync dataSync);
    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);
    void inject(FeatureFragment featureFragment);
    void inject(ContactDialogFragment contactDialogFragment);
}
