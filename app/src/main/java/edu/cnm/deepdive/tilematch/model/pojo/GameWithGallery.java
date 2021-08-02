package edu.cnm.deepdive.tilematch.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import edu.cnm.deepdive.tilematch.model.entity.Game;

public class GameWithGallery extends Gallery{
  @Relation(
      entity = Game.class,
      parentColumn = "game_id",
      entityColumn = "game_id"
  )
  private Game game;

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
