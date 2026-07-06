import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put("C001", "Aditya Sharma");
        customers.put("C002", "Riya Verma");
        customers.put("C003", "Karan Mehta");
    }

    @Override
    public String findCustomerById(String id) {
        return customers.getOrDefault(id, "Customer not found");
    }
}
