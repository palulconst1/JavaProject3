package repositories;

import model.*;
import service.*;

import java.io.IOException;
import java.util.*;

public class MedicRepo {

    private final Set<Medic> medics;

    public MedicRepo() throws IOException {
        medics = MedicService2.getInstance().loadMedics();
    }

    public Set<Medic> getMedics() {
        return Collections.unmodifiableSet(medics);
    }

    public boolean add(final Medic medic){
        return medics.add(medic);
    }

    public boolean remove(final int id){
        final Medic medic = getMedicByID(id);
        if(medic == null)
            return false;
        return medics.remove(medics);
    }

    public Medic getMedicByID(int id) {
        for(final Medic medic:medics){
            if(medic.getMedicID() == id)
                return medic;
        }
        return null;
    }

    public Set<Medic> getMedicsByFirstName(String firstName){
        Set<Medic> srcResult = null;
        for(final Medic medic:medics){
            if(medic.getFirstName() == firstName) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(medic);
            }
        }
        return srcResult;
    }

    public Set<Medic> getMedicsByLastName(String lastName){
        Set<Medic> srcResult = null;
        for(final Medic medic:medics){
            if(medic.getLastName().equals(lastName)) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(medic);
            }
        }
        return srcResult;
    }

    public Set<Medic> getFamilyMedics(){
        Set<Medic> srcResult = null;
        for(final Medic medic:medics){
            if(medic.getClass() == MedicFamilie.class) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(medic);
            }
        }
        return srcResult;
    }

    public Set<Medic> getSpecialistMedics(){
        Set<Medic> srcResult = null;
        for(final Medic medic:medics){
            if(medic.getClass() == MedicSpecializat.class) {
                if (srcResult == null)
                    srcResult = new HashSet<>();
                srcResult.add(medic);
            }
        }
        return srcResult;
    }

    public boolean setMedicFirstName(int id, String firstName){
        Medic medic = getMedicByID(id);
        if(medic == null)
            return false;
        medic.setFirstName(firstName);
        return true;
    }

    public boolean setMedicLastName(int id, String lastName){
        Medic medic = getMedicByID(id);
        if(medic == null)
            return false;
        medic.setLastName(lastName);
        return true;
    }

}
