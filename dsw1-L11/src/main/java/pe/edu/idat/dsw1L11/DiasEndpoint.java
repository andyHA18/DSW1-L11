package pe.edu.idat.dsw1L11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetDiasRequest;
import io.spring.guides.gs_producing_web_service.GetDiasResponse;

@Endpoint
public class DiasEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private DiasRepository DiasRepository;

	@Autowired
	public DiasEndpoint(DiasRepository DiasRepository) {
		this.DiasRepository = DiasRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDiasRequest")
	@ResponsePayload
	public GetDiasResponse getDias(@RequestPayload GetDiasRequest request) {
		GetDiasResponse response = new GetDiasResponse();
		response.setDias(DiasRepository.findDias(request.getName()));

		return response;
	}

}
