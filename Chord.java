import org.code.theater.*;
import org.code.media.*;

/**
 * The Chord class represents a musical chord that includes a name, 
 * an array of finger positions, and optionally, a sound file.
 *
 * It extends the Sound class to incorporate audio playback functionality.
 */
public class Chord extends Sound {

  /**
   * An array of strings representing the finger positions on the fretboard.
   */
  private String[] chord;

  /*
   * The name of the chord
   */
  private String name;

  /*
   * Constructs a Chord with a name and finger positions but no associated sound file.
   * The sound file name is initialized as an empty string
   *
   * @param chord an array of finger position strings
   * @param name  the name of the chord
   */
  public Chord(String[] chord, String name) {
    super();
    this.chord = chord;
    this.name = name;
  }

  /*
   * Constructs a Chord with a name, finger positions, and a specific sound file.
   *
   * @param fileName the file name of the chord's sound
   * @param chord    an array of finger position strings
   * @param name     the name of the chord
   */
  public Chord(String fileName, String[] chord, String name) {
    super(fileName);
    this.chord = chord;
    this.name = name;
  }

  /*
   * Returns the array of finger positions for the chord.
   *
   * @return an array of strings representing finger positions
   */
  public String[] getChord() {
    return chord;
  }

  /*
   * Returns the name of the chord.
   *
   * @return the chord's name
   */
  public String getName() {
    return name;
  }
}
