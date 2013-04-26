package net.zoldar.geocalc;

import java.util.Scanner;

import net.zoldar.geocalc.utils.QuitSignal;

public class GeoCalculatorRepl {
    private static final String PROMPT = "calculator >";
    private static final String RESULT_PREFIX = "    ";
    
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
        while (true) {
            try {
            	print(eval(read(s)));
            } catch (QuitSignal e) {
                break;
            } finally {
                s.close();
            }
        } 
    }
    
    private static String read(Scanner scanner) {
	System.out.print(PROMPT);
	String input = scanner.nextLine();
	return  input;
    }
    
    private static String eval(String input) {
	String result = ReplCommandHandler.handle(input);
	return result;
    }
    
    private static void print(String result) {
	System.out.println(RESULT_PREFIX+result);
    }
}
