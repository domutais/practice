package database;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;

import java.util.Date;
import java.util.GregorianCalendar;

@Document(collection = "general_data", schemaVersion = "1.0")
public class GeneralDataInstance {
    //List of methods to fully define an instance:
    /*.set
     */
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Secret
    private String companyName;

    private GregorianCalendar startDate, endDate;
    @Secret
    private String uniResponsibleName, uniResponsiblePosition;
    @Secret
    private String companyResponsibleName, companyResponsiblePosition;

    private String[] activities;
    private String departmentName; //кафедра
    private String facultyName;
    private String uniName;

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public String getUniResponsibleName() {
        return uniResponsibleName;
    }

    public void setUniResponsibleName(String uniResponsibleName) {
        this.uniResponsibleName = uniResponsibleName;
    }

    public String getUniResponsiblePosition() {
        return uniResponsiblePosition;
    }

    public void setUniResponsiblePosition(String uniResponsiblePosition) {
        this.uniResponsiblePosition = uniResponsiblePosition;
    }

    public String getCompanyResponsibleName() {
        return companyResponsibleName;
    }

    public void setCompanyResponsibleName(String companyResponsibleName) {
        this.companyResponsibleName = companyResponsibleName;
    }

    public String getCompanyResponsiblePosition() {
        return companyResponsiblePosition;
    }

    public void setCompanyResponsiblePosition(String companyResponsiblePosition) {
        this.companyResponsiblePosition = companyResponsiblePosition;
    }

    public String[] getActivities() {
        return activities;
    }

    public void setActivities(String[] activities) {
        this.activities = activities;
    }
}
