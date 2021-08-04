package edu.cnm.deepdive.tilematch.service;

import android.content.Context;
import edu.cnm.deepdive.tilematch.BuildConfig;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.model.dto.Image.SearchResult;
import edu.cnm.deepdive.tilematch.model.pojo.Tile;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class GalleryRepository {

  private final Context context;
  private final GalleryServiceProxy serviceProxy;

  public GalleryRepository(Context context) {
    this.context = context;
    serviceProxy = GalleryServiceProxy.getInstance();
  }

  public Single<List<Tile>> getGallery() {
    return serviceProxy
        .getHits(BuildConfig.API_KEY, 8)
        .map(SearchResult::getHits)
        .map((images) -> {
              List<Tile> tiles = new ArrayList<>();
              for (Image image : images) {
                tiles.add(new Tile(image.getWebFormatUrl()));
                tiles.add(new Tile(image.getWebFormatUrl()));
              }
              return tiles;
            }
        )
        .subscribeOn(Schedulers.io());
  }

}
