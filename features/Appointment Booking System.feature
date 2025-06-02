Feature: Appointment Booking System
Scenario: Verify Successful Appointment Booking
Given a patient is registered in the system
And the patient has access to the appointment booking portal
When the patient logs in to the appointment booking system using valid credentials
Then the patient dashboard is displayed with available functionalities
When the patient navigates to the 'Book Appointment' section
Then available time slots are displayed
And the available time slots include '10:00 AM', '11:00 AM', '2:00 PM'
When the patient selects the desired time slot '10:00 AM' from the available options
Then the selected time slot is highlighted
When the patient clicks on the 'Book Appointment' button
Then a confirmation dialog is displayed
When the patient confirms the appointment booking
Then the appointment booking is confirmed
And a confirmation message is displayed
Then the appointment details are correctly displayed in the patient dashboard
And no error messages are displayed during the booking process
And the system logs the appointment booking activity for audit purposes
Then the selected time slot '10:00 AM' is no longer available for booking
When the patient attempts to book another appointment at the same time slot '10:00 AM'
Then the system prevents double booking
And an error message is displayed
Then the patient receives an email confirmation with appointment details
And the patient receives an SMS confirmation with appointment details
Then the appointment status is updated to 'Booked' in the clinic management system
When the patient decides to reschedule or cancel the appointment
Then the patient is able to reschedule or cancel the appointment successfully
Then the system updates the available slots after cancellation
And the canceled time slot is made available for booking again