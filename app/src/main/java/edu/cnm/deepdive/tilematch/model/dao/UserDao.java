package edu.cnm.deepdive.tilematch.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.tilematch.model.entity.User;
import edu.cnm.deepdive.tilematch.model.pojo.UserWithGames;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * UserDao defines CRUD operations for user.
 */
@Dao
public interface UserDao {

  /**
   * Single insert method for user.
   * @param user
   * @return
   */
  @Insert
  Single<Long> insert(User user);

  /**
   * Varargs insert method for user.
   * @param users
   * @return
   */
  @Insert
  Single<List<Long>> insert(User... users);

  /**
   * Collection insert method for user.
   * @param users
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<? extends User> users);

  /**
   * Single update method for user.
   * @param user
   * @return
   */
  @Update
  Single<Integer> update(User user);

  /**
   * Varargs update method for user.
   * @param users
   * @return
   */
  @Update
  Single<Integer> update(User... users);

  /**
   * Collection update method for user.
   * @param users
   * @return
   */
  @Update
  Single<Integer> update(Collection<? extends User> users);

  /**
   * Single delete method for user.
   * @param user
   * @return
   */

  @Delete
  Single<Integer> delete(User user);

  /**
   * Varargs delete method for user.
   * @param users
   * @return
   */

  @Delete
  Single<Integer> delete(User... users);

  /**
   * Collection delete method for user.
   * @param users
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<? extends User> users);

  /**
   * Query method for user returns all users by userId
   * @param userId
   * @return
   */
  @Transaction
  @Query("SELECT * FROM user WHERE user_id = :userId")
  LiveData<UserWithGames> select(long userId);

}

