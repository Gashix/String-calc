import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String data[];
        char action;

        if (exp.contains("\" + \"")){
            data = exp.split("\" \\+ \"");
            action = '+';
        } else if (exp.contains("\" - \"")){
            data = exp.split("\" - \"");
            action = '-';
        }
         else if (exp.contains("\" * ")) {
            data = exp.split("\" \\* ");
            action = '*';
        } else if (exp.contains("\" /")) {
            data = exp.split("\" / ");
            action = '/';
        }
        else {
            throw new Exception("неверный формат записи ");
        }
        if (data[0].length() > 41) throw new Exception(data[0] + "...");
        if (data[1].length() > 41) throw new Exception(data[1] + "...");
        if (data[0].length() > 11 || data[1].length() > 11) throw new Exception("Строки не могут быть больше 10 символов!");
        if (action == '*' || action == '/'){
            if(data[1].contains("\"") || Integer.parseInt(data[1]) > 10 || Integer.parseInt(data[1]) < 1)
                throw new Exception("Делить и умножать можно только на число от 1 до 10!");
        }
        for (int i = 0; i < data.length; i++){
            data[i] = data[i].replace("\"","");
        }

        if (action == '+'){
            printInQuotes (data[0]+data[1]);
        } else if (action == '-'){
            int index = data[0].indexOf(data[1]);
            if (index == -1){
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0,index);
                result += data[0].substring(index+data[1].length());
                printInQuotes(result);
            }
        }else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++){
                result+=data[0];
            } printInQuotes(result);
        }else {
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printInQuotes(result);
        }

    } static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }
}