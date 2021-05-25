package repositories;

import model.*;
import service.*;

import java.io.IOException;
import java.util.*;

public class RetetaRepo {
    private final Set<Reteta> retetas;
    public RetetaRepo() throws IOException {
        retetas = RetetaService2.getInstance().loadRetetas();
    }
    public Set<Reteta> getRetetas(){
        return Collections.unmodifiableSet(retetas);
    }

    public boolean add(final Reteta reteta){
        return retetas.add(reteta);
    }

    public boolean remove(final int id){
        final Reteta reteta = getRetetasByID(id);
        if(reteta == null)
            return false;
        return retetas.remove(reteta);
    }

    public Reteta getRetetasByID(int id) {
        for(final Reteta reteta:retetas){
            if(reteta.getReteteID() == id)
                return reteta;
        }
        return null;
    }
}
