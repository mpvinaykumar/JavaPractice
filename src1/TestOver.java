import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestOver {
	public Map<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>();
	int[] array = { 121, 122, 121, 122, 123, 121, 122 };

	public void method1() {
		for (int i = 0; i < array.length; i++) {
			if (map1.get(array[i]) == null) { // no entry available
				List<Integer> list = new ArrayList<Integer>();
				list.add(array[i]);
				map1.put(array[i], list);
			} else
				// entry is already available
				map1.get(array[i]).add(array[i]);
		}

		for (Entry<Integer, List<Integer>> map : map1.entrySet()) {
			System.out.println(map.getKey());
			System.out.println(map.getValue().size());
		}
	}

	public static void main(String[] args) {
		TestOver to = new TestOver();
		to.method1();
	}

}
