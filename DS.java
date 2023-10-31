
package project;


import java.util.Scanner;
//creat the stucture of the node
class Node {
    int id;
    String name;
    String firstDay;
    int phone;
    String address;
    int workHours;
    double salary;
    Node next;

    public Node(int id, String name, String firstDay, int phone, String address, int workHours, double salary) {
        this.id = id;
        this.name = name;
        this.firstDay = firstDay;
        this.phone = phone;
        this.address = address;
        this.workHours = workHours;
        this.salary = salary;
        this.next = null;
    }
}
//make the head point to null
public class LinkedList {
    private Node head = null;

    public LinkedList(Node head) {
        this.head = head;
    }
//method to check if the employee id is exist or not
    private boolean IsExists(int id) {
        if (head == null) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.id == id) {
                return true;
            }
            current = current.next; }
        return false;
    }
//method to insert new employee in the list
    public void insert(int ID, String name, String FirstDay, int phoneNumber, String Address, int WorkHours, double salary) {
        if (IsExists(ID)) {
            System.out.println("Employee " + ID + " is already exists\n");
        } else {
            Node newNode = new Node(ID, name, FirstDay, phoneNumber, Address, WorkHours, salary);
            if (head == null || (head.id >= newNode.id)) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null && current.next.id < newNode.id) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            System.out.println("Employee inserted\n");
        }
    }
    // method to delete employee
    int delete(int id) {
//If there are no employees with this ID, the method will return -1 
        if (head == null) {
            System.out.println("Employee not found");
            return -1;
        }
// if the employee that want to delet it is the first one in the list, so the head will point to the next
        Node current = head;
        if (current.id == id) {
            head = current.next;
            System.out.println("Employee deleted");
            return 0;
        }

// If the employee is not the first one, the method will search for it
        while (current.next != null) {
            if (current.next.id == id) {
                current.next = current.next.next;
                System.out.println("Employee deleted");
                return 0;
            }
            current = current.next;
        }

// If the employee not in the list the method will return -1 
        System.out.println("Employee not found");
        return -1;
    }
    // Method to update an employee record
    void updateEmployee(int id) {
        Scanner scan = new Scanner(System.in);
        Node current = head;

        // if no employees in the list,will print error massage
        if (current == null) {
            System.out.println("There are no employees ");
            return;
        }
        //search for employee to update his record
        while (current != null) {
            if (current.id == id) {           
                System.out.println("enter number of record to updated ");
                System.out.println("1-Employee Phone number: " + current.phone);
                System.out.println("2- Employee Address: " + current.address);
                System.out.println("3- Employee Work hours: " + current.workHours);
                System.out.println("4- Employee salary: " + current.salary+"\n");

                int choice = scan.nextInt();
                //if choose 1 than will update emp phone number
                if (choice == 1) {
                    System.out.println("Enter the new phone number");
                    int phone = scan.nextInt();
                    current.phone = phone;
                //if choose 2 than will update emp address
                } else if (choice == 2) {
                    System.out.println("Enter the new address");
                    String address = scan.next();
                    current.address = address;
                //if choose 3 than will update emp work hours
                } else if (choice == 3) {
                    System.out.println("Enter the new work hours");
                    int hours = scan.nextInt();
                    if (hours < 32) {
                        System.out.println("Employee work hours should be more than 32 hours");
                        continue;
                    }
                    current.workHours = hours;
                //if choose 4 than will update emp salary
                } else if (choice == 4) {
                    System.out.println("Enter the new salary");
                    double salary = scan.nextDouble();
                    current.salary = salary;
                    //if the user choose wrong number
                } else {
                    System.out.println("wrong number,Please choose number form 1 to 4");
                    updateEmployee(id);
                    return;
                }
                System.out.println("Employee record is updated ");
                return;
            }
            current = current.next;
        }
        System.out.println("Employee not found");
    }
// method to show all employee in the list
    void Show() {
        Node current = head;
        int count = 1;
        if (current == null) {
            System.out.println("no employees in the list");
        } else {
            System.out.println("\t\tEmployee records\n" );
            System.out.print("---------------------------------------\n");
            while (current != null) {
                System.out.println("Employee:" + count);
                System.out.println("ID: " + current.id);
                System.out.println("Name: " + current.name);
                System.out.println("First Day: " + current.firstDay);
                System.out.println("Phone Number: " + current.phone);
                System.out.println("Address: " + current.address);
                System.out.println("Work Hours: " + current.workHours);
                System.out.println("Salary: " + current.salary);
                System.out.println();
                current = current.next;
                count++;
            }
        }
    }
    //method to search for employee by his ID
    public void Search(int ID) {
        if (head == null) {
            System.out.println("No employees with this ID");
        } else {
            Node current = head;
            while (current != null) {
                if (current.id == ID) {
                    System.out.println("Employee ID: " + current.id);
                    System.out.println("Employee Name: " + current.name);
                    System.out.println("Employee First Day: " + current.firstDay);
                    System.out.println("Employee phone Number: " + current.phone);
                    System.out.println("Employee Address: " + current.address);
                    System.out.println("Employee Working Hours " + current.workHours);
                    System.out.println("Employee Salary " + current.salary);
                    break;
                }
                current = current.next;
            }
            if (current == null) {
                System.out.println("No employee with ID " + ID);
            }
        }
    }
    //method to Update Employees salary
    void updateSalary() {
        Node current = head;
        while (current != null) {
            if (current.workHours > 32) {
                current.salary = current.salary * 1.02;
            }
            current = current.next;
        }
    }

//the main class will create the linkedlist and start the system
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node head = null;
        LinkedList record = new LinkedList(head);

        int id;
        String name;
        String firstDay;
        int phone;
        String address;
        int workhour;
        double salary;
        while (true) {
            System.out.print("---------------------------------------");
            System.out.println("\n\tEmployee management system\n" +
                    "---------------------------------------\n"+
                    "\t1- Insert employee \n" +
                    "\t2- Delete employee \n" +
                    "\t3- Update employee \n" +
                    "\t4- Show employees\n" +
                    "\t5- Search employee\n" +
                    "\t6- Update salary\n" +
                    "\t7- To End\n");
            System.out.print("---------------------------------------\n");
            System.out.print("Please enter your choice: ");
            int choice;
            choice = scan.nextInt();
            System.out.print("\n---------------------------------------\n");
            // if user choose1  then can add Employee
            if (choice == 1) {
                System.out.print("Employee ID: ");
                id = scan.nextInt();
                System.out.print("Employee Name: ");
                name = scan.next();
                System.out.print("First day of work: ");
                firstDay = scan.next();
                System.out.print("Employee phone number: ");
                phone = scan.nextInt();
                System.out.print("Employee Address: ");
                address = scan.next();
                System.out.print("Employee work Hours: ");
                workhour = scan.nextInt();
                // Check if employee working hours are less than 32housr then will return error massage 
                if (workhour < 32) {
                    System.out.println("You can not add Employee that has less than 32 hours");
                    continue;
                }
                System.out.print("Employee salary: ");
                salary = scan.nextInt();
                record.insert(id, name, firstDay, phone, address, workhour, salary);
            }
            // if user choose2  then can delete Employee
            else if (choice == 2) {
                System.out.print("Employee ID: ");
                id = scan.nextInt();
                record.delete(id);
            }
            // if user choose3  then can update Employee
            else if (choice == 3) {
                System.out.print("Employee ID: ");
                id = scan.nextInt();
                record.updateEmployee(id);
            }
            // if user choose4  then can show all Employee
            else if (choice == 4) {
                record.Show();
            }
            // if user choose5  then can search for all Employee
            else if (choice == 5) {
                System.out.print("Employee ID: ");
                id = scan.nextInt();
                record.Search(id);
            }
            // if user choose6  then can ubdate the salary of Employee
            else if (choice == 6) {
                record.updateSalary();
                System.out.println("The Salary is Updated now");
            }
            // if user choose7 the system will stop
            else if (choice == 7) {
                break;

            }
        }
    }
}



