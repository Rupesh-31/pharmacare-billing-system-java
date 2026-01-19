package medicineBilling;

public class Patient {
	    private String name;
	    private int age;
	    private long mobile;

	    public Patient(String name, int age, long mobile) {
	        this.name = name;
	        this.age = age;
	        this.mobile = mobile;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public long getMobile() {
	        return mobile;
	    }
	}