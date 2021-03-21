package org.sci.service;

import org.sci.newModel.Nuvela;
import org.sci.repository.NuvelaRepo;

public class NuvelaService {

    private NuvelaRepo nuvelaRepo;

    public NuvelaService(NuvelaRepo nuvelaRepo) {
        this.nuvelaRepo = nuvelaRepo;
    }

    //CRUD

    public Nuvela createNuvela(Nuvela nuvela) {
        return nuvelaRepo.createNuvela(nuvela);
    }

    public Nuvela readNuvela(Nuvela nuvela) {
        return nuvelaRepo.readNuvela(nuvela);
    }

    public Nuvela updateNuvela(Nuvela nuvela) {
        return nuvelaRepo.updateNuvela(nuvela);
    }

    public boolean deleteNuvela(Nuvela nuvela) {
        return nuvelaRepo.deleteNuvela(nuvela);
    }
}
