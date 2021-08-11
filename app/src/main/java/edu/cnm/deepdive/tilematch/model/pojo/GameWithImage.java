package edu.cnm.deepdive.tilematch.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.model.entity.Game;

/**
 * Pojo connecte game and image classes
 */
public class GameWithImage extends Image {

  @Relation(
      entity = Game.class,
      parentColumn = "game_id",
      entityColumn = "game_id"
  )
  private Game game;

  /**
   * Getter for GameWithImage
   *
   * @return
   */
  public Game getGame() {
    return game;
  }

  /**
   * Setter for GameWithImage
   *
   * @param game
   */
  public void setGame(Game game) {
    this.game = game;
  }
}
