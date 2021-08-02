package edu.cnm.deepdive.tilematch.service;

import android.content.Context;
import edu.cnm.deepdive.tilematch.BuildConfig;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class GalleryRepository {

  private final Context context;
  private final WebServiceProxy webservice;

  public GalleryRepository(Context context) {
    this.context = context;
    webservice = WebServiceProxy.getInstance();
  }

  public Single<Gallery.SearchResult> getSearchResult(){
    return webservice.getHits(BuildConfig.API_KEY,8)
        .subscribeOn(Schedulers.io());
  }

}
