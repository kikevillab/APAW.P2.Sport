package es.upm.miw.sports;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.daos.memory.DaoFactoryMemory;
import es.upm.miw.web.http.HttpMethod;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import upm.jbb.IO;

public class Main {

	private Server server = new Server();

	private HttpRequest request = new HttpRequest();
	
	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:uno@gmail.com");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("dos:dos@gmail.com");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("tres:tres@gmail.com");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("users");
		request.clearQueryParams();
		request.setBody("");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("tenis");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("tenis");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("ajedrez");
		this.request();
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
		request.setBody("tenis");
		this.request();
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
		request.setBody("noDeporte");
		this.request();
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/dos/sport");
		request.setBody("tenis");
		this.request();
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/dos/sport");
		request.setBody("ajedrez");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("users/search");
		request.addQueryParam("sport", "tenis");
		request.setBody("");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("noPath");
		request.clearQueryParams();
		this.request();
	}

	public void request() {
		System.out.println(request.toString());
		HttpResponse response = server.request(request);
		System.out.println(response);
		System.out.println("---------------------------------------ooo----------------------------------------");
	}

	public static void main(String[] args) {
		Main main = new Main();
		DaoFactory.setFactory(new DaoFactoryMemory());
		main.demo();
	}
}
