package streams.Lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MergeMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     MergeMaps mm = new MergeMaps();
     mm.LoadDAtaInMaps();
     
     Map<String,Employee> map3 = new HashMap<>(map1);
     
     map2.forEach((key,value) -> map3.merge(key, value, (v1,v2) -> new Employee(v1.getId(), v2.getName())));
		
     map3.forEach((key,val) ->  System.out.println( key +  "  Map2 " + val.getName() + " -" + val.getId()));
     
     Map<String,Employee> map4 = map2.entrySet().stream().collect(
    		 Collectors.toMap( Map.Entry :: getKey, Map.Entry :: getValue, (v1,v2) ->  new Employee(v1.getId(), v2.getName()),
    				 () -> new HashMap<>(map1)));
     
     map3.forEach((key,val) ->  System.out.println( key +  "  Map4 " + val.getName() + " -" + val.getId()));
     		 
     
     List<List<Integer>> all = new ArrayList<List<Integer>>();
     
     
    				 
	}

	private static Map<String, Employee> map1 = new HashMap<>();
	private static Map<String, Employee> map2 = new HashMap<>();
	
	private void LoadDAtaInMaps()
	{
		Employee employee1 = new Employee(1L, "Henry");
		map1.put(employee1.getName(), employee1);
		Employee employee2 = new Employee(22L, "Annie");
		map1.put(employee2.getName(), employee2);
		Employee employee3 = new Employee(8L, "John");
		map1.put(employee3.getName(), employee3);
		 
		Employee employee4 = new Employee(2L, "George");
		map2.put(employee4.getName(), employee4);
		Employee employee5 = new Employee(3L, "Henry");
		map2.put(employee5.getName(), employee5);
	}
}
