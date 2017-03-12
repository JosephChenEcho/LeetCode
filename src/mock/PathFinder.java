/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Joseph
 */
public class PathFinder {
    public static void main(String[] args) throws ParseException{
        DateFormat formatter;
      formatter = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
       // you can change format of date


        String input = "(01/01/2000-01:00:00) :: START";
        String time = input.split("::")[0];
        String flag = input.split("::")[1].trim();
  
        Date date1 = formatter.parse(time.substring(1,time.length() - 1));
        input = "(01/02/2000-01:00:00) :: START";
        time = input.split("::")[0];
        flag = input.split("::")[1].trim();
        Date date2 = formatter.parse(time.substring(1,time.length() - 1));
        int diff = date2.getDate() - date1.getDate();

    }
    
    static List<String> parseFile(String filename)
    		throws FileNotFoundException, IOException {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
        	allLines.add(line);
        }
        input.close();

        return parseLines(allLines);    	
    }
    
    static List<String> parseLines(List<String> lines) {
    	/*
    	 * 
    	 *  Your code goes here
    	 *  
    	 */
        
        List<String> retList = new ArrayList<String>();
        HashMap<String,List<String>> pathMap = new HashMap<String,List<String>>();
        String first = lines.get(0);
        String start = first.split(" ")[0].trim();
        String end = first.split(" ")[1].trim();
        for(int i = 1; i < lines.size(); i++){
            String key = lines.get(i).split(":")[0].trim();
            List<String> val = new ArrayList<String>();
            String[] child = lines.get(i).split(":")[1].trim().split(" ");
            for(String c : child){
                val.add(c.trim());
            }
            pathMap.put(key, val);
        }
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        dfshelper(retList, pathMap, new String(start), start, end, visited);
        return retList;
    }
    
    public static void dfshelper(List<String> retList, HashMap<String,List<String>> pathMap, String path, String start, String end, HashSet<String> visited){        
        
        if(!pathMap.containsKey(start)){
            if(start.equals(end)){                
                retList.add(new String(path));
            }            
            return;
        }
        
        if(pathMap.containsKey(start)){
            List<String> pathval = pathMap.get(start);
            for(String p : pathval){
                if(visited.contains(p)) continue;
                visited.add(p);
                path += p;                                
                dfshelper(retList, pathMap, path, p, end, visited);
                visited.remove(p);
                path = path.substring(0,path.length() - 1);     
            }
        }
    }
}
