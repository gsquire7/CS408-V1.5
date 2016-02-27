package Model;

 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * Code adapted from http://www.codejava.net/coding/how-to-read-excel-files-in-java-using-apache-poi
 * 
 * This will form the basis of reading from excel
 * should save a lot of time uploading the databases
 * allows for quick changes in database
 * 
 * @author www.codejava.net
 */
public class FightMoveDatabase {
	
    private static final FightMoveDatabase INSTANCE = new FightMoveDatabase(); 
	private ArrayList<MoveEffects> movelist = new ArrayList<MoveEffects>();
	
    
	public static FightMoveDatabase getInstance(){
		return INSTANCE;
	}
	public ArrayList<MoveEffects> getMoves()
	{
		return movelist;
	}
	
    private FightMoveDatabase()
    {
    	
    	
    	String name, type;
    	int strength, accuracy, pp;
    	double healthRegeneration;
    	int attackerAttack, defenderAttack, attackerDefense, defenderDefense, attackerSpeed, defenderSpeed, attackerSPAttack, defenderSPAttack, attackerSPDefense, defenderSPDefense;
    	double criticalMultiplier, poison, frozen, paralysed, confusion, burned, attackerSleep, defenderSleep, attackerSpeedRatio;
    	int exceptionsOdds;
    	
        String moveListFilePath = "MoveList.xlsx";
        FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(moveListFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
         
        Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            if(nextRow.getRowNum() == 0){
            	   continue; //just skip the rows if row number is 0 or 1
            	  }
            
                Cell cell = cellIterator.next();
                 name = cell.getStringCellValue();
                 cell = cellIterator.next();
                 type = cell.getStringCellValue();
                 cell = cellIterator.next();
                 strength = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 accuracy = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 pp  = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 healthRegeneration = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attackerAttack = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 defenderAttack = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attackerDefense = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 defenderDefense = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attackerSpeed = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 defenderSpeed = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attackerSPAttack = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 defenderSPAttack = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attackerSPDefense = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 defenderSPDefense = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 criticalMultiplier  = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 poison = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 frozen = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 paralysed = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 confusion = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 burned = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attackerSleep = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 defenderSleep = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attackerSpeedRatio = cell.getNumericCellValue();
                 cell = cellIterator.next();
                 exceptionsOdds = (int) cell.getNumericCellValue();
                 
                 
                 movelist.add(new MoveEffects(name, type, strength, accuracy, pp, healthRegeneration, attackerAttack, defenderAttack, attackerDefense, defenderDefense, 
                		 attackerSpeed, defenderSpeed, attackerSPAttack, defenderSPAttack, attackerSPDefense, defenderSPDefense, criticalMultiplier, 
                		 poison, frozen, paralysed, confusion, burned, attackerSleep, defenderSleep, attackerSpeedRatio, exceptionsOdds));
            }
        
//        	System.out.println("name" + "\t" + "type" + "\t" + "strength" + "\t" + "accuracy" + "\t" + "pp" + "\t" + "healthRegeneration" + "\t" + "attackerAttack" + "\t" + "defenderAttack" + "\t" + "attackerDefense" + "\t" + "defenderDefense" + "\t" + 
//				"attackerSpeed" + "\t" + "defenderSpeed" + "\t" + "attackerSPAttack" + "\t" + "defenderSPAttack" + "\t" + "attackerSPDefense" + "\t" + "defenderSPDefense" + "\t" + "criticalMultiplier" + "\t" +
//				"poison" + "\t" + "frozen" + "\t" + "paralysed" + "\t" + "confusion" + "\t" + "burned" + "\t" + "attackerSleep" + "\t" + "defenderSleep" + "\t" + "attackerSpeedRatio" + "\t" + "exceptionsOdds");
            System.out.println(movelist.get(0).moveToString());
            System.out.println(movelist.get(1).moveToString());
            System.out.println(movelist.get(2).moveToString());
            System.out.println(movelist.get(3).moveToString());
            System.out.println(movelist.get(4).moveToString());
            System.out.println(movelist.get(5).moveToString());
            System.out.println(movelist.get(6).moveToString());
            System.out.println(movelist.get(7).moveToString());
            System.out.println(movelist.get(8).moveToString());
            System.out.println(movelist.get(9).moveToString());
            System.out.println(movelist.get(10).moveToString());
            
            System.out.println("DONE");
        
         
        try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
 
}