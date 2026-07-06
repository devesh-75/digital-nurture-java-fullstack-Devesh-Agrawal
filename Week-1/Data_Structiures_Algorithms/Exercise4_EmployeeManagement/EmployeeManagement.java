public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagement system = new EmployeeManagement(10);

        system.addEmployee(new Employee("E001", "Ananya Rao", "Software Engineer", 65000));
        system.addEmployee(new Employee("E002", "Vikram Singh", "Product Manager", 85000));
        system.addEmployee(new Employee("E003", "Meera Iyer", "QA Analyst", 55000));

        System.out.println("All employees:");
        system.traverseEmployees();

        Employee found = system.searchEmployee("E002");
        System.out.println("Search result: " + found);

        system.deleteEmployee("E001");
        System.out.println("After deletion:");
        system.traverseEmployees();
    }
}
