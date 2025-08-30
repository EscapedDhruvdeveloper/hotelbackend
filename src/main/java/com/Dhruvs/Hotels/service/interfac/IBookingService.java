package com.Dhruvs.Hotels.service.interfac;

import com.Dhruvs.Hotels.dto.Response;
import com.Dhruvs.Hotels.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
