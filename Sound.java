import org.code.theater.*;
import org.code.media.*;

/*
 * The Sound class represents an audio file used in the scene
 * It stores the file name of the sound and provides access to it
 */
public class Sound {
 /*
  * The file name of the sound
  */
  public String fileName;

  /*
   * Constructs a Sound object with the specified file name
   * @param fileName the name of the sound file
   */
  public Sound(String fileName) {
    this.fileName = fileName;
  }

  /*
   * Constructs a Sound object with an empty file name
   */
  public Sound() {
    this("");
  }

  /*
   * Returns the file name of the sound
   * @return the file name of the sound
   */
  public String getFileName() {
    return fileName;
  }
}