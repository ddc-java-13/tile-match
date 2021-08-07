package edu.cnm.deepdive.tilematch.service;

import static edu.cnm.deepdive.tilematch.model.entity.Game.State.AWAITING_GUESS;

import android.content.Context;
import androidx.annotation.NonNull;
import edu.cnm.deepdive.tilematch.BuildConfig;
import edu.cnm.deepdive.tilematch.model.dao.GameDao;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.model.dto.Image.SearchResult;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.entity.Game.Difficulty;
import edu.cnm.deepdive.tilematch.model.pojo.Tile;
import edu.cnm.deepdive.tilematch.model.pojo.Tile.State;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GameRepository {

  private final Context context;
  private final Random rng;
  private final GalleryServiceProxy serviceProxy;
  private final GameDao gameDao;

  public GameRepository(Context context, Random rng) {
    this.context = context;
    this.rng = rng;
    serviceProxy = GalleryServiceProxy.getInstance();
    gameDao = TileMatchDatabase.getInstance().getGameDao();
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

  public Single<Game> startGame() { //TODO add param for difficulty.
    return getGallery()
        .map((tiles) -> {
          Collections.shuffle(tiles);
          Game game = new Game();
          game.setTimestamp(new Date());
          game.getTiles().addAll(tiles);
          game.setDifficulty(Difficulty.EASY); //TODO use difficulty paramater
          return game;
        });
  }

  public Single<Game> handleSelection(@NonNull Game game, int position) {
    List<Tile> tiles = game.getTiles();
    Tile tile = tiles.get(position);
    if (tile.getState() == State.FACE_DOWN) {
      game.getState().handleSelection(game, position);
    }
    return (
        (game.getState() == Game.State.COMPLETED)
            ? gameDao
            .insert(game)
            .map((id) -> {
              game.setId(id);
              return game;
            })
            : Single.just(game)
    )
        .subscribeOn(Schedulers.io());
  }

}
