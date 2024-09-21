package application;

import java.util.Date;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int number = Integer.parseInt(JOptionPane.showInputDialog("Room number:"));
		Date checkIn = sdf.parse(JOptionPane.showInputDialog("Check-in date (dd/MM/yyyy):"));
		Date checkOut = sdf.parse(JOptionPane.showInputDialog("Check-out date (dd/MM/yyyy):"));

		if (!checkOut.after(checkIn)) {
			JOptionPane.showMessageDialog(null, "Error in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			JOptionPane.showMessageDialog(null, "Reservation: " + reservation);

			JOptionPane.showMessageDialog(null, "Enter data to update the reservation:");
			checkIn = sdf.parse(JOptionPane.showInputDialog("Check-in date (dd/MM/yyyy):"));
			checkOut = sdf.parse(JOptionPane.showInputDialog("Check-out date (dd/MM/yyyy):"));

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				JOptionPane.showMessageDialog(null, "Error: Reservation dates for update must be future dates.");
			} else if (!checkOut.after(checkIn)) {
				JOptionPane.showMessageDialog(null,
						"Error in reservation: Check-out date must be after check-in date.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				JOptionPane.showMessageDialog(null, "Reservation: " + reservation);
			}
		}
	}

}
