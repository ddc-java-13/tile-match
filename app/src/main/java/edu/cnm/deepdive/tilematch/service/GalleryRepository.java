package edu.cnm.deepdive.tilematch.service;

import android.content.Context;
import edu.cnm.deepdive.tilematch.BuildConfig;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class GalleryRepository {

  private final Context context;
  private final GalleryServiceProxy serviceProxy;

  public GalleryRepository(Context context) {
    this.context = context;
    serviceProxy = GalleryServiceProxy.getInstance();
  }

  public Single<Gallery.SearchResult> getGallery(){
    return serviceProxy.getHits(BuildConfig.API_KEY,8)
        .subscribeOn(Schedulers.io());
  }

}
