package Spring_Boot_Demo.Entity;

public class Student
{
    private Long id;
    private String name;
    private String email;

    /** Returns the student's ID. */
    public Long getId() {
        return id;
    }

    /** Sets the student's ID. */
    public void setId(Long id) {
        this.id = id;
    }

    /** Returns the student's name. */
    public String getName() {
        return name;
    }

    /** Sets the student's name. */
    public void setName(String name) {
        this.name = name;
    }

    /** Returns the student's email address. */
    public String getEmail() {
        return email;
    }

    /** Sets the student's email address. */
    public void setEmail(String email) {
        this.email = email;
    }
}
