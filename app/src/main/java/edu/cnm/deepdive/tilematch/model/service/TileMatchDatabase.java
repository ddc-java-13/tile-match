package edu.cnm.deepdive.tilematch.model.service;

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
import edu.cnm.deepdive.tilematch.model.service.TileMatchDatabase.Converters;
import java.util.Date;

@Database(
    entities = {User.class, Game.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class TileMatchDatabase extends RoomDatabase {

  private static final String DB_NAME = "tile-match-db";
  private static Application context;

  public static void setContext(Application context) {
    TileMatchDatabase.context = context;
  }

  public static TileMatchDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract UserDao getGameDao();

  public abstract GameDao getGuessDao();

  private static class InstanceHolder {
    private static final TileMatchDatabase INSTANCE =
        Room.databaseBuilder(context, TileMatchDatabase.class, DB_NAME)
            .build();
  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }

}
