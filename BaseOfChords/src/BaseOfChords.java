import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Добавить команду для вывода списка доступных треков(опционально) */
public class BaseOfChords {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        int runner = 0;
        int runnerAnswer = 0;
        int runnerChord = 0;
        int runnerSong = 0;
        int runnerPlaylist = 0;

        String addressChords = "Chords";
        String addressSongs = "Songs";

        System.out.println("Choose the mode: chords or songs - 1 or 2");

        while (runner < 1) {
            String input = in.nextLine();
            if (input.equals("1")) {
                System.out.println("Mode:chords");
                System.out.println("Enter the name of the chord.");
                while (runnerChord < 1) {
                    String chordName = in.nextLine();
                    File chords[] = new File(addressChords).listFiles();
                    File chordFound = null;
                    for (int i = 0; i < chords.length && chordFound == null; i++) {
                        if (chords[i].getName().split(".txt")[0].equals(chordName)) {
                            chordFound = chords[i];
                        }
                    }
                    if (chordFound != null) {
                        Scanner out = new Scanner(chordFound);
                        while (out.hasNextLine()) {
                            System.out.println(out.nextLine());
                        }
                    } else {
                        System.out.print("Chord not found. ");
                        System.out.println("Try again.");
                        continue;
                    }
                    runnerChord++;
                }
            } else if (input.equals("2")) {
                System.out.println("Mode: Songs");
                System.out.println("Enter the name of the song or check playlist - 1 or 2");
                int choise = in.nextInt();
                in.nextLine();
                if (choise == 1) {
                    System.out.println("Do you know the singer / the group ?");
                    System.out.println("y/n ?");

                    while (runnerAnswer < 1) {
                        String answer = in.nextLine();
                        if (answer.equals("y") || answer.equals("Y")) {
                            System.out.println("Enter in this order:<singer>(space)(dash)(space)<the name of the song> (without the quotes)");
                            System.out.println("Example:Eminem - Rap God");
                            while (runnerSong < 1) {
                                String songNameFile = in.nextLine();
                                String songName = songNameFile.toLowerCase();
                                String[] song = songName.split(" - ");
                                File songs[] = new File(addressSongs).listFiles();
                                File songFound = null;
                                for (int i = 0; i < songs.length && songFound == null; i++) {
                                    if (songs[i].getName().toLowerCase().split(".txt")[0].split(" - ")[0].equals(song[0]) && songs[i].getName().toLowerCase().split(".txt")[0].split(" - ")[1].equals(song[1])) {
                                        songFound = songs[i];
                                    }
                                }
                                if (songFound != null) {
                                    Scanner out = new Scanner(songFound);
                                    while (out.hasNextLine()) {
                                        System.out.println(out.nextLine());
                                    }
                                } else {
                                    System.out.print("Song not found. ");
                                    System.out.println("Try again.");
                                    continue;
                                }
                                runnerSong++;
                            }
                        } else if (answer.equals("n") || answer.equals("N")) {
                            System.out.println("Enter in this order:<the name of the song> (without the quotes)");
                            System.out.println("Example:Rap God");
                            while (runnerSong < 1) {
                                String songNameFile = in.nextLine();
                                String songName = songNameFile.toLowerCase();
                                File songs[] = new File(addressSongs).listFiles();
                                File songFound = null;
                                for (int i = 0; i < songs.length && songFound == null; i++) {
                                    if (songs[i].getName().toLowerCase().split(".txt")[0].split(" - ")[1].equals(songName)) {
                                        songFound = songs[i];
                                    }
                                }
                                if (songFound != null) {
                                    Scanner out = new Scanner(songFound);
                                    while (out.hasNextLine()) {
                                        System.out.println(out.nextLine());
                                    }
                                } else {
                                    System.out.print("Song not found. ");
                                    System.out.println("Try again.");
                                    continue;
                                }
                                runnerSong++;
                            }
                        } else {
                            System.out.println("Incorrect answer. Try again.");
                            continue;
                        }
                        runnerAnswer++;
                    }
                } else if (choise == 2) {

                    File songs[] = new File(addressSongs).listFiles();
                    for (int i = 0; i < songs.length; i++) {
                        System.out.println(songs[i].getName().split(".txt")[0]);
                    }
                    System.out.println();
                    System.out.println("choose the song : enter only song's name");
                    while (runnerPlaylist < 1) {
                        String songInput = in.nextLine().toLowerCase();
                        File songFound = null;
                        for (int i = 0; i < songs.length && songFound == null; i++) {
                            if (songs[i].getName().toLowerCase().split(".txt")[0].split(" - ")[1].equals(songInput)) {
                                songFound = songs[i];
                            }
                        }
                        if (songFound != null) {
                            Scanner out = new Scanner(songFound);
                            while (out.hasNextLine()) {
                                System.out.println(out.nextLine());
                            }
                        } else {
                            System.out.print("Song not found. ");
                            System.out.println("Try again.");
                            continue;
                        }
                        runnerPlaylist++;
                    }
                }
            } else {
                System.out.println("Incorrect input. Try again.");
                continue;
            }
            runner++;
        }
    }
}	