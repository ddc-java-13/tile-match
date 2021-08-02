package edu.cnm.deepdive.tilematch.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public interface GalleryDao {

  @Insert
  Single<Long> insert(Gallery gallery);

  @Insert
  Single<List<Long>> insert(Gallery... gallery);

  @Insert
  Single<List<Long>> insert(Collection<? extends Gallery> gallery);

  @Update
  Single<Integer> update(Gallery gallery);

  @Update
  Single<Integer> update(Gallery... gallery);

  @Update
  Single<Integer> update(Collection<? extends Gallery> gallery);

  @Delete
  Single<Integer> delete(Gallery gallery);

  @Delete
  Single<Integer> delete(Gallery... gallery);

  @Delete
  Single<Integer> delete(Collection<? extends Game> games);


}
