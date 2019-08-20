package editor.gruppe1;

public class Singleton {

    private static final Singleton OBJ = new Singleton(); 
    
    private Singleton() { 
        System.out.println("Objekt wurde gebildet"); 
    } 
         
    public static Singleton getInstance() { 
      return OBJ; 
    } 
}
