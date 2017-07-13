package client.helpedClasses;

public class Employees {
    int id,salary;
    String name,phone,sequrityNumber,email,address;

    public Employees(int id, int salary, String name, String phone,
                     String sequrityNumber, String email, String address) {
        super();
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.phone = phone;
        this.sequrityNumber = sequrityNumber;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSequrityNumber() {
        return sequrityNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
