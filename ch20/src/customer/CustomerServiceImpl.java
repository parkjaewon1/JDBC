package customer;
public class CustomerServiceImpl {
	private static CustomerDaoImpl cd = new CustomerDaoImpl();
	public int insert(Customer customer) { // customer �Է��� ������
		int result = 0;
		Customer ct = cd.select(customer.getId()); // ct ��ȸ�� ������
		if (ct == null) {
			result = cd.insert(customer);
		} else System.out.println("�̹� �ִ� ������ �Դϴ�");
		return result;
	}
	public Customer select(String id) {
		return cd.select(id);
	}
}