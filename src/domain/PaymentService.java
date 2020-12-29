package domain;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentService {

    private PaymentDAO paymentDataAccess;

    public PaymentService() {
        paymentDataAccess = new PaymentDAO();
    }

    public static PaymentService getPaymentService(){

    	return new PaymentService();
    }

    public ArrayList<Payment> getPayment(int userId) {
        ArrayList<Payment> payment = null;
        try {
            payment = paymentDataAccess.paymentRetrieve(userId);
        } catch (Exception e) {
        	e.printStackTrace();
            payment = null;
        }
        return payment;
    }

    public boolean paymentCreate(int userId, String address, String contact, String ccNumber, 
			String ccExpiration, String ccPassword) throws SQLException {
        return paymentDataAccess.paymentAdd(userId, address, contact,ccNumber, 
    			ccExpiration, ccPassword);
    }
}