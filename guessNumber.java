import java.util.Random;
import java.util.Scanner;
class guessNumber{
    public static void main(String[] args){
Scanner sc = new Scanner(System.in);
Random random = new Random();

final int max_attempts = 5;
int randomNumber = random.nextInt(100)+1;
int attempts =0;

while (attempts<max_attempts) {
    System.out.println("Enter the number");
    int guess = sc.nextInt();
    attempts++;


    if (guess == randomNumber) {
        System.out.println("you guessed the correct number"+randomNumber);
    }
    else if (guess<randomNumber) {
        System.out.println("too low");
        
    }
    else{

        System.out.println("too high");
        
    }
    
    
}
 

if (attempts==max_attempts) {
    System.out.println("sorry you have reached maximum limit. the random number is = "+randomNumber);
    
}
sc.close();

    }
}