package edu.cnm.deepdive.tilematch.model.pojo;

public class Tile {

  private final String url;
  private State state = State.FACE_DOWN;

  public Tile(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }


  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public enum State {
    FACE_DOWN, MATCHING, FACE_UP
  }

}
