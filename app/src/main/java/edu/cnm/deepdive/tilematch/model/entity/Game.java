package edu.cnm.deepdive.tilematch.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.google.gson.annotations.Expose;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            childColumns = {"user_id"},
            parentColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  @Expose
  @NonNull
  @ColumnInfo(index = true)
  private Difficulty difficulty;

  private int height;

  private int width;

  @Expose
  @ColumnInfo(name = "play_time", index = true)
  private int playTime;

  @Expose
  @ColumnInfo(index = true)
  private int attempts;

  @Expose
  @NonNull
  @ColumnInfo(index = true)
  private Date timestamp;

  @Expose
  @ColumnInfo(name = "user_id")
  private long userId;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(@NonNull Difficulty difficulty) {
    this.difficulty = difficulty;
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

  public int getAttempts() {
    return attempts;
  }

  public void setAttempts(int attempts) {
    this.attempts = attempts;
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

  public enum Difficulty {
    EASY, MEDIUM, HARD;

    @TypeConverter
    public static Integer difficultyToInteger(Difficulty value) {
      return (value != null) ? value.ordinal() : null;
    }

    @TypeConverter
    public static Difficulty integerToDifficulty(Integer value) {
      return (value != null) ? Difficulty.values()[value] : null;
    }
  }

}