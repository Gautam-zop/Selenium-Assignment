package utils;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    static Xls_Reader reader;
    public static List<Object[]> getDataFromExcel(String fileName){
        List<Object[]> data = new ArrayList<>();
        try{
            String path = "/Users/zop9604/developer/git/Assignment/src/test/resources/data/" + fileName;
            reader = new Xls_Reader(path);
        } catch (Exception e){
            e.printStackTrace();
        }

        for (int rowCount = 2; rowCount <= reader.getRowCount("Sheet1"); rowCount++){
            int columnSize = reader.getColumnCount("Sheet1");
            List<Object> list = new ArrayList<>();
            for(int columnCount = 0; columnCount < columnSize; columnCount++){
                Object cellData= reader.getCellData("Sheet1", columnCount, rowCount);
                if(!cellData.equals(""))
                    list.add(cellData);
            }
            data.add(list.toArray());
        }
        return data;
    }
}


