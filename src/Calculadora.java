import java.util.Scanner; 

public class Calculadora {
	public static void main(String[] args){

    	double x=0;
        double y=0;
        boolean fuckingPotencia=false;
    	
        Scanner v = new Scanner(System.in);

        Pilha<String> op = new Pilha<String>();
        
        Pilha<Double> valores = new Pilha<Double>();
        
        System.out.print("Escreva a expressão desejada(sem espaços em branco)->");
        String conta = v.nextLine();

        for (int i=0; i<conta.length(); i++){
            char ch = conta.charAt(i);
            
            switch(ch) {
            	case '(':
            		op.push(String.valueOf(ch));
            		break;
            	case '^':
            		if(op.isEmpty()){
                        op.push(String.valueOf(ch));
                    } else {
                        while (op.top().equals("^")) {
                            op.pop();
                            y = valores.top();
                            valores.pop();
                            x = valores.top();
                            valores.pop();
                            valores.push(Math.pow(x, y));
                            if(op.isEmpty()){
                                break;
                            }
                        }
                        if(conta.charAt(i+1)=='('){
                            fuckingPotencia=true;
                        }
                        op.push(String.valueOf(ch));
                    }
            		break;
            	case '*':
            	case '/':
            		if(op.isEmpty()){
                        op.push(String.valueOf(ch));
                    } else {
                        while (op.top().equals("*") || op.top().equals("/") || op.top().equals("^")) {
                        	
                        	String opTopo = op.top();
                        	
                        	switch(opTopo) {
                        		case ("*"):
    	                    		op.pop();
    	                            y = valores.top();
    	                            valores.pop();
    	                            x = valores.top();
    	                            valores.pop();
    	                            valores.push(x * y);
    	                            break;
                        		case ("/"):
                        			op.pop();
    	                            y = valores.top();
    	                            valores.pop();
    	                            x = valores.top();
    	                            valores.pop();
    	                            valores.push(x / y);
    	                            break;
                        		case ("^"):
                                    op.pop();
                                    y = valores.top();
                                    valores.pop();
                                    x = valores.top();
                                    valores.pop();
                                    valores.push(Math.pow(x, y));
                                    break;
                        	}
                            if(op.isEmpty()){
                                break;
                            }
                        }
                        op.push(String.valueOf(ch));
                    }
            		break;
            	case '-':
            	case '+':
            		if(op.isEmpty()){
                        op.push(String.valueOf(ch));
                    } else {
                        while (op.top().equals("-") || 
                        	   op.top().equals("+") || 
                        	   op.top().equals("/") ||
                        	   op.top().equals("*") || 
                        	   op.top().equals("^")){
                        	
                        	String topo = op.top();
                        	
                        	switch(topo) {
                        		case "-":
                        			op.pop();
                                    y = valores.top();
                                    valores.pop();
                                    x = valores.top();
                                    valores.pop();
                                    valores.push(x - y);
                                    break;
                        		case "+":
                        			op.pop();
                                    y = valores.top();
                                    valores.pop();
                                    x = valores.top();
                                    valores.pop();
                                    valores.push(x + y);
                                    break;
                        		case "/":
                        			op.pop();
                                    y = valores.top();
                                    valores.pop();
                                    x = valores.top();
                                    valores.pop();
                                    valores.push(x / y);
                                    break;
                        		case "*":
                        			op.pop();
                                    y = valores.top();
                                    valores.pop();
                                    x = valores.top();
                                    valores.pop();
                                    valores.push(x * y);
                                    break;
                        		case "^":
                        			op.pop();
                                    y = valores.top();
                                    valores.pop();
                                    x = valores.pop();
                                    valores.pop();
                                    valores.push(Math.pow(x, y));
                                    break;
                        	}
                        	
                        	String topo2 = op.top();
                        	
                        	switch(topo2) {
    	                    	case "-":
    	                			op.pop();
    	                            y = valores.top();
    	                            valores.pop();
    	                            x = valores.top();
    	                            valores.pop();
    	                            valores.push(x - y);
    	                            break;
    	                		case "+":
    	                			op.pop();
    	                            y = valores.top();
    	                            valores.pop();
    	                            x = valores.top();
    	                            valores.pop();
    	                            valores.push(x + y);
    	                            break;
    	                		case "/":
    	                			op.pop();
    	                            y = valores.top();
    	                            valores.pop();
    	                            x = valores.top();
    	                            valores.pop();
    	                            valores.push(x / y);
    	                            break;
    	                		case "*":
    	                			op.pop();
    	                            y = valores.top();
    	                            valores.pop();
    	                            x = valores.top();
    	                            valores.pop();
    	                            valores.push(x * y);
    	                            break;
    	                		case "^":
    	                			op.pop();
    	                            y = valores.top();
    	                            valores.pop();
    	                            x = valores.pop();
    	                            valores.pop();
    	                            valores.push(Math.pow(x, y));
    	                            break;
                        	}
                        	
                            if(op.isEmpty() || op.tamanho==1){
                                break;
                            }
                        }
                        op.push(String.valueOf(ch));
                    }
            		break;
            	case ')':
            		while (!op.top().equals("(")) {
	                	
	                	String arriba = op.top();
	                	
	                	switch(arriba) {
	                		case("^"):
		                		op.pop();
		                        y = valores.top();
		                        valores.pop();
		                        x = valores.top();
		                        valores.pop();
		                        valores.push(Math.pow(x, y));
		                        break;
	                		case("*"):
		                		op.pop();
		                        y = valores.top();
		                        valores.pop();
		                        x = valores.top();
		                        valores.pop();
		                        valores.push(x*y);
		                        break;
	                		case("/"):
	                			op.pop();
		                        y = valores.top();
		                        valores.pop();
		                        x = valores.top();
		                        valores.pop();
		                        valores.push(x / y);
		                        break;
	                		case("+"):
	                			op.pop();
		                        y = valores.top();
		                        valores.pop();
		                        x = valores.top();
		                        valores.pop();
		                        valores.push(x+y);
		                        break;
	                		case("-"):
	                			op.pop();
		                        y = valores.top();
		                        valores.pop();
		                        x = valores.top();
		                        valores.pop();
		                        valores.push(x-y);
		                        break;
	                	}    
	                    if(op.isEmpty()){
	                        break;
	                    }
	                }
	                op.pop();
	                if(fuckingPotencia==true){
	                    op.pop();
	                    y = valores.top();
	                    valores.pop();
	                    x = valores.top();
	                    valores.pop();
	                    valores.push(Math.pow(x, y));
	                    fuckingPotencia=false;
	                }
	                break;
            	default:
            		String value="";
                    for(; i<conta.length(); i++){
                        if(Character.isDigit(conta.charAt(i)) || conta.charAt(i)=='.') {
                            value += Character.toString(conta.charAt(i));
                        } else{
                            i--;
                            break;
                        }
                    }
                    valores.push(Double.parseDouble(value));
                    break;
                }
            }
        
        while(!op.isEmpty()){
        	String ultimo = op.top();
        	
            switch(ultimo) {
            case "-":
            	op.pop();
                y = valores.top();
                valores.pop();
                x = valores.top();
                valores.pop();
                valores.push(x-y);
                break;
            case "+":
            	op.pop();
                y = valores.top();
                valores.pop();
                x = valores.top();
                valores.pop();
                valores.push(x+y);
                break;
            case "*":
            	op.pop();
                y = valores.top();
                valores.pop();
                x = valores.top();
                valores.pop();
                valores.push(x*y);
                break;
            case "/":
            	op.pop();
                y = valores.top();
                valores.pop();
                x = valores.top();
                valores.pop();
                valores.push(x/y);
                break;
            case "^":
            	op.pop();
                y = valores.top();
                valores.pop();
                x = valores.top();
                valores.pop();
                valores.push(Math.pow(x, y));
                break;
            }
        }
        
        System.out.println(valores.top());
        
        v.close();
    }
}
