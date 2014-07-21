
public class updateBit {

	public static int update(int num, int i, int v){
		int mask = ~( 1 << i);
		return (num & mask) | ( v << i);
	}
	
	public static void main(){
		System.out.println(update(10, 3, 5));
	}
}
