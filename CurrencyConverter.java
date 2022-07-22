package digitstowordscovert;
import java.util.Scanner;

public class CurrencyConverter {
	private static WordsConverter wc= new WordsConverter();
	private static Scanner sc= new Scanner(System.in); 
	
	public static void main(String[] args) {
			input();
		}
	
	public static void input() {
		double value=-1;
		System.out.println("Въведете валутата нa стойността: \"BGN\"; \"EUR\"; \"USD\";"); 
		String currency= sc.nextLine(); 
		while(!currency.equals("BGN")&&!currency.equals("EUR")&&!currency.equals("USD")) {
			System.out.println(currency+" не е валидна стойност. Въведете валутата нa стойността: \"BGN\"; \"EUR\"; \"USD\";");
			currency= sc.nextLine();
		}
		System.out.println("Въведете желаната парична стойност в цифри. E.g. 123.20");
		while(!sc.hasNextDouble()) {
			String str=sc.next();
			System.out.println(str+" не е валидна стойност. Въведете желаната парична стойност в цифри. E.g. 123.20");
		}
		value=sc.nextDouble();
		while(value<0||value>999999999.99) {
			System.out.println(value+" не е валидна стойност. Въведете желаната парична стойност в цифри. E.g. 123.20");
			value=sc.nextDouble();
		}
		print(value,currency);
	}
	
	public static void print(double n, String currency){
		int leva=(int)n;
		int stotinki=(int)(n*100-Math.floor(n)*100);
		
		if(currency.equals("BGN")){
			if(n==1.01)
				System.out.println("един лев и една стотинкa");
			else if(leva==1) {
				if(stotinki!=0)
					System.out.println("един лев и "+wc.converterMillioni(stotinki)+"стотинки");
				else
					System.out.println("един лев");
			}
			else if(stotinki==1){
				if(leva!=0)
					System.out.println(wc.converterMillioni(leva)+"лева и една стотинкa");
				else
					System.out.println("една стотинкa");
			}
			else if(stotinki==0)
				System.out.println(wc.converterMillioni(leva)+"лева");
			else if(leva==0)
				System.out.println(wc.converterMillioni(stotinki)+"стотинки");
			else
			System.out.println(wc.converterMillioni(leva)+"лева и "+wc.converterMillioni(stotinki)+"стотинки");
		}
		
		else if(currency.equals("EUR")){
			if(n==1.01)
				System.out.println("едно евро и един цент");
			else if(leva==1) {
				if(stotinki!=0)
					System.out.println("едно евро и "+wc.converterMillioni(stotinki)+"цента");
				else
					System.out.println("едно евро");
			}
			else if(stotinki==1){
				if(leva!=0)
					System.out.println(wc.converterMillioni(leva)+"евра и един цент");
				else
					System.out.println("един цент");
			}
			else if(stotinki==0)
				System.out.println(wc.converterMillioni(leva)+"евра");
			else if(leva==0)
				System.out.println(wc.converterMillioni(stotinki)+"цента");
			else
			System.out.println(wc.converterMillioni(leva)+"евра и "+wc.converterMillioni(stotinki)+"цента");
			}
		
		else if(currency.equals("USD")){
			if(n==1.01)
				System.out.println("един долар и един цент");
			else if(leva==1){
				if(stotinki!=0)
					System.out.println("един долар и "+wc.converterMillioni(stotinki)+"цента");
				else
					System.out.println("един долар");}
			else if(stotinki==1){
				if(leva!=0)
					System.out.println(wc.converterMillioni(leva)+"долара и един цент");
				else
					System.out.println("един цент");}
			else if(stotinki==0)
				System.out.println(wc.converterMillioni(leva)+"долара");
			else if(leva==0)
				System.out.println(wc.converterMillioni(stotinki)+"цента");
			else
			System.out.println(wc.converterMillioni(leva)+"долара и "+wc.converterMillioni(stotinki)+"цента");
			}
		else
			System.out.println("Невалидна валута. Default - BGN.");
	}
	
	/*public static void currencyConverter(int value, String currency) {
		
	}*/
}
