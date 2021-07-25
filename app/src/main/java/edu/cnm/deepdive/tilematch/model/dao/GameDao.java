package edu.cnm.deepdive.tilematch.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.pojo.GameWithUser;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface GameDao {

  @Insert
  Single<Long> insert(Game game);

  @Insert
  Single<List<Long>> insert(Game... games);

  @Insert
  Single<List<Long>> insert(Collection<? extends Game> games);

  @Update
  Single<Integer> update(Game game);

  @Update
  Single<Integer> update(Game... games);

  @Update
  Single<Integer> update(Collection<? extends Game> games);

  @Delete
  Single<Integer> delete(Game game);

  @Delete
  Single<Integer> delete(Game... games);

  @Delete
  Single<Integer> delete(Collection<? extends Game> games);

  @Query("SELECT * FROM game WHERE game_id = :gameId")
  LiveData<GameWithUser> selectByGameId(long gameId);

  @Query("SELECT * FROM game ORDER BY play_time ASC")
  LiveData<List<GameWithUser>> selectByPlayTime();

  @Query("SELECT * FROM game ORDER BY attempts ASC")
  LiveData<List<GameWithUser>> selectByAttempts();

  @Query("SELECT * FROM game ORDER BY difficulty ASC")
  LiveData<List<GameWithUser>> selectByDifficulty();

  @Query("SELECT * FROM game ORDER BY timestamp ASC")
  LiveData<List<GameWithUser>> selectByTimestamp();

}

