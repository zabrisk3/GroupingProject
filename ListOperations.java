import java.util.ArrayList;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.Cell;

public class ListOperations 
{
	public static boolean inListbig(ArrayList<ArrayList<Integer []>> biglist, Integer[] pair)
	{
		if(biglist.size()==0)
		{
			return false;
		}
		else
		{
			for(int i=0; i< biglist.size(); i++)
			{
				if (inListsmall(biglist.get(i), pair))
				{
					return true;
				}
				
			}
		}
		return false;
	}
	
    public static boolean inListsmall(ArrayList<Integer []> smalllist, Integer[] pair)
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
	
	
	public static String getStringvalue(Cell cell)
	{
		String base1="";
		switch (cell.getCellType()) 
		{
            case Cell.CELL_TYPE_NUMERIC:
            Double value=cell.getNumericCellValue();
            base1=  value.toString();
            break;
            case Cell.CELL_TYPE_STRING:
            base1=cell.getStringCellValue();
            break;
	     }
		return base1;
	} 
}
