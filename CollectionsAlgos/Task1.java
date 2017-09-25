import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
	
	public static void main(String[] args) {
		Integer[] temp = {1,2,3,4,5,6,7,8,9,10};
		List<Integer> list = Arrays.asList(temp);
		list = revert(list);
		for(Integer integer : list) {
			System.out.println(integer.intValue());
		}

	}

	private static List<Integer> revert(List<Integer> list) {
		List<Integer> temp = new LinkedList<Integer>();
		for(int i = list.size()-1; i >= 0; i--) {
			temp.add(list.get(i));
		}
		return temp;
	}
}