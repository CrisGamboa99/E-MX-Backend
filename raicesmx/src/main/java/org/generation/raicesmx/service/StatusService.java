package org.generation.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.generation.raicesmx.exception.StatusNotFoundException;
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
	    return statusRepository.findById(id_status)
	    		.orElseThrow(() -> new StatusNotFoundException(id_status));
	}
	
	// Mostrar por status
	public StatusEntity findByStatus(String nombre) {
		return this.statusRepository.findByStatus(nombre);
	}

	public StatusEntity createStatus (StatusEntity newStatus) {
	    return this.statusRepository.save(newStatus);
	}
    
    public void deleteStatus(Long id) {
        
    	if(this.statusRepository.existsById(id)) {
        	statusRepository.deleteById(id);
    	}else {
    		throw new StatusNotFoundException(id);
    	}
    }
    
    public StatusEntity updateStatus(StatusEntity statusModelo, Long id) {
        Optional < StatusEntity > statusDb = this.statusRepository.findById(statusModelo.getId_status());

        if (statusDb.isPresent()) {
            StatusEntity statusUpdate = statusDb.get();
            statusUpdate.setTipo_status(statusModelo.getTipo_status());
            statusRepository.save(statusUpdate);
            return statusUpdate;
        } else {
        	throw new StatusNotFoundException(id);
        }
    } 
}
