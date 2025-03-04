package ches;

import java.util.ArrayList;
import java.util.Scanner;

import entity.pieza;

public class tablero {


	ArrayList<ArrayList<String>> casillas = new ArrayList<ArrayList<String>>();
	public ArrayList<pieza> piezas = new ArrayList<pieza>();
	public static boolean jaque = false;
	public tablero() {
	    for (int i = 0; i < 8; i++) {
	        ArrayList<String> fila = new ArrayList<>(); 
	        for (int j = 0; j < 8; j++) {
	            fila.add("x");
	        }
	        casillas.add(fila); 
	    }
	}


public void busqueda(int x, int y)
{
	boolean lado1 = false , lado2 = false , lado3 = false ,lado4 = false;

	// eje x de izquieda a derecha
	for (int i = 0; i <x;i++)
	{

		//casillas.get(y).set(i, ","+i);
		if (casillas.get(y).get(i) != "x" || casillas.get(y).get(i) != "0")
		{
			if (casillas.get(y).get(i) == "torre" ||casillas.get(y).get(i) == "reina" )
			{
				lado1 = true;
	
			}
			else if ((casillas.get(y).get(i) == "peon" || casillas.get(y).get(i) == "caballo"||casillas.get(y).get(i) == "alfil") && !jaque)
				lado1 = false;
		}

			

		
	}
	// eje x de derecha a izquierda
	for (int i = 0; i <Math.abs(x-7);i++)
	{
		//casillas.get(y).set(Math.abs(i-7), ","+i);
		
		if (casillas.get(y).get(Math.abs(i-7)) != "x" || casillas.get(y).get(Math.abs(i-7)) != "0")
		{
			if (casillas.get(y).get(Math.abs(i-7)) == "torre" ||casillas.get(y).get(Math.abs(i-7)) == "reina" )
			{
				lado2 = true;
		
			}
			else if ((casillas.get(y).get(Math.abs(i-7)) == "peon" || casillas.get(y).get(Math.abs(i-7)) == "caballo"||casillas.get(y).get(Math.abs(i-7)) == "alfil")&& !jaque)
				lado2 = false;
		}
		
	}
	// eje y de arriba a abajo
	for (int i = 0; i <y;i++)
	{
		//casillas.get(i).set(x, ","+i);
		if (casillas.get(i).get(x) != "x" || casillas.get(i).get(x) != "0")
		{
			if (casillas.get(i).get(x) == "torre" ||casillas.get(i).get(x) == "reina" )
			{
				lado3 = true;
		
			}
			else if ((casillas.get(i).get(x) == "peon" || casillas.get(i).get(x) == "caballo"||casillas.get(i).get(x) == "alfil")&& !jaque)
				lado3 = false;
		}
		
	}
	// eje y de abajo a arriba
	for (int i = 0; i <Math.abs(y-7);i++)
	{
		//casillas.get(Math.abs(i-7)).set(x, ","+i);
		if (casillas.get(Math.abs(i-7)).get(x) != "x" || casillas.get(Math.abs(i-7)).get(x) != "0")
		{
			if (casillas.get(Math.abs(i-7)).get(x) == "torre" ||casillas.get(Math.abs(i-7)).get(x) == "reina" )
			{
				lado4 = true;
				
			}
			else if ((casillas.get(Math.abs(i-7)).get(x) == "peon" || casillas.get(Math.abs(i-7)).get(x) == "caballo"||casillas.get(Math.abs(i-7)).get(x) == "alfil")&& !jaque)
				lado4 = false;
		}
	}
	
	if (!lado1 && !lado2 && !lado3 && !lado4)
	{
		jaque = false;
	}
	else
	{
		jaque = true;
	}


	
	
	
	
		int n = 0;
		if (x > y)
		{
			n = Math.abs(x-7);
		}
		else if (x < y)
		{
			n = (Math.abs(y-7));
		}
		else
		{
			n = (Math.abs(y-7));
		}

		for (int i = 0; i <n;i++)
		{
			//casillas.get(i+y+1).set(i+x+1,","+i);
			if (casillas.get(i+y+1).get(i+x+1) != "x" || casillas.get(i+y+1).get(i+x+1) != "0")
			{
				if (casillas.get(i+y+1).get(i+x+1) == "alfil" ||casillas.get(i+y+1).get(i+x+1) == "reina" )
				{
					jaque = true;
					break;
					
				}
				else if ((casillas.get(i+y+1).get(i+x+1) == "peon" || casillas.get(i+y+1).get(i+x+1) == "caballo"||casillas.get(i+y+1).get(i+x+1) == "torre")&& !jaque)
					{jaque = false;
					break;
					}
				}
			}
		int nalfil = 0;
		for (int j = 0; j <8;j++)
			for (int z = 0; z <8;z++)
				if (casillas.get(j).get(z) == "alfil" || casillas.get(j).get(z) == "reina")
				{
					
				
					if (z > j)
					{
						nalfil= Math.abs(z-7);
					}
					else if (z < j)
					{
						nalfil = (Math.abs(j-7));
					}
					else
					{
						nalfil= (Math.abs(z-7));
					}

				
				
					for (int i = 0; i <nalfil;i++)
					{
			
						
						//casillas.get(i+j+1).set(i+z+1,","+i);
						if (casillas.get(i+j+1).get(i+z+1) != "x" || casillas.get(i+j+1).get(i+z+1) != "0")
						{
							if (casillas.get(i+j+1).get(i+z+1) == "rey")
							{
								jaque = true;
								break;
								
							}
							else if ((casillas.get(i+j+1).get(i+z+1) == "peon" || casillas.get(i+j+1).get(i+z+1) == "caballo"||casillas.get(i+j+1).get(i+z+1) == "torre")&& !jaque)
								{jaque = false;
								break;
								}
							}
					}
				}
		
		
		
		
		
		int n2 = 0;
		if (x > Math.abs(y-7))
		{
			n2 = Math.abs(x-7);
		}
		else if (x < Math.abs(y-7))
		{
			n2 = (Math.abs(Math.abs(y-7)-7));
		}
		else
		{
			n2 = (Math.abs(Math.abs(y-7)-7));
		}

		for (int i = 0; i <n2;i++)
		{
			//casillas.get(y-(i+1)).set((i+1)+x,","+i);
			
			if (casillas.get(y-(i+1)).get((i+1)+x) != "x" || casillas.get(y-(i+1)).get((i+1)+x) != "0")
			{
				if (casillas.get(y-(i+1)).get((i+1)+x) == "alfil" ||casillas.get(y-(i+1)).get((i+1)+x) == "reina" )
				{
					jaque = true;
					break;
					
				}
				else if ((casillas.get(y-(i+1)).get((i+1)+x) == "peon" || casillas.get(y-(i+1)).get((i+1)+x) == "caballo"||casillas.get(y-(i+1)).get((i+1)+x) == "torre")&& !jaque)
					{jaque = false;
					break;
					}
				}
		}
		
		// alfil de abajo a arriba izquierda a derecha
		int nalfil2 = 0;
		for (int j = 0; j <8;j++)
			for (int z = 0; z <8;z++)
				if (casillas.get(j).get(z) == "alfil" || casillas.get(j).get(z) == "reina")
			{
		if (z > Math.abs(j-7))
		{
			nalfil2 = Math.abs(z-7);
		}
		else if (z < Math.abs(j-7))
		{
			nalfil2 = (Math.abs(Math.abs(j-7)-7));
		}
		else
		{
			nalfil2 = (Math.abs(Math.abs(j-7)-7));
		}

			for (int i = 0; i <nalfil2;i++)
			{
			//casillas.get(j-(i+1)).set((i+1)+z,","+i);
			
			if (casillas.get(j-(i+1)).get((i+1)+z) != "x" || casillas.get(j-(i+1)).get((i+1)+z) != "0")
			{
				if (casillas.get(j-(i+1)).get((i+1)+z) == "rey")
				{
					jaque = true;
					break;
					
				}
				else if ((casillas.get(j-(i+1)).get((i+1)+z) == "peon" || casillas.get(j-(i+1)).get((i+1)+z) == "caballo"||casillas.get(j-(i+1)).get((i+1)+z) == "torre")&& !jaque)
					{jaque = false;
					break;
					}
				}
			
			}
		}
		
		// peon
		
		if (y < 7)
		{
			if((x == 0 && casillas.get(y+1).get(x+1) == "peon") || (x == 7 && casillas.get(y+1).get(x-1) == "peon"))
				jaque = true;
			else if(x!= 0 && x != 7)
				if (casillas.get(y+1).get(x+1) == "peon"||casillas.get(y+1).get(x-1) == "peon")
					jaque = true;
		}
		
		//caballo
		if (y <= 6 && x <= 5)  
		    if (casillas.get(y+1).get(x+2) == "caballo")  
		        jaque = true;  

		if (y <= 5 && x <= 6)  
		    if (casillas.get(y+2).get(x+1) == "caballo")  
		        jaque = true;  //casillas.get(y+2).set(x+1, "0");  

		if (y >= 1 && x <= 5)  
		    if (casillas.get(y-1).get(x+2) == "caballo")  
		        jaque = true;  //casillas.get(y-1).set(x+2, "0");  

		if (y >= 2 && x <= 6)  
		    if (casillas.get(y-2).get(x+1) == "caballo")  
		        jaque = true;  //casillas.get(y-2).set(x+1, "0");  

		if (x >= 1 && y <= 5)  
		    if (casillas.get(y+2).get(x-1) == "caballo")  
		        jaque = true;  //casillas.get(y+2).set(x-1, "0");  

		if (x >= 2 && y <= 6)  
		    if (casillas.get(y+1).get(x-2) == "caballo")  
		        jaque = true;  //casillas.get(y+1).set(x-2, "0");  

		if (y >= 2 && x >= 1)  
		    if (casillas.get(y-2).get(x-1) == "caballo")  
		        jaque = true;  //casillas.get(y-2).set(x-1, "0");  

		if (y >= 1 && x >= 2)  
		    if (casillas.get(y-1).get(x-2) == "caballo")  
		        jaque = true;  //casillas.get(y-1).set(x-2, "0");  
	

}
	

    	
    	


public void update()
{
	jaque = false;
	for (int i = 0; i<8; i++)
	{
		for (int j = 0; j<8;j++)
		{ 
			if (casillas.get(i).get(j) == "rey")
			{
				busqueda(j,i);
				
			}
				
			
			
			
		}
	}


	
}
public void agregarPieza(pieza p) {
    piezas.add(p);
    casillas.get(p.panely).set(p.panelx, p.pieza);
 
}
public void eliminarPieza(pieza p) {
    
    if (p.panely >= 0 && p.panely < casillas.size() && p.panelx >= 0 && p.panelx < casillas.get(p.panely).size()) {
        casillas.get(p.panely).set(p.panelx, "x");
    }


    
}
public void borrartodo() {
   for (ArrayList<String> casilla : casillas)
   {
	   for (int i = 0; i < casilla.size();i++)
	   {
		   casilla.set(i, "x");
	   }
   }
}


public void impresion() {
	System.out.print("\n\n\n\n\n\n\n\n");
	for (int i = 0; i<8; i++)
	{
		System.out.print("\n");
		for (int j = 0; j<8;j++)
		{
			
			System.out.print(casillas.get(i).get(j)+"\t");
		}
	}
	System.out.print("jaque: "+jaque);
	
	
	}
	
}
