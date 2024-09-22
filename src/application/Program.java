package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			int number = Integer.parseInt(JOptionPane.showInputDialog("Room number:"));
			Date checkIn = sdf.parse(JOptionPane.showInputDialog("Check-in date (dd/MM/yyyy):"));
			Date checkOut = sdf.parse(JOptionPane.showInputDialog("Check-out date (dd/MM/yyyy):"));

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			JOptionPane.showMessageDialog(null, "Reservation: " + reservation);

			JOptionPane.showMessageDialog(null, "Enter data to update the reservation:");
			checkIn = sdf.parse(JOptionPane.showInputDialog("Check-in date (dd/MM/yyyy):"));
			checkOut = sdf.parse(JOptionPane.showInputDialog("Check-out date (dd/MM/yyyy):"));

			reservation.updateDates(checkIn, checkOut);

			JOptionPane.showMessageDialog(null, "Reservation: " + reservation);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Invalid date format.");
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Update error: " + e.getMessage());
		}catch(RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Unexpected error!", null, JOptionPane.ERROR_MESSAGE, null);
		}
	}
}
