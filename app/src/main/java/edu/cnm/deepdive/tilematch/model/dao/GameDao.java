package edu.cnm.deepdive.tilematch.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.pojo.GameWithUser;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * GameDao defines CRUD operations for game.
 */
@Dao
public interface GameDao {

  /**
   * Single insert method for game.
   *
   * @param game
   * @return
   */
  @Insert
  Single<Long> insert(Game game);

  /**
   * Varargs insert method for game.
   *
   * @param games
   * @return
   */
  @Insert
  Single<List<Long>> insert(Game... games);

  /**
   * Collection insert method for game.
   *
   * @param games
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<? extends Game> games);

  /**
   * Single update method for game.
   *
   * @param game
   * @return
   */
  @Update
  Single<Integer> update(Game game);

  /**
   * Varargs update method for game.
   *
   * @param games
   * @return
   */
  @Update
  Single<Integer> update(Game... games);

  /**
   * Collection update method for game.
   *
   * @param games
   * @return
   */
  @Update
  Single<Integer> update(Collection<? extends Game> games);

  /**
   * Single delete method for game.
   *
   * @param game
   * @return
   */
  @Delete
  Single<Integer> delete(Game game);

  /**
   * Varargs delete method for game.
   *
   * @param games
   * @return
   */
  @Delete
  Single<Integer> delete(Game... games);

  /**
   * Collection delete method for game.
   *
   * @param games
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<? extends Game> games);

  /**
   * Query method for game returns all games by gameId
   *
   * @param gameId
   * @return
   */
  @Query("SELECT * FROM game WHERE game_id = :gameId")
  @Transaction
  LiveData<GameWithUser> selectByGameId(long gameId);

  /**
   * Query method for game returns all games ordered by playTime
   *
   * @return
   */
  @Query("SELECT * FROM game ORDER BY play_time ASC")
  @Transaction
  LiveData<List<GameWithUser>> selectByPlayTime();

  /**
   * Query method for game returns all games ordered by attempts
   *
   * @return
   */
  @Query("SELECT * FROM game ORDER BY attempts ASC")
  @Transaction
  LiveData<List<GameWithUser>> selectByAttempts();

  /**
   * Query method for game returns all games ordered by difficulty
   *
   * @return
   */
  @Query("SELECT * FROM game ORDER BY difficulty ASC")
  @Transaction
  LiveData<List<GameWithUser>> selectByDifficulty();

  /**
   * Query method for game returns all games ordered by timestamp
   *
   * @return
   */
  @Query("SELECT * FROM game ORDER BY timestamp ASC")
  @Transaction
  LiveData<List<GameWithUser>> selectByTimestamp();

}

