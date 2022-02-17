package com.bolsadeideas.springboot.backend.apirest.controllers;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.backend.apirest.models.OutBound.Motif;
import com.bolsadeideas.springboot.backend.apirest.models.OutBound.ShippingOrder;
import com.bolsadeideas.springboot.backend.apirest.services.RequestOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Client;
import com.bolsadeideas.springboot.backend.apirest.services.IClientService;

import static java.lang.String.format;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClientRestController {

	List<Motif> motifs = Arrays.asList(Motif.values());

	@Autowired
	private RequestOutboundService requestOutboundService;

	@Autowired
	private IClientService clientService;

	@GetMapping("/clients")
	public List<Client> index() {
		return clientService.findAll();
	}

	@GetMapping("/clients/{id}")
	public Client show(@PathVariable Long id) {
		return clientService.findById(id);
	}

	@PostMapping("/clients")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		client.setCreateAt(new Date());
		return clientService.save(client);
	}

	@PutMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		Client clientActual = clientService.findById(id);
		clientActual.setSurname(client.getSurname());
		clientActual.setName(client.getName());
		clientActual.setEmail(client.getEmail());
		return clientService.save(clientActual);
	}

	@DeleteMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		clientService.delete(id);
	}



	@GetMapping("/v2/Outbound/")
	public ResponseEntity<Optional<String>> getOutboundTemplate(@RequestHeader String agent,
																@ModelAttribute ShippingOrder order,
																@RequestHeader Motif motif) {
		return ResponseEntity.ok(requestOutboundService.getOutboundTemplate(motif, agent, order));
	}

	@GetMapping("/motifs")
	private List<Motif> motifs() {
		return Arrays.asList(Motif.values());
	}


}
