package kr.co.infracube.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.co.infracube.dto.AdminDto;
import kr.co.infracube.dto.CodeDto;
import kr.co.infracube.dto.CustomerDto;
import kr.co.infracube.dto.DeliveryDto;
import kr.co.infracube.mapper.MainMapper;

@Service("mainService")
public class MainService {
	@Autowired
	MainMapper mainmapper;
	
	public List<CodeDto> getGroupCode(CodeDto dto) throws Exception{
		return mainmapper.getGroupCode(dto);
	}
	
	public int insertCode(CodeDto dto) throws Exception{
		return mainmapper.insertCode(dto);
	}
	
	public CodeDto selectCode(CodeDto dto) throws Exception {
		return mainmapper.selectCode(dto);
	}
	
	public List<CodeDto> selectAllGTitle() throws Exception {
		return mainmapper.selectAllGTitle();
	}
	
	public int updateCode(CodeDto dto) throws Exception{
		return mainmapper.updateCode(dto);
	}
	
	public List<CodeDto> getBaseCode(CodeDto dto) throws Exception{
		return mainmapper.getBaseCode(dto);
	}
	
	public List<CodeDto> groupInfo() throws Exception{
		return mainmapper.groupInfo();
	}
	
	public List<CodeDto> selectAllBTitle() throws Exception {
		return mainmapper.selectAllBTitle();
	}
	
	public List<DeliveryDto> getDelivery(HashMap<String, String> paramMap) throws Exception{
		return mainmapper.getDelivery(paramMap);
	}
	
	public List<CustomerDto> customerInfo() throws Exception{
		return mainmapper.customerInfo();
	}
	
	public List<Map<String,String>> selectCustomerInfo(HashMap<String, String> paramMap) throws Exception{
		return mainmapper.selectCustomerInfo(paramMap);
	}
	
	public int processInsertDelivery(DeliveryDto dto) throws Exception{
		return mainmapper.processInsertDelivery(dto);
	}
	
	public DeliveryDto deliveryInfo(DeliveryDto dto) throws Exception{
		return mainmapper.deliveryInfo(dto);
	}
	public int processUpdateDelivery(DeliveryDto dto) throws Exception{
		return mainmapper.processUpdateDelivery(dto);
	}
	
	public AdminDto processLogin(AdminDto admin) throws Exception{
		return mainmapper.processLogin(admin);
	}
	public List<AdminDto> listAdmins(AdminDto dto) throws Exception{
		return mainmapper.listAdmins(dto);
	}
	public List<CustomerDto> listCustomers(HashMap<String, String> hashMap) throws Exception{
		return mainmapper.listCustomers(hashMap);
	}
	public int insertAdmin(AdminDto dto) throws Exception{
		return mainmapper.insertAdmin(dto);
	}
	public int insertCustomer(CustomerDto dto) throws Exception{
		return mainmapper.insertCustomer(dto);
	}
	public int updateAdmin(AdminDto dto) throws Exception{
		return mainmapper.updateAdmin(dto);
	}
	public int updateCustomer(CustomerDto dto) throws Exception{
		return mainmapper.updateCustomer(dto);
	}
	public int passwordChange(AdminDto dto) throws Exception{
		return mainmapper.passwordChange(dto);
	}
	public void excelAdmin(HttpServletResponse response) throws Exception{
		AdminDto dto = new AdminDto();
		List<AdminDto> list = mainmapper.listAdmins(dto);
		
		try {
			//Excel Down ??????
			Workbook workbook = new HSSFWorkbook();
			//????????????
            Sheet sheet = workbook.createSheet("?????????");
            
            //???, ???, ?????????
            Row row = null;
            Cell cell = null;
            int rowNo = 0;
            
            // ????????? ????????? ?????????
            CellStyle headStyle = workbook.createCellStyle();
    
            // ?????? ???????????? ????????????.
            headStyle.setBorderTop(BorderStyle.THIN);
            headStyle.setBorderBottom(BorderStyle.THIN);
            headStyle.setBorderLeft(BorderStyle.THIN);
            headStyle.setBorderRight(BorderStyle.THIN);
    
            // ???????????? ??????????????????.
            headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
            // ???????????? ????????? ???????????????.
            headStyle.setAlignment(HorizontalAlignment.CENTER);
    
            // ???????????? ?????? ????????? ???????????? ??????
            CellStyle bodyStyle = workbook.createCellStyle();
            bodyStyle.setBorderTop(BorderStyle.THIN);
            bodyStyle.setBorderBottom(BorderStyle.THIN);
            bodyStyle.setBorderLeft(BorderStyle.THIN);
            bodyStyle.setBorderRight(BorderStyle.THIN);
    
            // ?????? ??????
            row = sheet.createRow(rowNo++);
    
            cell = row.createCell(0);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
    
            cell = row.createCell(1);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
    
            cell = row.createCell(2);
            cell.setCellStyle(headStyle);
            cell.setCellValue("??????");
            
            cell = row.createCell(3);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
            
            cell = row.createCell(4);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(5);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
            
            cell = row.createCell(6);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(7);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
    
            // ????????? ?????? ??????
            for(Object map1 : list) {
                Map<String, Object> mapValue = (Map<String, Object>) map1;
                
                System.out.println("DB DATA : "+mapValue.toString());
                
                row = sheet.createRow(rowNo++);
                cell = row.createCell(0);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("email"));
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("admin_name"));
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("note"));
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("use_yn"));
                cell = row.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("insert_admin"));
                cell = row.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("insert_date"));
                cell = row.createCell(6);
                cell.setCellStyle(bodyStyle);
                if(mapValue.get("update_admin") != null)
                	cell.setCellValue(""+mapValue.get("update_admin"));
                else
                	cell.setCellValue("");
                cell = row.createCell(7);
                cell.setCellStyle(bodyStyle);
                if(mapValue.get("update_date") != null)
                	cell.setCellValue(""+mapValue.get("update_date"));
                else
                	cell.setCellValue("");
            }
    
            // ????????? ????????? ????????? ??????
            response.setContentType("ms-vnd/excel");
            response.setHeader("Content-Disposition", "attachment;filename=admin.xls");
 
            // ?????? ??????
            workbook.write(response.getOutputStream());
            workbook.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void excelCustomer(HttpServletResponse response) throws Exception{
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("searchKeyword", "");
		List<CustomerDto> list = mainmapper.listCustomers(hashmap);
		System.out.println(list);
		
		try {
			//Excel Down ??????
			Workbook workbook = new HSSFWorkbook();
			//????????????
            Sheet sheet = workbook.createSheet("??????");
            
            //???, ???, ?????????
            Row row = null;
            Cell cell = null;
            int rowNo = 0;
            
            // ????????? ????????? ?????????
            CellStyle headStyle = workbook.createCellStyle();
    
            // ?????? ???????????? ????????????.
            headStyle.setBorderTop(BorderStyle.THIN);
            headStyle.setBorderBottom(BorderStyle.THIN);
            headStyle.setBorderLeft(BorderStyle.THIN);
            headStyle.setBorderRight(BorderStyle.THIN);
    
            // ???????????? ??????????????????.
            headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
            // ???????????? ????????? ???????????????.
            headStyle.setAlignment(HorizontalAlignment.CENTER);
    
            // ???????????? ?????? ????????? ???????????? ??????
            CellStyle bodyStyle = workbook.createCellStyle();
            bodyStyle.setBorderTop(BorderStyle.THIN);
            bodyStyle.setBorderBottom(BorderStyle.THIN);
            bodyStyle.setBorderLeft(BorderStyle.THIN);
            bodyStyle.setBorderRight(BorderStyle.THIN);
    
            // ?????? ??????
            row = sheet.createRow(rowNo++);
    
            cell = row.createCell(0);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
    
            cell = row.createCell(1);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
    
            cell = row.createCell(2);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
            
            cell = row.createCell(3);
            cell.setCellStyle(headStyle);
            cell.setCellValue("??????????????????");
            
            cell = row.createCell(4);
            cell.setCellStyle(headStyle);
            cell.setCellValue("??????????????????");
            
            cell = row.createCell(5);
            cell.setCellStyle(headStyle);
            cell.setCellValue("??????");
            
            cell = row.createCell(6);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
            
            cell = row.createCell(7);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(8);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
            
            cell = row.createCell(9);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(10);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
    
            // ????????? ?????? ??????
            for(Object map1 : list) {
                Map<String, Object> mapValue = (Map<String, Object>) map1;
                
                System.out.println("DB DATA : "+mapValue.toString());
                
                row = sheet.createRow(rowNo++);
                cell = row.createCell(0);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("customer_code"));
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("customer_name"));
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("manager_name"));
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("manager_phone"));
                cell = row.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("manager_email"));
                cell = row.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("note"));
                cell = row.createCell(6);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("use_yn"));
                cell = row.createCell(7);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("insert_code"));
                cell = row.createCell(8);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("insert_date"));
                cell = row.createCell(9);
                cell.setCellStyle(bodyStyle);
                if(mapValue.get("update_code") != null)
                	cell.setCellValue(""+mapValue.get("update_code"));
                else
                	cell.setCellValue("");
                cell = row.createCell(10);
                cell.setCellStyle(bodyStyle);
                if(mapValue.get("update_date") != null)
                	cell.setCellValue(""+mapValue.get("update_date"));
                else
                	cell.setCellValue("");
            }
    
            // ????????? ????????? ????????? ??????
            response.setContentType("ms-vnd/excel");
            response.setHeader("Content-Disposition", "attachment;filename=customer.xls");
 
            // ?????? ??????
            workbook.write(response.getOutputStream());
            workbook.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void excelDelivery(HttpServletResponse response) throws Exception{
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("checkEndDate", "");
		hashmap.put("startDate", "");
		hashmap.put("endDate", "");
		hashmap.put("searchWord", "");
		List<DeliveryDto> list = mainmapper.getDelivery(hashmap);
		
		try {
			//Excel Down ??????
			Workbook workbook = new HSSFWorkbook();
			//????????????
            Sheet sheet = workbook.createSheet("??????");
            
            //???, ???, ?????????
            Row row = null;
            Cell cell = null;
            int rowNo = 0;
            
            // ????????? ????????? ?????????
            CellStyle headStyle = workbook.createCellStyle();
    
            // ?????? ???????????? ????????????.
            headStyle.setBorderTop(BorderStyle.THIN);
            headStyle.setBorderBottom(BorderStyle.THIN);
            headStyle.setBorderLeft(BorderStyle.THIN);
            headStyle.setBorderRight(BorderStyle.THIN);
    
            // ???????????? ??????????????????.
            headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
            // ???????????? ????????? ???????????????.
            headStyle.setAlignment(HorizontalAlignment.CENTER);
    
            // ???????????? ?????? ????????? ???????????? ??????
            CellStyle bodyStyle = workbook.createCellStyle();
            bodyStyle.setBorderTop(BorderStyle.THIN);
            bodyStyle.setBorderBottom(BorderStyle.THIN);
            bodyStyle.setBorderLeft(BorderStyle.THIN);
            bodyStyle.setBorderRight(BorderStyle.THIN);
    
            // ?????? ??????
            row = sheet.createRow(rowNo++);
    
            cell = row.createCell(0);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
    
            cell = row.createCell(1);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
    
            cell = row.createCell(2);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(3);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(4);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(5);
            cell.setCellStyle(headStyle);
            cell.setCellValue("???????????????");
            
            cell = row.createCell(6);
            cell.setCellStyle(headStyle);
            cell.setCellValue("OS");
            
            cell = row.createCell(7);
            cell.setCellStyle(headStyle);
            cell.setCellValue("CPU");
            
            cell = row.createCell(8);
            cell.setCellStyle(headStyle);
            cell.setCellValue("Memory");
            
            cell = row.createCell(9);
            cell.setCellStyle(headStyle);
            cell.setCellValue("HDD");
            
            cell = row.createCell(10);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(11);
            cell.setCellStyle(headStyle);
            cell.setCellValue("???????????????");
            
            cell = row.createCell(12);
            cell.setCellStyle(headStyle);
            cell.setCellValue("??????");
            
            cell = row.createCell(13);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????????????????");
            
            cell = row.createCell(14);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
            
            cell = row.createCell(15);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(16);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
            
            cell = row.createCell(17);
            cell.setCellStyle(headStyle);
            cell.setCellValue("?????????");
            
            cell = row.createCell(18);
            cell.setCellStyle(headStyle);
            cell.setCellValue("????????????");
    
            // ????????? ?????? ??????
            for(Object map1 : list) {
                Map<String, Object> mapValue = (Map<String, Object>) map1;
                
                System.out.println("DB DATA : "+mapValue.toString());
                
                row = sheet.createRow(rowNo++);
                cell = row.createCell(0);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("ccode"));
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("cname"));
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("bname"));
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("manu"));
                cell = row.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("mname"));
                cell = row.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("snum"));
                cell = row.createCell(6);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("os"));
                cell = row.createCell(7);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("cpu"));
                cell = row.createCell(8);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("memory"));
                cell = row.createCell(9);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("hdd"));
                cell = row.createCell(10);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("stype"));
                cell = row.createCell(11);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("term"));
                cell = row.createCell(12);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("ddate"));
                cell = row.createCell(13);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("edate"));
                cell = row.createCell(14);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("useyn"));
                cell = row.createCell(15);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("idelivery"));
                cell = row.createCell(16);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(""+mapValue.get("idate"));
                cell = row.createCell(17);
                cell.setCellStyle(bodyStyle);
                if(mapValue.get("udelivery") != null)
                	cell.setCellValue(""+mapValue.get("udelivery"));
                else
                	cell.setCellValue("");
                cell = row.createCell(18);
                cell.setCellStyle(bodyStyle);
                if(mapValue.get("udate") != null)
                	cell.setCellValue(""+mapValue.get("udate"));
                else
                	cell.setCellValue("");
            }
    
            // ????????? ????????? ????????? ??????
            response.setContentType("ms-vnd/excel");
            response.setHeader("Content-Disposition", "attachment;filename=delivery.xls");
 
            // ?????? ??????
            workbook.write(response.getOutputStream());
            workbook.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
