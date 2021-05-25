package repositories;

import model.*;
import service.*;

import java.io.IOException;
import java.util.*;

public class ProgramareRepo {
    private final Set<Programare> programares;
    public ProgramareRepo() throws IOException {
        programares = ProgramareService2.getInstance().loadProgramares();
    }
    public Set<Programare> getProgramares(){
        return Collections.unmodifiableSet(programares);
    }

    public boolean add(final Programare programare){
        return programares.add(programare);
    }

    public boolean remove(final int id){
        final Programare programare = getProgramaresByID(id);
        if(programare == null)
            return false;
        return programares.remove(programare);
    }

    public Programare getProgramaresByID(int id) {
        for(final Programare programare:programares){
            if(programare.getProgramareID() == id)
                return programare;
        }
        return null;
    }
}
