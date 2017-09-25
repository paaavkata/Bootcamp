import java.util.Arrays;
import java.util.List;

public class Task2 {
	
	public static void main(String[] args) {
		Integer[] temp = {1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1};
		Integer[] temp2 = {2,3,7,1,2,2};
		List<Integer> list = Arrays.asList(temp);
		boolean found = false;
		for(int i = 1; i < list.size()-1; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for(int j = 0; j<=i-1; j++) {
				sum1+=list.get(j);
			}
			for(int k = i+1; k < list.size(); k++) {
				sum2+=list.get(k);
			}
			if(sum1 == sum2) {
				System.out.println("The median is in " + i + "th position");
				found = true;
				break;
			}
			System.out.println("Iteration " + i + " " + sum1 + " " + sum2);
			sum1 = 0;
			sum2 = 0;
		}
		if(!found) {
			System.out.println("No median found");
		}
	}
}
