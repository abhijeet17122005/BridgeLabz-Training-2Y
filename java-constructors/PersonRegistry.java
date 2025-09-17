public class PersonRegistry {
    static class Person {
        private String name;
        private int age;
        
        public Person() {
            this.name = "Unknown";
            this.age = 0;
        }
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public Person(Person other) {
            this.name = other.name;
            this.age = other.age;
        }
        
        public void displayPersonInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public void setAge(int age) {
            this.age = age;
        }
    }
    
    public static void main(String[] args) {
        Person originalPerson = new Person("Alice", 25);
        Person copiedPerson = new Person(originalPerson);
        
        System.out.println("Original Person:");
        originalPerson.displayPersonInfo();
        
        System.out.println("\nCopied Person:");
        copiedPerson.displayPersonInfo();
        
        copiedPerson.setName("Alice Copy");
        copiedPerson.setAge(26);
        
        System.out.println("\nAfter modifying copied person:");
        System.out.println("Original:");
        originalPerson.displayPersonInfo();
        System.out.println("Copy:");
        copiedPerson.displayPersonInfo();
    }
}