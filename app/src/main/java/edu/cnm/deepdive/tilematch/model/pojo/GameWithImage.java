package edu.cnm.deepdive.tilematch.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.model.entity.Game;

public class GameWithImage extends Image {
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
