package digitstowordscovert;

public class WordsConverter {

	private static final String[] EDINICI = {
		    "",
		    "едно",
		    "две",
		    "три",
		    "четири",
		    "пет",
		    "шест",
		    "седем",
		    "осем",
		    "девет" };
	
	private static final String[] EDINICI2 = {
		    "",
		    "един",
		    "два",
		    "три",
		    "четири",
		    "пет",
		    "шест",
		    "седем",
		    "осем",
		    "девет" };

	private static final String[] DESETKI = {
			 "",
		    "десет",
		    "единадесет",
		    "надесет" };

	private static final String[] STOTICI = {
			 "",
		    "сто",
		    "ста",
		    "стотин"};

	private static final String[] HILQDI = {
			 "",
		    "хиляда",
		    "хиляди" };

	private static final String[] MILIONI = {
			 "",
		    "милион",
		    "милиона",};	
	
	public static String converterMillioni(int n){
		String milioni="";
		if(n>=1000000){
			int v=(int)n/1000000;
			if(v==1)
				milioni=converterHilqdi(v)+MILIONI[1]+" "+converterHilqdi(n-v*1000000);
			else if(v>1)
				milioni=converterHilqdi(v)+MILIONI[2]+" "+converterHilqdi(n-v*1000000);}
		else
			milioni=converterHilqdi(n);
		return milioni;
		}
	
	public static String converterHilqdi(int n){
		String hilqdi="";
		if(n>=1000){
			int v=(int)n/1000;
			if(v==1)
				hilqdi=HILQDI[1]+" "+converter(n-v*1000);
			else if(v>1)
				hilqdi=converter(v)+HILQDI[2]+" "+converter(n-v*1000);}
		else
			hilqdi=converter(n);
		return hilqdi;
		}
	
	public static String converter(int n){
		String edinici="";
		String desetki="";
		String stotici="";
		int pos3=n/100;
		int pos2=(n-pos3*100)/10;
		int pos1=n%10;
		
		if(n>0) 
			edinici=EDINICI2[pos1]+" ";
		
		if(n>=10){
			if(pos2==1&&pos1==0){
				desetki=DESETKI[1]+" ";
				edinici="";}
			else if(pos2==1&&pos1==1) {
				desetki=DESETKI[2]+" ";
				edinici="";}
			else if(pos2==1&&pos1>1) {
				desetki=EDINICI2[pos1]+DESETKI[3]+" ";
				edinici="";}
			else if(pos2!=0)
				desetki=EDINICI2[pos2]+DESETKI[1]+" ";
			if(pos1!=0&&pos2!=1&&pos2!=0)
				desetki+="и ";
			}
		
		if(n>=100){
			if(pos3==1){
				stotici=STOTICI[1]+" ";
				if(pos2==0||pos2==1||pos1==0){
				stotici=STOTICI[1]+" и ";
				}
				if(pos2==0&&pos1==0){
					stotici=STOTICI[1]+" ";
					}
				}
			else if (pos3==2||pos3==3){
				stotici=EDINICI[pos3]+STOTICI[2]+" ";
				if(pos2==0||pos2==1||pos1==0){
				stotici=EDINICI[pos3]+STOTICI[2]+" и ";}
				if(pos2==0&&pos1==0){
					stotici=EDINICI[pos3]+STOTICI[2]+" ";
					}
				}
			else{
				stotici=EDINICI[pos3]+STOTICI[3]+" ";
				if(pos2==0||pos2==1||pos1==0){
					stotici=EDINICI[pos3]+STOTICI[3]+" и ";
					}
				if(pos2==0&&pos1==0){
					stotici=EDINICI[pos3]+STOTICI[3]+" ";
					}}
				}
		
			return stotici+desetki+edinici;
		}
}
