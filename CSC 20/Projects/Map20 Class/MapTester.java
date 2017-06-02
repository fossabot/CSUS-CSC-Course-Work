package Project3;

import java.util.HashSet;
import java.util.Arrays;
import java.lang.NullPointerException;
 
class MapTester {
    public static void main(String[] args) {
        boolean pass = true;
        Map20<String,String> m = new Map20<String,String>();
        Map20<String,String> m2 = new Map20<String,String>();
        m.put("a","1");
        m.put("b","2");
        pass = pass && (m.put("c","3")==null);
        pass = pass && m.containsKey("a");
        pass = pass && m.containsKey("b");
        pass = pass && m.containsKey("c");
        pass = pass && !m.containsKey("d");
        pass = pass && m.containsValue("1");
        pass = pass && m.containsValue("2");
        pass = pass && m.containsValue("3");
        pass = pass && !m.containsValue("d");
        pass = pass && !m.isEmpty();
        pass = pass && (m.size()==3);
        m.clear();
        pass = pass && m.isEmpty();
        pass = pass && (m.size()==0);
        pass = pass && !m.containsKey("a");
        pass = pass && !m.containsKey("b");
        pass = pass && !m.containsKey("c");
        pass = pass && !m.containsKey("d");
        pass = pass && !m.containsValue("1");
        pass = pass && !m.containsValue("2");
        pass = pass && !m.containsValue("3");
        pass = pass && !m.containsValue("d");
        pass = pass && (m.get("a")==null);
        m.put("a","1");
        m.put("b","2");
        m.put("c","3");
        pass = pass && (m.get("a").equals("1"));
        pass = pass && (!m.get("b").equals("1"));
        pass = pass && m.keySet().equals(new HashSet<String>(Arrays.asList("a","b","c")));
        pass = pass && !m.remove("b","1");
        pass = pass && m.remove("b","2");
        pass = pass && (m.get("b")==null);
        pass = pass && (m.remove("b")==null);
        pass = pass && (m.remove("a").equals("1"));
        pass = pass && m.keySet().equals(new HashSet<String>(Arrays.asList("c")));
        pass = pass && !m.replace("c","2","1");
        pass = pass && (m.get("c").equals("3"));
        pass = pass && m.replace("c","3","1");
        pass = pass && (m.get("c").equals("1"));
        m.put("a","3");
        m.put("b","2");
        pass = pass && m.keySet().equals(new HashSet<String>(Arrays.asList("a","b","c")));
        pass = pass && (m2.put("a","1")==null);
        pass = pass && (m2.put("b","2")==null);
        pass = pass && (m2.put("c","3")==null);
        pass = pass && !m.equals(m2);
        pass = pass && (m2.replace("a","3").equals("1"));
        pass = pass && (m2.replace("c","1").equals("3"));
        pass = pass && m.equals(m2);
        pass = pass && (m2.replace("d","4")==null);
        pass = pass && m.equals(m2);
        pass = pass && (m2.put("d","4")==null);
        pass = pass && !m.equals(m2);
        try {
            m.put(null,"5");
            pass = false;
        }
        catch (NullPointerException e) { }
        catch (Exception e) { pass = false; }
        System.out.println(pass);
    }
}