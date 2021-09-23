public class DN02 {
	public static void main(String[] args){
		int st = args.length;
		int a = 0;
		int b = 0;		
		if(st != 0){
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		}
		pravokotnik(st,a,b);
	}
	
	static void pravokotnik(int st,int a, int b) {
		if (st != 0){
			System.out.printf("a =  %d, b = %d   ", a, b);
			int stev = 0;
			for(int i = 0; i < a; i++){
				String iksi = "";
				for(int j = 0; j < b; j++){
					//System.out.print("X");
					iksi += "X";
				}
				if (stev == 0){
					System.out.printf("%s\n",iksi);
				}
				else{
					System.out.printf("                %s\n",iksi);
				}
				stev ++;
			}
		}
		if (st == 0){
			for(int k = 1; k <= 5; k++){
				for(int o = 1; o <= 5; o++){
					System.out.printf("a =  %d, b = %d   ", k, o);
					int stevv = 0;
					for(int i = 0; i < k; i++){
						String iksi = "";
						for(int j = 0; j < o; j++){
							//System.out.print("X");
							iksi += "X";
						}
						if (stevv == 0){
							System.out.printf("%s\n",iksi);
						}
						else{
							System.out.printf("                %s\n",iksi);
						}
						stevv ++;
					}
					System.out.println("");
				}
			}
		}
	}
}