package server;

import database.DatabaseAPI;
import database.DocumentFiller;
import database.GeneralDataInstance;
import database.StudentDataInstance;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        GeneralDataInstance gdi = new GeneralDataInstance();
        gdi.setId(0);
        gdi.setActivities(new String[]{"Інструктажі", "Завдання 1", "Завдання 2", "П'яте", "Десяте", "Захист звіту"});
        gdi.setCompanyName("ТОВ \"Назва компанії\"");
        gdi.setFacultyName("Факультет комп'ютерних наук");
        gdi.setDepartmentName("Кафедра безпеки інформаційних систем");
        gdi.setStartDate(new GregorianCalendar(2023, Calendar.JUNE, 27));
        gdi.setEndDate(new GregorianCalendar(2023, Calendar.JULY, 18));
        gdi.setUniName("Харківський національний університет ім. В. Н. Каразіна");
        gdi.setCompanyResponsibleName("Іванов І. І");
        gdi.setCompanyResponsiblePosition("посада1");
        gdi.setUniResponsibleName("Петренко П. П");
        gdi.setUniResponsiblePosition("посада2");

        StudentDataInstance sdi = new StudentDataInstance();
        sdi.setDegree("бакалавр");
        sdi.setDirection("12 Інформаційні технології");
        sdi.setEmail("sample_email23@gmail.com");
        sdi.setName("Сидоренко Семен Семенович");
        sdi.setGroup("КБ-32");
        sdi.setMarks(new boolean[]{true, true, true, true, true, true});
        sdi.setSpeciality("125 Кібербезпека");
        sdi.setYear(3);

        DatabaseAPI.upsert(sdi);
        DatabaseAPI.upsert(gdi);
        try {
            DatabaseAPI.fillDocx(0, "sample_email23@gmail.com");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
