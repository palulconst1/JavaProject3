package repositories;

import model.*;
import service.*;

import java.io.IOException;
import java.util.*;

public class CabinetRepo {
    private final Set<Cabinet> cabinets;
    public CabinetRepo() throws IOException {
        cabinets = CabinetService2.getInstance().loadCabinets();
    }
    public Set<Cabinet> getCabinets(){
        return Collections.unmodifiableSet(cabinets);
    }

    public boolean add(final Cabinet cabinet){
        return cabinets.add(cabinet);
    }

    public boolean remove(final int id){
        final Cabinet cabinet = getCabinetByID(id);
        if(cabinet == null)
            return false;
        return cabinets.remove(cabinet);
    }

    public Cabinet getCabinetByID(int id) {
        for(final Cabinet cabinet:cabinets){
            if(cabinet.getCabinetID() == id)
                return cabinet;
        }
        return null;
    }
}
