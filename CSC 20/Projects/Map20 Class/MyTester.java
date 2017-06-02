import java.util.HashSet;
import java.util.Arrays;
import java.lang.NullPointerException;
 
class MyTester {
    public static void main(String[] args) {
        
        boolean pass = true;
        
        Map20<String,String> m = new Map20<String,String>();
        Map20<String,String> m2 = new Map20<String,String>();
        
        m.put("a","1");
        m.put("b","2");
        
        pass = pass && (m.put("c","3")==null);
        messedUp(pass, 1);
        pass = pass && m.containsKey("a");
        messedUp(pass, 2);
        pass = pass && m.containsKey("b");
        messedUp(pass, 3);
        pass = pass && m.containsKey("c");
        messedUp(pass, 4);
        pass = pass && !m.containsKey("d");
        messedUp(pass, 5);
        pass = pass && m.containsValue("1");
        messedUp(pass, 6);
        pass = pass && m.containsValue("2");
        messedUp(pass, 7);
        pass = pass && m.containsValue("3");
        messedUp(pass, 8);
        pass = pass && !m.containsValue("d");
        messedUp(pass, 9);
        pass = pass && !m.isEmpty();
        messedUp(pass, 10);
        pass = pass && (m.size()==3);
        messedUp(pass, 11);
        m.clear();
        pass = pass && m.isEmpty();
        messedUp(pass, 12);
        pass = pass && (m.size()==0);
        messedUp(pass, 13);
        pass = pass && !m.containsKey("a");
        messedUp(pass, 14);
        pass = pass && !m.containsKey("b");
        messedUp(pass, 15);
        pass = pass && !m.containsKey("c");
        messedUp(pass, 16);
        pass = pass && !m.containsKey("d");
        messedUp(pass, 17);
        pass = pass && !m.containsValue("1");
        messedUp(pass, 18);
        pass = pass && !m.containsValue("2");
        messedUp(pass, 19);
        pass = pass && !m.containsValue("3");
        messedUp(pass, 20);
        pass = pass && !m.containsValue("d");
        messedUp(pass, 21);
        pass = pass && (m.get("a")==null);
        messedUp(pass, 22);
        
        m.put("a","1");
        m.put("b","2");
        m.put("c","3");
        
        pass = pass && (m.get("a").equals("1"));
        messedUp(pass, 23);
        pass = pass && (!m.get("b").equals("1"));
        messedUp(pass, 24);
        pass = pass && m.keySet().equals(new HashSet<String>(Arrays.asList("a","b","c")));
        messedUp(pass, 25);
        pass = pass && !m.remove("b","1");
        messedUp(pass, 26);
        pass = pass && m.remove("b","2");
        messedUp(pass, 27);
        pass = pass && (m.get("b")==null);
        messedUp(pass, 28);
        pass = pass && (m.remove("b")==null);
        messedUp(pass, 28);
        pass = pass && (m.remove("a").equals("1"));
        messedUp(pass, 30);
        pass = pass && m.keySet().equals(new HashSet<String>(Arrays.asList("c")));
        messedUp(pass, 31);
        pass = pass && !m.replace("c","2","1");
        messedUp(pass, 33);
        pass = pass && (m.get("c").equals("3"));
        messedUp(pass, 34);
        pass = pass && m.replace("c","3","1");
        messedUp(pass, 35);
        pass = pass && (m.get("c").equals("1"));
        messedUp(pass, 36);
        
        m.put("a","3");
        m.put("b","2");
        
        pass = pass && m.keySet().equals(new HashSet<String>(Arrays.asList("a","b","c")));
        messedUp(pass, 37);
        pass = pass && (m2.put("a","1")==null);
        messedUp(pass, 38);
        pass = pass && (m2.put("b","2")==null);
        messedUp(pass, 39);
        pass = pass && (m2.put("c","3")==null);
        messedUp(pass, 40);
        
        
        
        
        pass = pass && !m.equals(m2); // True && True()
        messedUp(pass, 41);
        
        
        
        
        pass = pass && (m2.replace("a","3").equals("1"));
        messedUp(pass, 42);
        pass = pass && (m2.replace("c","1").equals("3"));
        messedUp(pass, 43);
        pass = pass && m2.equals(m2);
        messedUp(pass, 44);
        pass = pass && m.equals(m2);
        messedUp(pass, 445);
        pass = pass && (m2.replace("d","4")==null);
        messedUp(pass, 45);
        pass = pass && m.equals(m2);
        messedUp(pass, 46);
        pass = pass && (m2.put("d","4")==null);
        messedUp(pass, 47);
        pass = pass && !m.equals(m2);
        messedUp(pass, 48);
        
        try {
            m.put(null,"5");
            pass = false;
        }
        
        catch (NullPointerException e) {
            
        }
        catch (Exception e) {
            pass = false; 
        }
        
        System.out.println(pass);
    }
    
    public static void messedUp(boolean a, int line) {
        if(a == false) {
            System.out.println("Messed Up on line " + line);
            System.exit(0);
        }
    }
}


