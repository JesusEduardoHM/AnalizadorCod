package AnalizadorLex_Sem;

import java.util.Stack;

public class Sintactico {
	
	private String matriz[][]={//si se agregan datos a la tabla se tienen que modificar la cabezera para la entrada
			
			{"","id","num","int","float","char",",",";","+","-","*","/","(",")","Error","=","$","p","Tipo","V","A","S","E","T","F"},
			{"q0","q7","Error","q4","q5","q6","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q1","q2","Error","q3","Error","Error","Error","Error"},
			{"q1","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","p0","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q2","q8","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q3","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","p2","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q4","p3","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q5","p4","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q6","p5","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q7","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q9","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q8","Error","Error","Error","Error","Error","q11","q12","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q10","Error","Error","Error","Error","Error"},
			{"q9","q20","q21","Error","Error","Error","Error","Error","q14","q15","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","q13","q16","q17","q18"},
			{"q10","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","p1","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q11","q22","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q12","q7","Error","q4","q5","q6","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q23","q2","Error","q3","Error","Error","Error","Error"},
			{"q13","Error","Error","Error","Error","Error","Error","q24","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q14","q20","q21","Error","Error","Error","Error","Error","Error","Error","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","Error","q25","q17","q18"},
			{"q15","q20","q21","Error","Error","Error","Error","Error","Error","Error","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","Error","q26","q17","q18"},
			{"q16","Error","Error","Error","Error","Error","Error","p11","q27","q28","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q17","Error","Error","Error","Error","Error","Error","p14","p14","p14","q29","q30","Error","p14","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q18","Error","Error","Error","Error","Error","Error","p17","p17","p17","p17","p17","Error","p17","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q19","q20","q21","Error","Error","Error","Error","Error","Error","Error","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","Error","q31","q17","q18"},
			{"q20","Error","Error","Error","Error","Error","Error","p19","p19","p19","p19","p19","Error","p19","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q21","Error","Error","Error","Error","Error","Error","p20","p20","p20","p20","p20","Error","p20","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q22","Error","Error","Error","Error","Error","q11","q12","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q32","Error","Error","Error","Error","Error"},
			{"q23","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","p7","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q24","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","p8","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q25","Error","Error","Error","Error","Error","Error","p9","q27","q28","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q26","Error","Error","Error","Error","Error","Error","p10","q27","q28","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q27","q20","q21","Error","Error","Error","Error","Error","Error","Error","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q33","q18"},
			{"q28","q20","q21","Error","Error","Error","Error","Error","Error","Error","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q34","q18"},
			{"q29","q20","q21","Error","Error","Error","Error","Error","Error","Error","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q35"},
			{"q30","q20","q21","Error","Error","Error","Error","Error","Error","Error","Error","Error","q19","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","q36"},
			{"q31","Error","Error","Error","Error","Error","Error","Error","q27","q28","Error","Error","Error","q37","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q32","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","p6","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q33","Error","Error","Error","Error","Error","Error","p12","p12","p12","q29","q30","Error","p12","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q34","Error","Error","Error","Error","Error","Error","p13","p13","p13","q29","q30","Error","p13","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q35","Error","Error","Error","Error","Error","Error","p15","p15","p15","p15","p15","Error","p15","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q36","Error","Error","Error","Error","Error","Error","p16","p16","p16","p16","p16","Error","p16","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},
			{"q37","Error","Error","Error","Error","Error","Error","p18","p18","p18","p18","p18","Error","p18","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error","Error"},}
			;
	
	
	//int var1 , var2 ; var1 = var2 ;

	Stack<String> pila=new Stack<String>();
	String pala[]= new String [18]; //pala es para las producciones
	int puntpila=1, puntcom, nl; //puntero indica el estado y puntero2 endica el componente que se esta analizando
	int columna, renglon, borrPa;
	String cadinter="";
	String pilaS;
	String p[]={ //
			/*P0*/"p",
			/*P1*/"Tipo,id,V",
			/*P2*/"A",
			/*P3*/"int",
			/*P4*/"float",
			/*P5*/"char",
			/*P6*/",,id,V",
			/*P7*/";,p",
			/*P8*/"id,=,S,;",
			/*P9*/"+,E",
			/*P10*/"-,E",
			/*P11*/"E",
			/*P12*/"E,+,T",
			/*P13*/"E,-,T",
			/*P14*/"T",
			/*P15*/"T,*,F",
			/*P16*/"T,/,F",
			/*P17*/"F",
			/*P18*/"(,E,)",
			/*P19*/"id",
			/*P20*/"num"};
	
	boolean Fin=true; //Fn indica que ya termino el codigo
	Stack<String> pilaerror=new Stack<String>();
	
	public String metodo(Stack<String> com)
	{
		nl=1; //Contador de lineas
		pilaS="$ q0 \n"; //pilaS lo que muestra en la interfaz
		pila.push("$");
		pila.push("q0");
		
		com.push("$"); //ana son todos los lexemas
		while(Fin)
		{
			columna=0; renglon=0; borrPa=0;
			pala= new String [18];
			if(com.elementAt(puntcom).compareTo("\n")!=0)
			{

				//System.out.println(com.elementAt(act2));
				try
				{
					for(int i=0;matriz[0][i].compareTo(com.elementAt(puntcom))!=0;i++)
					{
						columna++;
					}
					//System.out.println(pila.elementAt(act));
					
					for(int i=0;matriz[i][0].compareTo(pila.elementAt(puntpila))!=0;i++)
					{
						renglon++;
					}
					cadinter=matriz[renglon][columna]; //Indica una produccion, cambio de estado o error
				}
				catch (Exception e) 
				{
					cadinter="Error";//en el caso de que un componente lexico no se encuentre en la tabla
				}
				String cad="";
				//System.out.println(cadinter);
				if(cadinter.compareTo("Error")==0)
				{
					pilaS+="\n"+cadinter+"";
					pilaerror.push((pilaerror.size()+1)+".-Error Sintactico en "+ com.elementAt(puntcom)+" numero de linea "+nl);
					//puntero2++; en el caso de recuperacion de errores
					return pilaS;
				}
				else
				{
					if((cadinter.charAt(0)+"").compareTo("p")!=0) //Si no se encuentra una p, se agrega el elemento que esta analizando y el estado al que se tiene que r en ese caso
					{
						pila.push(matriz[0][columna]);
						pila.push(matriz[renglon][columna]);
						puntcom++;
					}
					else
					{
						int ps=0; //indica en que produccion se va a trabajar
						if(matriz[renglon][columna].length()==2) //igual a 2 es p0-9
						{
							ps=Integer.parseInt(matriz[renglon][columna].charAt(1)+"");
						}
						else
						{
							if(matriz[renglon][columna].length()==3)//igual a 3 es p10-99
							{
								ps=Integer.parseInt(matriz[renglon][columna].charAt(2)+"");
								ps+=Integer.parseInt(matriz[renglon][columna].charAt(1)+"")*10;
							}
							else
							{
								if(matriz[renglon][columna].length()==4)
								{
									ps=Integer.parseInt(matriz[renglon][columna].charAt(3)+"");
									ps+=Integer.parseInt(matriz[renglon][columna].charAt(2)+"")*10;
									ps+=Integer.parseInt(matriz[renglon][columna].charAt(1)+"")*100;
								}
							}
						}
						
						if(ps!=6) //ps6/p6 es el unico que tiene , como simbolo interno
						{
							cadinter=p[ps]; //guarda lo que genera esa produccion, ps indica cual se va a guardar
							for(int i=0;cadinter.length()>i;i++)
							{
								if(cadinter.charAt(i)!=',')//las comas son lo que separa los elementos
								{
									cad+=cadinter.charAt(i);// guarda caracter por caracter
								}
								else
								{
									pala[borrPa]=cad; //pala guarda todas las Palabras que se van a borrar en el vector
									borrPa++;//borrPa borraPa indica cuantas palabras se van a borrar
									puntpila++;
									//System.out.print(cad);
									cad="";
								}
							}
							pala[borrPa]=cad;
							//System.out.println(cad);
							borrPa++;
						}
						else
						{
							pala[0]=",";
							pala[1]="id";
							pala[2]="V";
							borrPa+=3;
						}
						
						//System.out.println(borrPa);
						int pan=0;//pan indica cuantos elementos se van a borrar de la pila
						for(int i=0;borrPa>i;i++)
						{
							if(pila.elementAt(pila.size()-(2*(i+1))).compareTo(pala[borrPa-i-1])==0)//Compara si coincide con los elementos que se van a borrar
							{
								//System.out.print(pala[borrPa-i-1]+" ");
								pan=2*(i+1);// Cantadidad de espacios que se van a borrar
								//System.out.print(pan+" ");
							}
						}
						for(int i=0;i<pan;i++)
						{
							pila.pop();
						}
						if(ps==0)
						{
							pila.push("p'");
						}
						else
						{
							if(ps>0&&ps<3)
							{
								pila.push("p");
							}
							else
							
								{
									if(ps>2&&ps<6)
									{
										pila.push("Tipo");
									}
									else
									{
										if(ps>5&&ps<8)
										{
											pila.push("V");
										}
										else
										{
											if(ps==8)
											{
												pila.push("A");
											}
											else
											{
												if(ps>8&&ps<12)
												{
													pila.push("S");
												}
												else
												{
													if(ps>11&&ps<15)
													{
														pila.push("E");
													}
													else
													{
														if(ps>14&&ps<18)
														{
															pila.push("T");
														}
														else
														{
															if(ps>17&&ps<21)
															{
																pila.push("F");
															}
											
														}
										
													}
												}
											}
										}
									}
								
							}
						}
						columna=0; renglon=0;
						if(pila.peek().compareTo("p'")!=0)
						{
							for(int i=0;matriz[0][i].compareTo(pila.peek())!=0;i++)
							{
								columna++;
							}
							for(int i=0;matriz[i][0].compareTo(pila.elementAt(pila.size()-2))!=0;i++)
							{
								//System.out.println(matriz[i][0]);
								//System.out.println(pila.elementAt(pila.size()-2));
								renglon++;
							}
							pan++;
							pila.push(matriz[renglon][columna]);
						
							for(int i=0;i<pila.size();i++)
							{
								//System.out.print(pila.elementAt(i)+" ");
							}
							//System.out.println();
						}
						else
						{
							Fin=false;//Indica que llego a p' y termina
						}
					}
				}
				
				
				if(Fin)
				{
					puntpila=pila.size()-1;//Indica el desplazamiento
					pilaS+="\n";
					for(int i=0;i<pila.size();i++)//Indica el estado de la pila
					{
						pilaS+=pila.elementAt(i)+" ";//Indica las Reducciones o expanciones
						//System.out.println(pila[i]);
					}
				}
				else
				{
					pilaS+="\n";
					pilaS+="$"+" ";
					pilaS+="q0"+" ";
					pilaS+="p'";
					pilaS+="\n";
					pilaS+="\n";
					pilaS+="ACEPTADA";
				}
				pilaS+="\n";
			}
			else
			{
				//en caso de que haya un salto de linea
				puntcom++;
				nl++;
			}
		}
		return pilaS;
	}
	public String[] getpilaerror(){
		String vec[]=new String[pilaerror.size()];
		int i,j;
		for(i=0,j=this.pilaerror.size()-1; i<=j ;i++){ //pila errores
			vec[i]=this.pilaerror.elementAt(i);
		}
		return vec;		
	}
}