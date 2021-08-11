package edu.cnm.deepdive.tilematch.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * GalleryDao defines CRUD operations for gallery.
 */
public interface GalleryDao {

  /**
   * Single insert method for gallery.
   *
   * @param image
   * @return
   */
  @Insert
  Single<Long> insert(Image image);

  /**
   * Varargs insert method for gallery.
   *
   * @param image
   * @return
   */
  @Insert
  Single<List<Long>> insert(Image... image);

  /**
   * Collections insert method for gallery.
   *
   * @param gallery
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<? extends Image> gallery);

  /**
   * Single update method for gallery.
   *
   * @param image
   * @return
   */
  @Update
  Single<Integer> update(Image image);

  /**
   * Varargs update method for gallery.
   *
   * @param image
   * @return
   */
  @Update
  Single<Integer> update(Image... image);

  /**
   * Collections update method for gallery.
   *
   * @param gallery
   * @return
   */
  @Update
  Single<Integer> update(Collection<? extends Image> gallery);

  /**
   * Single delete method for gallery.
   *
   * @param image
   * @return
   */
  @Delete
  Single<Integer> delete(Image image);

  /**
   * Varargs delete method for gallery.
   *
   * @param image
   * @return
   */
  @Delete
  Single<Integer> delete(Image... image);

  /**
   * Collections delete method for gallery.
   *
   * @param games
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<? extends Game> games);


}
