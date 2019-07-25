package streams.Lambdas;

public class Employee {

	  private Long id;
	    private String name;
		public Employee(long l, String string) {
			// TODO Auto-generated constructor stub
			id = l;
			name = string;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	    
}
