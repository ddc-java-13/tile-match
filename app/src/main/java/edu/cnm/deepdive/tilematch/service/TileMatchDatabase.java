package edu.cnm.deepdive.tilematch.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.tilematch.model.dao.GameDao;
import edu.cnm.deepdive.tilematch.model.dao.UserDao;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.entity.User;
import edu.cnm.deepdive.tilematch.service.TileMatchDatabase.Converters;
import java.util.Date;

/**
 * TileMatchDatabase extends room database.
 */
@Database(
    entities = {User.class, Game.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class TileMatchDatabase extends RoomDatabase {

  private static final String DB_NAME = "tile-match-db";
  private static Application context;

  /**
   * Method for creating an instance of context for TileMatchDatabase.
   *
   * @param context
   */
  public static void setContext(Application context) {
    TileMatchDatabase.context = context;
  }

  /**
   * Getter for InstanceHolder for TileMatchDatabase.
   *
   * @return
   */
  public static TileMatchDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Getter for UserDao.
   *
   * @return
   */
  public abstract UserDao getUserDao();

  /**
   * Getter for GameDao.
   *
   * @return
   */
  public abstract GameDao getGameDao();

  private static class InstanceHolder {

    private static final TileMatchDatabase INSTANCE =
        Room.databaseBuilder(context, TileMatchDatabase.class, DB_NAME)
            .build();
  }

  /**
   * Subclass defines type converters.
   */
  public static class Converters {

    /**
     * Type converter for dato to long.
     *
     * @param value
     * @return
     */
    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    /**
     * Type converter for long to date.
     *
     * @param value
     * @return
     */
    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }

}
