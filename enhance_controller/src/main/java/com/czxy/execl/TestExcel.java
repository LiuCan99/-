package com.czxy.execl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: liucan
 * @Date: 2019/11/21 9:34
 */
public class TestExcel {

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";
    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /**
     * 添加操作参照 SquadController  selStuToSquad方法  486   行业务逻辑
     * selStuToSquad方法 参数 Map<课堂id, 学生id> params
     *
     * 解析excel Demo
     * @param args
     * @throws IOException
     */

    /*
    public static void main(String[] args) throws IOException {
        File file = new File("G://javaTest/test.xlsx");
        //从Excel文件获取Workbook对象
        Workbook workbookFromExcel = getWorkbookFromExcel(file);

        //记录excel中解析出来的  邮箱和分组
        Map<Integer,String> failMap=new HashMap<>();
        List<String> failList=new ArrayList<>();
        Map<String,String> successMap=new HashMap<>();

        for (int numSheet = 0; numSheet < workbookFromExcel.getNumberOfSheets(); numSheet++) {
            Sheet hssfSheet = workbookFromExcel.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row  把邮箱账号都添加到list里面
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                Row hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    //邮箱
                    String name = hssfRow.getCell(0).toString();
                    //分组
                    String  group = hssfRow.getCell(1).toString();
                    //行号
                    int rowNum1 = hssfRow.getRowNum();

                    //返回成功map集合和失败map集合  失败后的人员名单
                    // todo 校验学员是否在student表存在操作


                    if(group.equals("B")){
                        //成功 添加到successMap集合中
                        successMap.put(name,group);
                    }else {
                        //失败添加到failMap集合中
                        failMap.put(rowNum1,name);
                        failList.add(rowNum1+"&"+name);
                    }
                }
            }
        }

        //返回导入提示信息

        System.out.println("成功导入名"+successMap.size()+"学员");
        successMap.forEach((k,v)->{
            System.out.println(k+"-->"+v);
        });

        System.out.println(failMap.size()+"名学员导入失败");
        //调用表单导出方法
        //exp(failList);
        failMap.forEach((k,v)->{
            System.out.println(k+"-->"+v);
        });
        failList.forEach(index->{
            System.out.println(index);
        });

    }*/


    /**
     * 导出excel
     */







    // public static void exp(HttpServletResponse response, List<String> params){
    @Test
   public  void exp(){
      List<String> params=new ArrayList<>();
      params.add("1&luxinyu@itcast.cn");
      params.add("2&liucan@itcast.cn");
      params.add("3&niuxunru@itcast.cn");

        //表格名称
        String title="失败名单";
        //表格字段
        String[] rowsName = new String[] { "失败列", "邮箱账号" };
        //表格数据
        List<Object[]>dataList=new ArrayList<>();
        Object[] objs = null;

        //遍历数据
        for(int i=0;i<params.size();i++){
            //准备数据
            FailInfo student=new FailInfo();
            String[] split = params.get(i).split("&");
            student.setRowNum(split[0]);
            student.setEmil(split[1]);


            objs = new Object[rowsName.length];
            objs[0]=student.getRowNum();
            objs[1]=student.getEmil();

            dataList.add(objs);
        }

        //ExportExcel ex = new ExportExcel(title, rowsName, dataList);
        Date date=new Date();
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(time.format(date));

        //ex.export(response, time.format(date) + "-学生导入失败名单.xls");

    }


    /**
     * 输出数据到自定义模版的Excel输出流
     *
     * @param excelTemplate 自定义模版文件
     * @param data          数据
     * @param outputStream  Excel输出流
     * @throws IOException 错误时抛出异常，由调用者处理
     */
    public static void writeDataToTemplateOutputStream(File excelTemplate, List<List<Object>> data, OutputStream outputStream)
            throws IOException {
        Workbook book = TestExcel.getWorkbookFromExcel(excelTemplate);
        TestExcel.writeDataToWorkbook(null, data, book, 0);
        TestExcel.writeWorkbookToOutputStream(book, outputStream);
    }

    /**
     * 从Excel文件获取Workbook对象
     *
     * @param excelFile Excel文件
     * @return Workbook对象
     * @throws IOException 错误时抛出异常，由调用者处理
     */
    public static Workbook getWorkbookFromExcel(File excelFile) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(excelFile);
        ) {

            if (excelFile.getName().endsWith(XLS)) {
                return new HSSFWorkbook(inputStream);
            } else if (excelFile.getName().endsWith(XLSX)) {
                return new XSSFWorkbook(inputStream);
            } else {
                throw new IOException("文件类型错误");
            }
        }
    }

    /**
     * 把Workbook对象内容输出到Excel文件
     *
     * @param book Workbook对象
     * @param file Excel文件
     * @throws FileNotFoundException 找不到文件异常，文件已创建，实际不存在该异常
     * @throws IOException           输入输出异常
     */
    public static void writeWorkbookToFile(Workbook book, File file) throws FileNotFoundException, IOException {
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        try (
                OutputStream outputStream = new FileOutputStream(file);
        ) {
            writeWorkbookToOutputStream(book, outputStream);
        }
    }

    /**
     * 把Workbook对象输出到Excel输出流
     *
     * @param book         Workbook对象
     * @param outputStream Excel输出流
     * @throws IOException 错误时抛出异常，由调用者处理
     */
    public static void writeWorkbookToOutputStream(Workbook book, OutputStream outputStream) throws IOException {
        book.write(outputStream);
    }

    /**
     * 输出数据到Workbook对象中指定页码
     *
     * @param title 标题，写在第一行，可传null
     * @param data  数据
     * @param book  Workbook对象
     * @param page  输出数据到Workbook指定页码的页面数
     */
    public static void writeDataToWorkbook(List<String> title, List<List<Object>> data, Workbook book, int page) {
        Sheet sheet = book.getSheetAt(page);

        Row row = null;
        Cell cell = null;

        // 设置表头
        if (null != title && !title.isEmpty()) {
            row = sheet.getRow(0);
            if (null == row) {
                row = sheet.createRow(0);
            }

            for (int i = 0; i < title.size(); i++) {
                cell = row.getCell(i);
                if (null == cell) {
                    cell = row.createCell(i);
                }
                cell.setCellValue(title.get(i));
            }
        }

        List<Object> rowData = null;
        for (int i = 0; i < data.size(); i++) {

            row = sheet.getRow(i + 1);
            if (null == row) {
                row = sheet.createRow(i + 1);
            }

            rowData = data.get(i);
            if (null == rowData) {
                continue;
            }
            for (int j = 0; j < rowData.size(); j++) {
                cell = row.getCell(j);
                if (null == cell) {
                    cell = row.createCell(j);
                }
                setValue(cell, rowData.get(j));
            }
        }
    }

    /**
     * 读取Excel文件第一页
     *
     * @param pathname 文件路径名
     * @return 第一页数据集合
     * @throws IOException 错误时抛出异常，由调用者处理
     */
    public static List<List<Object>> readExcelFirstSheet(String pathname) throws IOException {
        File file = new File(pathname);
        return readExcelFirstSheet(file);

    }

    /**
     * 读取Excel文件第一页
     *
     * @param file Excel文件
     * @return 第一页数据集合
     * @throws IOException 错误时抛出异常，由调用者处理
     */
    public static List<List<Object>> readExcelFirstSheet(File file) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(file);
        ) {

            if (file.getName().endsWith(XLS)) {
                return readXlsFirstSheet(inputStream);
            } else if (file.getName().endsWith(XLSX)) {
                return readXlsxFirstSheet(inputStream);
            } else {
                throw new IOException("文件类型错误");
            }
        }

    }

    /**
     * 读取xls格式Excel文件第一页
     *
     * @param inputStream Excel文件输入流
     * @return 第一页数据集合
     * @throws IOException 错误时抛出异常，由调用者处理
     */
    public static List<List<Object>> readXlsFirstSheet(InputStream inputStream) throws IOException {
        Workbook workbook = new HSSFWorkbook(inputStream);
        return readExcelFirstSheet(workbook);
    }

    /**
     * 读取xlsx格式Excel文件第一页
     *
     * @param inputStream Excel文件输入流
     * @return 第一页数据集合
     * @throws IOException 错误时抛出异常，由调用者处理
     */
    public static List<List<Object>> readXlsxFirstSheet(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        return readExcelFirstSheet(workbook);
    }

    /**
     * 读取Workbook第一页
     *
     * @param book Workbook对象
     * @return 第一页数据集合
     */
    public static List<List<Object>> readExcelFirstSheet(Workbook book) {
        return readExcel(book, 0);
    }

    /**
     * 读取指定页面的Excel
     *
     * @param book Workbook对象
     * @param page 页码
     * @return 指定页面数据集合
     */
    public static List<List<Object>> readExcel(Workbook book, int page) {
        List<List<Object>> list = new ArrayList<>();
        Sheet sheet = book.getSheetAt(page);
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // 如果当前行为空，则加入空，保持行号一致
            if (null == row) {
                list.add(null);
                continue;
            }

            List<Object> columns = new ArrayList<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                columns.add(getValue(cell));
            }

            list.add(columns);
        }

        return list;
    }

    /**
     * 解析单元格中的值
     *
     * @param cell 单元格
     * @return 单元格内的值
     */
    private static Object getValue(Cell cell) {
        if (null == cell) {
            return null;
        }
        Object value = null;
        switch (cell.getCellType()) {
            case 4: //CellType.BOOLEAN
                value = cell.getBooleanCellValue();
                break;
            case 0: //CellType.NUMERIC

                // 日期类型，转换为日期
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                }
                // 数值类型
                else {

                    // 默认返回double，创建BigDecimal返回准确值
                    value = new BigDecimal(cell.getNumericCellValue());
                }
                break;

            default:
                value = cell.toString();
                break;
        }

        return value;
    }

    /**
     * 设置单元格值
     *
     * @param cell  单元格
     * @param value 值
     */
    private static void setValue(Cell cell, Object value) {
        if (null == cell) {
            return;
        }

        if (null == value) {
            cell.setCellValue((String) null);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Date) {
            cell.setCellValue(FORMAT.format((Date) value));
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else {
            cell.setCellValue(value.toString());
        }

    }
}
