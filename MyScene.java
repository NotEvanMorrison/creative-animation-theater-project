import org.code.theater.*;
import org.code.media.*;
/*
 * The MyScene class is a custom Scene that displays a series of guitar chords for the song Kiss Me
 */
public class MyScene extends Scene {
  private Chord[] allChords;   // Instance Variables

/*
 * Constructs a MyScene object and uses chord data from Kiss Me
 */
public MyScene() {
    allChords = createChordArray();
  }


 /*
  * Reads the KissMeCords.txt which has all of the chord information(its location and name) 
  * Converts it into an array of Chord objects
  * @return an array of Chord objects created from the text file "KissMeCords.txt"
  */  
  private Chord[] createChordArray() {
    String[] stringChords = FileReader.toStringArray("KissMeCords.txt");
    Chord[] returnArray = new Chord[stringChords.length];
    int index = 0;
    
   for (String chord : stringChords) {
      String[] chordData = chord.split(" ");
      String chordName = chordData[0];
      
      String[] chordArray = new String[chordData.length - 1];
      for (int i = 0; i < chordArray.length; i++) {
        if (i + 1 < chordData.length) {  // Make sure we don't go out of bounds
          chordArray[i] = chordData[i + 1];
        }
      }
      
      Chord newChord = new Chord(chordArray, chordName);
      returnArray[index] = newChord;
      index++;
    }
    return returnArray;
  }

 /*
  * Goes through all the chords and displays each in the theater
  * Draws the fretboard, chord name, and finger positions each scene and then has a transition sound effect
  */   
  public void drawAllChord() {
  for (Chord chord : allChords) {
    clear("white");
    drawImage("fretboard.png", 0, 200, 400);
    drawText(chord.getName(), 50, 100);
    String[] chordData = chord.getChord();
    if (chordData.length > 0) {
      for (int i = 0; i < chordData.length; i++) {
        String[] fingerPosition = chordData[i].split(",");
        int fingerX = Integer.parseInt(fingerPosition[0]);
        int fingerY = Integer.parseInt(fingerPosition[1]);
        drawEllipse(fingerX, fingerY, 10, 10);
        if (chord.getName().equals("Bm")) {
          drawBar();
        }
      }
    }

 playSound("swoosh.wav"); // Play swoosh sound effect
    
    pause(1.0);
  }
}

  /*
   * Draws a rectangle for chords that need a barre chord (this one is Bm) aka one 
   * finger covering multiple strings
   */
  private void drawBar() {
    drawRectangle(21, 210, 10, 74);
  }


  /*Original chord testing module we developed with the help of Mr. Aiello, 
   *used for individual chord testing purpose not an official part of the project 
   */ 
  //    public void drawTestChord() {
  //   drawImage("fretboard.png", 0, 200, 400);
  //   String chordD = "Asus4 52,259 82,230 52,245";
  //   String[] chordData = chordD.split(" ");
  //   String chordName = chordData[0];
  //   drawText(chordName, 50, 100);
  //   for (int i = 1; i < chordData.length; i++) {
  //     String[] fingerPosition = chordData[i].split(",");
  //     int fingerX = Integer.parseInt(fingerPosition[0]);
  //     int fingerY = Integer.parseInt(fingerPosition[1]);
  //     drawEllipse(fingerX, fingerY, 10, 10);
  //   }
  // }
}