package managers;

import java.util.ArrayList;
import java.util.List;

import storage.StorableList;
import transaction.Transaction;
import transaction.Wallet;
import users.Customer;
import users.User;

public class TransactionManager {

	private StorableList<Transaction> transactionList;
	private Transaction t;
	private Wallet wallet;

	private static TransactionManager instance;

	public static TransactionManager getInstance() {
		if (instance == null) {
			instance = new TransactionManager();
		}
		return instance;
	}

	private TransactionManager() {
		this.transactionList = new StorableList<>();

	}

	public Transaction findTransaction(String TransactionID) {

		for (Transaction t : transactionList) {
			if (t.getTransactionID().equals(TransactionID)) {
				return t;
			}
		}
		return null;
	}

	public boolean addCharge(Transaction newCharge) {
		if (findTransaction(newCharge.getTransactionID()) != null) {
			return false;
		} else {
			transactionList.add(newCharge);
			return true;
		}

	}

	public void UpdateWallet(User customer, double newWallet) {// να κάνουμε τύπου customer και να κάνουμε έτσι accessτο
																// wallet καθε customer
		customer.getWallet().setAmount(newWallet);
	}

	public boolean addCredit(Transaction newCredit) {

		if (findTransaction(newCredit.getTransactionID()) != null) {
			return false;
		} else {
			transactionList.add(newCredit);
			return true;
		}

	}

	public void PayBalance(Customer customer, double amount) {

		Wallet customerWallet = customer.getWallet();

		double customerAmount = customerWallet.getAmount();

		customerWallet.setAmount(customerAmount - amount);

		System.out.println("The payment has been completed");

	}

	public List<Transaction> showWalletStatementsOfUser(Customer customer) { // to megalo kommatitha ginei sto cli kai
																				// mhpws prepei na ginei typou customer
																				// h string na to skeftw

		List<Transaction> customerStatementHistoryWallet = new ArrayList<>();

		for (Transaction t : this.transactionList) {

			if (t.getVAT().equals(customer)) {

				customerStatementHistoryWallet.add(t);

			}

		}

		return customerStatementHistoryWallet;

	}

	public void payFine(Customer customer, double amount) {

		Wallet customerWallet = customer.getWallet();

		double customerAmount = customerWallet.getAmount();
		customerWallet.setAmount(customerAmount + amount);

		System.out.println("The fine has been paid succesfully");

	}

}
