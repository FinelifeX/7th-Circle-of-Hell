import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project {
	
	public static void main(String [] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		Scanner chord = new Scanner(new File ("The names of the chords.txt"));		
		Scanner song = new Scanner (new File ("Song-Names.txt"));
		
		int checkerChord = 0;
		int checkerSong = 0;
		int runner = 0;
		int runnerSong = 0;
		
		System.out.println("Choose the mode: accords(chords) or songs - 1 or 2");
		while(runner < 1) {
			String input = in.nextLine();
			input = input.toLowerCase();
			if(input.equals("1")) {
				System.out.println("Mode: Accords/chords");
				System.out.println("Enter the name of the accord/chord.");
				String chordName = in.nextLine();
				String chordNameScanner = "";			
				do {	
					chordNameScanner = chord.nextLine();
					if(chordName.equals(chordNameScanner)) {
						chordName += ".txt";
						Scanner chordOutput = new Scanner (new File (chordName));
						checkerChord += 1;
						while(chordOutput.hasNextLine()) {
							String outputChord = chordOutput.nextLine();
							System.out.println(outputChord);
						}
						break;	
					}
					else continue;				
				}
				while(chord.hasNextLine());
				if (checkerChord == 0) System.out.println("Chord not found");
			
			}
			else if(input.equals("2")) {				
				System.out.println("Mode: Songs");
				System.out.println("Enter the name of the song.");
				System.out.println("Do you know the singer / the group ?");
				System.out.println("y/n ?");
				while(runnerSong < 1) {
					String answer = in.nextLine();
					if(answer.equals("y")) {
						System.out.println("Enter in this order:<singer>(space)(dash)(space)<the name of the song> (without the quotes)");
						System.out.println("Example:Eminem - Rap God");
						String songNameFile = in.nextLine();
						String songName = songNameFile.toLowerCase();
						String [] strings = songName.split(" - ");					
						String songNameScanner = "";					
						do {
							songNameScanner = song.nextLine().toLowerCase();						
							String [] songChecker = songNameScanner.split(" - ");
							if((strings[0].equals(songChecker[0]) && strings[1].equals(songChecker[1])) || (strings[1].equals(songChecker[1])) ) {
								songNameFile += ".txt";
								Scanner songOutput = new Scanner(new File (songNameFile));
								checkerSong += 1;
								while(songOutput.hasNextLine()) {
									System.out.println("");
									String outputSong = songOutput.nextLine();
									System.out.println(outputSong);
								}
								break;				
							}
							else continue;			
						}
						while(song.hasNextLine());	
						if(checkerSong == 0) System.out.println("Song not found");					
					}
					else if(answer.equals("n")) {
						System.out.println("Enter in this order:<the name of the song> (without the quotes)");
						System.out.println("Example:Rap God");
						String songNameFile = in.nextLine();
						String songName = songNameFile.toLowerCase();					
						String songNameScanner = "";					
						do {
							songNameScanner = song.nextLine().toLowerCase();
							String [] songChecker = songNameScanner.split(" - ");						
							if(songName.equals(songChecker[1])) {
								songNameFile += ".txt";
								Scanner songOutput = new Scanner(new File (songNameFile));
								checkerSong += 1;
								while(songOutput.hasNextLine()) {
									System.out.println("");
									String outputSong = songOutput.nextLine();
									System.out.println(outputSong);
								}
								break;				
							}
							else continue;			
						}
						while(song.hasNextLine());	
						if(checkerSong == 0) System.out.println("Song not found");					
					}
					else {
						System.out.println("Incorrect answer. Try again.");
						continue;
					}
					runnerSong++;
				}
			}
			else {
				System.out.println("Incorrect input. Try again.");
				continue;
			}
			runner++;
		}
	}	
}	