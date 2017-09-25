
public class Task3 {
	public static void main(String[] args) {
		String oldString = new String("Here is an example of ordinary string.");
		String newString = reverse(oldString);
		System.out.println(newString);
	}
	
	
	public static String reverse(String oldString){
        char c = oldString.charAt(oldString.length()-1);
        
        if(oldString.length() == 1) {
        	return Character.toString(c);   
        }

        return c + reverse(oldString.substring(0,oldString.length()-1));
    }
}
