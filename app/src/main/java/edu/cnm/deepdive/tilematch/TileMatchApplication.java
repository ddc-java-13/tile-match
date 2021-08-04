package edu.cnm.deepdive.tilematch;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.tilematch.service.TileMatchDatabase;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class TileMatchApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    TileMatchDatabase.setContext(this);
    TileMatchDatabase
        .getInstance()
        .getUserDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Picasso.setSingletonInstance(
        new Picasso.Builder(this)
            .loggingEnabled(BuildConfig.DEBUG)
            .build()
    );

  }


}
