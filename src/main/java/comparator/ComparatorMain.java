package comparator;

import cache.LFUCache;

import java.util.*;

public class ComparatorMain {

    public static void main(String[] args) {

        ComparatorMain comparatorMain = new ComparatorMain();

        comparatorMain.print();

    }

    public void print() {

        Employee e1 = new Employee("firstName", 20);
        Employee e2 = new Employee("firstName", 20);
        Employee e3 = new Employee("firstName", 5);




        PriorityQueue<Employee> queue = new PriorityQueue<>(new EmployeeComparator());

        Set<Employee> set = new TreeSet<>(new EmployeeComparator());

        set.add(e1);
        set.add(e2);
        set.add(e3);




        queue.add(e1);
        queue.add(e2);
        queue.add(e3);
        queue.remove();

    }

    class Item {
        int key;
        int freq;

        public Item(int value, int freq ) {
            this.key = value;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if( key != item.key) return false;
            return freq == item.freq;

        }

        @Override
        public int hashCode() {

            int result = key;
            result = 31 * result + freq;
            return result;
        }
    }



    public class Employee {

        private String name;

        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return age == employee.age &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, age);
        }
    }

    public class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {

            if(o1.name.equalsIgnoreCase(o2.name) && o1.age == o2.age) {
                return 0;
            }

            return o1.age - o2.age;
        }
    }
}
