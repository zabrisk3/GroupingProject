import java.util.ArrayList;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.Cell;

public class ListOperations 
{
	public static boolean already_in_list_big(ArrayList<ArrayList<Integer []>> biglist, Integer[] pair)
	{
		if(biglist.size()==0)
		{
			return false;
		}
		else
		{
			for(int i=0; i< biglist.size(); i++)
			{
				if (already_in_list_small(biglist.get(i), pair))
				{
					return true;
				}
				
			}
		}
		return false;
	}
	public static boolean already_in_list_small(ArrayList<Integer []> smalllist, Integer[] pair)
	{
		if(smalllist.size()==0)
		{
			return false;
		}
		else
		{
			for(int i=0; i< smalllist.size(); i++)
			{			
				if (Arrays.deepEquals(smalllist.get(i), pair))
				{
					return true;
				}
				
			}
		}
		return false;
	}
	
	public static int get_number_of_unique_values(ArrayList<Integer []> pairlist)
	{ 

		ArrayList<Integer[]> uniquevalues=new ArrayList<Integer[]>();
		for (int k=0; k< pairlist.size(); k++)
		{
			int x=pairlist.get(k)[0];
			int y=pairlist.get(k)[1];
			Integer[] cand ={x,y};
			if(!already_in_list_small(uniquevalues, cand))
			{
				uniquevalues.add(cand);
			}
			
		}
		return uniquevalues.size();
		
	}
	
	
	public static String getStringvalue(Cell cell)
	{
		String base1="";
		switch (cell.getCellType()) 
		{
	       case Cell.CELL_TYPE_NUMERIC:
	       //Double value= spreadsheet.getRow(row).getCell(column).getNumericCellValue();
	       Double value=cell.getNumericCellValue();
	       base1=  value.toString();
	       break;
	       case Cell.CELL_TYPE_STRING:
	       //base1=spreadsheet.getRow(row).getCell(column).getStringCellValue(); 
	       base1=cell.getStringCellValue();
	    	break;
	     }
		return base1;
	} 
}
