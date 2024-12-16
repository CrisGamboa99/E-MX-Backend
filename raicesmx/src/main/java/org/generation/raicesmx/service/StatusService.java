package org.generation.raicesmx.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.generation.raicesmx.model.StatusEntity;
import org.generation.raicesmx.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

	private final StatusRepository statusRepository;
	
	@Autowired
	public StatusService (StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}
	
	public List<StatusEntity> getAllStatus(){
	    return this.statusRepository.findAll();
	}

	public StatusEntity getStatus(Long id_status){
	    return statusRepository.findById(id_status).orElse(null);
	}

	public StatusEntity createStatus (StatusEntity newStatus) {
	    return this.statusRepository.save(newStatus);
	}
    
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
    
    public StatusEntity updateStatus(StatusEntity statusModelo) {
        Optional < StatusEntity > statusDb = this.statusRepository.findById(statusModelo.getId_status());

        if (statusDb.isPresent()) {
            StatusEntity statusUpdate = statusDb.get();
            statusUpdate.setId_status(statusModelo.getId_status());
            statusUpdate.setTipo_status(statusModelo.getTipo_status());
            statusRepository.save(statusUpdate);
            return statusUpdate;
        } else {
            throw new NoSuchElementException("No se encontró registro con id : " + statusModelo.getId_status());
        }
    } 
}
