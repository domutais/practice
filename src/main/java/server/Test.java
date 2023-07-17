package server;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String[][] tokensArray = {
                {"Test1", "dolor sit"},
                {"Test2", "Test2 is successful"},
                {"email", "sample@gmail.com"}
        };
        Map<String, String> tokens = new HashMap<>();
        for (String[] s : tokensArray) {
            tokens.put(s[0], s[1]);
        }


        try {
            DocumentFiller filler = new DocumentFiller("src/template.docx");
            filler.fill(tokens);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
