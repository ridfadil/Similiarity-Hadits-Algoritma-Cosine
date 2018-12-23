package padilah.farid.hadits.similiarityhaditsfarid;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Initializing Active Android
        ActiveAndroid.initialize(this);
    }

}
