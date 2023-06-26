package com.coderhouse.Clase8;

import com.coderhouse.Clase8.model.Client;
import com.coderhouse.Clase8.model.Invoice;
import com.coderhouse.Clase8.model.Product;
import com.coderhouse.Clase8.repository.ClientRepository;
import com.coderhouse.Clase8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Clase8Application implements CommandLineRunner {
	@Autowired
	private ProductRepository productoRepository;

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {

		SpringApplication.run(Clase8Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening. Access H2 on: http://localhost:8888/h2-console");

		//Carga automática de clientes y productos
		try {
			//Parte 1: creación de clientes
			Client cliente1 = new Client();
			cliente1.setName("nombre1");
			cliente1.setLastname("apellido1");
			cliente1.setDocnumber("1111111");
			this.clientRepository.save(cliente1);

			Client cliente2 = new Client();
			cliente2.setName("nombre2");
			cliente2.setLastname("apellido2");
			cliente2.setDocnumber("2222222");
			this.clientRepository.save(cliente2);

			Client cliente3 = new Client();
			cliente3.setName("nombre3");
			cliente3.setLastname("apellido3");
			cliente3.setDocnumber("3333333");
			this.clientRepository.save(cliente3);


			//Parte 2 creación de productos
			Product cuchara = new Product();
			cuchara.setTitle("cuchara");
			cuchara.setCode("A00001");
			cuchara.setDescription("producto1");
			cuchara.setPrice(15.5);
			cuchara.setStock(100);
			this.productoRepository.save(cuchara);

			Product tenedor = new Product();
			tenedor.setTitle("tenedor");
			tenedor.setCode("A00002");
			tenedor.setDescription("producto2");
			tenedor.setPrice(25.5);
			tenedor.setStock(200);
			this.productoRepository.save(tenedor);

			Product cuchillo = new Product();
			cuchillo.setTitle("cuchillo");
			cuchillo.setCode("A00003");
			cuchillo.setDescription("producto3");
			cuchillo.setPrice(35.5);
			cuchillo.setStock(200);
			this.productoRepository.save(cuchillo);

			Product espatula = new Product();
			espatula.setTitle("espatula");
			espatula.setCode("A00004");
			espatula.setDescription("producto4");
			espatula.setPrice(45.5);
			espatula.setStock(300);
			this.productoRepository.save(espatula);

			Product colador = new Product();
			colador.setTitle("colador");
			colador.setCode("A00005");
			colador.setDescription("producto5");
			colador.setPrice(55.5);
			colador.setStock(400);
			this.productoRepository.save(colador);

			System.out.println("Server listening. Access H2 on: http://localhost:8888/h2-console");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}