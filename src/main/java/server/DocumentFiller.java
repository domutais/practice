package server;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.jar.JarFile;
import java.util.zip.*;

public class DocumentFiller {
    private File template; // XML file that contains text data from the .docx file
    private File templateZip;

    public DocumentFiller(String templatePath) throws  Exception{
        if (template == null) this.templateZip = new File("src/template.docx");
        else this.templateZip = new File(templatePath);
    }

    public void fill(Map<String, String> tokens) throws Exception {
        zipUnpack();

        FileReader fr = new FileReader(template);
        Scanner sc = new Scanner(fr);

        File xml = new File("tmp/document.xml");
        xml.createNewFile();
        FileWriter fw = new FileWriter(xml);
        while (sc.hasNextLine()) {
            Iterator<Map.Entry<String, String>> iterator = tokens.entrySet().iterator();
            String tmp = sc.nextLine();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                tmp = tmp.replace("$"+entry.getKey()+"$", entry.getValue());
            }

            fw.write(tmp);
        }

        fr.close();
        fw.close();

        File docx = new File("src/"+tokens.get("email")+".docx");
        zipPack(xml, docx);

    }

    public void zipUnpack() throws Exception {
        FileSystem fileSystem = FileSystems.newFileSystem(templateZip.toPath());
        template = new File("src/template.xml");
        Files.copy(fileSystem.getPath("/word/document.xml"), template.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }


    public void zipPack(File in, File zip) throws Exception {
        Files.copy(templateZip.toPath(), zip.toPath(), StandardCopyOption.REPLACE_EXISTING);

        FileSystem fileSystem = FileSystems.newFileSystem(zip.toPath());
        Files.copy(in.toPath(), fileSystem.getPath("/word/document.xml"), StandardCopyOption.REPLACE_EXISTING);

        fileSystem.close();
    }


}
