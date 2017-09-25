import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {2,3,6,6,8,9,10,10,10,12,12};
		Set<Integer> temp = new HashSet<Integer>();
		for (int i = 0; i < input1.length; i++) {
			temp.add(input1[i]);
		}
		for (Integer integer : temp) {
			System.out.print(integer.intValue() + ",");
		}
	}
}
