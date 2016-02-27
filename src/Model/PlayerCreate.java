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

import Controller.MoveController;

public class PlayerCreate {

	public ArrayList<PokemonState> createPlayer(String filename) throws IOException
    {
		MoveController FMC = new MoveController();
		int id, level, xp, xpMax, hp, hpMax, attack, defense, speed, specialAttack, specialDefense, move1PP, move2PP, move3PP, move4PP, move1PPMax, move2PPMax, move3PPMax, move4PPMax;
		String pokemon, name, type, move1, move2, move3, move4, frontpic, backpic;
		boolean poison, frozen, paralysed, confused, burned, sleeping;
		ArrayList<PokemonState> party = new ArrayList<PokemonState>();
		
    	
        String moveListFilePath = filename;
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
                 id = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 pokemon = cell.getStringCellValue();
                 cell = cellIterator.next();
                 name = cell.getStringCellValue();
                 cell = cellIterator.next();
                 level = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 type = cell.getStringCellValue();
                 cell = cellIterator.next();
                 xp = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 xpMax = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 hp = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 hpMax = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 attack = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 defense = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 speed = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 specialAttack = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 specialDefense = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 move1 = cell.getStringCellValue();
                 cell = cellIterator.next();
                 move2 = cell.getStringCellValue();
                 cell = cellIterator.next();
                 move3 = cell.getStringCellValue();
                 cell = cellIterator.next();
                 move4 = cell.getStringCellValue();
                 cell = cellIterator.next();
                 move1PP = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 move2PP = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 move3PP = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 move4PP = (int) cell.getNumericCellValue();
                 cell = cellIterator.next();
                 poison = cell.getBooleanCellValue();
                 cell = cellIterator.next();
                 frozen =  cell.getBooleanCellValue();
                 cell = cellIterator.next();
                 paralysed = cell.getBooleanCellValue();
                 cell = cellIterator.next();
                 confused = cell.getBooleanCellValue();
                 cell = cellIterator.next();
                 burned = cell.getBooleanCellValue();
                 cell = cellIterator.next();
                 sleeping = cell.getBooleanCellValue();
                 cell = cellIterator.next();
                 frontpic = cell.getStringCellValue();
                 cell = cellIterator.next();
                 backpic = cell.getStringCellValue();
                 
                 move1PPMax = FMC.getMovePP(move1);
                 move2PPMax = FMC.getMovePP(move2);
                 move3PPMax = FMC.getMovePP(move3);
                 move4PPMax = FMC.getMovePP(move4);

                 party.add(new PokemonState(id, pokemon, name, level, type, xp, xpMax, hp, hpMax,
                		 attack, defense, speed, specialAttack, specialDefense,
                		 move1, move2, move3, move4, move1PPMax, move2PPMax, move3PPMax,
                		 move4PPMax, move1PP, move2PP, move3PP, move4PP,
                		 poison, frozen, paralysed, confused, burned, sleeping, frontpic, backpic));
        }
        System.out.println("DONE");
        workbook.close();
        inputStream.close();
        return party;
    }
}
