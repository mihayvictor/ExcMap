package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] fildes = line.split(",");
                String name = fildes[0];
                int count = Integer.parseInt(fildes[1]);
               
                if (map.containsKey(name)) {
                    int votesSoFar = map.get(name);
                    map.put(name, count + votesSoFar);
                }else{
                    map.put(name, count);
                }
                //Visualizar as adições
                System.out.println(map.toString());
                
                line = br.readLine();
            }

            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
            
        } catch (IOException e) {
          
            System.out.println("Error " +  e.getMessage());
        }
        sc.close();
    }
}
