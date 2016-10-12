# Java-Fractal-Generator
Generate fractal based on:       
 * base pattern: an array of turns in degrees that form a line.  
    - eg: [90] is a single turn, looks like (L).
 * iteration number: integer value, 0 is initial pattern, 17 is the highest I have ever used
 * mirrored: boolean
    - true -> pattern is mirrored, good for patterns with turns in one direction like [90,90]
    - false -> pattern isn't mirrored
    - try out both to make cool patterns
 
How to use:
  1. Compile the .java files. I like to use the terminal command "javac *.java" in the main directory.
  2. Run the program using "java Main [pattern] iteration mirrored"
      * eg: java Main [90,-90,30] 7 true
        * This would make a fractal with a base of 90, -90, 30 of 7 iterations that is generated using mirroring.
      * note: When typing the base pattern, enclose the list **must** have braces and **cannot** include spaces.
