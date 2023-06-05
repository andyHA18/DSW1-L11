package pe.edu.idat.dsw1L11;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Dias;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DiasRepository {
	private static final Map<String, Dias> dias = new HashMap<>();

	@PostConstruct
	public void initData() {
		Dias lunes = new Dias();
		lunes.setName("lunes");
		lunes.setCurrency(Currency.MONDAY);
		dias.put(lunes.getName(), lunes);

		Dias martes = new Dias();
		martes.setName("martes");
		martes.setCurrency(Currency.TUESDAY);
		dias.put(martes.getName(), martes);

		Dias miercoles = new Dias();
		miercoles.setName("miercoles");
		miercoles.setCurrency(Currency.WEDNESDAY);
		dias.put(miercoles.getName(), miercoles);

		Dias jueves = new Dias();
		jueves.setName("jueves");
		jueves.setCurrency(Currency.THURSDAY);
		dias.put(jueves.getName(), jueves);

		Dias viernes = new Dias();
		viernes.setName("viernes");
		viernes.setCurrency(Currency.FRIDAY);
		dias.put(viernes.getName(), viernes);

		Dias sabado = new Dias();
		sabado.setName("sabado");
		sabado.setCurrency(Currency.SATURDAY);
		dias.put(sabado.getName(), sabado);

		Dias domingo = new Dias();
		domingo.setName("domingo");
		domingo.setCurrency(Currency.SUNDAY);
		dias.put(domingo.getName(), domingo);

	}

	public Dias findDias(String name) {
		Assert.notNull(name, "The Dias's name must not be null");
		return dias.get(name);
	}
}