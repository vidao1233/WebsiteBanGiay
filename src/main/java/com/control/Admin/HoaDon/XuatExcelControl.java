package com.control.Admin.HoaDon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entity.Account;
import com.entity.Invoice;
import com.service.IAccountService;
import com.service.IInvoiceService;
import com.service.impl.AccountService;
import com.service.impl.InvoiceService;


@WebServlet(urlPatterns = {"/xuatExcelControl"})
public class XuatExcelControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService acc = new AccountService();
	IInvoiceService inv = new InvoiceService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        String ngayXuat = request.getParameter("dateHoaDon");  
       
        
        List<Invoice> list = inv.searchByNgayXuat(ngayXuat);
        List<Account> listAllAccount = acc.getAllAccount();
        
        FileOutputStream file=new FileOutputStream("C:\\HoaDonWebBanGiay\\"+ngayXuat+"hoaDon.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet workSheet=workbook.createSheet("1");
        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3;
        
        row=workSheet.createRow(0);
        cell0=row.createCell(0);
        cell0.setCellValue("Mã Hóa Đơn");
        cell1=row.createCell(1);
        cell1.setCellValue("Account");
        cell2=row.createCell(2);
        cell2.setCellValue("Tổng Giá($)");
        cell3=row.createCell(3);
        cell3.setCellValue("Ngày Xuất");
        
        double tongGia;
        int i=0;
        
        for (Invoice o : list) {
        	i=i+1;
        	for (Account a : listAllAccount) {
        		if(o.getAccountID()==a.getId()) {
        			tongGia=Math.round((o.getTongGia()) * 100.0) / 100.0;
        			 row=workSheet.createRow(i);
        			 cell0=row.createCell(0);
        		     cell0.setCellValue(o.getMaHD());
        		     cell1=row.createCell(1);
        		     cell1.setCellValue(a.getUser());
        		     cell2=row.createCell(2);
        		     cell2.setCellValue(tongGia);
        		     cell3=row.createCell(3);
        		     cell3.setCellValue(ngayXuat);	
        		}
        		}
        }
        workbook.write(file);
        workbook.close();
        file.close();
        
        request.setAttribute("mess", "Đã xuất file Excel thành công!");
        request.getRequestDispatcher("hoaDon").forward(request, response);

       
    }
}
