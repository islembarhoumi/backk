package com.epi.cabinetsmedicaux.services;


import com.epi.cabinetsmedicaux.model.RendezVous;
import com.epi.cabinetsmedicaux.model.Secretaire;
import com.epi.cabinetsmedicaux.repository.PatientRepository;
import com.epi.cabinetsmedicaux.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RendezVousService {
    private final RendezVousRepository rendezVousRepository;

    public RendezVousService(RendezVousRepository RendezVousRepository) {
        this.rendezVousRepository = RendezVousRepository;
    }




    public List<RendezVous> getAllRendezVous() {
        return (List<RendezVous>) rendezVousRepository.findAll();
    }

    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }

    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }



    public RendezVous updateRendezVous(Long id, RendezVous rendezvous) {

        Optional<RendezVous> existingRendezvousOptional = rendezVousRepository.findById(id);

        if (existingRendezvousOptional.isPresent()) {
            RendezVous existingRendezvous = existingRendezvousOptional.get();
            // Mise à jour des champs du rendez-vous existant
            existingRendezvous.setDate(rendezvous.getDate());
            existingRendezvous.setHeure(rendezvous.getHeure());
            existingRendezvous.setStatut(rendezvous.getStatut());
            existingRendezvous.setMedcin(rendezvous.getMedcin());
            existingRendezvous.setEtat(rendezvous.getEtat());

            // Sauvegarde du rendez-vous mis à jour
            return rendezVousRepository.save(existingRendezvous);
        } else {
            // Si le rendez-vous avec l'ID donné n'est pas trouvé
            return null;
        }
    }




    public Optional<RendezVous> getRendezvousById(Long id) {
        return rendezVousRepository.findById(id);
    }





}



