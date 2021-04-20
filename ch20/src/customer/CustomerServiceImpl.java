package customer;
public class CustomerServiceImpl {
	private static CustomerDaoImpl cd = new CustomerDaoImpl();
	public int insert(Customer customer) { // customer 입력한 데이터
		int result = 0;
		Customer ct = cd.select(customer.getId()); // ct 조회한 데이터
		if (ct == null) {
			result = cd.insert(customer);
		} else System.out.println("이미 있는 데이터 입니다");
		return result;
	}
	public Customer select(String id) {
		return cd.select(id);
	}
}