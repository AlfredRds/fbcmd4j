package facebook;

import java.util.InputMismatchException;
//Scanner para la lectura de datos
import java.util.Scanner;

public class Main {
	private LoggerFacebook log = new LoggerFacebook();
	private Scanner sc = new Scanner(System.in);

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
					System.out.println("Mostrando NewsFeed...");
					fb.getFeed();
					break;
				case 2:
					System.out.println("Mostrando Muro...");
					fb.getWall();
					break;
				case 3:
					int smNumber = SubMenuPublicar();
					switch(smNumber) {
						case 0:
							break;
						case 1:
							
							System.out.println("Iniciando publicar en grupo...");
							System.out.println("Escoge un grupo ");
							fb.getAllGroups();
							try {
								String groupId = fb.getGroup(sc.nextInt());

								if( groupId != null) {
									System.out.println("Escribe 0 cuando no quieras escribir nada");
									System.out.print("Escribe el mensaje: ");
									String message = sc.next(); 
									System.out.print("link: ");
									sc = new Scanner(System.in);
									String link = sc.next();
									fb.publish(groupId, message, link);
								}else {
									System.out.println("El grupo que usted selecciono no existe");
								}
							}catch(InputMismatchException ex) {
								log.loggerInfo("Se ingresaron caracteres no validos");
								System.out.println("Porfavor ingrese caracteres validos y no deje espacios");
							}catch(Exception ex) {
								log.loggerInfo("Ha ocurrido un error" + ex);
								System.out.println("Porfavor intentelo de nuevo");
							}
							sc = new Scanner(System.in);
							break;
						default:
							System.out.println("La opcion que selecciono es invalida");
							break;
					}
					break;
				default:
					System.out.println("La opcion que selecciono no es valida, intentelo de nuevo");
			}
		}

	}
	
	public int Menu() {		
		try {
			System.out.println("Escribe el numero de la opcion que desees");
			System.out.println("1. Ver Newsfeed");
			System.out.println("2. Ver tu Muro");
			System.out.println("3. Publicar un estado");
			System.out.println("0. Salir");
			
			return sc.nextInt();
		}catch(InputMismatchException ex) {
			log.loggerInfo("Se ingresaron caracteres no validos");
			System.out.println("Ingrese unicamente numeros porfavor " + ex);
			sc = new Scanner(System.in);
		}
		
		return 999;
	}
	
	public int SubMenuPublicar() {
		try {
			System.out.println("Donde deseas publicar?");
			System.out.println("1. En un grupo");
			System.out.println("0. Salir");
			return sc.nextInt();
		
		}catch(InputMismatchException ex) {
			log.loggerInfo("Se ingresaron caracteres no validos");
			System.out.println("Ingrese unicamente numeros porfavor " + ex);
			sc = new Scanner(System.in);
		}
		
		return 999;
	}
}


