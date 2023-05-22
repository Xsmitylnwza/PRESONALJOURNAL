import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class JournalManager {
    public static void main(String[] args) {
        JournalEntry j = null;
        deleteEntries();

    }
    public static void writeEntry(JournalEntry entry){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to input: ");
        String text = scanner.nextLine();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = dateTimeFormatter.format(localDate);
        LocalTime time2 = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String time = timeFormatter.format(time2);
        String timestamp = date+" "+time;
        entry = new JournalEntry(timestamp,text);
        try {
            File filewriter = new File("journal.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(filewriter,true));
            writer.write(entry.getTimestamp()+" - "+entry.getText());
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static List readEntires(){
        List<String> yeahman = new ArrayList<>();
        try {
            File filereader = new File("journal.txt");
            BufferedReader reader = new BufferedReader(new FileReader(filereader));
            String word;
            while ((word = reader.readLine()) != null){
                String[] split = word.split(" ");
                System.out.println(split[0]+" "+split[1]);
                yeahman.add(word);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Timestamp you want to read: ");
        String timestamp = scanner.nextLine();
        for(String s : yeahman){
            if(s.contains(timestamp)){
                System.out.println(s);
            }
        }
        return yeahman;
    }
    public static void deleteEntries(){
        List<String> yeahman = new ArrayList<>();
        try {
            File filereader = new File("journal.txt");
            BufferedReader reader = new BufferedReader(new FileReader(filereader));
            String word;
            while ((word = reader.readLine()) != null){
                String[] split = word.split(" ");
                System.out.println(split[0]+" "+split[1]);
                yeahman.add(word);
            }
            reader.close();
            filereader.delete();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Timestamp you want to delete: ");
        String timestamp = scanner.nextLine();
        try {
            File filewriter = new File("copy.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(filewriter));
            for (String s:yeahman) {
                if(!s.contains(timestamp)){
                    writer.write(s);
                    writer.newLine();
                }
            }
            writer.close();
            filewriter.renameTo(new File("journal.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
