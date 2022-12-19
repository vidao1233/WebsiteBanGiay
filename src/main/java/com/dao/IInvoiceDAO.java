package com.dao;

import java.util.List;

import com.entity.Invoice;

public interface IInvoiceDAO {
	public List<Invoice> getAllInvoice();
	public double totalMoneyDay(int day);
	public double totalMoneyMonth(int month);
	public double sumAllInvoice();
	public List<Invoice> searchByNgayXuat(String ngayXuat);
	public void deleteInvoiceByAccountId(String id);
	public void insertInvoice(int accountID, double tongGia);
}
