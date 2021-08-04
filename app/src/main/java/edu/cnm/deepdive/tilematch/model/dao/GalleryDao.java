package edu.cnm.deepdive.tilematch.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public interface GalleryDao {

  @Insert
  Single<Long> insert(Image image);

  @Insert
  Single<List<Long>> insert(Image... image);

  @Insert
  Single<List<Long>> insert(Collection<? extends Image> gallery);

  @Update
  Single<Integer> update(Image image);

  @Update
  Single<Integer> update(Image... image);

  @Update
  Single<Integer> update(Collection<? extends Image> gallery);

  @Delete
  Single<Integer> delete(Image image);

  @Delete
  Single<Integer> delete(Image... image);

  @Delete
  Single<Integer> delete(Collection<? extends Game> games);


}
