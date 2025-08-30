package com.Dhruvs.Hotels.service.interfac;

import com.Dhruvs.Hotels.dto.LoginRequest;
import com.Dhruvs.Hotels.dto.Response;
import com.Dhruvs.Hotels.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
