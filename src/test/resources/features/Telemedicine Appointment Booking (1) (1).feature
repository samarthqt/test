Feature: Telemedicine Appointment Booking
@JIC-10 @TC-4048 @TC-4127 @TC-4094
Scenario: Patient selects a healthcare provider
Given the patient is logged into the telemedicine system
When the patient navigates to the "Select Healthcare Provider" page
And the patient chooses a healthcare provider from the list
Then the system displays available time slots for the selected provider
@JIC-10 @TC-4048 @TC-4127 @TC-4094
Scenario: Patient chooses an available time slot
Given the patient has selected a healthcare provider
When the patient views the list of available time slots
And the patient selects a preferred time slot
Then the system prompts the patient to confirm the booking
@JIC-10 @TC-4048 @TC-4127 @TC-4094
Scenario: Patient confirms the booking
Given the patient has selected a time slot for a telemedicine consultation
When the patient confirms the booking
Then the system displays a booking confirmation message
And the system sends a confirmation email to the patient
@JIC-10 @TC-4048 @TC-4127 @TC-4094
Scenario: Patient attempts to book without selecting a provider
Given the patient is on the "Select Healthcare Provider" page
When the patient tries to proceed without selecting a provider
Then the system displays an error message prompting the selection of a provider
@JIC-10 @TC-4048 @TC-4127 @TC-4094
Scenario: Patient attempts to book without selecting a time slot
Given the patient has selected a healthcare provider
When the patient tries to confirm the booking without selecting a time slot
Then the system displays an error message prompting the selection of a time slot
@JIC-10 @TC-4048 @TC-4127 @TC-4094
Scenario: Display of available providers
Given the patient is logged into the telemedicine system
When the patient navigates to the "Select Healthcare Provider" page
Then the system displays a list of available healthcare providers
@JIC-10 @TC-4048 @TC-4127 @TC-4094
Scenario: Display of available time slots
Given the patient has selected a healthcare provider
When the patient views the available time slots
Then the system displays only the time slots that are not already booked
@TC-4048 @TC-4127 @TC-4094
Scenario: Book Appointment with Invalid Doctor
Given the user is logged into the healthcare portal
When the user navigates to the 'Appointments' section and clicks on 'Book Appointment'
And enters 'Dr. Invalid' in the doctor selection field
Then an error message is displayed indicating that the doctor is not found or invalid
And the system prevents proceeding with the booking and displays a validation error message
@TC-4127 @TC-4094
Scenario: Book Appointment with Past Date
Given the user is logged into the healthcare portal
When the user navigates to the 'Appointments' section and clicks on 'Book Appointment'
And selects '2023-01-01' from the calendar
Then the system prevents proceeding with the booking
And displays a validation error message indicating the date is in the past
@TC-4094
Scenario: Audio Consultation with Past Date
Given the patient is logged into the telemedicine platform with ID P98765
When the patient navigates to the 'Consultations' section on the dashboard
And selects 'Schedule a Consultation' and chooses 'Audio' as the type
And searches for doctor using Doctor ID D12345
And attempts to select a slot at 10:00 AM on 2023-10-10
Then the system does not allow selection of a past date slot
And an error message or warning is displayed indicating that past dates cannot be booked
And the 'Confirm Booking' button is disabled for the past date
And a tooltip or message may appear explaining the reason
When the patient logs out from the platform
Then the patient is successfully logged out of the telemedicine platform
And the login screen is displayed