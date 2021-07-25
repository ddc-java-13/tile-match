package edu.cnm.deepdive.tilematch.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.entity.User;

public class GameWithUser extends Game {

  @Relation(
      entity = User.class,
      parentColumn = "user_id",
      entityColumn = "user_id"
  )
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
