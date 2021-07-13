package edu.cnm.deepdive.tilematch.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = Game.class,
    parentColumns = "game_id",
    childColumns = "id"),
    indices = {@Index(value = {"image_id", "image_name"},
    unique = true)})
public class Image {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "image_id")
  private long id;

  @ColumnInfo(name = "image_name")
  private String imageName;

  @ColumnInfo(name = "image_location")
  private String imageLocation;

  @ColumnInfo(name = "image_position")
  private long imagePosition;

  private Date timestamp;

  public enum State {
    FACE_UP, FACE_DOWN
  }

  @ColumnInfo(name = "game_id")
  private long gameId;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public String getImageLocation() {
    return imageLocation;
  }

  public void setImageLocation(String imageLocation) {
    this.imageLocation = imageLocation;
  }

  public long getImagePosition() {
    return imagePosition;
  }

  public void setImagePosition(long imagePosition) {
    this.imagePosition = imagePosition;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public long getGameId() {
    return gameId;
  }

  public void setGameId(long gameId) {
    this.gameId = gameId;
  }
}

