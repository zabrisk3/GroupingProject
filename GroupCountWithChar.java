import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GroupCountWithChar 
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream(new File("SimpleExample.xlsx"));
		System.out.println("File Loaded");
		XSSFWorkbook groupingWorkbook = new XSSFWorkbook(fis);
		XSSFSheet groupingSheet = groupingWorkbook.getSheetAt(0);
		int noOfColumns = groupingSheet.getRow(0).getPhysicalNumberOfCells();
		int noOfRows=groupingSheet.getLastRowNum()+1;
		
		ArrayList<ArrayList<Integer []>> listoflists = new ArrayList<ArrayList<Integer []>>();
		
		for (int i=0; i< noOfColumns; i++)
		{
			for (int j=0; j< noOfRows; j++)
			{
				Integer [] test={i,j};
				if (!ListOperations.inListbig(listoflists, test))
				{
					
					ArrayList<Integer[]> newlist=new ArrayList<Integer[]>();
					ArrayList<Integer[]> rejectlist= new ArrayList<Integer[]>();
					Integer[] test1={i,j};
					newlist.add(test1);
					int previous_length=0;
					int current_length=newlist.size();
					while (previous_length < current_length)
					{
						previous_length=newlist.size();
						int size=newlist.size();
						for (int k=0; k< size; k++)
						{	
							int l=newlist.get(k)[0];
							int m=newlist.get(k)[1];
							Integer[] base = {l, m};
							Cell cell_type=groupingSheet.getRow(m).getCell(l);
							String base1=ListOperations.getStringvalue(cell_type);	
							
							if (!ListOperations.inListsmall(rejectlist, base)); 
							{	
	
								rejectlist.add(base);
								ArrayList<Integer[]> candlist= new ArrayList<Integer[]>();
								String[] triallist=new String[4];
								if (l==0 && m==0)
								{
									Integer[] cand1={l+1,m};
									Integer[] cand2={l, m+1};
									candlist.add(cand1);
									candlist.add(cand2);
									Cell cell1=groupingSheet.getRow(m).getCell(l+1);
									Cell cell2=groupingSheet.getRow(m+1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									triallist[0]=trial1;
									triallist[1]=trial2;
								
								}
								else if (l== 0 && m== noOfRows-1) 
								{
									Integer[] cand1={l+1,m};
									Integer[] cand2={l, m-1};
									candlist.add(cand1);
									candlist.add(cand2);
									Cell cell1=groupingSheet.getRow(m).getCell(l+1);
									Cell cell2=groupingSheet.getRow(m-1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									triallist[0]=trial1;
									triallist[1]=trial2;	
								}
								else if (l== noOfColumns-1 && m== 0) 
								{
									Integer[] cand1={l-1,m};
									Integer[] cand2={l, m+1};
									candlist.add(cand1);
									candlist.add(cand2);
									Cell cell1=groupingSheet.getRow(m).getCell(l-1);
									Cell cell2=groupingSheet.getRow(m+1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									triallist[0]=trial1;
									triallist[1]=trial2;	
								}
								else if (l== noOfColumns-1 && m== noOfRows-1) 
								{
									Integer[] cand1={l-1,m};
									Integer[] cand2={l, m-1};
									candlist.add(cand1);
									candlist.add(cand2);
									Cell cell1=groupingSheet.getRow(m).getCell(l-1);
									Cell cell2=groupingSheet.getRow(m-1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									triallist[0]=trial1;
									triallist[1]=trial2;	
								}
								else if (m == 0)
								{
									Integer[] cand1={l-1,m};
									Integer[] cand2={l+1, m};
									Integer[] cand3={l, m+1};
									candlist.add(cand1);
									candlist.add(cand2);
									candlist.add(cand3);
									Cell cell1=groupingSheet.getRow(m).getCell(l-1);
									Cell cell2=groupingSheet.getRow(m).getCell(l+1);
									Cell cell3=groupingSheet.getRow(m+1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									String trial3 = ListOperations.getStringvalue(cell3);
									triallist[0]=trial1;
									triallist[1]=trial2;	
									triallist[2]=trial3;
									
								}
								else if (m == noOfRows-1)
								{
									Integer[] cand1={l-1,m};
									Integer[] cand2={l+1, m};
									Integer[] cand3={l, m-1};
									candlist.add(cand1);
									candlist.add(cand2);
									candlist.add(cand3);
									Cell cell1=groupingSheet.getRow(m).getCell(l-1);
									Cell cell2=groupingSheet.getRow(m).getCell(l+1);
									Cell cell3=groupingSheet.getRow(m-1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									String trial3 = ListOperations.getStringvalue(cell3);
									triallist[0]=trial1;
									triallist[1]=trial2;	
									triallist[2]=trial3;
									
								}
								else if (l == 0)
								{
									Integer[] cand1={l,m-1};
									Integer[] cand2={l+1, m};
									Integer[] cand3={l, m+1};
									candlist.add(cand1);
									candlist.add(cand2);
									candlist.add(cand3);
									Cell cell1=groupingSheet.getRow(m-1).getCell(l);
									Cell cell2=groupingSheet.getRow(m).getCell(l+1);
									Cell cell3=groupingSheet.getRow(m+1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									String trial3 = ListOperations.getStringvalue(cell3);
									triallist[0]=trial1;
									triallist[1]=trial2;	
									triallist[2]=trial3;
									
								}
								else if (l == noOfColumns-1)
								{
									Integer[] cand1={l,m-1};
									Integer[] cand2={l-1, m};
									Integer[] cand3={l, m+1};
									candlist.add(cand1);
									candlist.add(cand2);
									candlist.add(cand3);
									Cell cell1=groupingSheet.getRow(m-1).getCell(l);
									Cell cell2=groupingSheet.getRow(m).getCell(l-1);
									Cell cell3=groupingSheet.getRow(m+1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									String trial3 = ListOperations.getStringvalue(cell3);
									triallist[0]=trial1;
									triallist[1]=trial2;	
									triallist[2]=trial3;
									
								}
								
								else 
								{
									Integer[] cand1 = {l-1,m};
									Integer[] cand2 = {l,m-1};
									Integer[] cand3 = {l+1, m};
									Integer[] cand4 = {l, m+1};
									
									candlist.add(cand1);
									candlist.add(cand2);
									candlist.add(cand3);
									candlist.add(cand4);
								
									Cell cell1=groupingSheet.getRow(m).getCell(l-1);
									Cell cell2=groupingSheet.getRow(m-1).getCell(l);
									Cell cell3=groupingSheet.getRow(m).getCell(l+1);
									Cell cell4=groupingSheet.getRow(m+1).getCell(l);
									String trial1 = ListOperations.getStringvalue(cell1);
									String trial2 = ListOperations.getStringvalue(cell2);
									String trial3 = ListOperations.getStringvalue(cell3); 
									String trial4 = ListOperations.getStringvalue(cell4); 
									triallist[0]=trial1;
									triallist[1]=trial2;
									triallist[2]=trial3;
									triallist[3]=trial4;
								}
								
								for (int z=0; z< candlist.size(); z++) {
									if(base1.equals(triallist[z]) && !ListOperations.inListsmall(newlist,candlist.get(z)))
									{
										newlist.add(candlist.get(z));
									}
								
								}
							
							}
						
						}	
						current_length=newlist.size();
					}
					listoflists.add(newlist);
				}
			
			}
			
		}
			
	XSSFWorkbook resultsWorkbook = new XSSFWorkbook();
	XSSFSheet resultSheet = resultsWorkbook.createSheet("Group Results");
	Row headingRow = resultSheet.createRow(0);
	Cell groupValue=headingRow.createCell(0);
	Cell groupSize=headingRow.createCell(1);
	groupValue.setCellValue("Value");
	groupSize.setCellValue("Group Size");
	
	for (int w=0; w<listoflists.size(); w++)
	{
		int r=listoflists.get(w).get(0)[0];
		int s=listoflists.get(w).get(0)[1];
		
		Row row1 = resultSheet.createRow(w+1);
		Cell value=row1.createCell(0);
		Cell size=row1.createCell(1);
		Cell rawCell=groupingSheet.getRow(s).getCell(r);
		
		switch (rawCell.getCellType()) 
		{
	       case Cell.CELL_TYPE_NUMERIC:
	    	value.setCellValue(rawCell.getNumericCellValue());
	       break;
	       case Cell.CELL_TYPE_STRING:
	       value.setCellValue(rawCell.getStringCellValue());
	       break;
	     }
		
		size.setCellValue(listoflists.get(w).size());
	}
	
	FileOutputStream out = new FileOutputStream(new File("GroupingResults.xlsx"));
	resultsWorkbook.write(out);
	out.close();
	groupingWorkbook.close();
	resultsWorkbook.close();
	System.out.println("");
	System.out.println("Successfully Counted Groups!");
	}	
		
}
