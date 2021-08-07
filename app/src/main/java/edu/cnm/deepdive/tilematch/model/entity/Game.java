package edu.cnm.deepdive.tilematch.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.google.gson.annotations.Expose;
import edu.cnm.deepdive.tilematch.model.pojo.Tile;
import edu.cnm.deepdive.tilematch.model.pojo.Tile.State;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


  @NonNull
  @ColumnInfo(index = true)
  private Difficulty difficulty;

  private int height;

  private int width;

  @ColumnInfo(name = "play_time", index = true)
  private int playTime;

  @ColumnInfo(index = true)
  private int attempts;

  @NonNull
  @ColumnInfo(index = true)
  private Date timestamp;

  @ColumnInfo(name = "user_id", index = true)
  private Long userId;

  @Ignore
  private final List<Tile> tiles = new ArrayList<>();

  @Ignore
  private int matches;

  @Ignore
  private int guess;

  @Ignore
  @NonNull
  private State state = State.AWAITING_GUESS;

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

  @NonNull
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NonNull Date timestamp) {
    this.timestamp = timestamp;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public List<Tile> getTiles() {
    return tiles;
  }

  public int getMatches() {
    return matches;
  }

  public void setMatches(int matches) {
    this.matches = matches;
  }

  public int getGuess() {
    return guess;
  }

  public void setGuess(int guess) {
    this.guess = guess;
  }

  @NonNull
  public State getState() {
    return state;
  }

  public void setState(@NonNull State state) {
    this.state = state;
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

  public enum State {
    AWAITING_GUESS {
      @Override
      public void handleSelection(Game game, int selection) {
        List<Tile> tiles = game.getTiles();
        Tile tile = tiles.get(selection);
        for (Tile t : tiles) {
          if (t.getState() == Tile.State.MATCHING) {
            t.setState(Tile.State.FACE_DOWN);
          }
        }
        tile.setState(Tile.State.MATCHING);
        game.setState(Game.State.AWAITING_MATCH);
        game.setGuess(selection);
      }
    },

    AWAITING_MATCH {
      @Override
      public void handleSelection(Game game, int selection) {
        List<Tile> tiles = game.getTiles();
        Tile tile = tiles.get(selection);
        game.setAttempts(game.getAttempts() + 1);
        Tile guess = tiles.get(game.getGuess());
        if (guess.getUrl().equals(tile.getUrl())) {
          guess.setState(Tile.State.FACE_UP);
          tile.setState(Tile.State.FACE_UP);
          game.setMatches(game.getMatches() + 1);
          if (game.getMatches() >= tiles.size() / 2) {
            game.setState(Game.State.COMPLETED);
            game.setPlayTime((int) (System.currentTimeMillis() - game.getTimestamp().getTime()));
          } else {
            game.setState(AWAITING_GUESS);
          }
        } else {
          tile.setState(Tile.State.MATCHING);
          game.setState(AWAITING_GUESS);
        }
      }
    },

    COMPLETED;
    public void handleSelection(Game game, int selection) {
    }

  }

}