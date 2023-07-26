package homework12_2.part2;

import java.sql.Date;

public class Director {

    private int id;
    private String first_name;
    private String last_name;
    private Date birth_date;
    private String country;

    public Director(int id, String first_name, String last_name, Date birth_date, String country) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.country = country;
    }

    public Director() {
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
