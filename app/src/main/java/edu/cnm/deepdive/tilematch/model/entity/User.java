package edu.cnm.deepdive.tilematch.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * User entity class.
 */
@Entity()
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;


  @NonNull
  @ColumnInfo(name = "first_name")
  private String firstName;


  @NonNull
  @ColumnInfo(name = "last_name")
  private String lastName;

  @NonNull
  private Date timestamp;


  /**
   * Getter for User id.
   *
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * Setter for User id.
   *
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Getter for User first name.
   *
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Setter for User first name.
   *
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Getter for User last name.
   *
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Setter for User last name.
   *
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Getter for User timestamp.
   *
   * @return
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Setter for User timestamp.
   *
   * @param timestamp
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

}

