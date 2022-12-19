package com.service.impl;

import java.util.List;

import com.dao.IInvoiceDAO;
import com.dao.impl.InvoiceDaoImpl;
import com.entity.Invoice;
import com.service.IInvoiceService;

public class InvoiceService implements IInvoiceService{

	IInvoiceDAO inv = new InvoiceDaoImpl();
	
	@Override
	public List<Invoice> getAllInvoice() {
		// TODO Auto-generated method stub
		return inv.getAllInvoice();
	}

	@Override
	public double totalMoneyDay(int day) {
		// TODO Auto-generated method stub
		return inv.totalMoneyDay(day);
	}

	@Override
	public double totalMoneyMonth(int month) {
		// TODO Auto-generated method stub
		return inv.totalMoneyMonth(month);
	}

	@Override
	public double sumAllInvoice() {
		// TODO Auto-generated method stub
		return inv.sumAllInvoice();
	}

	@Override
	public List<Invoice> searchByNgayXuat(String ngayXuat) {
		// TODO Auto-generated method stub
		return inv.searchByNgayXuat(ngayXuat);
	}

	@Override
	public void deleteInvoiceByAccountId(String id) {
		// TODO Auto-generated method stub
		inv.deleteInvoiceByAccountId(id);
	}

	@Override
	public void insertInvoice(int accountID, double tongGia) {
		// TODO Auto-generated method stub
		inv.insertInvoice(accountID, tongGia);
	}

}
