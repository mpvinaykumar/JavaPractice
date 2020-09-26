package alogrithms;

import javax.swing.JOptionPane;

public class FindExcelColumn {
	 
public static void main(String args[])
{
 
    String input = JOptionPane.showInputDialog("Enter any column number: "); // Di
 
    int colNum=Integer.parseInt(input);
 
    //System.out.println("1- Excel Column Name  Given ColumNumber "+colNum+ "  is   " + ExcelColumnName(colNum));
    
    System.out.println("2- Excel Column Name  Given ColumNumber "+colNum+ "  is   " + ExcelColumnName(colNum));
 
 
}
 
   private static  String ExcelColumnName(int colNum) {
        int Base = 26;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String colName = "";
 
        while (colNum > 0) {
           int position = colNum % Base;
           colName = (position == 0 ? 'Z' : chars.charAt(position > 0 ? position - 1 : 0)) + colName;
           colNum = (colNum - 1) / Base;
        }
        return colName;
    }
   
   private static String printString(int columnNumber) 
   { 
       // To store result (Excel column name) 
       StringBuilder columnName = new StringBuilder(); 
 
       while (columnNumber > 0) { 
           // Find remainder 
           int rem = columnNumber % 26; 
 
           // If remainder is 0, then a 
           // 'Z' must be there in output 
           if (rem == 0) { 
               columnName.append("Z"); 
               columnNumber = (columnNumber / 26) - 1; 
           } 
           else // If remainder is non-zero 
           { 
               columnName.append((char)((rem - 1) + 'A')); 
               columnNumber = columnNumber / 26; 
           } 
       } 
 
       // Reverse the string and print result 
       return columnName.reverse().toString(); 
   } 
 
}