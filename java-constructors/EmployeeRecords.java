public class EmployeeRecords {
    static class Employee {
        public String employeeID;
        
        protected String department;
        
        private double salary;
        
        public Employee(String employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }
        
        public void setSalary(double salary) {
            if (salary > 0) {
                this.salary = salary;
                System.out.println("Salary updated to: $" + String.format("%.2f", salary));
            } else {
                System.out.println("Invalid salary amount!");
            }
        }
        
        public double getSalary() {
            return salary;
        }
        
        public void giveRaise(double percentage) {
            if (percentage > 0) {
                double raise = salary * (percentage / 100);
                salary += raise;
                System.out.println("Salary increased by " + percentage + "%. New salary: $" + 
                                 String.format("%.2f", salary));
            }
        }
        
        public void displayEmployeeInfo() {
            System.out.println("Employee ID: " + employeeID + " (public access)");
            System.out.println("Department: " + department + " (protected access)");
            System.out.println("Salary: $" + String.format("%.2f", salary) + " (private - accessed internally)");
        }
    }
    
    static class Manager extends Employee {
        private String teamSize;
        private double bonus;
        
        public Manager(String employeeID, String department, double salary, String teamSize, double bonus) {
            super(employeeID, department, salary);
            this.teamSize = teamSize;
            this.bonus = bonus;
        }
        
        public void displayManagerDetails() {
            System.out.println("=== Manager Details ===");
            System.out.println("Employee ID: " + employeeID + " (public - inherited and accessible)");
            System.out.println("Department: " + department + " (protected - accessible in subclass)");
            System.out.println("Base Salary: $" + String.format("%.2f", getSalary()) + " (private - accessed via public method)");
            System.out.println("Team Size: " + teamSize);
            System.out.println("Bonus: $" + String.format("%.2f", bonus));
            System.out.println("Total Compensation: $" + String.format("%.2f", getTotalCompensation()));
        }
        
        public double getTotalCompensation() {
            return getSalary() + bonus;
        }
        
        public void setBonus(double bonus) {
            this.bonus = bonus;
            System.out.println("Manager bonus updated to: $" + String.format("%.2f", bonus));
        }
        
        public void approveRaise(Employee employee, double percentage) {
            System.out.println("Manager " + employeeID + " from " + department + 
                             " department approved " + percentage + "% raise for employee " + employee.employeeID);
            employee.giveRaise(percentage);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Employee Records Management ===\n");
        
        Employee emp1 = new Employee("EMP001", "Software Development", 75000.00);
        
        System.out.println("Regular Employee:");
        emp1.displayEmployeeInfo();
        System.out.println("Accessing public employee ID directly: " + emp1.employeeID);
        
        System.out.println("\nUpdating employee salary:");
        emp1.setSalary(80000.00);
        emp1.giveRaise(5.0);
        
        System.out.println("\n" + "=".repeat(50));
        
        Manager manager1 = new Manager(
            "MGR001", 
            "Software Development", 
            120000.00, 
            "15 developers",
            15000.00
        );
        
        manager1.displayManagerDetails();
        
        System.out.println("\nManager operations:");
        manager1.setBonus(18000.00);
        manager1.setSalary(125000.00);
        manager1.displayManagerDetails();
        
        System.out.println("\nManager approving employee raise:");
        Employee emp2 = new Employee("EMP002", "Software Development", 70000.00);
        emp2.displayEmployeeInfo();
        manager1.approveRaise(emp2, 8.0);
        emp2.displayEmployeeInfo();
        
        System.out.println("\nDemonstrating access levels:");
        System.out.println("Manager's public employee ID: " + manager1.employeeID);
        System.out.println("Manager's total compensation: $" + String.format("%.2f", manager1.getTotalCompensation()));
    }
}