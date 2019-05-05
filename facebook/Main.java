package facebook;

//Scanner para la lectura de datos
import java.util.Scanner;

public class Main {
	private LoggerFacebook log = new LoggerFacebook();

	public static void main(String[] args){
		Main main = new Main();
		main.Init();
	}
	
	public void Init() {
		this.log.loggerInfo("Inicializando Facebook");
		FacebookInstance fb = new FacebookInstance();
		
		while(true) {
			int number = Menu();
			switch(number) {
				case 0:
					System.out.println("Vuelva pronto!");
					this.log.loggerInfo("El usuario ha abandonado la sesion");
					System.exit(0);
					break;
				case 1:

					break;
			}
		}

	}
	
	public int Menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe el numero de la opcion que desees");
		System.out.println("1. Ver Newsfeed");
		System.out.println("2. Ver tu Muro");
		System.out.println("3. Publicar un estado");
		System.out.println("0. Salir");
		
		return sc.nextInt();
	}
}


