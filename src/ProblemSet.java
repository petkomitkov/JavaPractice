import java.util.Arrays;

public class ProblemSet {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		System.out.println(kthMin(arr,3));
	
		
	}
	
	//1
	public static boolean isOdd(int number) {
		return (number % 2) == 1;
	}
	
	//2
	public static boolean isPrime(int number) {
		
		//Izpolzvame teoremata na Wilson, koqto glasi che p e prosto togava i samo togava kogato p deli (p-1)! + 1.Tova e baven algoritam.Po burzo e ot 1 do sqrt(number) da vidim dali se delqt na p.
			
		int fact = factorial(number - 1); //Pravim otdelna funkciq za smqtane na faktoriel.
		return (fact + 1) % number == 0;
		
	}
	
	//3
	public static int min(int[] sequence) {
		int minSoFar = Integer.MAX_VALUE;
		
		for(int index = 0;index < sequence.length;index++) {
			
			if(sequence[index] < minSoFar) {
				minSoFar = sequence[index];
			}
		}
		
		return minSoFar;
	}
	
	//4
	public static int kthMin(int[] sequence, int k) {
	
		// Shte sortirame masiva zashtoto inache ne znam kak tr da stane.
		// Nqma da pravim proverka za pravilen vhod  (sequence.length >= k) tui kato povtoreniqta q pravqt bezsmislena.
		java.util.Arrays.sort(sequence);
		int currentMinCount = 1;
		
		if(k == 1) {
			return sequence[0];
		}
		
		for(int index = 1;;index++) {
			
			if(sequence[index] != sequence[index-1]) {
				currentMinCount++;
			}
			
			if(currentMinCount == k) {
				return sequence[index];
			}
		}
	}
	
	//5
	public static int getAverage(int[] sequence) {
		int seqSum = sum(sequence); // pravim suma za sbor na elementite ot tip int
		
		return seqSum / sequence.length;
	}
	
	//6
	public static int doubleFac(int number) {
		
		return factorial(factorial(number)); // izpolzvame funkciqta definirana za prednata zadacha.
	}
	
	//7
	public static int kthFac(int number, int k) {
		
		int accumulator = factorial(number);
		
		for(int ord  = 1;ord < k;ord++) {
			accumulator = factorial(factorial(accumulator));
		}
		
		return accumulator;
	}
	
	public static int factorial(int number) {
		int accumulator = 1;
		
		for(int numbertoMultiply = 1;numbertoMultiply <= number;numbertoMultiply++){
			accumulator = accumulator * numbertoMultiply;
		}
		
		return accumulator;
	}
	
	public static int sum(int[] sequence) {
		int acc = 0;
		
		for(int index = 0;index < sequence.length;index++) {
			
			acc += sequence[index];
		}
		
		return acc;
	}
}
