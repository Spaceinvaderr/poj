
import java.util.Arrays;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chirillo
 */
public class IdBuilder {
    private final HashSet<Long> lst=new HashSet<>();
    private String Separator;
    private String Default;
    
    public IdBuilder(String Separator, String Default) {
        setSeparator(Separator).setDefault(Default);
    }
    public IdBuilder(String Separator) { 
        this(Separator,"NULL"); 
    }
    
    public IdBuilder() { this(", "); }
    
    public final IdBuilder setSeparator(String separator) { 
        this.Separator=Separator; return this; 
    }
    public final IdBuilder setDefault(String Default) { 
        this.Default=Default; return this; 
    }
    public IdBuilder append(long id) { 
        lst.add(id); return this; 
    }
    public IdBuilder clear() { 
        lst.clear(); return this; 
    }
    
    @Override public String toString() 
    {
        if(lst.size()<=0) return Default;
        Long[] tb=new Long[lst.size()];
        lst.toArray(tb);
        Arrays.sort(tb);
        final StringBuilder sb=new StringBuilder();
        /*///
        sb.append(tb[0]);
        for(int i=1;i<tb.length;++i) sb.append(Separator).append(tb[0]);
        /*/
        boolean first=true;
        for(long id:tb)
        {
            if(first) first=false;
            else sb.append(Separator);
            sb.append(id);
        }        
        //*///
        return sb.toString();
    }        
    
    
}
