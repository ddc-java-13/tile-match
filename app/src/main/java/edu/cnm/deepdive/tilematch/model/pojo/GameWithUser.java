package edu.cnm.deepdive.tilematch.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.entity.User;

/**
 * Pojo connects Game and User class
 */
public class GameWithUser extends Game {

  @Relation(
      entity = User.class,
      parentColumn = "user_id",
      entityColumn = "user_id"
  )
  private User user;

  /**
   * Getter for GameWithUser
   *
   * @return
   */
  public User getUser() {
    return user;
  }

  /**
   * Setter for GameWithUser
   *
   * @param user
   */
  public void setUser(User user) {
    this.user = user;
  }
}
