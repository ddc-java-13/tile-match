package edu.cnm.deepdive.tilematch.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import edu.cnm.deepdive.tilematch.model.pojo.Tile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Game entity class.
 */
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

  /**
   * Getter for game id.
   *
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * Setter for game id.
   *
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Getter for game difficulty.
   *
   * @return
   */
  @NonNull
  public Difficulty getDifficulty() {
    return difficulty;
  }

  /**
   * Setter for game difficulty.
   *
   * @param difficulty
   */
  public void setDifficulty(@NonNull Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  /**
   * Getter for game height.
   *
   * @return
   */
  public int getHeight() {
    return height;
  }

  /**
   * Setter for game height.
   *
   * @param height
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Getter for game width.
   *
   * @return
   */
  public int getWidth() {
    return width;
  }

  /**
   * Setter for game width.
   *
   * @param width
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Getter for game play time.
   *
   * @return
   */
  public int getPlayTime() {
    return playTime;
  }

  /**
   * Setter for game play time.
   *
   * @param playTime
   */
  public void setPlayTime(int playTime) {
    this.playTime = playTime;
  }

  /**
   * Getter for game attempts.
   *
   * @return
   */
  public int getAttempts() {
    return attempts;
  }

  /**
   * Setter for game attempts.
   *
   * @param attempts
   */
  public void setAttempts(int attempts) {
    this.attempts = attempts;
  }

  /**
   * Getter for game timestamp.
   *
   * @return
   */
  @NonNull
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Setter for game timestamp.
   *
   * @param timestamp
   */
  public void setTimestamp(@NonNull Date timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Getter for game user id.
   *
   * @return
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * Setter for game user id.
   *
   * @param userId
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   * Getter for game tiles.
   *
   * @return
   */
  public List<Tile> getTiles() {
    return tiles;
  }

  /**
   * Getter for game matches.
   *
   * @return
   */
  public int getMatches() {
    return matches;
  }

  /**
   * Setter for game matches.
   *
   * @param matches
   */
  public void setMatches(int matches) {
    this.matches = matches;
  }

  /**
   * Getter for game guess.
   *
   * @return
   */
  public int getGuess() {
    return guess;
  }

  /**
   * Setter for game guess.
   *
   * @param guess
   */
  public void setGuess(int guess) {
    this.guess = guess;
  }

  /**
   * Getter for game state.
   *
   * @return
   */
  @NonNull
  public State getState() {
    return state;
  }

  /**
   * Setter for game state.
   *
   * @param state
   */
  public void setState(@NonNull State state) {
    this.state = state;
  }


  /**
   * Game difficulty enum.
   */
  public enum Difficulty {
    EASY(4), MEDIUM(6), HARD(8);

    private final int gameDifficulty;

    Difficulty(int difficulty) {
      this.gameDifficulty = difficulty;
    }

    /**
     * getter for game difficulty enum.
     *
     * @return
     */
    public int getGameDifficulty() {
      return gameDifficulty;
    }

    /**
     * type converter for game difficulty enum, converts difficulty to Integer.
     *
     * @param value
     * @return
     */
    @TypeConverter
    public static Integer difficultyToInteger(Difficulty value) {
      return (value != null) ? value.ordinal() : null;
    }

    /**
     * type converter for game difficulty enum, converts Integer to difficulty.
     *
     * @param value
     * @return
     */
    @TypeConverter
    public static Difficulty integerToDifficulty(Integer value) {
      return (value != null) ? Difficulty.values()[value] : null;
    }
  }

  /**
   * Game state enum.
   */
  public enum State {
    /**
     * Constructor for game state awaiting guess enum.
     */
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

    /**
     * Constructor for game state awaiting match enum.
     */
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

    /**
     * Constructor for game state completed enum.
     *
     * @param game
     * @param selection
     */
    COMPLETED;

    public void handleSelection(Game game, int selection) {
    }

  }

}