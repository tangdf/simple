package com.wb.utils.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 * 
 * @author leno
 * @version v1.0
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
public class ExportExcel<T> {


	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */

		
	/**
	 * 数据导出excel
	 * @author sunjiawei
	 * @param title:生成工作表的标题
	 * @param headers:每个字段的名称
	 * @param dataset:数据集
	 * @param out:输出流	 
	 * @param width:每个字段所在单元格的宽度，如果用默认宽度，令width=null;	 
	 */
	public void exportExcel(String title, String[] headers,
			Collection<T> dataset, OutputStream out, short[] width) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.WHITE.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		//遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
        while (it.hasNext()) {
           index++;
           row = sheet.createRow(index);
           T t = it.next();
           //利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
           Field[] fields = t.getClass().getDeclaredFields();
           for (short i = 0; i < fields.length; i++) {
               HSSFCell cell = row.createCell(i);
               cell.setCellStyle(style2);
               String fieldName = fields[i].getName(); //取得javabean属性
               String getMethodName = "get"
                      + fieldName.substring(0, 1).toUpperCase()
                      + fieldName.substring(1);
               try {
                   Class tCls = t.getClass();
                   Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                   Object value = getMethod.invoke(t, new Object[] {});
//                   Object value = fields[i].get(fieldName);
                   //判断值的类型后进行强制类型转换
                   String textValue = null;
                   if (value==null || "".equals(value)){
                	   textValue = "";
                   }else if (value instanceof Date) {
                       Date date = (Date) value;
                       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                       textValue = sdf.format(date);
                    }else{
                    	textValue = value.toString();
                    }
                   HSSFRichTextString richString = new HSSFRichTextString(textValue);
                   cell.setCellValue(richString);
               }catch (Exception e) {
                   e.printStackTrace();
               }finally {
                   //清理资源
               }
           }
        }
//		for(int j=0;j<dataset.size();j++){
//			row = sheet.createRow(j+1);			
//			for (short i = 0; i < dataset.get(j).length; i++) {
//				HSSFCell cell = row.createCell(i);				
//				cell.setCellStyle(style2);
//				HSSFRichTextString richString = new HSSFRichTextString(
//				String.valueOf( dataset.get(j)[i]).replace("null", ""));
//				cell.setCellValue(richString);
//			}
//		}
		
		if(width!=null){
			for(short i=0;i<width.length;i++){
				sheet.setColumnWidth(i,width[i]);
			}
		}
		try {
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解析excel，生成list
	 * @param in  文件输入流
	 * @return
	 * @throws Exception
	 */

	public List<List<Object>> getBankListByExcel(InputStream in) throws Exception {
		List<List<Object>> list = null;  
		
		HSSFWorkbook work = new HSSFWorkbook(in);
        if(null == work){  
            throw new Exception("Excel工作薄为空！");  
        }  
        HSSFSheet sheet = null;  
        HSSFRow row = null;  
        HSSFCell cell = null;  
          
        list = new ArrayList<List<Object>>();  
        //遍历Excel中所有的sheet  
        for (int i = 0; i < work.getNumberOfSheets(); i++) {  
            sheet = work.getSheetAt(i);  
            if(sheet==null){continue;}  
              
            //遍历当前sheet中的所有行  
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {  
                row = sheet.getRow(j);  
                if(row==null||row.getFirstCellNum()==j){continue;}  
                  
                //遍历所有的列  
                List<Object> li = new ArrayList<Object>();  
                for (int y = row.getFirstCellNum(); y < 11; y++) {  
                    cell = row.getCell((short) y);
                    String s="";
                    if(cell==null){
                    	li.add("");
                    }else{
                    	
                    	if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
                    		s= String.valueOf((int)cell.getNumericCellValue());
                    	}else{
                    		s=cell.toString();
                    	}	
                    	li.add(s);
                    }  
                }  
                list.add(li);  
            }  
        }  
        //((Closeable) work).close();  
        return list;
	}
	/**
	 * 格式化单元格数值
	 * @param cell
	 * @return
	 */
	private Object getCellValue(HSSFCell cell) {
        Object value = null;  
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  //日期格式化  
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字  
          
        switch (cell.getCellType()) {  
        case HSSFCell.CELL_TYPE_STRING:  
            value = cell.getRichStringCellValue().getString();  
            break;  
        case HSSFCell.CELL_TYPE_NUMERIC:  
//            //if("m/d/yy".equals(cell.getCellStyle().getDataFormat())){
//            if(HSSFDateUtil.isCellDateFormatted(cell)){  //日期格式
//                value = sdf.format(cell.getDateCellValue());  
//            }else{  
//                //value = df2.format(cell.getNumericCellValue()); 
//            	value =  cell.getNumericCellValue();  
//                //这里处理 数字的科学计算法  
//                if(value.toString().contains("E")){  
//                    DecimalFormat bdf=new DecimalFormat("#");  
//                    value = bdf.format(value);                      
//                }
//            } 
        	short format = cell.getCellStyle().getDataFormat();  
        	//yyyy-MM-dd----14  yyyy年m月d日---31 yyyy年m月----57  m月d日----58
            if(format == 14 || format == 31 || format == 57 || format == 58){
                double value1 = cell.getNumericCellValue();    
                Date date = HSSFDateUtil.getJavaDate(value1);
                value = sdf.format(date);    
            }else if (format == 20 || format == 32) { //HH:mm----20  h时mm分----32 
               sdf = new SimpleDateFormat("HH:mm");  
            }else if (HSSFDateUtil.isCellDateFormatted(cell)) {// 判断当前的cell是否为Date  
            	//先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。  
                // 如果是Date类型则，取得该Cell的Date值    
                Date date = cell.getDateCellValue();  
                //DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");  
                value= sdf.format(date);  
            } else { // 如果是纯数字  
                // 取得当前Cell的数值  
            	value = cell.getNumericCellValue();                   
            }  
            break;  
        case HSSFCell.CELL_TYPE_BOOLEAN:  
            value = cell.getBooleanCellValue();  
            break;  
        case HSSFCell.CELL_TYPE_BLANK:  
            value = "";  
            break;  
        default:  
            break;  
        }  
        return value;
	}

}

