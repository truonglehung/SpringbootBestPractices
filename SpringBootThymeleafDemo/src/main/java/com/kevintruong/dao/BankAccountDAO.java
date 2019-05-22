package com.kevintruong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kevintruong.exception.BankTransactionException;
import com.kevintruong.model.BankAccount;
import com.kevintruong.model.BankAccountInfo;

@Repository
@Transactional
public class BankAccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BankAccountDAO() {
	}

	public BankAccount findById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(BankAccount.class, id);
	}

	public List<BankAccountInfo> listBankAccountInfo() {
		String sql = "Select new " + BankAccountInfo.class.getName() //
				+ "(e.id,e.fullName,e.balance) " //
				+ " from " + BankAccount.class.getName() + " e ";
		Session session = this.sessionFactory.getCurrentSession();
		Query<BankAccountInfo> query = session.createQuery(sql, BankAccountInfo.class);
		return query.getResultList();
	}

	// MANDATORY: Giao dịch bắt buộc phải được tạo sẵn trước đó.
	@Transactional(propagation = Propagation.MANDATORY)
	public void addAmount(Long id, double amount) throws BankTransactionException {
		BankAccount account = this.findById(id);
		if (account == null) {
			throw new BankTransactionException("Account not found " + id);
		}
		double newBalance = account.getBalance() + amount;
		if (account.getBalance() + amount < 0) {
			throw new BankTransactionException(
					"The money in the account '" + id + "' is not enough (" + account.getBalance() + ")");
		}
		account.setBalance(newBalance);
	}

	// Không được bắt BankTransactionException trong phương thức này.
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = BankTransactionException.class)
	public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException {

		addAmount(toAccountId, amount);
		addAmount(fromAccountId, -amount);
	}
}
