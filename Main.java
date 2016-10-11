//import java.io.*;


public class Main {

    public static void main(String[] args) {
        for (String s : args) {
            //System.out.println(s);
        }
        String turnsString = new String(args[0]);
        String turnsStringWithoutBrackets = turnsString.substring(1,turnsString.length()-1);
        String[] splitTurnsString = turnsStringWithoutBrackets.split(",");
        double[] base = new double[splitTurnsString.length];
        for (int i = 0; i < splitTurnsString.length; i++) {
            base[i] = Double.parseDouble(splitTurnsString[i]);
        }
        int iteration = Integer.parseInt(args[1]);
        boolean mirrored = Boolean.parseBoolean(args[2]);
        Fractal f = new Fractal(base,iteration,mirrored).setOptimalAngle().display();
    }
}
