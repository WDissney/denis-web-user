package web.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "lastName", length = 70)
    private String lastName;
    @Column(name = "age")
    private int age;

    public User (){};

    public User(String name, String lstName, int age) {
        this.name = name;
        this.lastName = lstName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lstName) {
        this.lastName = lstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "id  =  " + id +
                ", name  =  " + name +
                ", lastName  =  " + lastName +
                ", age  =  " + age ;
    }
}
