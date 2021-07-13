package edu.cnm.deepdive.tilematch.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
    parentColumns = "id",
    childColumns = "user_id"))
public class Game {

  @PrimaryKey
  @ColumnInfo(name = "game_id")
  private long id;

  @ColumnInfo(name = "game_mode")
  private String gameMode;

  private int height;

  private int width;

  @ColumnInfo(name = "play_time")
  private int playTime;

  @ColumnInfo(name = "match_attempts")
  private int matchAttempts;

  private Date timestamp;

  @ColumnInfo(name = "user_id")
  private long userId;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getGameMode() {
    return gameMode;
  }

  public void setGameMode(String gameMode) {
    this.gameMode = gameMode;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getPlayTime() {
    return playTime;
  }

  public void setPlayTime(int playTime) {
    this.playTime = playTime;
  }

  public int getMatchAttempts() {
    return matchAttempts;
  }

  public void setMatchAttempts(int matchAttempts) {
    this.matchAttempts = matchAttempts;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
}
