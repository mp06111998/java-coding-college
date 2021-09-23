public class DN03{
	public static void main(String[] args){
		String a = args[0];
		String b = args[1];
		String c = args[2];
		double a1 = Double.parseDouble(a);
		double b1 = Double.parseDouble(b);
		double c1 = Double.parseDouble(c);
		if (args.length == 3){
			Izracun(a1,b1,c1);
		}
		else if (a1 == 5){
			int min = 1;
			double vrednost = Double.parseDouble(args[min]);
			System.out.print("Minimum stevil ");
			for(int i = 1; i < args.length; i++){
				double n = Double.parseDouble(args[i]);
				if (n < vrednost){
					min = i;
					vrednost = Double.parseDouble(args[min]);
				}
				System.out.printf("%s ",args[i]);
			}
			System.out.print("je " + args[min]);
		}
	}
	
	static void Izracun(double a1, double b1, double c1){
		if(a1 == 1){
			System.out.printf("%.1f + %.1f = %.1f",b1,c1,b1+c1);
		}
		else if(a1 == 2){
			System.out.printf("%.1f - %.1f = %.1f",b1,c1,b1-c1);
		}
		else if(a1 == 3){
			System.out.printf("%.1f * %.1f = %.1f",b1,c1,b1*c1);
		}
		else if(a1 == 4){
			System.out.printf("%.1f / %.1f = %.1f",b1,c1,b1/c1);
		}
	}
}