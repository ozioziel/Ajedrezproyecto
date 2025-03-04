package ches;

import java.util.ArrayList;


public class prueba {

	public static void main(String[] args) {    
	    ArrayList<pos> paneles = new ArrayList<>();
	    ArrayList<ArrayList<pos>> columna = new ArrayList<ArrayList<pos>>();
	    
	    for (int i = 0; i < 8; i++ )
	    {
	    	paneles = new ArrayList<>();
	        for (int j = 0; j < 8; j++ )
		    {
		    	paneles.add(new pos());
		    }
	        columna.add(paneles);

	    }
	    for (int i = 0; i < 8; i++ )
	    	for (int j = 0; j < 8; j++ )
	    {

	    		columna.get(i).get(j).ix += 85*j;
	    		columna.get(i).get(j).iy += 85*i;
	    		columna.get(i).get(j).fx += 85*j;
	    		columna.get(i).get(j).fy += 85*i;
	    }
	    
	    
	    for (int i = 0; i < 8; i++ )
	    { 
	    	System.out.print("\n");
	        for (int j = 0; j < 8; j++ )
		    {
		    	System.out.print("\t"+"ix: "+ columna.get(i).get(j).ix+"  iy: "+ columna.get(i).get(j).iy +"  fx: "+ columna.get(i).get(j).fx+ "  fy: " + columna.get(i).get(j).fy);
		    }

	    }
	        

	}

}
