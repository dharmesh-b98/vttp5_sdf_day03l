package people;

public class Person {
    private String name;
    private String mrtStation;
    private Integer birthYear;

    public Person(String name, String mrtStation, Integer birthYear) {
        this.name = name;
        this.mrtStation = mrtStation;
        this.birthYear = birthYear;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMrtStation() {
        return mrtStation;
    }
    public void setMrtStation(String mrtStation) {
        this.mrtStation = mrtStation;
    }
    public Integer getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    
}
