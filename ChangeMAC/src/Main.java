import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        //Потоки ввод-вывод
        File file1 = new File(args[0]);
        File file2 = new File(args[0] + "_Result");
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));


        //Регулярное выражение для поиска
        String regex = args[1];
        Pattern pattern = Pattern.compile(regex);

        //Костыль, чтобы искать совпадение из файла, в котором есть переносы строк.
        String line;
        String buf = "";
        boolean ifBuf = false;
        Matcher matcher;
        String newMac = randomMACAddress();
        int i = 0;

        //Поиск и замена
        while ((line = br.readLine()) != null) {
            line = buf + line;
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                
                if(i >= Integer.parseInt(args[2])){

                    newMac = randomMACAddress();
                    i = 0;
                }
                line = pattern.matcher(line).replaceFirst(newMac);
                matcher = pattern.matcher(line);
                i++;
            }

            buf = line.substring(line.length() - 11);
            line = line.substring(0, line.length()-11);
            if (ifBuf) {

                line = line.substring(0,11) + "\n" + line.substring(11);
            }
            bw.write(line);
            ifBuf = true;
        }
        bw.write(buf);
        bw.flush();
        bw.close();
    }

    //Создание рандомного MAC (unicast)
    private static String randomMACAddress(){
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        macAddr[0] = (byte)(macAddr[0] & (byte)254);
        StringBuilder sb = new StringBuilder(18);
        for(byte b : macAddr){

            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}