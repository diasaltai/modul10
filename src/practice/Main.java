package practice;
import java.util.ArrayList;
import java.util.List;

// Общий компонент

abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public abstract void displayHierarchy();
    public abstract double calculateBudget();
    public abstract int calculateStaffCount();
}

// Класс сотрудника

class Employee extends OrganizationComponent {
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        super(name);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void displayHierarchy() {
        System.out.println("Сотрудник: " + name + ", Должность: " + position + ", Зарплата: " + salary);
    }

    @Override
    public double calculateBudget() {
        return salary;
    }

    @Override
    public int calculateStaffCount() {
        return 1;
    }
}

// Класс департамента

class Department extends OrganizationComponent {
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public void displayHierarchy() {
        System.out.println("Департамент: " + name);
        for (OrganizationComponent component : components) {
            component.displayHierarchy();
        }
    }

    @Override
    public double calculateBudget() {
        double totalBudget = 0;
        for (OrganizationComponent component : components) {
            totalBudget += component.calculateBudget();
        }
        return totalBudget;
    }

    @Override
    public int calculateStaffCount() {
        int totalStaff = 0;
        for (OrganizationComponent component : components) {
            totalStaff += component.calculateStaffCount();
        }
        return totalStaff;
    }
}

// Клиентский код

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Али", "Менеджер", 1000);
        Employee employee2 = new Employee("Бека", "Разработчик", 800);
        Employee employee3 = new Employee("Сауле", "Бухгалтер", 900);

        Department itDepartment = new Department("IT-Отдел");
        itDepartment.add(employee1);
        itDepartment.add(employee2);

        Department financeDepartment = new Department("Финансовый отдел");
        financeDepartment.add(employee3);

        Department headOffice = new Department("Головной офис");
        headOffice.add(itDepartment);
        headOffice.add(financeDepartment);

        headOffice.displayHierarchy();
        System.out.println("Общий бюджет: " + headOffice.calculateBudget());
        System.out.println("Общее количество сотрудников: " + headOffice.calculateStaffCount());
    }
}