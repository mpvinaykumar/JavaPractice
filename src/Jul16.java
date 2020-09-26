import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Jul16 {

	public static void main(String[] args) {
		IntStream iStream = IntStream.range(1, 4);
		List<Integer> list1 = iStream.boxed().collect(Collectors.toList());// error!
		list1.add(123);

		list1.forEach(System.out::println);
		
		HashSet<String> hash = new HashSet<String>();
		
		hash.add(new String("vinay"));
		hash.add(new String("vinay"));
		hash.add("Vinay");
		
		System.out.println(hash.size());
		System.out.println(new String("vinay").hashCode());
		System.out.println(new String("vinay").hashCode());
		System.out.println("vinay".hashCode());
		
		char[] charAr1 = "VinviN".toCharArray();
		Arrays.sort(charAr1);
		System.out.println(charAr1);
		

		Integer[] myInts = {1,2,3,4};
		Number[] myNumber = myInts;
		
		System.out.println(Arrays.deepToString(myNumber));

	}
}

