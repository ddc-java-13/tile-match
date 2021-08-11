package edu.cnm.deepdive.tilematch.model.pojo;

/**
 * Tile class.
 */
public class Tile {

  private final String url;
  private State state = State.FACE_DOWN;

  /**
   * Tile url.
   *
   * @param url
   */
  public Tile(String url) {
    this.url = url;
  }

  /**
   * String form of tile url.
   *
   * @return
   */
  public String getUrl() {
    return url;
  }

  /**
   * Tile game state.
   *
   * @return
   */
  public State getState() {
    return state;
  }

  /**
   * Setter for Tile state.
   *
   * @param state
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * Tile stats enum.
   */
  public enum State {
    FACE_DOWN, MATCHING, FACE_UP
  }

}
