package database;

import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;

import java.util.*;

public abstract class DatabaseAPI {
    private static final String dbPath = "C:/PracticeDB/";
    private static final String baseScanPackage = "database";
    private static final ICipher cipher;
    static {
        ICipher c = null;
        try {
            c = new Default1Cipher("dsfsdkfgsdhgfjda;sd");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        cipher = c;
    } // initialize using try-catch

    private static final JsonDBTemplate database = new JsonDBTemplate(dbPath, baseScanPackage, cipher);

    public static void insert(GeneralDataInstance gdi) {
        database.insert(gdi, "general_data");
    }

    public static void insert(StudentDataInstance gdi) {
        database.insert(gdi, "students");
    }

    public static void delete(GeneralDataInstance gdi) {
        database.remove(gdi, "general_data");
    }

    public static void delete(StudentDataInstance gdi) {
        database.remove(gdi, "students");
    }

    public static Map<String, String> getTokens(String email) {
        Map<String, String> ret = new HashMap<>();
        StudentDataInstance student = database.findById(email, StudentDataInstance.class);
        GeneralDataInstance data = database.findById(0, GeneralDataInstance.class);

        ret.put("GEN_companyName", data.getCompanyName());
        ret.put("GEN_uniName", data.getUniName());
        ret.put("GEN_startD", String.valueOf(data.getStartDate().get(Calendar.DAY_OF_MONTH)));
        ret.put("GEN_startM", monthToString(data.getStartDate()));
        ret.put("GEN_startY", String.valueOf(data.getStartDate().get(Calendar.YEAR)));
        ret.put("GEN_endD", String.valueOf(data.getEndDate().get(Calendar.DAY_OF_MONTH)));
        ret.put("GEN_endM", monthToString(data.getEndDate()));
        ret.put("GEN_endY", String.valueOf(data.getEndDate().get(Calendar.YEAR)));
        ret.put("GEN_urn", data.getUniResponsibleName());
        ret.put("GEN_urp", data.getUniResponsiblePosition());
        ret.put("GEN_crn", data.getCompanyResponsibleName());
        ret.put("GEN_crp", data.getCompanyResponsiblePosition());
        String tasks[] = data.getActivities();
        for(int i = 0; i < 30; i++) {
            ret.put("GEN_task"+i, (i < tasks.length ? tasks[i] : ""));
        }
        ret.put("GEN_dept", data.getDepartmentName());
        ret.put("GEN_fac", data.getFacultyName());

        ret.put("ST_name", student.getName());
        ret.put("ST_deg", student.getDegree());
        ret.put("ST_dir", student.getDirection());
        ret.put("ST_sp", student.getSpeciality());
        ret.put("ST_year", String.valueOf(student.getYear()));
        ret.put("ST_group", student.getGroup());
        boolean[] marks = student.getMarks();
        for(int i = 0; i < 30; i++) {
            ret.put("ST_mark"+i, (i < tasks.length ? (marks[i] ? "Вик." : "Не вик.") : ""));
        }

        return ret;

    }

    private static String monthToString(GregorianCalendar date) {
        int month = date.get(Calendar.MONTH);

        if (month == Calendar.JANUARY) return "січня";
        if (month == Calendar.FEBRUARY) return "лютого";
        if (month == Calendar.MARCH) return "березня";
        if (month == Calendar.APRIL) return "квітня";
        if (month == Calendar.MAY) return "травня";
        if (month == Calendar.JUNE) return "червня";
        if (month == Calendar.JULY) return "липня";
        if (month == Calendar.AUGUST) return "серпня";
        if (month == Calendar.SEPTEMBER) return "вересня";
        if (month == Calendar.OCTOBER) return "жовтня";
        if (month == Calendar.NOVEMBER) return "листопада";
        if (month == Calendar.DECEMBER) return "грудня";
        return "";
    }
}
