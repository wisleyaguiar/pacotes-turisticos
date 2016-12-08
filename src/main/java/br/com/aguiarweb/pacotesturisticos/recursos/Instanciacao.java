package br.com.aguiarweb.pacotesturisticos.recursos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.aguiarweb.pacotesturisticos.dominio.Cliente;
import br.com.aguiarweb.pacotesturisticos.dominio.Contrato;
import br.com.aguiarweb.pacotesturisticos.dominio.Hotel;
import br.com.aguiarweb.pacotesturisticos.dominio.Item;
import br.com.aguiarweb.pacotesturisticos.dominio.Pacote;
import br.com.aguiarweb.pacotesturisticos.dominio.Passeio;
import br.com.aguiarweb.pacotesturisticos.repositorio.ClienteRepositorio;
import br.com.aguiarweb.pacotesturisticos.repositorio.ContratoRepositorio;
import br.com.aguiarweb.pacotesturisticos.repositorio.HotelRepositorio;
import br.com.aguiarweb.pacotesturisticos.repositorio.ItemRepositorio;
import br.com.aguiarweb.pacotesturisticos.repositorio.PacoteRepositorio;
import br.com.aguiarweb.pacotesturisticos.repositorio.PasseioRepositorio;

@RestController
@RequestMapping("/instanciacao")
public class Instanciacao {
	
	@Autowired
	private ClienteRepositorio clienteRepo;
	
	@Autowired
	private ContratoRepositorio contratoRepo;
	
	@Autowired
	private HotelRepositorio hotelRepo;
	
	@Autowired
	private ItemRepositorio itemRepo;
	
	@Autowired
	private PacoteRepositorio pacoteRepo;
	
	@Autowired
	private PasseioRepositorio passeioRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public String executar() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Cliente c1 = new Cliente(null,"José de Oliveira","joseoliveira@gmail.com","(34) 3244-5467","089.445.321-09",sdf.parse("15/03/1975"),new BigDecimal("1200.00"));
			Cliente c2 = new Cliente(null,"Carlos Alberto","alberto_1988@gmail.com","(34) 9944-0989","897.345.213-07",sdf.parse("20/11/1988"),new BigDecimal("3000.00"));
			Cliente c3 = new Cliente(null,"Maria Júlia Coutinho","mj_coutinho@gmail.com","(11) 3344-0933","774.522.466-11",sdf.parse("10/06/1985"),new BigDecimal("10000.00"));
			
			Hotel h1 = new Hotel(null,"Beira Mar Risort","Foz do Iguaçu - RS", new BigDecimal("130.00"));
			Hotel h2 = new Hotel(null,"Caldas Novas Park","Caldas Novas - GO", new BigDecimal("350.00"));
			Hotel h3 = new Hotel(null,"Boca da Viúva","Parati - MG", new BigDecimal("69.00"));
			
			Passeio p1 = new Passeio(null,"Mergulho maluco", new BigDecimal("10.00"), "Caldas Novas - GO");
			Passeio p2 = new Passeio(null,"Corrida Parada", new BigDecimal("20.90"), "Foz do Iguaçu - RS");
			Passeio p3 = new Passeio(null,"Rapel sem folego", new BigDecimal("35.00"), "Uberlândia - MG");
			Passeio p4 = new Passeio(null,"Dieta Pé na Jaca", new BigDecimal("50.00"), "Uberaba - MG");
			Passeio p5 = new Passeio(null,"Férias da Sogra", new BigDecimal("43.00"), "Tupaciguara - MG");
			Passeio p6 = new Passeio(null,"Corrida dos solteiros", new BigDecimal("90.00"), "Araguari - MG");
			Passeio p7 = new Passeio(null,"Encontro virgão", new BigDecimal("200.00"), "Patos de Minas - MG");
			Passeio p8 = new Passeio(null,"Contos e Cantos", new BigDecimal("12.00"), "Lagoa Grande - MG");
			
			Pacote pa1 = new Pacote(null,"Férias Gostosas",5,h1);
			Pacote pa2 = new Pacote(null,"Semana do Saco doido",7,h2);
			Pacote pa3 = new Pacote(null,"Descanço Legal",10,h3);
			Pacote pa4 = new Pacote(null,"Só Jesus Salva",6,h2);
			
			Item i1 = new Item(null,1,pa1,p1);
			Item i2 = new Item(null,2,pa1,p2);
			Item i3 = new Item(null,3,pa1,p3);
			
			Item i4 = new Item(null,4,pa2,p4);
			Item i5 = new Item(null,5,pa2,p5);
			Item i6 = new Item(null,6,pa2,p6);
			
			Item i7 = new Item(null,7,pa3,p7);
			Item i8 = new Item(null,8,pa3,p8);
			Item i9 = new Item(null,9,pa3,p1);
			
			Contrato co1 = new Contrato(null,sdf.parse("01/01/2017"), pa1, c1);
			Contrato co2 = new Contrato(null,sdf.parse("01/07/2017"), pa2, c2);
			Contrato co3 = new Contrato(null,sdf.parse("01/12/2017"), pa3, c3);
			Contrato co4 = new Contrato(null,sdf.parse("03/05/2017"), pa4, c2);
			Contrato co5 = new Contrato(null,sdf.parse("09/08/2017"), pa3, c1);
			
			clienteRepo.save(c1);
			clienteRepo.save(c2);
			clienteRepo.save(c3);
			
			hotelRepo.save(h1);
			hotelRepo.save(h2);
			hotelRepo.save(h3);
			
			passeioRepo.save(p1);
			passeioRepo.save(p2);
			passeioRepo.save(p3);
			passeioRepo.save(p4);
			passeioRepo.save(p5);
			passeioRepo.save(p6);
			passeioRepo.save(p7);
			passeioRepo.save(p8);
			
			pacoteRepo.save(pa1);
			pacoteRepo.save(pa2);
			pacoteRepo.save(pa3);
			pacoteRepo.save(pa4);
			
			itemRepo.save(i1);
			itemRepo.save(i2);
			itemRepo.save(i3);
			itemRepo.save(i4);
			itemRepo.save(i5);
			itemRepo.save(i6);
			itemRepo.save(i7);
			itemRepo.save(i8);
			itemRepo.save(i9);
			
			contratoRepo.save(co1);
			contratoRepo.save(co2);
			contratoRepo.save(co3);
			contratoRepo.save(co4);
			contratoRepo.save(co5);
			
			
		} catch (ParseException e) {
			return e.getMessage();
		}
		return "Pronto!";
	}
}
