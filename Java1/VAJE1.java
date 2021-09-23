public class VAJE1 {
 
	public static void main(String[] args){
		pravokotnik(5, 3, 7);
		System.out.println();
		trikotnik(5, 3);
		System.out.println();
		trikotnik(1, 5);
		System.out.println();
		okvir(0, 4, 15);
		System.out.println();
		dvaPravokotnika(5, 15, 3, 6);
		System.out.println();
	}
 
	static void pravokotnik(int odmik, int visina, int sirina){
		for(int i = 0; i < visina; i++){
			for(int j = 0; j < odmik; j++){
				System.out.print(" ");
			}
			for(int j = 0; j < sirina; j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
 
	static void trikotnik(int odmik, int visina){
		for(int i = 1; i <= visina; i++){
			for(int j = i-odmik; j< visina; j++){
				System.out.print(" ");
			}
			for(int k = 1; k< (i*2); k++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
 
	static void okvir(int odmik, int visina, int sirina){
		for(int i = 1; i<= visina; i++){
			if (i==1){
				for(int k = 0; k<odmik; k++){
					System.out.print(" ");
				}
				for(int j = 0; j<sirina; j++){
					System.out.print("*");
				}
				System.out.println();
			}
			if (i == visina){
				for(int k = 0; k<odmik; k++){
					System.out.print(" ");
				}
				for(int j = 0; j<sirina; j++){
					System.out.print("*");
				}
				System.out.println();
			}
			else{
				for(int k = 0; k<odmik; k++){
					System.out.print(" ");
				}
				System.out.print("*");
				for(int k = 0; k<(sirina-2); k++){
					System.out.print(" ");
				}
				System.out.print("*");
				System.out.println();
			}
		}
	}
 
	static void dvaPravokotnika(int odmik, int razmik, int visina, int sirina){
		for(int i = 0; i < visina; i++){
			for(int j = 0; j < odmik; j++){
				System.out.print(" ");
			}
			for(int j = 0; j < sirina; j++){
				System.out.print("*");
			}
			for(int j = 0; j < razmik; j++){
				System.out.print(" ");
			}
			for(int j = 0; j < sirina; j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}