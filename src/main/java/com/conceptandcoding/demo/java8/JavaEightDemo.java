package com.conceptandcoding.demo.java8;

import java.util.*;
import java.util.stream.Collectors;

public class JavaEightDemo implements I1, I2 {

    public void display() {
        I1.super.display();
    }

    public static void main(String[] args) {
        /* List<String> list = Arrays.asList("Hello", "World");
        list.stream().map(l -> l.toLowerCase()).limit(2).skip(1).peek(ele -> System.out.println(ele))
                .forEach(System.out::println); */
        /*
         * List<List<Integer>>
         * mobileNums=Arrays.asList(Arrays.asList(123,1233),Arrays.asList(788,98));
         * mobileNums.stream().flatMap(nums->nums.parallelStream()).forEach(System.out::
         * println);
         * List<Integer> nums=Arrays.asList(7,9);
         * int sum = nums.stream().reduce(0, Integer::sum);
         * 
         */

        /*
         * JavaEightDemo demo = new JavaEightDemo();
         * demo.display();
         */ 


          List<Employee> employees = Arrays.asList(new Employee("Rishikesh", "IT",100), new
          Employee("Pawan", "IT",200),
          new Employee("Kumar", "Networking",300));
       Map<String, Optional<Employee>> result =
    employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        ));

        List<Integer> list = Arrays.asList(1,5,3,9,10);

        Map<Boolean, List<Integer>> results =
    list.stream()
        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(results);
         employees.stream()
    .sorted(Comparator.comparing(Employee::getDept)
        .thenComparing(Employee::getSalary, Comparator.reverseOrder()))
    .toList();

        /*
         * Top 5 highest transactions
         * Sum of transactions per user
         * Filter failed transactions
         */

        /* List<Transaction> transactions = Arrays.asList(new Transaction("Rishikesh", 100, "SUCCESS"),
                new Transaction("Pawan", 200, "FAILED"),
                new Transaction("Rishikesh", 300, "FAILED"),
                new Transaction("Pawan", 400, "SUCCESS"),
                new Transaction("Vatsal", 500, "SUCCESS"),
                new Transaction("SVN", 600, "SUCCESS")); */

        /*
         * List<Transaction> tran = transactions.stream().sorted((t1, t2) ->
         * t2.getAmount() - t1.getAmount()).limit(5)
         * .collect(Collectors.toList());
         */
        /*
         * Map<String, Double> map = transactions.stream()
         * .collect(Collectors.groupingBy(Transaction::getUser,
         * Collectors.summingDouble(Transaction::getAmount)));
         * System.out.println(map);
         * 
         * transactions.stream().filter(tr ->
         * tr.getStatus().equals("FAILED")).forEach(System.out::println);
         */
       /*  List<Integer> nums = List.of(1, 2, 3, 4, 2, 3, 5);

        nums.stream().filter(n -> Collections.frequency(transactions, n) > 1).collect(Collectors.toList());

        Set<Integer> seen = new HashSet<>();
        List<Integer> l = nums.stream().filter(n -> !seen.add(n)).collect(Collectors.toList());
        l.stream().forEach(System.out::println); */

    }

}

class Transaction {
    String user;
    int amount;
    String status; // SUCCESS / FAILED

    public Transaction(String user, int amount, String status) {
        this.user = user;
        this.amount = amount;
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction [user=" + user + ", amount=" + amount + ", status=" + status + "]";
    }

}

class Employee {
    String name;
    String dept;
    int salary;

    public Employee(String name, String dept,int salary) {
        this.name = name;
        this.dept = dept;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    
    @Override
    public String toString() {
        return "Employee [name=" + name + ", dept=" + dept + "]";
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}

interface I1 {

    default void display() {
        System.out.println("Inside I1");
    }
}

interface I2 {

    default void display() {
        System.out.println("Inside I2");
    }
}
